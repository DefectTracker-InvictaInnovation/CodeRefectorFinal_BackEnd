package com.sgic.internal.product.controller.dto.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sgic.internal.product.controller.dto.SeverityDto;
import com.sgic.internal.product.entities.DefectSeverity;

@Service
public class SeverityConverter {
	private static Logger logger = LogManager.getLogger(DefectSeverity.class);

	// Convert All List<Entity> to List<DTO>
	public static List<SeverityDto> EntityListTODtoList(List<DefectSeverity> defectSeverityList) {
		if (defectSeverityList != null) {
			logger.info("Defect Severity Converter -> Convert Lists Entity to DTO");
			List<SeverityDto> listSeverityDto = new ArrayList<>();
			for (DefectSeverity defectSeverity : defectSeverityList) {
				SeverityDto severityDto = new SeverityDto();
				severityDto.setId(defectSeverity.getId());
				severityDto.setName(defectSeverity.getName());
				severityDto.setValue(defectSeverity.getValue());
				severityDto.setIcon(defectSeverity.getIcon());
				severityDto.setColor(defectSeverity.getColor());
				listSeverityDto.add(severityDto);
			}
			return listSeverityDto;
		}
		return null;
	}

	// Convert Data To Entity
			public static DefectSeverity DtoToEntity(SeverityDto severityDto) {
				DefectSeverity defectSeverity = new DefectSeverity();
				if (severityDto != null) {
					logger.info("Defect Severity Converter -> Convert Object DTO to Entity");
					defectSeverity.setName(severityDto.getName());
					defectSeverity.setValue(severityDto.getValue());
					defectSeverity.setIcon(severityDto.getIcon());
					defectSeverity.setColor(severityDto.getColor());
					
					return defectSeverity;
				}
				return null;
			}

			// Convert Data To Entity
			public static DefectSeverity DtoToEntityUpdate(SeverityDto severityDto) {
				DefectSeverity defectSeverity = new DefectSeverity();
				if (severityDto != null) {
					logger.info("Defect Severity Converter -> Convert Object DTO to Entity");
					defectSeverity.setId(severityDto.getId());
					defectSeverity.setName(severityDto.getName());
					defectSeverity.setValue(severityDto.getValue());
					defectSeverity.setIcon(severityDto.getIcon());
					defectSeverity.setColor(severityDto.getColor());
					
					return defectSeverity;
				}
				return null;
			}

			// Convert Entity To Data
		public static SeverityDto EntityToDto(DefectSeverity defectSeverity) {
			SeverityDto severityDto = new SeverityDto();
			if (defectSeverity != null) {
				logger.info("Defect Severity Converter -> Convert Object Entity to DTO");
				severityDto.setId(defectSeverity.getId());
				severityDto.setName(defectSeverity.getName());
				severityDto.setValue(defectSeverity.getValue());
				severityDto.setIcon(defectSeverity.getIcon());
				severityDto.setColor(defectSeverity.getColor());
				return severityDto;
			}
			return null;
		}
}
