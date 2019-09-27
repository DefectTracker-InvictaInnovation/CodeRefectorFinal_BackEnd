package com.sgic.internal.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.internal.product.controller.dto.RoleDTO;
import com.sgic.internal.product.controller.dto.SeverityDto;
import com.sgic.internal.product.entities.Role;
import com.sgic.internal.product.services.RoleServices;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class RoleController {
	
	@Autowired
	private RoleServices roleServices;

	@PostMapping("/createRole")
	public Role saveRole(@RequestBody Role role) {
		return roleServices.saveRole(role);	
	}
	
	@GetMapping("/getAllRoleInfo")
	public List<Role> getAllroleInfo(){
		return roleServices.getAllRoleInfo();	
	}
	
	@GetMapping("/getroleById/{roleId}") 
	public ResponseEntity<Role> getRoleById(@PathVariable(name = "roleId") Long roleId) {
			return new ResponseEntity<>(roleServices.getRoleById(roleId),HttpStatus.OK);
	}
}
