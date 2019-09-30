package com.sgic.internal.product.controller.dto.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sgic.internal.product.controller.dto.TypeDto;
import com.sgic.internal.product.entities.DefectType;

@Service
public class TypeConverter {
	private static Logger logger = LogManager.getLogger(DefectType.class);

	// Convert entity to dto
		public TypeDto defectTypeToDefectTypeDto(DefectType defectType) {
			TypeDto defectTypeDto = new TypeDto();
			
			if(defectType != null) {
				defectTypeDto.setId(defectType.getId());
				defectTypeDto.setName(defectType.getName());
				defectTypeDto.setValue(defectType.getValue());
				return defectTypeDto;
			}
			return null;
		}
		
		// Convert dto to entity 
		public DefectType defectTypeDtoToDefectType(TypeDto defectTypeDto) {
			DefectType defectType = new DefectType();
			defectType.setId(defectTypeDto.getId());
			defectType.setName(defectTypeDto.getName());
			defectType.setValue(defectTypeDto.getValue());
			return defectType;
		}
		
		// Convert entity to dto list
		public List<TypeDto> defectTypeToDefectTypeDto(List<DefectType> defectTypeList){
			if(defectTypeList != null) {
				List<TypeDto> listDefectTypeDto = new ArrayList<>();
				for (DefectType defectType: defectTypeList) {
					TypeDto defectTypeDto = new TypeDto();
					
					defectTypeDto.setId(defectType.getId());
					defectTypeDto.setName(defectType.getName());
					defectTypeDto.setValue(defectType.getValue());
					listDefectTypeDto.add(defectTypeDto);
				}
				return listDefectTypeDto;
			}
			return null;
		}
}
