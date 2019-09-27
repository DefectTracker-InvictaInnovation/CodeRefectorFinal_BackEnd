package com.sgic.internal.defecttracker.defectservice.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defectservice.entities.ProjectRoleAllocation;
import com.sgic.internal.defecttracker.defectservice.repositories.ProjectRoleAllocationRepository;
import com.sgic.internal.defecttracker.defectservice.services.ProjectRoleAllocationService;


@Service
public class ProjectRoleAllocationServiceImpl implements ProjectRoleAllocationService{

	@Autowired
	private ProjectRoleAllocationRepository projectRoleAllocationRepository;
	
	@Override
	public ProjectRoleAllocation createroleAllocation(ProjectRoleAllocation projectRoleAllocation) {
		return projectRoleAllocationRepository.save(projectRoleAllocation);
	}

	@Override
	public List<ProjectRoleAllocation> getAllRoleAllocation() {
		return projectRoleAllocationRepository.findAll();
	}
}
