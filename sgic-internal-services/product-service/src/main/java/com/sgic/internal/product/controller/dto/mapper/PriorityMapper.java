package com.sgic.internal.product.controller.dto.mapper;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.internal.product.controller.dto.PriorityDto;
import com.sgic.internal.product.controller.dto.converter.PriorityConverter;
import com.sgic.internal.product.entities.DefectPriority;
import com.sgic.internal.product.services.PriorityService;
import com.sgic.internal.product.services.impl.PriorityServiceImpl;


@Service
public class PriorityMapper {
	@Autowired
	private PriorityService defectPriorityService;

	@Autowired
	private PriorityConverter defectPriorityConverter;

	private static Logger logger = LogManager.getLogger(PriorityServiceImpl.class);

	// Mapper for creating defect priority
	public Boolean createDefectPriority(PriorityDto defectPriorityDto) {
		// BasicConfigurator.configure();
		DefectPriority defectPriority = PriorityConverter.defectPriorityDtoToDefectPriority(defectPriorityDto);
		defectPriorityService.createDefectPriority(defectPriority);
		logger.info("Defect Priority Create Mapper");
		return true;
	}
	
	// Mapper for listing all defect priorities
		@SuppressWarnings("static-access")
		public List<PriorityDto> getAllDefectPriority(){
			//BasicConfigurator.configure();
			List<DefectPriority> defectPriorityList = defectPriorityService.findAllDefectPriority();
			if(defectPriorityList != null) {
				logger.info("Defect Priority List Mapper");
				return (defectPriorityConverter.defectPriorityToDefectPriorityDto(defectPriorityList));
			}
			else {
				logger.warn("No Defect Priorities");
				return null;
			}				
		}
		
		//Mapper for getting defect priority by id
		public PriorityDto getDefectPriorityById(Long id) {
			//BasicConfigurator.configure();		
			DefectPriority defectPriorityList =defectPriorityService.findDefecPriorityById(id);
		    if (defectPriorityList != null) {
		    	logger.info("Defect Priority Get By Id Mapper");
		    	return PriorityConverter.defectPriorityToDefectPriorityDto(defectPriorityList);
		    }
		    else {
		    	logger.warn("No Defect Priority By Id");
		    	return null;
		    }	    
		}
		
		// Mapper for delete defect priority
		public Boolean deleteDefectPriority(Long id) {
			//BasicConfigurator.configure();
			if(defectPriorityService.deleteDefectPriorityById(id)) {
				logger.info("Defect Priority Delete Mapper");
				return true;
			}
			else {
				logger.warn("No Defect Priority");
				return false;
			}		
		}
		
		// Mapper for update defect priority
		public Boolean updateDefectPriority(Long id, PriorityDto defectPriorityDto) {
			//BasicConfigurator.configure();
			DefectPriority defectPriority = PriorityConverter.defectPriorityDtoToDefectPriority(defectPriorityDto);
			DefectPriority defectPriorityList =defectPriorityService.findDefecPriorityById(id);
			if(defectPriorityList == null) {
				logger.warn("No Defect Priority By Id");
				return false;
			}
			else {
				defectPriority.setId(id);
				defectPriorityService.createDefectPriority(defectPriority);
				logger.info("Defect Priority Update Mapper");
				return true;
			}		
		}

}
