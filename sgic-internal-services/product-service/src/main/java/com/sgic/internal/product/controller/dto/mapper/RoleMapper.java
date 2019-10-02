package com.sgic.internal.product.controller.dto.mapper;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.product.controller.dto.RoleDto;
import com.sgic.internal.product.controller.dto.SeverityDto;
import com.sgic.internal.product.controller.dto.converter.RoleConverter;
import com.sgic.internal.product.entities.DefectSeverity;
import com.sgic.internal.product.entities.Role;
import com.sgic.internal.product.services.RoleService;

	@Service
	public class RoleMapper {

		@Autowired
		private RoleService roleService;
		
		@Autowired
		private RoleConverter roleConverter;
		
		@Autowired
		private static Logger logger = LogManager.getLogger(RoleService.class);
		
		@SuppressWarnings("static-access")
//		<--- Get List Method's Mapped  -->
		public List<RoleDto> getAllRole() {
			logger.info("Role Mapper --- Successfully Listed Role --- ");
			List<Role> roleList = roleService.getAllRoleInfo();
			return roleConverter.RoleToRoleDtoList(roleList);
		}
		
		// Save Role
		@SuppressWarnings("static-access")
		public Role saveRole(RoleDto roleDto) {
			logger.info("Role Mapper -> Role Saved");
			return roleService.saveRole(roleConverter.roleDtoToRole(roleDto));
		}

		// Update Role
		@SuppressWarnings("static-access")
		public Role updateRole(RoleDto roleDto) {
			logger.info("Role Mapper -> Role Updated ");
			return roleService.updateRole(roleConverter.roleDtoToRole(roleDto));
		}

		// Delete Role
		public RoleDto deleteRoleById(Long roleId) {
			logger.info("Role Mapper -> Role Deleted");
			roleService.deleteRoleById(roleId);
			return null;
		}

		// Get Role By Id
		@SuppressWarnings("static-access")
		public RoleDto getRoleById(Long roleId) {
			logger.info("Role Mapper -> Role Id Found");
			Role role = roleService.getRoleById(roleId);
			return roleConverter.RoleToRoleDto(role);
		}
	}

