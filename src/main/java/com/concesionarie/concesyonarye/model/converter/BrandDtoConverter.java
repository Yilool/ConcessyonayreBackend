package com.concesionarie.concesyonarye.model.converter;

import org.springframework.stereotype.Component;

import com.concesionarie.concesyonarye.model.dto.BrandDto;
import com.concesionarie.concesyonarye.model.entity.Brand;

@Component
public class BrandDtoConverter {
	private static final String code = "BRD0";

	public Brand fromBrandDTOToBrand(BrandDto brandDto) {
		Brand brand = new Brand(brandDto.getBrandName());

		return brand;
	}

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
