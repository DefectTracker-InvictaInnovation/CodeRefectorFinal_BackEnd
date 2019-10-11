package com.sgic.internal.defecttracker.defectservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.defecttracker.defectservice.entities.ProjectRoleAllocation;

public interface ProjectRoleAllocationRepository extends JpaRepository<ProjectRoleAllocation, Long> {

	ProjectRoleAllocation findProjectRoleAllocationByprojectroleId(Long projectroleId);
}
