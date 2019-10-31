package com.sgic.internal.defecttracker.defectservice.controller.dto;

import java.util.ArrayList;

import com.sgic.internal.defecttracker.defectservice.entities.Project;

public class TypeConfigDto {
	
	private Long typeId;
	private Project project;
	private ArrayList<String> typeList;
	
	public Long getTypeId() {
		return typeId;
	}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public ArrayList<String> getTypeList() {
		return typeList;
	}
	public void setTypeList(ArrayList<String> typeList) {
		this.typeList = typeList;
	}
	
	

}
