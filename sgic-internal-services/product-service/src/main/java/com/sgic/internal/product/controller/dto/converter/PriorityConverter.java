package com.sgic.internal.product.controller.dto.converter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sgic.internal.product.controller.dto.PriorityDto;
import com.sgic.internal.product.entities.DefectPriority;

@Service
public class PriorityConverter {

	// Convert Entity to Dto
		public static PriorityDto defectPriorityToDefectPriorityDto(DefectPriority defectPriority) {
		PriorityDto defectPriorityDto = new PriorityDto();

			if (defectPriority != null) {
				defectPriorityDto.setId(defectPriority.getId());
				defectPriorityDto.setName(defectPriority.getName());
				defectPriorityDto.setValue(defectPriority.getValue());
				defectPriorityDto.setIcon(defectPriority.getIcon());
				defectPriorityDto.setColor(defectPriority.getColor());
				return defectPriorityDto;
			}
			return null;
		}

		// Convert Dto to Entity
		public static DefectPriority defectPriorityDtoToDefectPriority(PriorityDto defectPriorityDto) {
			DefectPriority defectPriority = new DefectPriority();
			defectPriority.setId(defectPriorityDto.getId());
			defectPriority.setName(defectPriorityDto.getName());
			defectPriority.setValue(defectPriorityDto.getValue());
			defectPriority.setIcon(defectPriorityDto.getIcon());
			defectPriority.setColor(defectPriorityDto.getColor());
			return defectPriority;
		}

		// Convert Entity To Dto List
		public static List<PriorityDto> defectPriorityToDefectPriorityDto(List<DefectPriority> defectPriorityList) {
			if(defectPriorityList != null) {
				List<PriorityDto> defectPriorityDtoList = new ArrayList<>();
				for(DefectPriority defectPriority : defectPriorityList) {
					PriorityDto defectPriorityDto = new PriorityDto();
					defectPriorityDto.setId(defectPriority.getId());
					defectPriorityDto.setName(defectPriority.getName());
					defectPriorityDto.setValue(defectPriority.getValue());
					defectPriorityDto.setIcon(defectPriority.getIcon());
					defectPriorityDto.setColor(defectPriority.getColor());
					defectPriorityDtoList.add(defectPriorityDto);
				}
				return defectPriorityDtoList;
			}
			return null;
		}
		}

