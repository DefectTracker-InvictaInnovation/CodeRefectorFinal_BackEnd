package com.sgic.internal.defecttracker.defectservice.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sgic.internal.defecttracker.defectservice.controller.dto.ProjectRoleAllocationDto;
import com.sgic.internal.defecttracker.defectservice.controller.dto.mapper.ProjectRoleAllocationMapper;
import com.sgic.internal.defecttracker.defectservice.entities.ProjectRoleAllocation;

@CrossOrigin
@RestController
public class ProjectRoleAllocationController {

	
	@SuppressWarnings("unused")
	@Autowired(required = false)
	private ProjectRoleAllocationDto projectRoleAllocationDto;
	
	@Autowired
	private ProjectRoleAllocationMapper projectRoleAllocationMapper;
	
	private static Logger logger = LogManager.getLogger(ProjectRoleAllocationMapper.class);

//	<----This APIs Is -- Save Single Object--->
	@PostMapping(value = "/saverole")
	public ProjectRoleAllocation createRole(@RequestBody ProjectRoleAllocationDto projectRoleAllocationDto) {
		try {
			logger.info("Role Controller :--> Successfully Saved");
			projectRoleAllocationMapper.saveRole(projectRoleAllocationDto);
		} catch (Exception ex) {
			logger.error("Role Controller :--> error" + ex.getMessage());
		}
		return null;

	}
	
	@GetMapping(value = "/getAllRole")
	public ResponseEntity<List<ProjectRoleAllocationDto>> getAllRole() {
		logger.info("Project Role Allocation Controller -> GetProjectRole");
		return new ResponseEntity<>(projectRoleAllocationMapper.getAllRole(), HttpStatus.OK);
	}
}
