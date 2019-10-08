package com.sgic.internal.product.controller.dto.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.sgic.internal.product.controller.dto.DashboardConfigDto;
import com.sgic.internal.product.entities.DashboardConfig;

@Service
public class DashboardConfigConverter {

	public static DashboardConfigDto DashboardConfigToDashboardConfigDto(DashboardConfig dashboardConfig) {
		DashboardConfigDto dashboardConfigDto = new DashboardConfigDto();
		if (dashboardConfig != null) {

			dashboardConfigDto.setConfigId(dashboardConfig.getConfigId());
			dashboardConfigDto.setRoleName(dashboardConfig.getRoleName());
			dashboardConfigDto.setDashboardList(dashboardConfig.getDashboardList());
			dashboardConfigDto.setUserName(dashboardConfig.getUserName());
			return dashboardConfigDto;
		}
		return null;
	}

	public static DashboardConfig DashboardConfigDtoToDashboardConfig(DashboardConfigDto dashboardConfigDto) {
		DashboardConfig dashboardConfig = new DashboardConfig();
		if (dashboardConfigDto != null) {
			dashboardConfig.setConfigId(dashboardConfigDto.getConfigId());
			dashboardConfig.setRoleName(dashboardConfigDto.getRoleName());
            dashboardConfig.setDashboardList(dashboardConfigDto.getDashboardList());
            dashboardConfig.setUserName(dashboardConfigDto.getUserName());
			return dashboardConfig;
		}

		return null;
	}

	public static List<DashboardConfigDto> DashboardConfigToDashboardConfigDtoList(
			List<DashboardConfig> dashboardConfigList) {
		if (dashboardConfigList != null) {
			List<DashboardConfigDto> ListdashboardconfigDto = new ArrayList<>();
			for (DashboardConfig dashboardConfig : dashboardConfigList ) {
				DashboardConfigDto dashboardConfigDto = new DashboardConfigDto();
				dashboardConfigDto.setConfigId(dashboardConfig.getConfigId());
				dashboardConfigDto.setRoleName(dashboardConfig.getRoleName());
				dashboardConfigDto.setDashboardList(dashboardConfig.getDashboardList());
				dashboardConfigDto.setUserName(dashboardConfig.getUserName());
                ListdashboardconfigDto.add(dashboardConfigDto);
			}

			return ListdashboardconfigDto;
		}
		return null;

	}
}
