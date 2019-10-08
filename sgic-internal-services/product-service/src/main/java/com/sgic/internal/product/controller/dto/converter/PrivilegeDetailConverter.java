package com.sgic.internal.product.controller.dto.converter;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import com.sgic.internal.product.controller.dto.PrivilegeDetailDto;
import com.sgic.internal.product.entities.Privilege;
import com.sgic.internal.product.entities.PrivilegeDetail;
import com.sgic.internal.product.entities.Role;

@Service
public class PrivilegeDetailConverter {

	private static Logger logger = LogManager.getLogger(PrivilegeDetailDto.class);

	// Convert All List PrivilegeDetail Entity to Dto
	public static List<PrivilegeDetailDto> PrivilegeDetailEntityToPrivilegeDetailDtoList(List<PrivilegeDetail> privilegedetaillist) {

		if (privilegedetaillist != null) {

			logger.info("Privilege Converter => Convert Lists To Entity");
			List<PrivilegeDetailDto> listPrivilegedetailDto = new ArrayList<>();
			for (PrivilegeDetail privilegeDetail : privilegedetaillist) {
                 PrivilegeDetailDto privilegeDetailDto = new PrivilegeDetailDto();
                 privilegeDetailDto.setId(privilegeDetail.getId());
                 privilegeDetailDto.setPrivilegeId(privilegeDetail.getPrivillage().getPrivilegeId());
                 privilegeDetailDto.setPrivilegeName(privilegeDetail.getPrivillage().getPrivilegeName());
                 privilegeDetailDto.setRoleId(privilegeDetail.getRole().getRoleId());
                 privilegeDetailDto.setRoleName(privilegeDetail.getRole().getRoleName());
				listPrivilegedetailDto.add(privilegeDetailDto);
			}
			return listPrivilegedetailDto;
		}
		return null;
	}

	// Convert PrivilegeDetailDtO to PrivilegeDetail Entity
	public static PrivilegeDetail PrivilegeDetailDtoToPrivilegeDetail(PrivilegeDetailDto privilegeDetailDto) {
		PrivilegeDetail privilegeDetail = new PrivilegeDetail();
		if (privilegeDetailDto != null) {
			logger.info("PrivilegeDetail Converter---> PrivilegeDetail DTO To PrivilegeDetail Entity Converte ");
			privilegeDetail.setId(privilegeDetailDto.getId());
			
			Privilege privilege = new Privilege();
			privilege.setPrivilegeId(privilegeDetailDto.getPrivilegeId());
			privilege.setPrivilegeName(privilegeDetailDto.getPrivilegeName());
			privilegeDetail.setPrivillage(privilege);
			
			Role role = new Role();
			role.setRoleId(privilegeDetailDto.getRoleId());
			role.setRoleName(privilegeDetailDto.getRoleName());
			privilegeDetail.setRole(role);
			
			return privilegeDetail;
		}
		return null;
	}

	// Convert PrivilegeDTO to PrivilegeEntity
	public static PrivilegeDetailDto PrivilageDetailEntityTOPrivilegeDetailDto(PrivilegeDetail privilegeDetail) {

		PrivilegeDetailDto privilegeDetailDto = new PrivilegeDetailDto();
		if (privilegeDetail != null) {
			logger.info("PrivilegeDetail Convert => PrivilageDetail Entity Object to PrivilageDetail Dto");
			privilegeDetailDto.setId(privilegeDetail.getId());
			privilegeDetailDto.setPrivilegeId(privilegeDetail.getPrivillage().getPrivilegeId());
			privilegeDetailDto.setPrivilegeName(privilegeDetail.getPrivillage().getPrivilegeName());
		    privilegeDetailDto.setRoleId(privilegeDetail.getRole().getRoleId());
		    privilegeDetailDto.setRoleName(privilegeDetail.getRole().getRoleName());
			return privilegeDetailDto;
		}
		return null;
	}
}
