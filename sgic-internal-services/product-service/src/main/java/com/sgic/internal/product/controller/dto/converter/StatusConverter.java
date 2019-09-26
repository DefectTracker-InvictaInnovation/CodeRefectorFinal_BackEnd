package com.sgic.internal.product.controller.dto.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sgic.internal.product.controller.dto.StatusDto;
import com.sgic.internal.product.entities.DefectStatus;

@Service
public class StatusConverter {
	private static Logger logger = LogManager.getLogger(DefectStatus.class);

	// Convert All List<Entity> to List<DTO>
	public static List<StatusDto> EntityListTODtoList(List<DefectStatus> defectStatusList) {
		if (defectStatusList != null) {
			logger.info("Defect Status Converter -> Convert Lists Entity to DTO");
			List<StatusDto> listStatusDto = new ArrayList<>();
			for (DefectStatus defectStatus : defectStatusList) {
				StatusDto statusDto = new StatusDto();
				statusDto.setId(defectStatus.getId());
				statusDto.setName(defectStatus.getName());
				statusDto.setValue(defectStatus.getValue());
				listStatusDto.add(statusDto);
			}
			return listStatusDto;
		}
		return null;
	}

	// Convert Data To Entity
			public static DefectStatus DtoToEntity(StatusDto statusDto) {
				DefectStatus defectStatus = new DefectStatus();
				if (statusDto != null) {
					logger.info("Defect Status Converter -> Convert Object DTO to Entity");
					defectStatus.setName(statusDto.getName());
					defectStatus.setValue(statusDto.getValue());
					return defectStatus;
				}
				return null;
			}

			// Convert Data To Entity
			public static DefectStatus DtoToEntityUpdate(StatusDto statusDto) {
				DefectStatus defectStatus = new DefectStatus();
				if (statusDto != null) {
					logger.info("Defect Status Converter -> Convert Object DTO to Entity");
					defectStatus.setId(statusDto.getId());
					defectStatus.setName(statusDto.getName());
					defectStatus.setValue(statusDto.getValue());
					return defectStatus;
				}
				return null;
			}

			// Convert Entity To Data
		public static StatusDto EntityToDto(DefectStatus defectStatus) {
			StatusDto statusDto = new StatusDto();
			if (defectStatus != null) {
				logger.info("Defect Status Converter -> Convert Object Entity to DTO");
				statusDto.setId(defectStatus.getId());
				statusDto.setName(defectStatus.getName());
				statusDto.setValue(defectStatus.getValue());
				return statusDto;
			}
			return null;
		}

}
