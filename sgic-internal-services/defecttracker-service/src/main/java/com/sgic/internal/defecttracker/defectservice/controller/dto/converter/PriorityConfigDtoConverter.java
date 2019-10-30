package com.sgic.internal.defecttracker.defectservice.controller.dto.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defectservice.controller.dto.PriorityConfigDto;
import com.sgic.internal.defecttracker.defectservice.entities.PriorityConfig;

@Service
public class PriorityConfigDtoConverter {
	
	public static PriorityConfigDto priorityConfigToPriorityConfigDto(PriorityConfig priorityConfig) {
		PriorityConfigDto priorityConfigDto = new PriorityConfigDto();

		if (priorityConfig != null) {

			priorityConfigDto.setPriorityId(priorityConfig.getPriorityId());
			priorityConfigDto.setProject(priorityConfig.getProject());
			priorityConfigDto.setPriorityList(priorityConfig.getPriorityList());

			return priorityConfigDto;
		}
		return null;
	}

	public static PriorityConfig priorityConfigDtoToPriorityConfig(PriorityConfigDto priorityConfigDto) {
		PriorityConfig priorityConfig = new PriorityConfig();

		priorityConfig.setPriorityId(priorityConfigDto.getPriorityId());
		priorityConfig.setProject(priorityConfigDto.getProject());
		priorityConfig.setPriorityList(priorityConfigDto.getPriorityList());
	
		return priorityConfig;
	}

	public static List<PriorityConfigDto> priorityConfigToPriorityConfigDtos(List<PriorityConfig> priorityConfigList) {

		if (priorityConfigList != null) {
			List<PriorityConfigDto> lPriorityConfigDto = new ArrayList<>();
			for (PriorityConfig priorityConfig : priorityConfigList) {
				PriorityConfigDto priorityConfigDto = new PriorityConfigDto();

				priorityConfigDto.setPriorityId(priorityConfig.getPriorityId());
				priorityConfigDto.setProject(priorityConfig.getProject());
				priorityConfigDto.setPriorityList(priorityConfig.getPriorityList());
				lPriorityConfigDto.add(priorityConfigDto);

			}

			return lPriorityConfigDto;
		}
		return null;
	}

}
