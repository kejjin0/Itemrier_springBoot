package com.hotSix.itemrier_boot.controller.order;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotSix.itemrier_boot.domain.order.Order;
import com.hotSix.itemrier_boot.domain.order.OrderStatus;
import com.hotSix.itemrier_boot.service.order.OrderService;
import com.hotSix.itemrier_boot.service.order.PaymentService;
import com.siot.IamportRestClient.IamportClient;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class OrderCancelController {
	@Autowired
	private PaymentService paymentService;
	private IamportClient iamportClient;
	
	@Autowired
	private OrderService orderservice;
	
	private String APIkey="6564752634063018";
	private String APIsecret="lAXgFwKZuJ67Zxu6pqkyaAPEcYUAzrKmQ4qHajAE27i8EJqqQX7qEyfoTn20ULTAobTg0IHByHepAXKc";
	
	@PostConstruct
	public void init() {
		this.iamportClient = new IamportClient(APIkey, APIsecret);
	}
	
	@GetMapping("/order/cancel")
	public String paymentCancel(@RequestParam("orderId") String orderId, Model model) throws IOException{
		System.out.println("환불할 주문 번호 " + orderId);
		Order order = this.orderservice.getOrder(orderId);
		if(order.getStatus().equals(OrderStatus.Cancel)) {
			model.addAttribute("message", "이미 취소한 주문입니다.");
		}
		else {
			String token = paymentService.getToken(APIkey, APIsecret);
			paymentService.refundOrder(token, orderId);
			this.orderservice.modifyStatus(orderId);
			model.addAttribute("message", "완료되었습니다.");	
		}
		return "myPage/order/orderCancelResult";
	}

}
