package com.concesionarie.concesyonarye.model.converter;

import org.springframework.stereotype.Component;

import com.concesionarie.concesyonarye.model.dto.PromotionDto;
import com.concesionarie.concesyonarye.model.entity.Promotion;

// TODO: Auto-generated Javadoc
/**
 * The Class PromotionDtoConverter.
 */
@Component
public class PromotionDtoConverter {
	
	/** The Constant code. */
	private static final String code = "PRM0";
	
	/**
	 * From promotion DTO to promotion.
	 *
	 * @param promotionDto the promotion dto
	 * @return the promotion
	 */
	public Promotion fromPromotionDTOToPromotion(PromotionDto promotionDto) {
		Promotion promotion = new Promotion(promotionDto.getPromoname(), promotionDto.getDiscountPercent());
		
		return promotion;
	}
	
	/**
	 * From promotion to promotion dto.
	 *
	 * @param promotion the promotion
	 * @return the promotion dto
	 */
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
