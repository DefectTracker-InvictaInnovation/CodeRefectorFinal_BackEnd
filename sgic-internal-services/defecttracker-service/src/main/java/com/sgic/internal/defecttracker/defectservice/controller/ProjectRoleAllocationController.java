package com.sgic.internal.defecttracker.defectservice.controller;

import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sgic.internal.defecttracker.defectservice.controller.dto.ProjectRoleAllocationDto;
import com.sgic.internal.defecttracker.defectservice.controller.dto.mapper.ProjectRoleAllocationMapper;
import com.sgic.internal.defecttracker.defectservice.entities.ProjectRoleAllocation;


@CrossOrigin
@RestController
public class ProjectRoleAllocationController {
	
	
	private RestTemplate restTemplate;
	
	@Autowired
	private ProjectRoleAllocationMapper projectRoleAllocationMapper;
	
	private static Logger logger = LogManager.getLogger(ProjectRoleAllocationMapper.class);

//	<----This APIs Is -- Save Single Object--->
	@PostMapping(value = "/saverole")
	public ProjectRoleAllocation createRole(@RequestBody ProjectRoleAllocationDto projectRoleAllocationDto) {
		try {
			logger.info("Role Controller :--> Successfully Saved");
			projectRoleAllocationMapper.saveRole(projectRoleAllocationDto);
		} catch (Exception ex) {
			logger.error("Role Controller :--> error" + ex.getMessage());
		}
		return null;

	}
	
	@GetMapping(value = "/getAllRole")
	public ResponseEntity<List<ProjectRoleAllocationDto>> getAllRole() {
		logger.info("Project Role Allocation Controller -> GetProjectRole");
		return new ResponseEntity<>(projectRoleAllocationMapper.getAllRole(), HttpStatus.OK);
	}
	
//	@SuppressWarnings("unused")
//	@GetMapping(value = "/saveuser")
//	public String getAllRoleEmail() {
//		RestTemplate restTemplate = new RestTemplate();
//		try {
//			String url = "http://localhost:8081/defectservices/getAllRole";
//			String resp = restTemplate.getForObject(url, String.class);
//
//			JsonParser springParser = JsonParserFactory.getJsonParser();
//			// List<Object> map = springParser.parseList(resp);
//
//			ObjectMapper objectMapper = new ObjectMapper();
//			List<ProjectRoleAllocationDto> listCar = objectMapper.readValue(resp,
//					new TypeReference<List<ProjectRoleAllocationDto>>() {
//					});
//
//			Map<String, String> signup = null;
//			for (ProjectRoleAllocationDto entry : listCar) {
//
//				signup = new HashMap<>();
//				signup.put("email", entry.getEmail());
//				signup.put("username", entry.getFirstname());
//				signup.put("name", entry.getFirstname());
//				signup.put("password", "12345");
//				signup.put("role", "role");
//
//				System.out.println("Email :" + entry.getEmail());
//				System.out.println("First Name :" + entry.getFirstname());
//				System.out.println("name :" + entry.getName());
//
//			}
//
//			
//			HttpHeaders headers = new HttpHeaders();
//			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//			@SuppressWarnings("rawtypes")
//			HttpEntity<Map> entity = new HttpEntity<Map>(signup, headers);
//			System.out.println("yes");
//			return restTemplate.exchange("http://localhost:8085/loginservice/api/auth/signup", HttpMethod.POST, entity,
//					String.class).getBody();
//
//			// return null;
//
//		} catch (Exception ex) {
//			logger.error("Check Your Error");
//			System.out.println("Something went Wrong" + ex.getCause());
//		}
//		return null;
//	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/saveuser")
	public ResponseEntity<List> getAllRoleEmail() {
		try {
			
			String url = "http://localhost:8081/defectservices/getAllRole";
			String resp = restTemplate.getForObject(url, String.class);

			System.out.println("resp" + resp);

			ObjectMapper objectMapper = new ObjectMapper();
			List<ProjectRoleAllocationDto> listCar = objectMapper.readValue(resp,
					new TypeReference<List<ProjectRoleAllocationDto>>() {
					});
			System.out.println("list " + listCar);

			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<List> entity = new HttpEntity<List>(listCar, headers);
			System.out.println("yes");
			ResponseEntity<List> obj = restTemplate.exchange("http://localhost:8085/loginservice/api/auth/signup",
					HttpMethod.POST, entity, List.class);

			System.out.println("obj" + obj);
			return obj;

		} catch (Exception ex) {
			logger.error("Check Your Error");
			System.out.println("Something went Wrong" + ex.getCause());
		}
		return null;
	}
	
	@GetMapping("/getprojectrolebyid/{projectroleId}") 
	public ResponseEntity<ProjectRoleAllocationDto> getProjectRoleAllocationById(@PathVariable(name = "projectroleId") Long projectroleId) {
		try {
			return new ResponseEntity<>(projectRoleAllocationMapper.getByprojectroleId(projectroleId), HttpStatus.OK);

		} catch (Exception ex) {

		}
		return null;

	}
}
