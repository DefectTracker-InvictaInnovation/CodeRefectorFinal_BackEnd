package com.sgic.internal.product.controller.dto.mapper;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.internal.product.controller.dto.PrivilegeDetailDto;
import com.sgic.internal.product.controller.dto.converter.PrivilegeDetailConverter;
import com.sgic.internal.product.entities.PrivilegeDetail;
import com.sgic.internal.product.services.PrivilegeDetailService;

@Service
public class PrivilegeDetailMapper {

	@Autowired
	private PrivilegeDetailConverter privilegeDetailConverter;
	
	@Autowired
	private PrivilegeDetailService privilegeDetailService;

	// Get All PrivilegeDetail
	@SuppressWarnings("static-access")
	public List<PrivilegeDetailDto> getAllPrivilageDetail() {
		List<PrivilegeDetail> privilagedetaillist = privilegeDetailService.getAllPrivilegeDetail();
		return privilegeDetailConverter.PrivilegeDetailEntityToPrivilegeDetailDtoList(privilagedetaillist);
	}

	// Save PrivilegeDetail
	@SuppressWarnings("static-access")
	public PrivilegeDetail savePrivilegeDetail(PrivilegeDetailDto privilegeDetailDtO) {
		return privilegeDetailService.savePrivilegeDetail(privilegeDetailConverter.PrivilegeDetailDtoToPrivilegeDetail(privilegeDetailDtO));
	}

	// Update PrivilegeDetail
	@SuppressWarnings("static-access")
	public PrivilegeDetail UpdatePrivilegeDetail(PrivilegeDetailDto privilegeDetailDto) {
		PrivilegeDetail privilegeDetail = PrivilegeDetailConverter.PrivilegeDetailDtoToPrivilegeDetail(privilegeDetailDto);
		return privilegeDetailService.updatePrivilegeDetail(privilegeDetailConverter.PrivilegeDetailDtoToPrivilegeDetail(privilegeDetailDto));
	}
	// Delete PrivilegeDetail
	public PrivilegeDetailDto deletePrivilegeDetailById(Long id) {
		privilegeDetailService.deletePrivilegeDetailById(id);
		return null;
	}

	 //Get PrivilegeDetail By Id
	@SuppressWarnings("static-access")
	public PrivilegeDetailDto getPrivilegeDetailById(Long id) {
		PrivilegeDetail privilegeDetail  = privilegeDetailService.getPrivilegeDetailById(id);
		return privilegeDetailConverter.PrivilageDetailEntityTOPrivilegeDetailDto(privilegeDetail);
	}
}
