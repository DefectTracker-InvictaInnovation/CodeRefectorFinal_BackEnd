package com.sgic.internal.product.entities;




import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name ="dashboardConfig")
public class DashboardConfig {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long configId;
	
	
	private String roleName;


	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private ArrayList<String> dashboardList;
//	 private List<String> dashboardList;

	public Long getConfigId() {
		return configId;
	} 

	public void setConfigId(Long configId) {
		this.configId = configId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public ArrayList<String> getDashboardList() {
		return dashboardList;
	}

	public void setDashboardList(ArrayList<String> dashboardList) {
		this.dashboardList = dashboardList;
	}

	
	
	
	
}
