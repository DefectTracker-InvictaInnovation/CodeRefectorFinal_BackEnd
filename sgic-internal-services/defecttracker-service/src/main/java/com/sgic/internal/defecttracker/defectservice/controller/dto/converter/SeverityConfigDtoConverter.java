package com.sgic.internal.defecttracker.defectservice.controller.dto.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defectservice.controller.dto.SeverityConfigDto;
import com.sgic.internal.defecttracker.defectservice.entities.SeverityConfig;

@Service
public class SeverityConfigDtoConverter {
	
	public static SeverityConfigDto severityConfigToSeverityConfigDto(SeverityConfig severityConfig) {
		SeverityConfigDto severityConfigDto = new SeverityConfigDto();

		if (severityConfig != null) {

			severityConfigDto.setSeverityId(severityConfig.getSeverityId());
			severityConfigDto.setProject(severityConfig.getProject());
			severityConfigDto.setSeverityList(severityConfig.getSeverityList());

			return severityConfigDto;
		}
		return null;
	}

	public static SeverityConfig severityConfigDtoToSeverityConfig(SeverityConfigDto severityConfigDto) {
		SeverityConfig severityConfig = new SeverityConfig();

		severityConfig.setSeverityId(severityConfigDto.getSeverityId());
		severityConfig.setProject(severityConfigDto.getProject());
		severityConfig.setSeverityList(severityConfigDto.getSeverityList());
	
		return severityConfig;
	}

	public static List<SeverityConfigDto> severityConfigToSeverityConfigDtos(List<SeverityConfig> severityConfigList) {

		if (severityConfigList != null) {
			List<SeverityConfigDto> lSeverityConfigDto = new ArrayList<>();
			for (SeverityConfig severityConfig : severityConfigList) {
				SeverityConfigDto severityConfigDto = new SeverityConfigDto();

				severityConfigDto.setSeverityId(severityConfig.getSeverityId());
				severityConfigDto.setProject(severityConfig.getProject());
				severityConfigDto.setSeverityList(severityConfig.getSeverityList());
				lSeverityConfigDto.add(severityConfigDto);

			}

			return lSeverityConfigDto;
		}
		return null;
	}

}
