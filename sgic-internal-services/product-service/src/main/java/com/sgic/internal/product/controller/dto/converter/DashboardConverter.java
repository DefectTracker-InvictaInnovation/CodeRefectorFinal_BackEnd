package com.sgic.internal.product.controller.dto.converter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.sgic.internal.product.controller.dto.DashboardDto;
import com.sgic.internal.product.entities.Dashboard;

@Service
public class DashboardConverter {
	
	public static DashboardDto DashboardToDashboardDto(Dashboard dashboard) {
		DashboardDto dashboardDto = new DashboardDto();
		if (dashboard != null) {
			dashboardDto.setDashboardId(dashboard.getDashboardId());
			dashboardDto.setDashboardName(dashboard.getDashboardName());
			return dashboardDto;
		}
		return null;
	}

	public static Dashboard DashboardDtoToDashboard(DashboardDto dashboardDto) {
		Dashboard dashboard = new Dashboard();
		if (dashboardDto != null) {
			dashboard.setDashboardId(dashboardDto.getDashboardId());
			dashboard.setDashboardName(dashboardDto.getDashboardName());
			return dashboard;
		}

		return null;
	}

	public static List<DashboardDto> DashboardToDashboardDtoList(
			List<Dashboard> dashboardList) {
		if (dashboardList != null) {
			List<DashboardDto> ListdashboardDto = new ArrayList<>();
			for (Dashboard dashboard : dashboardList) {
				DashboardDto dashboardDto = new DashboardDto();
                dashboardDto.setDashboardId(dashboard.getDashboardId());
                dashboardDto.setDashboardName(dashboard.getDashboardName());			
				ListdashboardDto.add(dashboardDto);
			}

			return ListdashboardDto;
		}
		return null;

	}

}
