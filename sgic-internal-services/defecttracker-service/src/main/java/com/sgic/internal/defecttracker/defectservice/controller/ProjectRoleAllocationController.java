package com.sgic.internal.defecttracker.defectservice.controller;

import java.io.IOException;
import java.util.ArrayList;
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

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sgic.internal.defecttracker.defectservice.controller.dto.EmailDto;
import com.sgic.internal.defecttracker.defectservice.controller.dto.ProjectRoleAllocationDto;
import com.sgic.internal.defecttracker.defectservice.controller.dto.UserDto;
import com.sgic.internal.defecttracker.defectservice.controller.dto.mapper.ProjectRoleAllocationMapper;
import com.sgic.internal.defecttracker.defectservice.entities.ProjectRoleAllocation;

@CrossOrigin
@RestController
public class ProjectRoleAllocationController {

	@Autowired
	public  RestTemplate restTemplate;

	@Autowired
	private ProjectRoleAllocationMapper projectRoleAllocationMapper;

	private static Logger logger = LogManager.getLogger(ProjectRoleAllocationMapper.class);

//	<----This APIs Is -- Save Single Object--->
	@PostMapping(value = "/saverole")
	public ProjectRoleAllocation createRole(@RequestBody ProjectRoleAllocationDto projectRoleAllocationDto) {
		try {
			logger.info("Role Controller :--> Successfully Saved");
			projectRoleAllocationMapper.saveRole(projectRoleAllocationDto);
			
			String url = "http://localhost:8081/defectservices/getAllRole";
			String resp = restTemplate.getForObject(url, String.class);
			
			

			System.out.println("resp" + resp);

			ObjectMapper objectMapper = new ObjectMapper();
			List<ProjectRoleAllocationDto> list = objectMapper.readValue(resp,
					new TypeReference<List<ProjectRoleAllocationDto>>() {
					});
			System.out.println("list " + list);
			
			
			
			for (ProjectRoleAllocationDto entry : list) {
				
				
				name(entry);
				
			System.out.println("respjjjjjjjjjjjjjjjjjjjjj"+entry.getFirstname() );
//				if(!entry.getFirstname().equalsIgnoreCase("Hariloyan")) {
//				
//					System.out.println("respjjjjjjjjjjjjjjjjjjjjj"+entry.getFirstname() );
//					
//				UserDto user = new UserDto();
//				user.setName(entry.getName());
//				user.setUsername(entry.getFirstname());
//				user.setEmail(entry.getEmail());
//				user.setPassword(entry.getPassword());
//				user.setRole(entry.getRoleName());
//				user.setLastname(entry.getFirstname());
//				
//				System.out.println("userList " + user);
//				
//			System.out.println("passowrdbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"+user.getPassword());
//
//			HttpHeaders headers = new HttpHeaders();
//			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//			HttpEntity<UserDto> entity = new HttpEntity<UserDto>(user, headers);
//			System.out.println("yes");
//			ResponseEntity<?> obj = restTemplate.exchange("http://localhost:8085/loginservice/api/auth/signup",
//					HttpMethod.POST, entity, UserDto.class);
//		
//			System.out.println("obj" + obj);
//			
//			
//			EmailDto email=new EmailDto();
//			email.setEmail(entry.getEmail());
//			email.setSubject("This your Password");
//			email.setText("This your Password :"+entry.getPassword() +"This is your UserName :"+entry.getFirstname());
//			
//			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//			HttpEntity<EmailDto> Email = new HttpEntity<EmailDto>(email, headers);
//			System.out.println("yesssssssssssss");
//			ResponseEntity<?> obj1 = restTemplate.exchange("http://localhost:8084/employeeservice/sendmail",
//					HttpMethod.POST, Email, EmailDto.class);
//			System.out.println("obj1" + obj1);
//			
//		}
			
			}
			
			
			
			
			
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

//	@SuppressWarnings("rawtypes")
//	@GetMapping(value = "/saveuser")
//	public ResponseEntity<List> getAllRoleEmail() {
//		try {
//			
//			String url = "http://localhost:8081/defectservices/getAllRole";
//			String resp = restTemplate.getForObject(url, String.class);
//
//			System.out.println("resp" + resp);
//
//			ObjectMapper objectMapper = new ObjectMapper();
//			List<ProjectRoleAllocationDto> listCar = objectMapper.readValue(resp,
//					new TypeReference<List<ProjectRoleAllocationDto>>() {
//					});
//			System.out.println("list " + listCar);
//
//			HttpHeaders headers = new HttpHeaders();
//			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//			HttpEntity<List> entity = new HttpEntity<List>(listCar, headers);
//			System.out.println("yes");
//			ResponseEntity<List> obj = restTemplate.exchange("http://localhost:8085/loginservice/api/auth/signup",
//					HttpMethod.POST, entity, List.class);
//
//			System.out.println("obj" + obj);
//			return obj;
//
//		} catch (Exception ex) {
//			logger.error("Check Your Error");
//			System.out.println("Something went Wrong" + ex.getCause());
//		}
//		return null;
//	}

	@GetMapping("/getprojectrolebyid/{projectroleId}")
	public ResponseEntity<ProjectRoleAllocationDto> getProjectRoleAllocationById(
			@PathVariable(name = "projectroleId") Long projectroleId) {
		try {
			return new ResponseEntity<>(projectRoleAllocationMapper.getByprojectroleId(projectroleId), HttpStatus.OK);

		} catch (Exception ex) {

		}
		return null;

	}
	
	static void name(ProjectRoleAllocationDto entry) {
		
		RestTemplate restTemplate = null;
		System.out.println("respjjjjjjjjjjjjjjjjjjjjj"+entry.getFirstname() );
		
		
		UserDto user = new UserDto();
		user.setName(entry.getName());
		user.setUsername(entry.getFirstname());
		user.setEmail(entry.getEmail());
		user.setPassword(entry.getPassword());
		user.setRole(entry.getRoleName());
		user.setLastname(entry.getFirstname());
		
		System.out.println("userList " + user);
		
	System.out.println("passowrdbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"+user.getPassword());

	HttpHeaders headers = new HttpHeaders();
	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	HttpEntity<UserDto> entity = new HttpEntity<UserDto>(user, headers);
	System.out.println("yes");
	ResponseEntity<?> obj = restTemplate.exchange("http://localhost:8085/loginservice/api/auth/signup",
			HttpMethod.POST, entity, UserDto.class);

	System.out.println("obj" + obj);
	
	
	EmailDto email=new EmailDto();
	email.setEmail(entry.getEmail());
	email.setSubject("This your Password");
	email.setText("This your Password :"+entry.getPassword() +"This is your UserName :"+entry.getFirstname());
	
	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	HttpEntity<EmailDto> Email = new HttpEntity<EmailDto>(email, headers);
	System.out.println("yesssssssssssss");
	ResponseEntity<?> obj1 = restTemplate.exchange("http://localhost:8084/employeeservice/sendmail",
			HttpMethod.POST, Email, EmailDto.class);
	System.out.println("obj1" + obj1);
	
		
	}
	
	@GetMapping(value = "/saveuser")
	public ResponseEntity<?> getAllRoleEmail()
	throws JsonParseException, JsonMappingException, IOException  {
		try {
			
			
			return null;
		} catch (Exception ex) {
			logger.error("Check Your Error");
			System.out.println("Something went Wrong" + ex.getCause());
		}
		return null;
	}

}
