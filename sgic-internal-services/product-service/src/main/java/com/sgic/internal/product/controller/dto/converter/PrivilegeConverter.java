package com.sgic.internal.product.controller.dto.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import com.sgic.internal.product.controller.dto.PrivilegeDto;
import com.sgic.internal.product.entities.Privilege;

@Service
public class PrivilegeConverter {

	private static Logger logger = LogManager.getLogger(PrivilegeDto.class);

	// Convert All List Privilege Entity to Dto
	public static List<PrivilegeDto> PrivilegeEntityToPrivilegeDTOList(List<Privilege> privilegelist) {

		if (privilegelist != null) {

			logger.info("Privilege Converter => Convert Lists To Entity");
			List<PrivilegeDto> listPrivilegeDto = new ArrayList<>();
			for (Privilege privilege : privilegelist) {
				PrivilegeDto privilegeDTO = new PrivilegeDto();
				privilegeDTO.setPrivilegeId(privilege.getPrivilegeId());
				privilegeDTO.setPrivilegeName(privilege.getPrivilegeName());
				listPrivilegeDto.add(privilegeDTO);
			}
			return listPrivilegeDto;
		}
		return null;
	}

	// Convert PrivilegeDTO to PrivilegeEntity
	public static Privilege PrivilegeDtoToPrivilege(PrivilegeDto privilegeDto) {
		Privilege privilege = new Privilege();
		if (privilegeDto != null) {
			logger.info("Privilege Converter---> Privilege DTO To Privilege Entity Converte ");
			privilege.setPrivilegeId(privilegeDto.getPrivilegeId());
			privilege.setPrivilegeName(privilegeDto.getPrivilegeName());
			return privilege;
		}
		return null;
	}

	// Convert PrivilegeDTO to PrivilegeEntity
	public static PrivilegeDto PrivilageEntityTOPrivilegeDTO(Privilege privilege) {

		PrivilegeDto privilegeDTO = new PrivilegeDto();
		if (privilege != null) {
			logger.info("Privilege Convert => Privilage Entity Object to Privilege Dto");
			privilegeDTO.setPrivilegeId(privilege.getPrivilegeId());
			privilegeDTO.setPrivilegeName(privilege.getPrivilegeName());
			return privilegeDTO;
		}
		return null;
	}
}
