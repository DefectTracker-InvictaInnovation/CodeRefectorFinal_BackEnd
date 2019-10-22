package com.sgic.internal.product.controller.dto.mapper;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.product.controller.dto.CompanyLicenseTypeDto;
import com.sgic.internal.product.controller.dto.converter.CompanyLicenseTypeConverter;
import com.sgic.internal.product.entities.CompanyLicenseType;
import com.sgic.internal.product.services.CompanyLicenseTypeService;

@Service
public class CompanyLicenceTypeMapper {
	
		@Autowired
		private CompanyLicenseTypeConverter companyLicenseTypeConverter;
		@Autowired
		private CompanyLicenseTypeService companyLicenseTypeService;

		private static Logger logger = LogManager.getLogger(CompanyLicenseTypeDto.class);

		// Get All Company License Type
		@SuppressWarnings("static-access")
		public List<CompanyLicenseTypeDto> getAllCompanyLicenseType() {
			logger.info("Priority Mapper -> All Priority Data Retrieved");
			List<CompanyLicenseType> companyLicenseTypeList = companyLicenseTypeService.getAllCompanyLicenseType();
			return companyLicenseTypeConverter.EntityListTODtoList(companyLicenseTypeList);
		}

		// Save License Type
		@SuppressWarnings("static-access")
		public  CompanyLicenseType saveCompanyLicenseType(CompanyLicenseTypeDto companyLicenseTypeDto) {
			logger.info("CompanyLicenceType Mapper -> CompanyLicenceType Saved");
			return companyLicenseTypeService.saveCompanyLicenseType(companyLicenseTypeConverter.DtoToEntityUpdate(companyLicenseTypeDto));
		}
		
		// Update License Type
		@SuppressWarnings("static-access")
		public CompanyLicenseType updateCompanyLicenseType(CompanyLicenseTypeDto companyLicenseTypeDto) {
			logger.info("CompanyLicenseType Mapper -> CompanyLicenseType Updated ", companyLicenseTypeDto.getLicenseId());
			return companyLicenseTypeService.updateCompanyLicenseType(companyLicenseTypeConverter.DtoToEntityUpdate(companyLicenseTypeDto));
			
		}

		
}
