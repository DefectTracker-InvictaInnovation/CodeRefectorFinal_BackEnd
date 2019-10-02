package com.sgic.internal.product.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.internal.product.entities.DashboardConfig;
import com.sgic.internal.product.repositories.DashboardConfigRepository;
import com.sgic.internal.product.services.DashboardConfigService;

@Service
public class DashboardConfigServiceImpl implements DashboardConfigService{

	@Autowired
	private DashboardConfigRepository dashboardConfigRepository;
	
	@Override
	public DashboardConfig createDashboardConfig(DashboardConfig dashboardConfig) {
		return dashboardConfigRepository.save(dashboardConfig);
	}

	@Override
	public List<DashboardConfig> getAllDashboardConfig() {
		return dashboardConfigRepository.findAll();
	}

}
