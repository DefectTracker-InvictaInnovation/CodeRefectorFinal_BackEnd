package com.sgic.internal.login.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.sgic.internal.login.entities.ProjectRoleAllocationDto;
import com.sgic.internal.login.entities.Role;
import com.sgic.internal.login.entities.RoleName;
import com.sgic.internal.login.entities.User;
import com.sgic.internal.login.payload.UserProfile;
import com.sgic.internal.login.repositories.RoleRepository;
import com.sgic.internal.login.repositories.UserRepository;
import com.sgic.internal.login.request.LoginForm;
import com.sgic.internal.login.response.JwtResponse;
import com.sgic.internal.login.response.ResponseMessage;
import com.sgic.internal.login.securityjwt.JwtProvider;
import com.sgic.internal.login.services.CurrentUser;
import com.sgic.internal.login.servicesimpl.UserPrinciple;
import com.sgic.internal.login.servicesimpl.UserSummary;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtProvider jwtProvider;
	
	@Autowired
	PasswordGeneratorran passwordGenerator;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateJwtToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		return ResponseEntity.ok(
				new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities(), userDetails.isEnabled()));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody List<ProjectRoleAllocationDto> projectRoleAllocationDto)
			throws JsonParseException, JsonMappingException, IOException {

		for (ProjectRoleAllocationDto entry : projectRoleAllocationDto) {

			User user = new User();
			user.setEmail(entry.getEmail());
			user.setName(entry.getFirstname());
			user.setUsername(entry.getFirstname());
//			user.setPassword(encoder.encode(entry.getPassword()));
//			userRepository.saveAndFlush(user);
			user.setPassword(passwordGenerator.generateRandomPassword());
			System.out.println("passowrdbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"+user.getPassword());

			if (userRepository.existsByUsername(user.getName())) {
				return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
						HttpStatus.BAD_REQUEST);
			}

			if (userRepository.existsByEmail(user.getEmail())) {
				return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
						HttpStatus.BAD_REQUEST);
			}

			// Creating user's account
			User user1 = new User();
			user1.setUsername(user.getUsername());
			user1.setName(user.getName());
			user1.setEmail(user.getEmail());
			user1.setPassword(encoder.encode(user.getPassword()));

			String strRoles = entry.getRoleName();
			Set<Role> roles = new HashSet<>();

			switch (strRoles) {
			case "Admin":
				Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: admin Role not find."));
				roles.add(adminRole);

				break;
			case "PM":
				Role pmRole = roleRepository.findByName(RoleName.ROLE_PM)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: pm Role not find."));
				roles.add(pmRole);

				break;
			case "QA":
				Role qaRole = roleRepository.findByName(RoleName.ROLE_QA)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: qa Role not find."));
				roles.add(qaRole);

				break;
			case "Developer":
				Role devrole = roleRepository.findByName(RoleName.ROLE_DEVELOPER)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: developer Role not find."));
				roles.add(devrole);

				break;
			case "HR":
				Role hrrole = roleRepository.findByName(RoleName.ROLE_HR)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: hr Role not find."));
				roles.add(hrrole);

				break;
			default:
				Role userRole = roleRepository.findByName(RoleName.ROLE_QA)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(userRole);
			}

			user.setRoles(roles);
			userRepository.save(user1);
		}

		return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
	}

//	@PostMapping("/signup")
//	public ResponseEntity<?> registerUser( @RequestBody SignUpForm signUpRequest) {
//		System.out.println("fffffffffffffffffffffffffffffffffffffff :" + signUpRequest.getEmail());
//		
//
//		
//		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
//			return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
//					HttpStatus.BAD_REQUEST);
//		}
//
//		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
//			return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
//					HttpStatus.BAD_REQUEST);
//		}
//
//		// Creating user's account
//		User user = new User(signUpRequest.getName(), signUpRequest.getUsername(), signUpRequest.getEmail(),
//				encoder.encode(signUpRequest.getPassword()));
//
//	String strRoles = signUpRequest.getRole();
//		Set<Role> roles = new HashSet<>();
//
//		
//			switch (strRoles) {
//			case "admin":
//				Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
//						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: admin Role not find."));
//				roles.add(adminRole);
//
//				break;
//			case "pm":
//				Role pmRole = roleRepository.findByName(RoleName.ROLE_PM)
//						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: pm Role not find."));
//				roles.add(pmRole);
//
//				break;
//			case "qa":
//				Role qaRole = roleRepository.findByName(RoleName.ROLE_QA)
//						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: qa Role not find."));
//				roles.add(qaRole);
//
//				break;
//			case "developer":
//				Role devrole = roleRepository.findByName(RoleName.ROLE_DEVELOPER)
//						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: developer Role not find."));
//				roles.add(devrole);
//
//				break;
//			case "hr":
//				Role hrrole = roleRepository.findByName(RoleName.ROLE_HR)
//						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: hr Role not find."));
//				roles.add(hrrole);
//
//				break;
//			default:
//				Role userRole = roleRepository.findByName(RoleName.ROLE_QA)
//						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
//				roles.add(userRole);
//			}
//
//		user.setRoles(roles);
//		userRepository.save(user);
//
//		return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
//	}

	@GetMapping("/user/me")
    public UserSummary getCurrentUser(@CurrentUser UserPrinciple currentUser) {
        UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getName());
        return userSummary;
    }
	
	@GetMapping("/user/admin")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public UserSummary getCurrentAdmin(@CurrentUser UserPrinciple currentUser) {
		UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(),
				currentUser.getName());
		return userSummary;
	}	
	
	 @GetMapping("/users/{username}")
	    public UserProfile getUserProfile(@PathVariable(value = "username") String username) {
	    User user = userRepository.findByUsername(username);
	                
	        UserProfile userProfile = new UserProfile(user.getId(), user.getUsername(),user.getName(),user.getRoles());

	        return userProfile;
	    }
}
