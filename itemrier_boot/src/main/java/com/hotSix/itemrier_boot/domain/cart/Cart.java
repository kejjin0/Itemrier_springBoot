package com.hotSix.itemrier_boot.domain.cart;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Entity
@Getter @ToString
public class Cart {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int cartId;
    private List<CartItem> cartItem;
    private int userId;
    private int count; // 상품 총 개수
    
    public Cart() {}

    @Builder
    public Cart(int cartId, List<CartItem> cartItem, int userId, int count) {
        super();
        this.cartId = cartId;
        this.cartItem = cartItem;
        this.userId = userId;
        this.count = count;
    }
}
