package com.sgic.internal.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sgic.internal.product.controller.dto.CompanyDto;
//import com.sgic.internal.product.controller.dto.DashboardConfigDto;
import com.sgic.internal.product.entities.DashboardConfig;
import com.sgic.internal.product.services.DashboardConfigService;

import lombok.Data;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DashboardConfigController<ResultObject> {

    @Autowired
	private DashboardConfigService dashboardConfigService;
	
	
	@PostMapping(value = "/createdashboardconfig")
	public ResultObject savedashbordconfog( @RequestBody  DashboardConfig dashboardConfig) {
		System.out.println(dashboardConfig.getDashboardList().get(0).length());
		DashboardConfig obj=new DashboardConfig();
		obj.setConfigId(dashboardConfig.getConfigId());
		obj.setRoleName(dashboardConfig.getRoleName());
		obj.setDashboardList(dashboardConfig.getDashboardList());
		dashboardConfigService.createDashboardConfig(dashboardConfig);
//		 dashboardConfigMapper.savedashboardconfig(dashboardConfigDto);
		return null;
	}
	
	
	@GetMapping("/Config")
	public List<DashboardConfig> getAllDashboardConfig() {	
		return dashboardConfigService.getAllDashboardConfig();
	}
}
