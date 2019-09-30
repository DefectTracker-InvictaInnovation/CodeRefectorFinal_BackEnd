package com.sgic.internal.product.controller.dto.mapper;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.product.controller.dto.StatusDto;
import com.sgic.internal.product.controller.dto.converter.StatusConverter;
import com.sgic.internal.product.entities.DefectStatus;
import com.sgic.internal.product.services.StatusService;
import com.sgic.internal.product.services.impl.StatusServiceImpl;

@Service
public class StatusMapper {
	@Autowired
	private StatusService defectStatusService;

	@Autowired
	private StatusConverter defectStatusConverter;

	private static Logger logger = LogManager.getLogger(StatusServiceImpl.class);

	// Mapper for crating defect status
	public Boolean createDefectStatus(StatusDto defectStatusDto) {
		DefectStatus defectStatus = defectStatusConverter.defectStatusdtotodefectStatus(defectStatusDto);
		defectStatusService.createDefectStatus(defectStatus);
		logger.info("Defect Status Create Mapper");
		return true;
	}

	// Mapper for listing all defect status
	public List<StatusDto> getAllDefectStatus() {
		List<DefectStatus> defectStatusList = defectStatusService.findAllDefectStatus();
		if (defectStatusList != null) {
			logger.info("Defect Status List Mapper");
			return (defectStatusConverter.defectStatusTodefectStatusDto(defectStatusList));
		} else {
			logger.warn("No Defect Status");
			return null;
		}

	}

	// Mapper for getting defect status by id
	public StatusDto getDefectstatusById(Long id) {
		DefectStatus defectStatusList = defectStatusService.findDefectStatusById(id);
		if (defectStatusList != null) {
			logger.info("Defect Status Get By Id Mapper");
			return defectStatusConverter.defectStatustoDefectStatusDto(defectStatusList);
		} else {
			logger.warn("No Defect Status By Id");
			return null;
		}

	}

	// Mapper for delete defect status
	public Boolean deleteDefectStatus(Long id) {
		if (defectStatusService.deleteDefectStatusById(id)) {
			logger.info("Defect Status Delete Mapper");
			return true;
		} else {
			logger.warn("No Defect Status");
			return false;
		}
	}

	// Mapper for update defect status
	public Boolean updateDefectStatus(Long id, StatusDto defectStatusDto) {
		DefectStatus defectStatus = defectStatusConverter.defectStatusdtotodefectStatus(defectStatusDto);
		DefectStatus defectStatusList = defectStatusService.findDefectStatusById(id);
		if (defectStatusList == null) {
			logger.warn("No Defect Status By Id");
			return false;
		} else {
			defectStatus.setId(id);
			defectStatusService.createDefectStatus(defectStatus);
			logger.info("Defect Status Update Mapper");
			return true;
		}
	}
	
	//Mapper for count defect statuses
	public int getStatusCount() {
		return defectStatusService.getStatusCount();
	}
}
