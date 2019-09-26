//package com.sgic.internal.product.services.impl;
//
//import java.util.List;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.sgic.internal.product.entities.Privilege;
//import com.sgic.internal.product.repositories.PrivilegeRepo;
//import com.sgic.internal.product.services.PrivilegeService;
//
//@Service
//public class PrivilegeServiceImpl implements PrivilegeService {
//
//	@Autowired
//	PrivilegeRepo privilegeRepo;
//	
//	private static Logger logger = LogManager.getLogger(PrivilegeRepo.class);
//	@Override
//	public Privilege getPrivilegeById(Long privilageId) {
//		logger.info("service started -> getPrivilegeById");
//		return privilegeRepo.findPrivilegeById(privilageId);
//	}
//
//	@Override
//	public Privilege savePrivilege(Privilege privilege) {
//		logger.info("service started -> SavePrivilege");
//		return privilegeRepo.save(privilege);
//	}
//
//	@Override
//	public List<Privilege> getAllPrivilege() {
//		logger.info("service started -> GetAllPrivilege");
//		return privilegeRepo.findAll();
//	}
//
//	@Override
//	public Privilege deletePrivilegeById(Long privilageId) {
//		logger.info("service started -> deletePrivilegeById");
//		privilegeRepo.deleteById(privilageId);
//		return null;
//	}
//
//
//	@Override
//	public Privilege updatePrivilege(Privilege privilege) {
//		logger.info("service started -> UpdatePrivilege");
//		Long privilageId = privilege.getPrivilegeId();
//		logger.info("service started -> getPrivilegeId");
//		boolean isExist = ((PrivilegeRepo) privilegeRepo).findById(privilageId) != null;
//		if (isExist) {
//			logger.info("service started -> Updated By privilegeId");
//			return privilegeRepo.save(privilege);
//		} else {
//			logger.info("service started -> privilegeId Not Found");
//		}
//		return null;
//	}
//	
//}
//
