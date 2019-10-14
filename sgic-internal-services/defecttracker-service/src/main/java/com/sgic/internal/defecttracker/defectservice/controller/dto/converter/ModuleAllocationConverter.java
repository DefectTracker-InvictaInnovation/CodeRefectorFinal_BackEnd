package com.sgic.internal.defecttracker.defectservice.controller.dto.converter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.sgic.internal.defecttracker.defectservice.controller.dto.ModuleAllocationDto;
import com.sgic.internal.defecttracker.defectservice.entities.Employee;
import com.sgic.internal.defecttracker.defectservice.entities.Module;
import com.sgic.internal.defecttracker.defectservice.entities.ModuleAllocation;
import com.sgic.internal.defecttracker.defectservice.entities.ProjectRoleAllocation;
import com.sgic.internal.defecttracker.defectservice.entities.SubModule;

@Service
public class ModuleAllocationConverter {


//	<----Convert Variable Entity To DTO --- For Send DTO In To DataBase ---->
	public static ModuleAllocationDto ModuleAllocationToModuleAllocationDto(
			ModuleAllocation moduleAllocation) {
		ModuleAllocationDto moduleAllocationDto= new ModuleAllocationDto();
		if (moduleAllocation != null) {
			moduleAllocationDto.setModuleallocationId(moduleAllocation.getModuleallocationId());
			moduleAllocationDto.setProjectroleId(moduleAllocation.getProjectRoleAllocation().getProjectroleId());
//		   moduleAllocationDto.setModuleList(moduleAllocation.getModuleList());
			
			return moduleAllocationDto;
		}
		return moduleAllocationDto;
	}
	
//	<----Convert Variable DTO To Entity  --- For Get  Data Form  DataBase  ---->
	public static ModuleAllocation ModuleAllocationDtoToModuleAllocation(
			ModuleAllocationDto moduleAllocationDto) {
		ModuleAllocation moduleAllocation = new ModuleAllocation();
		if (moduleAllocationDto != null) {
			
			moduleAllocation.setModuleallocationId(moduleAllocationDto.getModuleallocationId());
			
			ProjectRoleAllocation projectRoleAllocation = new ProjectRoleAllocation();
			projectRoleAllocation.setProjectroleId(moduleAllocationDto.getProjectroleId());
			moduleAllocation.setProjectRoleAllocation(projectRoleAllocation);
			
//			moduleAllocation.setModuleList(moduleAllocationDto.getModuleList());
			
			
			return moduleAllocation;
		}

		return null;

	}
	
//	<----Convert Variable DTO To Entity  --- For Get  List  Form  DataBase  ---->
	public static List<ModuleAllocationDto> ModuleAllocationToModuleAllocationDtoList(
			List<ModuleAllocation> moduleAllocationList) {
		if (moduleAllocationList != null) {
			List<ModuleAllocationDto> ListmoduleAllocationDto = new ArrayList<>();
			for (ModuleAllocation moduleAllocation : moduleAllocationList) {
				ModuleAllocationDto moduleAllocationDto = new ModuleAllocationDto();
				moduleAllocationDto.setModuleallocationId(moduleAllocation.getModuleallocationId());
				moduleAllocationDto.setProjectroleId(moduleAllocation.getProjectRoleAllocation().getProjectroleId());
//				moduleAllocationDto.setModuleList(moduleAllocation.getModuleList());
				
				RestTemplate restTemplate = new RestTemplate();
				ResponseEntity<Employee> response = restTemplate.exchange(
						"http://localhost:8084/employeeservice/getempolyeebyid/"+moduleAllocation.getProjectRoleAllocation().getResourceAllocation().getEmpId(), HttpMethod.GET, null,
						new ParameterizedTypeReference<Employee>() {
						});
				Employee employee = response.getBody();
				System.out.println();
				moduleAllocationDto.setEmployeeid(employee.getEmployeeid());
				moduleAllocationDto.setName(employee.getName());
				moduleAllocationDto.setEmail(employee.getEmail());
				moduleAllocationDto.setFirstname(employee.getFirstname());
				ListmoduleAllocationDto.add(moduleAllocationDto);

			}

			return ListmoduleAllocationDto;
		}
		return null;

	}
}
