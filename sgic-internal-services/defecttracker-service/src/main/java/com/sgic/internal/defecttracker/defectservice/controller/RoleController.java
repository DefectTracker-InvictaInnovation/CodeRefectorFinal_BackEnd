package com.sgic.internal.defecttracker.defectservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.internal.defecttracker.defectservice.entities.RoleAllocationList;
import com.sgic.internal.defecttracker.defectservice.services.RoleService;

@CrossOrigin
@RestController
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@GetMapping("/getAllRoleInfo")
	public List<RoleAllocationList> getAllroleInfo(){
		return roleService.getAllRole();	
	}
}
