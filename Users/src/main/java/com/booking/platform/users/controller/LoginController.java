package com.booking.platform.users.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.booking.platform.users.entity.BkpRole;
import com.booking.platform.users.entity.BkpUser;
import com.booking.platform.users.entity.ERole;
import com.booking.platform.users.models.AtomicPersistResponse;
import com.booking.platform.users.models.JwtResponse;
import com.booking.platform.users.models.LoginRequest;
import com.booking.platform.users.models.MessageResponse;
import com.booking.platform.users.models.SignupRequest;
import com.booking.platform.users.repository.RoleRepository;
import com.booking.platform.users.repository.UserRepository;
import com.booking.platform.users.security.JwtHelper;
import com.booking.platform.users.security.services.UserDetailsImpl;
import com.booking.platform.users.security.services.UserDetailsServiceImpl;
import com.booking.platform.users.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class LoginController {
	
	@Autowired
	UserService userService; 


	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Validated @RequestBody LoginRequest loginRequest) {		

		return ResponseEntity.ok(userService.authenticateUser(loginRequest));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Validated @RequestBody SignupRequest signUpRequest) {
		AtomicPersistResponse atomicPersistResponse=userService.saveUser(signUpRequest);
		if (atomicPersistResponse!=null && atomicPersistResponse.isStatus()==false) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse(atomicPersistResponse.isMessage()));
		} 
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
}
