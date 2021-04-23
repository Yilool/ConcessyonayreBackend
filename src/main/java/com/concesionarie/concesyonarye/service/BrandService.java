package com.concesionarie.concesyonarye.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concesionarie.concesyonarye.exception.BrandException;
import com.concesionarie.concesyonarye.exception.ExceptionsCode;
import com.concesionarie.concesyonarye.model.converter.BrandDtoConverter;
import com.concesionarie.concesyonarye.model.dto.BrandDto;
import com.concesionarie.concesyonarye.model.entity.Brand;
import com.concesionarie.concesyonarye.model.repository.BrandRepository;

@Service("BrandService")
public class BrandService {
	@Autowired
	private BrandRepository brandRepository;
	
	@Autowired
	private BrandDtoConverter brandDtoConverter;

	public BrandDto registerNewBrand(String name) throws BrandException {
		Brand brand;

		if (brandRepository.findBrandByBrandName(name.toUpperCase()) != null) {
			throw new BrandException(ExceptionsCode.BRAND_EXISTS);
		} else {
			brand = new Brand(name);
		}

		return brandDtoConverter.fromBrandToBrandDto(brandRepository.save(brand));
	}

	public BrandDto deleteBrand(String code) throws BrandException {
		if (!brandRepository.existsById(Integer.parseInt(code.substring(4)))) {
			throw new BrandException(ExceptionsCode.BRAND_NOT_EXISTS);
		}

		Brand brand = brandRepository.findBrandById(Integer.parseInt(code.substring(4)));

		brand.setFinishDate(LocalDate.now());

		return brandDtoConverter.fromBrandToBrandDto(brandRepository.save(brand));
	}

	public List<BrandDto> getAllBrands() throws BrandException {
		List<Brand> brands = brandRepository.findAll();

		if (brands.size() == 0) {
			throw new BrandException(ExceptionsCode.NOT_BRANDS);
		}

		List<BrandDto> brandDtos = new ArrayList<>();

		brands.stream().forEach(brand -> {
			BrandDto brandDto = brandDtoConverter.fromBrandToBrandDto(brand);
			brandDtos.add(brandDto);
		});

		return brandDtos;
	}
}
