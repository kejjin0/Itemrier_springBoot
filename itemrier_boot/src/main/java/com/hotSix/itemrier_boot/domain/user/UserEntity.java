package com.hotSix.itemrier_boot.domain.user;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "@user_info")
public class UserEntity {
	@Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String phoneNum;
	
	@Column(nullable = false)
	private String nickname;
	
	private int zipcode;
	
	private String addStreet;

	private String addDetail;
}
