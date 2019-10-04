package com.sgic.internal.login.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

//@RequestMapping(value="/api/auth/signup",method=RequestMethod.POST)

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
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
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sgic.internal.login.entities.ProjectRoleAllocationDto;
import com.sgic.internal.login.entities.Role;
import com.sgic.internal.login.entities.RoleName;
import com.sgic.internal.login.entities.User;
import com.sgic.internal.login.payload.UserProfile;
import com.sgic.internal.login.repositories.RoleRepository;
import com.sgic.internal.login.repositories.UserRepository;
import com.sgic.internal.login.request.LoginForm;
import com.sgic.internal.login.request.SignUpForm;
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
	RestTemplate restTemplate;
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
			user.setName( entry.getFirstname());
			user.setUsername(entry.getFirstname());
			user.setPassword("1234567");

			userRepository.saveAndFlush(user);
		}

		return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
	}

	@GetMapping("/user/me")
	@PreAuthorize("hasRole('ROLE_QA')")
	public UserSummary getCurrentUser(@CurrentUser UserPrinciple currentUser) {
		UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(),
				currentUser.getName());
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

		UserProfile userProfile = new UserProfile(user.getId(), user.getUsername(), user.getName(), user.getEmail());

		return userProfile;
	}
}
