package com.hotSix.itemrier_boot.domain.cart;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Entity
@Getter @ToString
public class Cart {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int cartId;
    //private List<CartItem> cartItem;
    private int userId;
    private int count; // 상품 총 개수
    
    public Cart() {}

    @Builder
    public Cart(int cartId, List<CartItem> cartItem, int userId, int count) {
        super();
        this.cartId = cartId;
        //this.cartItem = cartItem;
        this.userId = userId;
        this.count = count;
    }
}
