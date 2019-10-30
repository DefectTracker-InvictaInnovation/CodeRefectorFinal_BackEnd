package com.sgic.internal.defecttracker.defectservice.controller.dto;

import java.util.ArrayList;

import com.sgic.internal.defecttracker.defectservice.entities.Project;

public class StatusConfigDto {
	
	private Long statusId;
	private Project project;
	private ArrayList<String> statusList;
	
	public Long getStatusId() {
		return statusId;
	}
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public ArrayList<String> getStatusList() {
		return statusList;
	}
	public void setStatusList(ArrayList<String> statusList) {
		this.statusList = statusList;
	}
	
	
	
	

}
