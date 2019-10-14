package com.sgic.internal.defecttracker.defectservice.controller.dto;

import java.util.ArrayList;

public class ModuleAllocationDto {

	private Long moduleallocationId;
	private Long projectroleId;
	private String employeeid;
	private String name;
	private String firstname;
	private String email;
	private ArrayList<String> moduleList;
	
	public Long getModuleallocationId() {
		return moduleallocationId;
	}
	public void setModuleallocationId(Long moduleallocationId) {
		this.moduleallocationId = moduleallocationId;
	}
	public Long getProjectroleId() {
		return projectroleId;
	}
	public void setProjectroleId(Long projectroleId) {
		this.projectroleId = projectroleId;
	}
	public String getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ArrayList<String> getModuleList() {
		return moduleList;
	}
	public void setModuleList(ArrayList<String> moduleList) {
		this.moduleList = moduleList;
	}
	
	
}

