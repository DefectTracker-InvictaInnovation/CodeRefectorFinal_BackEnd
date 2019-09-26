package com.sgic.internal.product.controller.dto.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sgic.internal.product.controller.dto.ProductPrivilegeDto;
import com.sgic.internal.product.entities.Privilege;
import com.sgic.internal.product.entities.ProductPrivilege;

@Service
public class ProductPrivilegeConverter {
	private static Logger logger = LogManager.getLogger(ProductPrivilege.class);

	// Convert All List<Entity> to List<DTO>
	public static List<ProductPrivilegeDto> EntityListTODtoList(List<ProductPrivilege> productPrivilegeList) {
		if (productPrivilegeList != null) {
			logger.info("Defect Priority Converter -> Convert Lists Entity to DTO");
			List<ProductPrivilegeDto> listProductPrivilegeDto = new ArrayList<>();
			for (ProductPrivilege productPrivilege : productPrivilegeList) {
				ProductPrivilegeDto productPrivilegeDTO = new ProductPrivilegeDto();

				productPrivilegeDTO.setProductPrivilegeId(productPrivilege.getId());
				productPrivilegeDTO.setProductPrivilegeNameId(productPrivilege.getPrivilege().getPrivilegeId());
				productPrivilegeDTO.setProductPrivilegeName(productPrivilege.getPrivilege().getName());
				productPrivilegeDTO.setProductPrivilegeStatus(productPrivilege.isPrivilegeStatus());

				listProductPrivilegeDto.add(productPrivilegeDTO);
			}
			return listProductPrivilegeDto;
		}
		return null;
	}

	// Convert Data To Entity
	public static ProductPrivilege DtoToEntity(ProductPrivilegeDto productPrivilegeDTO) {
		ProductPrivilege productPrivilege = new ProductPrivilege();
		if (productPrivilegeDTO != null) {
			logger.info("Defect Priority Converter -> Convert Object DTO to Entity");
//					productPrivilege.setId(productPrivilegeDto.getProjectPrivilegeId());

			Privilege privilege = new Privilege();
			privilege.setPrivilegeId(productPrivilegeDTO.getProductPrivilegeNameId());
//			privilege.setName(productPrivilegeDto.getProjectPrivilegeName());
			
			productPrivilege.setPrivilege(privilege);

			productPrivilege.setPrivilegeStatus(productPrivilegeDTO.isProductPrivilegeStatus());

			return productPrivilege;
		}
		return null;
	}

	// Convert Data To Entity
	public static ProductPrivilege DtoToEntityUpdate(ProductPrivilegeDto productPrivilegeDTO) {
		ProductPrivilege productPrivilege = new ProductPrivilege();
		if (productPrivilegeDTO != null) {
			logger.info("Defect Priority Converter -> Convert Object DTO to Entity");
			productPrivilege.setId(productPrivilegeDTO.getProductPrivilegeId());

			Privilege privilege = new Privilege();
			privilege.setPrivilegeId(productPrivilegeDTO.getProductPrivilegeNameId());
			privilege.setName(productPrivilegeDTO.getProductPrivilegeName());
			productPrivilege.setPrivilege(privilege);

			productPrivilege.setPrivilegeStatus(productPrivilegeDTO.isProductPrivilegeStatus());

			return productPrivilege;
		}
		return null;
	}

	// Convert Entity To Data
	public static ProductPrivilegeDto EntityToDto(ProductPrivilege productPrivilege) {
		ProductPrivilegeDto productPrivilegeDTO = new ProductPrivilegeDto();
		if (productPrivilege != null) {
			logger.info("Defect Priority Converter -> Convert Object Entity to DTO");
			productPrivilegeDTO.setProductPrivilegeId(productPrivilege.getId());
			productPrivilegeDTO.setProductPrivilegeNameId(productPrivilege.getPrivilege().getPrivilegeId());
			productPrivilegeDTO.setProductPrivilegeName(productPrivilege.getPrivilege().getName());
			productPrivilegeDTO.setProductPrivilegeStatus(productPrivilege.isPrivilegeStatus());

			return productPrivilegeDTO;
		}
		return null;
	}
}
