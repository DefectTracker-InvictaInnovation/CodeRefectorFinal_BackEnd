package com.sgic.internal.defecttracker.defectservice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="assignRole")
public class ProjectRoleAllocation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="projectrole_id")
	private Long projectroleId;
	
	@ManyToOne
	@JoinColumn(name="resource_id", nullable=false)
	private ResourceAllocation resourceAllocation;

	@ManyToOne
	@JoinColumn(name="roleId", nullable=false)
	private Role roleAllocationList;
	

	public Long getProjectroleId() {
		return projectroleId;
	}

	public void setProjectroleId(Long projectroleId) {
		this.projectroleId = projectroleId;
	}

	public ProjectRoleAllocation() {
		super();
	}

	public ResourceAllocation getResourceAllocation() {
		return resourceAllocation;
	}

	public void setResourceAllocation(ResourceAllocation resourceAllocation) {
		this.resourceAllocation = resourceAllocation;
	}

	public Role getRoleAllocationList() {
		return roleAllocationList;
	}

	public void setRoleAllocationList(Role roleAllocationList) {
		this.roleAllocationList = roleAllocationList;
	}


}
