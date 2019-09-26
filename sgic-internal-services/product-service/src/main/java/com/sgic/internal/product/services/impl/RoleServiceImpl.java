package com.sgic.internal.product.services.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.product.entities.Role;
import com.sgic.internal.product.repositories.RoleRepo;
import com.sgic.internal.product.services.RoleServices;

@Service
public class RoleServiceImpl implements RoleServices{

	@Autowired
	private RoleRepo roleRepo;
	
	private static Logger logger = LogManager.getLogger(RoleRepo.class);
	@Override
	public Role saveRole(Role role) {
		logger.info("service started -> SavePrivilege");
		return roleRepo.save(role);
	}

	@Override
	public List<Role> getAllRole() {
		logger.info("service started -> GetAllPrivilege");
		return roleRepo.findAll();
	}

	@Override
	public Role getRoleById(Long roleId) {
		logger.info("service started -> getPrivilegeById");
		return roleRepo.findRoleById(roleId);
	}

	@Override
	public Role deleteRoleById(Long roleId) {
		logger.info("service started -> deleteRoleById");
		roleRepo.deleteById(roleId);
		return null;
	}

	@Override
	public Role updateRole(Role role) {
		logger.info("service started -> UpdateRole");
		Long roleId = role.getRoleId();
		logger.info("service started -> getRoleId");
		boolean isExist = ((RoleRepo) roleRepo).findById(roleId) != null;
		if (isExist) {
			logger.info("service started -> Updated By roleId");
			return roleRepo.save(role);
		} else {
			logger.info("service started -> roleId Not Found");
		}
		return null;
	}

	@Override
	public Role getRoleById(Long roleId) {
		return roleRepository.findRoleByroleId(roleId);
	}

}
