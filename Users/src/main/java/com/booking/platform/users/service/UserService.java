package com.booking.platform.users.service;

import org.springframework.stereotype.Service;

import com.booking.platform.users.models.AtomicPersistResponse;
import com.booking.platform.users.models.JwtResponse;
import com.booking.platform.users.models.LoginRequest;
import com.booking.platform.users.models.SignupRequest;

@Service
public interface UserService {
	public AtomicPersistResponse saveUser(SignupRequest signUpRequest);
	public JwtResponse authenticateUser(LoginRequest loginRequest);

}
