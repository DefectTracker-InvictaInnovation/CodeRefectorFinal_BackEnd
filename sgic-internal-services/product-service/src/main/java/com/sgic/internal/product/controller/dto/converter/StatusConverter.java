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
	// Convert entity to dto
		public StatusDto defectStatustoDefectStatusDto(DefectStatus defectStatus) {
			StatusDto defectStatusdto = new StatusDto();
			if (defectStatus != null) {
				defectStatusdto.setId(defectStatus.getId());
				defectStatusdto.setName(defectStatus.getName());
				defectStatusdto.setValue(defectStatus.getValue());
				return defectStatusdto;
			}
			return null;
		}

	// Convert dto to entity
		public DefectStatus defectStatusdtotodefectStatus(StatusDto defectStatusDto) {
			DefectStatus defectStatus = new DefectStatus();

			defectStatus.setId(defectStatusDto.getId());
			defectStatus.setName(defectStatusDto.getName());
			defectStatus.setValue(defectStatusDto.getValue());
			return defectStatus;
		}

	// Convert entity to dto list

		public List<StatusDto> defectStatusTodefectStatusDto(List<DefectStatus> defectStatusList) {
			if (defectStatusList != null) {
				List<StatusDto> listDefectStatusDto = new ArrayList<>();
				for (DefectStatus defectStatus : defectStatusList) {
					StatusDto defectStatusDto = new StatusDto();

					defectStatusDto.setId(defectStatus.getId());
					defectStatusDto.setName(defectStatus.getName());
					defectStatusDto.setValue(defectStatus.getValue());
					listDefectStatusDto.add(defectStatusDto);
				}
				return listDefectStatusDto;
			}
			return null;
		}
}
