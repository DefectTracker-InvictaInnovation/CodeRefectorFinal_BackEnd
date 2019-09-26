package com.sgic.internal.product.controller.dto.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sgic.internal.product.controller.dto.PriorityDto;
import com.sgic.internal.product.entities.DefectPriority;

@Service
public class PriorityConverter {
	private static Logger logger = LogManager.getLogger(DefectPriority.class);

	// Convert All List<Entity> to List<DTO>
	public static List<PriorityDto> EntityListTODtoList(List<DefectPriority> defectPriorityList) {
		if (defectPriorityList != null) {
			logger.info("Defect Priority Converter -> Convert Lists Entity to DTO");
			List<PriorityDto> listPriorityDto = new ArrayList<>();
			for (DefectPriority defectPriority : defectPriorityList) {
				PriorityDto priorityDto = new PriorityDto();
				priorityDto.setId(defectPriority.getId());
				priorityDto.setName(defectPriority.getName());
				priorityDto.setValue(defectPriority.getValue());
				priorityDto.setIcon(defectPriority.getIcon());
				priorityDto.setColor(defectPriority.getColor());
				listPriorityDto.add(priorityDto);
			}
			return listPriorityDto;
		}
		return null;
	}

	// Convert Data To Entity
			public static DefectPriority DtoToEntityUpdate(PriorityDto priorityDto) {
				DefectPriority defectPriority = new DefectPriority();
				if (priorityDto != null) {
					logger.info("Defect Priority Converter -> Convert Object DTO to Entity");
					defectPriority.setId(priorityDto.getId());
					defectPriority.setName(priorityDto.getName());
					defectPriority.setValue(priorityDto.getValue());
					defectPriority.setIcon(priorityDto.getIcon());
					defectPriority.setColor(priorityDto.getColor());
					
					return defectPriority;
				}
				return null;
			}

			// Convert Data To Entity
			public static DefectPriority DtoToEntity(PriorityDto priorityDto) {
				DefectPriority defectPriority = new DefectPriority();
				if (priorityDto != null) {
					logger.info("Defect Priority Converter -> Convert Object DTO to Entity");
//					defectPriority.setId(priorityDto.getPriorityId());
					defectPriority.setName(priorityDto.getName());
					defectPriority.setValue(priorityDto.getValue());
					defectPriority.setIcon(priorityDto.getIcon());
					defectPriority.setColor(priorityDto.getColor());
					
					return defectPriority;
				}
				return null;
			}

			// Convert Entity To Data
		public static PriorityDto EntityToDto(DefectPriority defectPriority) {
			PriorityDto priorityDto = new PriorityDto();
			if (defectPriority != null) {
				logger.info("Defect Priority Converter -> Convert Object Entity to DTO");
				priorityDto.setId(defectPriority.getId());
				priorityDto.setName(defectPriority.getName());
				priorityDto.setValue(defectPriority.getValue());
				priorityDto.setIcon(defectPriority.getIcon());
				priorityDto.setColor(defectPriority.getColor());
				return priorityDto;
			}
			return null;
		}
}
