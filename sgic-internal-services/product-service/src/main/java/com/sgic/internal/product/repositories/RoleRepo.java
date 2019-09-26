package com.sgic.internal.product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.product.entities.Role;


public interface RoleRepo extends JpaRepository<Role, Long>{

	Role findRoleById(Long roleId);

	Role findRoleByroleId(Long roleId);
}
