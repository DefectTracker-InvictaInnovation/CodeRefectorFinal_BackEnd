package com.sgic.internal.defecttracker.defectservice.controller.dto.mapper;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.internal.defecttracker.defectservice.controller.dto.ModuleAllocationDto;
import com.sgic.internal.defecttracker.defectservice.controller.dto.converter.ModuleAllocationConverter;
import com.sgic.internal.defecttracker.defectservice.entities.ModuleAllocation;
import com.sgic.internal.defecttracker.defectservice.services.ModuleAllocationService;

@Service
public class ModuleAllocationMapper {

	@Autowired
	private ModuleAllocationConverter moduleAllocationConverter;
	
	@Autowired
	private ModuleAllocationService moduleAllocationService;


	@SuppressWarnings("static-access")
//	<--- Save Method's Mapped ---Single Object -->
	public ModuleAllocation saveModuleAllocation(ModuleAllocationDto moduleAllocationDto) {
		return moduleAllocationService.createModuleAllocation(moduleAllocationConverter.ModuleAllocationDtoToModuleAllocation(moduleAllocationDto));
	}			
	
	@SuppressWarnings("static-access")
//	<--- Get List Method's Mapped  -->
	public List<ModuleAllocationDto> getAllModuleAllocation() {
		List<ModuleAllocation> moduleallocationList = moduleAllocationService.getAllModuleAllocation();
		return moduleAllocationConverter.ModuleAllocationToModuleAllocationDtoList(moduleallocationList);
	}
}
