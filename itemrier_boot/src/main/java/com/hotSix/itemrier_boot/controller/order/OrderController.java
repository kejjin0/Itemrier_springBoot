package com.hotSix.itemrier_boot.controller.order;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hotSix.itemrier_boot.domain.order.BuyerInfo;
import com.hotSix.itemrier_boot.domain.order.DeliveryInfo;
import com.hotSix.itemrier_boot.domain.order.Order;
import com.hotSix.itemrier_boot.domain.order.OrderItem;
import com.hotSix.itemrier_boot.domain.order.OrderStatus;
import com.hotSix.itemrier_boot.domain.user.UserEntity;
import com.hotSix.itemrier_boot.dto.item.AuctionDto;
import com.hotSix.itemrier_boot.dto.item.GroupPurchaseDto;
import com.hotSix.itemrier_boot.dto.order.OrderDto;
import com.hotSix.itemrier_boot.dto.user.UserDto;
import com.hotSix.itemrier_boot.repository.user.UserRepository;
import com.hotSix.itemrier_boot.service.item.AuctionService;
import com.hotSix.itemrier_boot.service.item.GroupPurchaseService;
import com.hotSix.itemrier_boot.service.myPage.UsedGoodsHistoryService;
import com.hotSix.itemrier_boot.service.order.OrderService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class OrderController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private GroupPurchaseService groupPurchaseService;
	@Autowired
	private AuctionService auctionService;

	// (구매자)
	// 구매 폼
	@GetMapping("/orderForm")
	public String viewOrderForm(@AuthenticationPrincipal UserDetails userDetail, @RequestParam("itemId") int itemId,
			@RequestParam("itemName") String itemName, @RequestParam("price") int price,@RequestParam("type") String type, Model model) throws Exception {
		UserEntity user = userRepository.findByEmail(userDetail.getUsername());
		int buyerId = user.getUserId();

		// orderId
		// orderId 만들기
		Date today = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");
		String orderId = simpleDateFormat.format(today).toString();
		int randomN = 0;
		for (int i = 0; i < 4; i++) {
			randomN = (int) (Math.random() * 9);
			orderId = orderId.concat(Integer.toString(randomN));
		}

		Boolean check = orderService.existsByOrderId(orderId);
		while (check == true) {
			simpleDateFormat = new SimpleDateFormat("yyMMdd");
			orderId = simpleDateFormat.format(today).toString();
			for (int i = 0; i < 4; i++) {
				randomN = (int) (Math.random() * 9);
				orderId = orderId.concat(Integer.toString(randomN));
			}
		}

		model.addAttribute("buyerId", buyerId);
		model.addAttribute("itemName", itemName);
		model.addAttribute("price", price);
		model.addAttribute("itemId", itemId);
		model.addAttribute("orderId", orderId);
		model.addAttribute("type", type);
		return "order/OrderForm";
	}

	// 구매하기
	@PostMapping("insertOrder")
	@ResponseBody
	public String insertOrder(@RequestBody OrderDto orderDto) {
		System.out.println("insertOrder");
		Order order = new Order();
		
		order.setOrderId(orderDto.getOrderId());
		order.setBuyerId(orderDto.getBuyerId());
		order.setDeliveryInfo(orderDto.getDeliveryInfo());
		order.setBuyerId(orderDto.getBuyerId());
		order.setBuyerInfo(orderDto.getBuyerInfo());
		order.setEmail(orderDto.getEmail());
		order.setPrice(orderDto.getPrice());
		order.setQuantity(orderDto.getQuantity());
		order.setPg(orderDto.getPg());
		order.setPay_method(orderDto.getPay_method());
		order.setOrderDate(orderDto.getOrderDate());		
		order.setStatus(OrderStatus.Complete);
		order.setType(orderDto.getType());		
		List<OrderItem> items = new ArrayList<>();
		OrderItem item = new OrderItem();
		item.setLineNum(1);
		item.setOrderId(order.getOrderId());
		item.setItemId(orderDto.getItemId());
		item.setOrderPrice(orderDto.getPrice());
		item.setStatus(OrderStatus.Complete);
		items.add(item);
		order.setOrderItems(items);

		orderService.insertOrder(order);
		System.out.println(order.toString());
		
		// 공동구매 현재 판매 수량 업데이트
		if(orderDto.getType().equals("groupPurchase")) {
			groupPurchaseService.updateCurrentQuantity(item.getItemId());
		}

		String view = "/myPage/orders/orderInfo?orderId=" + orderDto.getOrderId();
		return view;
	}

	// 공동 구매 주문 내역 보여주기
	@GetMapping("/myPage/orders/groupPurchase")
	public String groupPurchaseViewOrders(@AuthenticationPrincipal UserDetails userDetail, Model model)
			throws Exception {
		UserEntity user = userRepository.findByEmail(userDetail.getUsername());
		int buyerId = user.getUserId();
		List<Order> orders = orderService.getOrders(buyerId, "groupPurchase");
		model.addAttribute("orders", orders);
		return "myPage/order/groupPurchaseOrders";
	}

	// 경매 주문 내역 보여주기
	@GetMapping("/myPage/orders/auction")
	public String auctionViewOrders(@AuthenticationPrincipal UserDetails userDetail, Model model) throws Exception {
		UserEntity user = userRepository.findByEmail(userDetail.getUsername());
		int buyerId = user.getUserId();
		List<Order> orders = orderService.getOrders(buyerId, "auction");
		model.addAttribute("orders", orders);
		return "myPage/order/auctionOrders";
	}

	// 주문 자세한 내역 보여주기
	@GetMapping("/myPage/orders/orderInfo")
	public String viewAuctionOrderDetail(@RequestParam("orderId") String orderId, Model model) throws Exception {

		Order order = this.orderService.getOrder(orderId);
		model.addAttribute("order", order);
		return "myPage/order/orderDetail";
	}

	// 성함, 전화번호 수정 창
	@GetMapping("/myPage/order/updateBuyerInfoForm")
	public String viewBuyerInfoForm(@RequestParam("orderId") String orderId,
			@RequestParam("buyerName") String buyerName, @RequestParam("phoneNum") String phoneNum, Model model) {
		BuyerInfo buyerInfo = new BuyerInfo(buyerName, phoneNum);
		model.addAttribute("buyerInfo", buyerInfo);
		model.addAttribute("orderId", orderId);
		return "myPage/order/buyerInfoForm";
	}

	// 성함, 전화번호 변경
	@PostMapping("/myPage/order/updateBuyerInfo")
	public String modifyAuctionInvoiceNumber(@RequestParam("orderId") String orderId,
			@RequestParam("buyerName") String buyerName, @RequestParam("phoneNum") String phoneNum, Model model,
			RedirectAttributes redirect) throws Exception {

		BuyerInfo buyerInfo = new BuyerInfo(buyerName, phoneNum);
		this.orderService.modifyBuyerInfo(orderId, buyerInfo);
		redirect.addAttribute("orderId", orderId);
		// order 세부 정보 보여주는 곳으로 이동
		return "myPage/order/modifyResult";
	}

	// 배송지 변경 창
	@GetMapping("/myPage/order/updateDeliveryInfoForm")
	public String viewDeliveryForm(@RequestParam("orderId") String orderId, @RequestParam("zipCode") String zipCode,
			@RequestParam("addStreet") String addStreet, @RequestParam("addDetail") String addDetail,
			@RequestParam("deliveryLocation") String deliveryLocation,
			@RequestParam("deliveryRequest") String deliveryRequest, Model model) {
		DeliveryInfo deliveryInfo = new DeliveryInfo(zipCode, addStreet, addDetail, deliveryLocation, deliveryRequest);
		this.orderService.modifyDeliveryInfo(orderId, deliveryInfo);
		model.addAttribute("orderId", orderId);

		return "myPage/order/deliveryInfoForm";
	}

	// 배송지 변경
	@PostMapping("/myPage/order/updateDeliveryInfo")
	public String modifyDeliveryInfo(@RequestParam("orderId") String orderId, @RequestParam("zipCode") String zipCode,
			@RequestParam("addStreet") String addStreet, @RequestParam("addDetail") String addDetail,
			@RequestParam("deliveryLocation") String deliveryLocation,
			@RequestParam("deliveryRequest") String deliveryRequest, Model model, RedirectAttributes redirect)
			throws Exception {

		DeliveryInfo deliveryInfo = new DeliveryInfo(zipCode, addStreet, addDetail, deliveryLocation, deliveryRequest);
		this.orderService.modifyDeliveryInfo(orderId, deliveryInfo);
		redirect.addAttribute("orderId", orderId);
		// order 세부 정보 보여주는 곳으로 이동
		return "myPage/order/modifyResult";
	}

	// 현황 변경
	@GetMapping("/myPage/order/updateStatus")
	public String modifyDeliveryInfo(@RequestParam("orderId") String orderId, Model model) throws Exception {

		this.orderService.modifyStatus(orderId);
		model.addAttribute("orderId", orderId);
		// order 세부 정보 보여주는 곳으로 이동
		return "redirct:/myPage/order/cancel";
	}

	// 취소 확인 정보 전달
	@GetMapping("/myPage/order/cancel")
	public String viewCancelConfirm(@RequestParam("orderId") String orderId, Model model) throws Exception {

		Order order = this.orderService.getOrder(orderId);
		model.addAttribute("order", order);
		return "orderCancelInfo";
	}

	// 결제 확인 정보 전달
	@GetMapping("/myPage/order/completion")
	public String viewCompletionConfirm(@RequestParam("orderId") String orderId, Model model) throws Exception {

		Order order = this.orderService.getOrder(orderId);
		model.addAttribute("order", order);
		return "orderCompletionInfo";
	}

	
	// 공동 구매 물품 구매자 정보 확인
	@GetMapping("/myPage/seller/groupPurchase/orders")
	public String viewGroupPurchaseOrders(@RequestParam("itemId")int itemId, Model model) {
		long count = this.orderService.getOrderCount(itemId, OrderStatus.Complete);
		List<Order> orders = this.orderService.getOrderList(itemId, OrderStatus.Complete);
		GroupPurchaseDto item = this.groupPurchaseService.findById(itemId);
		
		model.addAttribute("count", count);
		model.addAttribute("buyers", orders);
		model.addAttribute("item", item);
		
		return "myPage/order/seller/viewGroupPurchaseBuyers";
	}
	
	@GetMapping("/myPage/seller/auction/orders")
	public String viewAuctionOrders(@RequestParam("itemId")int itemId, Model model) {
		List<Order> orders = this.orderService.getOrderList(itemId, OrderStatus.Complete);
		AuctionDto item = this.auctionService.findById(itemId);
		
		model.addAttribute("buyers", orders);
		model.addAttribute("item", item);
		
		return "myPage/order/seller/viewAuctionBuyers";
	}
}
