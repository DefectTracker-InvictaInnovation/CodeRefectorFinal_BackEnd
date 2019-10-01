package com.sgic.internal.product.controller.dto.mapper;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.internal.product.controller.dto.DashboardDto;
import com.sgic.internal.product.controller.dto.converter.DashboardConverter;
import com.sgic.internal.product.entities.Dashboard;
import com.sgic.internal.product.services.DashboardService;

@Service
public class DashboardMapper {

	@Autowired
	private DashboardService dashboardService;

	@Autowired
	private DashboardConverter dashboardConverter;

	
	@SuppressWarnings("static-access")
	public Dashboard savedashboard(DashboardDto dashboardDto) {
		return dashboardService.createDashboard(dashboardConverter.DashboardDtoToDashboard(dashboardDto));
	}

	@SuppressWarnings("static-access")
	public List<DashboardDto> getAllDashboard() {
		List<Dashboard> dashboardlist = dashboardService.getAllDashboard();
		return dashboardConverter.DashboardToDashboardDtoList(dashboardlist);
	}
}
