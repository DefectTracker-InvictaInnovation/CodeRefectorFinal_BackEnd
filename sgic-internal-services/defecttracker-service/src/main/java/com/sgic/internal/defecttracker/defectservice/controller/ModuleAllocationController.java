package com.sgic.internal.defecttracker.defectservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sgic.internal.defecttracker.defectservice.controller.dto.ModuleAllocationDto;
import com.sgic.internal.defecttracker.defectservice.controller.dto.mapper.ModuleAllocationMapper;
import com.sgic.internal.defecttracker.defectservice.entities.ModuleAllocation;
import com.sgic.internal.defecttracker.defectservice.services.ModuleAllocationService;

@CrossOrigin
@RestController
public class ModuleAllocationController<ResultObject> {

	@Autowired
	private ModuleAllocationMapper moduleAllocationMapper;
	
    @Autowired
    private ModuleAllocationService moduleAllocationService;
	
//	<----This APIs Is -- Save Single Object--->
	@PostMapping(value = "/savemoduleallocation")
	public ModuleAllocation createModuleAllocation(@RequestBody ModuleAllocationDto moduleAllocationDto) {
		try {
			moduleAllocationMapper.saveModuleAllocation(moduleAllocationDto);
		} catch (Exception ex) {
			
		}
		return null;

	}
	
	
	 @GetMapping("/list")
	 public ResponseEntity<Iterable<ModuleAllocationDto>> getAllModuleAllocation() {
			return new ResponseEntity<>(moduleAllocationMapper.getAllModuleAllocation(), HttpStatus.OK);
		}

}
