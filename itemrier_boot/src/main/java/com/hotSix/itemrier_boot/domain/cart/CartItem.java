package com.hotSix.itemrier_boot.domain.cart;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Entity
@Getter @ToString
public class CartItem {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int cartItemId;
    private boolean inStock;
    private int cartId;
    private int itemId;
    private int quantity;
    
    public CartItem() {}

    @Builder
    public CartItem(int cartItemId, boolean inStock, int cartId, int itemId, int quantity) {
        super();
        this.cartItemId = cartItemId;
        this.inStock = inStock;
        this.cartId = cartId;
        this.itemId = itemId;
        this.quantity = quantity;
    }
}
