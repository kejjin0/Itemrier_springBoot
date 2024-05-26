package com.hotSix.itemrier_boot.domain.Category;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Table(name = "CATEGORY")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int catId;
	
	@Column(nullable = false)
	private String catName;
}
