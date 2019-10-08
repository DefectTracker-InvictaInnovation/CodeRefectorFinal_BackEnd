package com.sgic.internal.product.controller.dto.mapper;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.internal.product.controller.dto.DashboardConfigDto;
import com.sgic.internal.product.controller.dto.converter.DashboardConfigConverter;
import com.sgic.internal.product.entities.DashboardConfig;
import com.sgic.internal.product.services.DashboardConfigService;

@Service
public class DashboardConfigMapper<ResultObject> {


	@Autowired
	private DashboardConfigService dashboardConfigService;

	@Autowired
	private DashboardConfigConverter dashboardConfigConverter;

	
	@SuppressWarnings({ "static-access", "unchecked" })
	public ResultObject savedashboardconfig(DashboardConfigDto dashboardConfigDto) {
		return (ResultObject) dashboardConfigConverter.DashboardConfigDtoToDashboardConfig(dashboardConfigDto);
	}

	@SuppressWarnings("static-access")
	public List<DashboardConfigDto> getAllDashboardConfig() {
		List<DashboardConfig> dashboardconfiglist = dashboardConfigService.getAllDashboardConfig();
		return dashboardConfigConverter.DashboardConfigToDashboardConfigDtoList(dashboardconfiglist);
	}
}
