package com.sgic.internal.product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sgic.internal.product.entities.Privilege;

public interface PrivilegeRepo extends JpaRepository<Privilege, Long> {

//	Privilege findPrivilegeById(Long privilageId);

}
