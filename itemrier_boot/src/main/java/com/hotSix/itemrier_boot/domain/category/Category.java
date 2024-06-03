package com.hotSix.itemrier_boot.domain.category;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "CATEGORY")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int catId;
	
	@Column(nullable = false)
	private String catName;
}
