package com.sgic.internal.defecttracker.defectservice.controller.dto;

import java.util.ArrayList;

import com.sgic.internal.defecttracker.defectservice.entities.Project;

public class SeverityConfigDto {
	
	private Long severityId;
	private Project project;
	private ArrayList<String> severityList;
	
	public Long getSeverityId() {
		return severityId;
	}
	public void setSeverityId(Long severityId) {
		this.severityId = severityId;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public ArrayList<String> getSeverityList() {
		return severityList;
	}
	public void setSeverityList(ArrayList<String> severityList) {
		this.severityList = severityList;
	}
	
	

}
