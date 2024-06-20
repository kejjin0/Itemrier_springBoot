package com.hotSix.itemrier_boot.dto.item;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.hotSix.itemrier_boot.domain.category.Category;
import com.hotSix.itemrier_boot.domain.item.Auction;
import com.hotSix.itemrier_boot.domain.item.Bid;
import com.hotSix.itemrier_boot.domain.item.ItemStatus;
import com.hotSix.itemrier_boot.domain.user.UserEntity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(force = true)
@Data
public class AuctionDto {
	private int itemId;
	
	@NotBlank(message = "상품명은 필수 입력 항목입니다.")
	private String itemName;
	
	@NotBlank(message = "상품 정보는 필수 입력 항목입니다.")
	private String description;
	
	@NotNull(message = "제품 상태는 필수 선택 항목입니다.")
	private String condition;
	
	@NotBlank(message = "연락 수단은 필수 입력 항목입니다.")
	private String contactType;
	
	private int price; // 시작가(등록 가격)
	
	@PositiveOrZero(message = "가격은 0 이상의 값이어야 합니다.")
	private int startPrice; // 시작가
	
	private ItemStatus status;
	
	private UserEntity seller;
	
	@NotNull(message = "카테고리는 필수 선택 항목입니다.")
	private String catId;
	
	private Category category;
	
	private int currentBid; // 현재 최고가
	
    private LocalDateTime startTime; // 시작시간(등록 날짜)
    
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@NotNull(message = "마감일은 필수 선택 항목입니다.")
    private LocalDateTime endTime; // 종료시간
    
    private String fileName; // 파일이름
    
    private String filePath; // 파일경로
    
    private Integer winner; // 낙찰자
    
    public Auction toEntity(AuctionDto dto) {
    	Auction auction = new Auction();
    	auction.setItemId(dto.getItemId());
    	auction.setItemName(dto.getItemName());
    	auction.setDescription(dto.getDescription());
    	auction.setCondition(dto.getCondition());
    	auction.setContactType(dto.getContactType());
    	auction.setPrice(dto.getPrice());
    	auction.setStartPrice(dto.getStartPrice());
    	auction.setStatus(dto.getStatus());
    	auction.setSeller(dto.getSeller());
    	auction.setCategory(dto.getCategory());
    	auction.setCurrentBid(dto.getCurrentBid());
    	auction.setStartTime(dto.getStartTime());
    	auction.setEndTime(dto.getEndTime());
    	auction.setWinner(dto.getWinner());
    	auction.setFileName(dto.getFileName());
    	auction.setFilePath(dto.getFilePath());
    	return auction;
    }
    
    public static AuctionDto toDTO(Auction auction) {
    	AuctionDto dto = new AuctionDto();
    	dto.setItemId(auction.getItemId());
    	dto.setItemName(auction.getItemName());
    	dto.setDescription(auction.getDescription());
    	dto.setCondition(auction.getCondition());
    	dto.setContactType(auction.getContactType());
    	dto.setStartPrice(auction.getStartPrice());
    	dto.setStatus(auction.getStatus());
    	dto.setSeller(auction.getSeller());
    	dto.setCategory(auction.getCategory());
    	dto.setCurrentBid(auction.getCurrentBid());
    	dto.setStartTime(auction.getStartTime());
    	dto.setEndTime(auction.getEndTime());
    	dto.setWinner(auction.getWinner());
    	dto.setFileName(auction.getFileName());
    	dto.setFilePath(auction.getFilePath());
    	return dto;
    }
}
