package com.hotSix.itemrier_boot.controller.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotSix.itemrier_boot.domain.order.BuyerInfo;
import com.hotSix.itemrier_boot.domain.order.DeliveryInfo;
import com.hotSix.itemrier_boot.domain.order.Order;
import com.hotSix.itemrier_boot.service.order.OrderService;

@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
	// (구매자)
	// 주문 내역 보여주기
	@RequestMapping("myPage/orders")
	public String viewOrders(
			@RequestParam("buyerId") int buyerId,
			ModelMap model) throws Exception {
		List<Order> orders = orderService.getOrders(buyerId);
		model.put("orders", orders);
		return "orders";
	}
	
	// 주문 자세한 내역 보여주기
	@RequestMapping("myPage/orders/orderInfo")
	public String viewAuctionOrderDetail(
			@RequestParam("orderId") String orderId,
			Model model) throws Exception{
		
		Order order = this.orderService.getOrder(orderId);
		model.addAttribute("order", order);
		return "orderDetail";
	}
	
	// 성함, 전화번호 변경
	@RequestMapping("myPage/order/updateBuyerInfo")
	public String modifyAuctionInvoiceNumber(
			@RequestParam("orderId") String orderId,
			@RequestParam("buyerInfo") BuyerInfo buyerInfo,
			Model model) throws Exception{
		
		this.orderService.modifyBuyerInfo(orderId, buyerInfo);
		model.addAttribute("orderId", orderId);
		// order 세부 정보 보여주는 곳으로 이동
		return "redirct:/myPage/order/orderInfo";
	}
	
	// 배송지 변경
	@RequestMapping("myPage/order/updateDeliveryInfo")
	public String modifyDeliveryInfo(
			@RequestParam("orderId") String orderId,
			@RequestParam("deliveryInfo") DeliveryInfo deliveryInfo,
			Model model) throws Exception{
		
		this.orderService.modifyDeliveryInfo(orderId, deliveryInfo);
		model.addAttribute("orderId", orderId);
		// order 세부 정보 보여주는 곳으로 이동
		return "redirct:/myPage/order/orderInfo";
	}
	
	// 현황 변경
	@RequestMapping("myPage/order/updateStatus")
	public String modifyDeliveryInfo(
			@RequestParam("orderId") String orderId,
			Model model) throws Exception{
		
		this.orderService.modifyStatus(orderId);
		model.addAttribute("orderId", orderId);
		// order 세부 정보 보여주는 곳으로 이동
		return "redirct:/myPage/order/cancel";
	}
	
	// 취소 확인 정보 전달
	@RequestMapping("/myPage/order/cancel")
	public String viewCancelConfirm(@RequestParam("orderId") String orderId,
			Model model) throws Exception{
		
		Order order = this.orderService.getOrder(orderId);
		model.addAttribute("order", order);
		return "orderCancelInfo";
	}
	
	// 결제 확인 정보 전달
		@RequestMapping("/myPage/order/completion")
		public String viewCompletionConfirm(@RequestParam("orderId") String orderId,
				Model model) throws Exception{
			
			Order order = this.orderService.getOrder(orderId);
			model.addAttribute("order", order);
			return "orderCompletionInfo";
		}
	
}
