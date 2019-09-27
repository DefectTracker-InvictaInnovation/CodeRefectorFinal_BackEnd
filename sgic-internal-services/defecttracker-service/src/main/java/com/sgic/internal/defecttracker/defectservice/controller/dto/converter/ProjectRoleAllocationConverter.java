package com.sgic.internal.defecttracker.defectservice.controller.dto.converter;


import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.sgic.internal.defecttracker.defectservice.controller.dto.ProjectRoleAllocationDto;
import com.sgic.internal.defecttracker.defectservice.entities.Employee;
import com.sgic.internal.defecttracker.defectservice.entities.ProjectRoleAllocation;
import com.sgic.internal.defecttracker.defectservice.entities.ResourceAllocation;
import com.sgic.internal.defecttracker.defectservice.entities.RoleAllocationList;


@Service
public class ProjectRoleAllocationConverter {

	@Autowired
	private static Logger logger = LogManager.getLogger(ProjectRoleAllocationDto.class);

//	<----Convert Variable Entity To DTO --- For Send DTO In To DataBase ---->
	public static ProjectRoleAllocationDto ProjectRoleAllocationToProjectRoleAllocationDto(
			ProjectRoleAllocation projectRoleAllocation) {
		ProjectRoleAllocationDto projectRoleAllocationDto = new ProjectRoleAllocationDto();
		if (projectRoleAllocation != null) {
			logger.info("Project Role Allocation Converter--- successfully Converte Project Role Allocation Entity To DTO");
            projectRoleAllocationDto.setProjectroleId(projectRoleAllocation.getProjectroleId());
            projectRoleAllocationDto.setRoleId(projectRoleAllocation.getRoleAllocationList().getRoleId());
			projectRoleAllocationDto.setResourceId(projectRoleAllocation.getResourceAllocation().getResourceId());

			return projectRoleAllocationDto;
		}
		return projectRoleAllocationDto;
	}
	
//	<----Convert Variable DTO To Entity  --- For Get  Data Form  DataBase  ---->
	public static ProjectRoleAllocation ProjectRoleAllocationDtoToProjectRoleAllocation(
			ProjectRoleAllocationDto projectRoleAllocationDto) {
		ProjectRoleAllocation projectRoleAllocation = new ProjectRoleAllocation();
		if (projectRoleAllocationDto != null) {
			logger.info("Project Role Allocation Converter--- successfully Converte Project Role Allocation DTO  To Entity");
			projectRoleAllocation.setProjectroleId(projectRoleAllocationDto.getProjectroleId());
			
			ResourceAllocation resourceAllocation = new ResourceAllocation();
			resourceAllocation.setResourceId(projectRoleAllocationDto.getResourceId());
			projectRoleAllocation.setResourceAllocation(resourceAllocation);
			
			RoleAllocationList role = new RoleAllocationList();
			role.setRoleId(projectRoleAllocationDto.getRoleId());
			projectRoleAllocation.setRoleAllocationList(role);
			
			return projectRoleAllocation;
		}

		return null;

	}
	
//	<----Convert Variable DTO To Entity  --- For Get  List  Form  DataBase  ---->
	public static List<ProjectRoleAllocationDto> ProjectRoleAllocationToProjectRoleAllocationDtoList(
			List<ProjectRoleAllocation> projectRoleAllocationList) {
		if (projectRoleAllocationList != null) {
			List<ProjectRoleAllocationDto> ListroleAllocationDto = new ArrayList<>();
			for (ProjectRoleAllocation projectRoleAllocation : projectRoleAllocationList) {
				logger.info("Project Role Allocation Converter--- successfully Converte List");
				ProjectRoleAllocationDto projectRoleAllocationDto = new ProjectRoleAllocationDto();
				projectRoleAllocationDto.setProjectroleId(projectRoleAllocation.getProjectroleId());
				projectRoleAllocationDto.setRoleId(projectRoleAllocation.getRoleAllocationList().getRoleId());
				projectRoleAllocationDto.setRoleName(projectRoleAllocation.getRoleAllocationList().getRoleName());
				projectRoleAllocationDto.setResourceId(projectRoleAllocation.getResourceAllocation().getResourceId());
				
				RestTemplate restTemplate = new RestTemplate();
				ResponseEntity<Employee> response = restTemplate.exchange(
						"http://localhost:8084/employeeservice/getempolyeebyid/"+projectRoleAllocation.getResourceAllocation().getEmpId(), HttpMethod.GET, null,
						new ParameterizedTypeReference<Employee>() {
						});
				Employee employee = response.getBody();
				System.out.println();
				projectRoleAllocationDto.setName(employee.getName());
				projectRoleAllocationDto.setEmail(employee.getEmail());
				projectRoleAllocationDto.setFirstname(employee.getFirstname());
				ListroleAllocationDto.add(projectRoleAllocationDto);

			}

			return ListroleAllocationDto;
		}
		return null;

	}
	
	
}
