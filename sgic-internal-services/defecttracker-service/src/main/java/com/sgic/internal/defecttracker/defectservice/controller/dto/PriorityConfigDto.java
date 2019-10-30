package com.sgic.internal.defecttracker.defectservice.controller.dto;

import java.util.ArrayList;

import com.sgic.internal.defecttracker.defectservice.entities.Project;

public class PriorityConfigDto {
	
	private Long priorityId;
	private Project project;
	private ArrayList<String> priorityList;

	public Long getPriorityId() {
		return priorityId;
	}

	public void setPriorityId(Long priorityId) {
		this.priorityId = priorityId;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public ArrayList<String> getPriorityList() {
		return priorityList;
	}

	public void setPriorityList(ArrayList<String> priorityList) {
		this.priorityList = priorityList;
	}
	
}
