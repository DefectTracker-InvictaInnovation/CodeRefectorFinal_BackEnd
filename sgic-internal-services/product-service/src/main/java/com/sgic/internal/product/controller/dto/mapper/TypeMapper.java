package com.sgic.internal.product.controller.dto.mapper;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.product.controller.dto.TypeDto;
import com.sgic.internal.product.controller.dto.converter.TypeConverter;
import com.sgic.internal.product.entities.DefectType;
import com.sgic.internal.product.services.TypeService;
import com.sgic.internal.product.services.impl.TypeServiceImpl;



@Service
public class TypeMapper {
	@Autowired
	private TypeService defectTypeService;
	
	@Autowired
	private TypeConverter defectTypeConverter;
	
	@SuppressWarnings("unused")
	private static Logger logger = LogManager.getLogger(TypeServiceImpl.class);
	
	// Mapper for creating defect type
	public Boolean createDefectType (TypeDto defectTypeDto){
		//BasicConfigurator.configure();
		DefectType defectType = defectTypeConverter.defectTypeDtoToDefectType(defectTypeDto);
		defectTypeService.createDefectType(defectType);
		//logger.info("Defect Type Create Mapper");
		return true;
	}
	
	// Mapper for listing all defect types
	public List<TypeDto> getAllDefectType(){
		//BasicConfigurator.configure();
		List<DefectType> defectTypeList = defectTypeService.findAllDefectType();
		if(defectTypeList != null) {
			//logger.info("Defect Types List Mapper");
			return (defectTypeConverter.defectTypeToDefectTypeDto(defectTypeList));
		}
		else {
			//logger.warn("No Defect Types");
			return null;
		}			
	}
	
	//Mapper for getting defect type by id
	public TypeDto getDefectTypeById(Long id) {
		//BasicConfigurator.configure();		
	    DefectType defectTypeList =defectTypeService.findDefectTypeById(id);
	    if (defectTypeList != null) {
	    	//logger.info("Defect Type Get By Id Mapper");
	    	return defectTypeConverter.defectTypeToDefectTypeDto(defectTypeList);
	    }
	    else {
	    	//logger.warn("No Defect Type By Id");
	    	return null;
	    }	    
	}
	
	// Mapper for delete defect type
	public Boolean deleteDefectType(Long id) {
		//BasicConfigurator.configure();
		if(defectTypeService.deleteDefectTypeById(id)) {
			//logger.info("Defect Type Delete Mapper");
			return true;
		}
		else {
			//logger.warn("No Defect Type");
			return false;
		}		
	}
	
	// Mapper for update defect type
	public Boolean updateDefectType(Long id, TypeDto defectTypeDto) {
		//BasicConfigurator.configure();
		DefectType defectType = defectTypeConverter.defectTypeDtoToDefectType(defectTypeDto);
		DefectType defectTypeList =defectTypeService.findDefectTypeById(id);
		if(defectTypeList == null) {
			//logger.warn("No Defect Type By Id");
			return false;
		}
		else {
			defectType.setId(id);
			defectTypeService.createDefectType(defectType);
			//logger.info("Defect Type Update Mapper");
			return true;
		}		
	}
	
	// Mapper for count defect type
	public int getDefectTypeCount() {
		return defectTypeService.getDefectTypeCount();
	}
}
