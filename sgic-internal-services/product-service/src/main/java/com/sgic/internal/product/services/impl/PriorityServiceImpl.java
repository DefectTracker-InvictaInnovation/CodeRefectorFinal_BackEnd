package com.sgic.internal.product.services.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgic.internal.product.entities.DefectPriority;
import com.sgic.internal.product.repositories.CompanyRepository;
import com.sgic.internal.product.repositories.DefectPriorityRepository;
import com.sgic.internal.product.services.PriorityService;

@Service
public class PriorityServiceImpl implements PriorityService{

	@Autowired
	private DefectPriorityRepository defectPriorityRepository;
	
	private static Logger logger = LogManager.getLogger(PriorityServiceImpl.class);

	// Create defect priority service implementation
	@Override
	public Object createDefectPriority(DefectPriority defectPriority) {
		logger.info("Create Defect Priority Service Implementation");
		return defectPriorityRepository.save(defectPriority);
	}

	// Defect priority exists implementation
	@Override
	@Transactional(readOnly = true)
	public boolean isDefectPriorityAlreadyExists(Long id) {
		logger.info("Defect Priority Exists Service Implementation");
		return defectPriorityRepository.existsById(id);
	}

	// List all defect priorities implementation
	@Override
	public List<DefectPriority> findAllDefectPriority() {
		logger.info("List All Defect Priority Service Implementation");
		return defectPriorityRepository.findAll();
	}

	// Find defect priority by id implementation
	@Override
	public DefectPriority findDefecPriorityById(long id) {
		logger.info("Get Defect Priority By Id Service Implementation");
		return defectPriorityRepository.findById(id).orElse(null);
	}

	// Delete defect priority implementation
	@Override
	public Boolean deleteDefectPriorityById(long id) {
		defectPriorityRepository.deleteById(id);
		logger.info("Delete Defect Priority Service Implementation");
		return true;
	}
}
