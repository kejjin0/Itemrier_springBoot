package com.hotSix.itemrier_boot.domain.order;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class OrderItemPK {
	private int lineNum;
	private int orderId;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemPK other = (OrderItemPK) obj;
		if (lineNum != other.lineNum) return false;
		if (orderId != other.orderId) return false;
		return true;
	}
}
