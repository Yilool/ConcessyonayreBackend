package com.concesionarie.concesyonarye.model.converter;

import org.springframework.stereotype.Component;

import com.concesionarie.concesyonarye.model.dto.PromotionDto;
import com.concesionarie.concesyonarye.model.entity.Promotion;

@Component
public class PromotionDtoConverter {
	private static final String code = "PRM0";
	
	public Promotion fromPromotionDTOToPromotion(PromotionDto promotionDto) {
		Promotion promotion = new Promotion(promotionDto.getPromoname(), promotionDto.getDiscountPercent());
		
		return promotion;
	}
	
	public PromotionDto fromPromotionToPromotionDto(Promotion promotion) {
		PromotionDto promotionDto = new PromotionDto();
		
		promotionDto.setCod(code + promotion.getId());
		promotionDto.setPromoname(promotion.getPromoname());
		promotionDto.setDiscountPercent(promotion.getDiscountPercent());
		promotionDto.setStartDate(promotion.getStartDate());
		
		if (promotion.getFinishDate() != null) {
			promotionDto.setFinishDate(promotion.getFinishDate());
		}
		
		return promotionDto;
	}
}
