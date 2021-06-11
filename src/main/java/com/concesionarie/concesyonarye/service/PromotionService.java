package com.concesionarie.concesyonarye.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concesionarie.concesyonarye.exception.ExceptionsCode;
import com.concesionarie.concesyonarye.exception.PromotionException;
import com.concesionarie.concesyonarye.model.converter.PromotionDtoConverter;
import com.concesionarie.concesyonarye.model.dto.PromotionDto;
import com.concesionarie.concesyonarye.model.entity.Promotion;
import com.concesionarie.concesyonarye.model.repository.PromotionRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class PromotionService.
 */
@Service("PromotionService")
public class PromotionService {
	
	/** The promotion repository. */
	@Autowired
	private PromotionRepository promotionRepository;
	
	/** The promotion dto converter. */
	@Autowired
	private PromotionDtoConverter promotionDtoConverter;
	
	/**
	 * Register new promotion.
	 *
	 * @param promotionDto the promotion dto
	 * @return the promotion dto
	 * @throws PromotionException the promotion exception
	 */
	public PromotionDto registerNewPromotion(PromotionDto promotionDto) throws PromotionException {
		Promotion promotion;

		if (promotionRepository.findPromotionByPromoname(promotionDto.getPromoname().toUpperCase()) != null) {
			throw new PromotionException(ExceptionsCode.PROMOTION_EXISTS);
		} else {
			promotion = promotionDtoConverter.fromPromotionDTOToPromotion(promotionDto);
		}

		return promotionDtoConverter.fromPromotionToPromotionDto(promotionRepository.save(promotion));
	}
	
	/**
	 * Delete promotion.
	 *
	 * @param cod the cod
	 * @return the promotion dto
	 * @throws PromotionException the promotion exception
	 */
	public PromotionDto deletePromotion(String cod) throws PromotionException {
		Promotion promotion = promotionRepository.findPromotionById(Integer.parseInt(cod.substring(4)));
		
		if (promotion == null) {
			throw new PromotionException(ExceptionsCode.PROMOTION_NOT_EXISTS);
		}
		
		promotion.setFinishDate(LocalDate.now());
		
		return promotionDtoConverter.fromPromotionToPromotionDto(promotionRepository.save(promotion));
	}
	
	/**
	 * Gets the all promotions.
	 *
	 * @return the all promotions
	 * @throws PromotionException the promotion exception
	 */
	public List<PromotionDto> getAllPromotions() throws PromotionException {
		List<Promotion> promotions = promotionRepository.findAll();
		
		if (promotions.size() == 0) {
			throw new PromotionException(ExceptionsCode.NOT_PROMOTIONS);
		}
		
		List<PromotionDto> promotionDtos = new ArrayList<>();
		
		promotions.stream().forEach(promo -> {
			PromotionDto promotionDto = promotionDtoConverter.fromPromotionToPromotionDto(promo);
			promotionDtos.add(promotionDto);
		});
		
		return promotionDtos;
	}
}
