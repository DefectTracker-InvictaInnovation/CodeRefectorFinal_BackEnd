package com.sgic.internal.defecttracker.defectservice.controller.dto.mapper;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.internal.defecttracker.defectservice.controller.dto.ModuleAllocationDto;
import com.sgic.internal.defecttracker.defectservice.controller.dto.converter.ModuleAllocationConverter;
import com.sgic.internal.defecttracker.defectservice.entities.ModuleAllocation;
import com.sgic.internal.defecttracker.defectservice.services.ModuleAllocationService;

@Service
public class ModuleAllocationMapper<ResultObject> {

	@Autowired
	private ModuleAllocationConverter moduleAllocationConverter;
	
	@Autowired
	private ModuleAllocationService moduleAllocationService;


	@SuppressWarnings({ "static-access", "unchecked" })
//	<--- Save Method's Mapped ---Single Object -->
	public ResultObject saveModuleAllocation(ModuleAllocationDto moduleAllocationDto) {
		return (ResultObject) moduleAllocationService.createModuleAllocation(moduleAllocationConverter.ModuleAllocationDtoToModuleAllocation(moduleAllocationDto));
	}			
	
	@SuppressWarnings("static-access")
//	<--- Get List Method's Mapped  -->
	public List<ModuleAllocationDto> getAllModuleAllocation() {
		List<ModuleAllocation> moduleallocationList = moduleAllocationService.getAllModuleAllocation();
		return moduleAllocationConverter.ModuleAllocationToModuleAllocationDtoList(moduleallocationList);
	}
}
