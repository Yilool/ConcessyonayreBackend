package com.concesionarie.concesyonarye.model.converter;

import org.springframework.stereotype.Component;

import com.concesionarie.concesyonarye.model.dto.BrandDto;
import com.concesionarie.concesyonarye.model.entity.Brand;

// TODO: Auto-generated Javadoc
/**
 * The Class BrandDtoConverter.
 */
@Component
public class BrandDtoConverter {
	
	/** The Constant code. */
	private static final String code = "BRD0";

	/**
	 * From brand DTO to brand.
	 *
	 * @param brandDto the brand dto
	 * @return the brand
	 */
	public Brand fromBrandDTOToBrand(BrandDto brandDto) {
		Brand brand = new Brand(brandDto.getBrandName());

		return brand;
	}

	/**
	 * From brand to brand dto.
	 *
	 * @param brand the brand
	 * @return the brand dto
	 */
	public BrandDto fromBrandToBrandDto(Brand brand) {
		BrandDto brandDto = new BrandDto();

		brandDto.setCod(code + brand.getId());
		brandDto.setBrandName(brand.getBrandName());
		brandDto.setStartDate(brand.getStartDate());

		if (brand.getFinishDate() != null) {
			brandDto.setFinishDate(brand.getFinishDate());
		}

		return brandDto;
	}
}
