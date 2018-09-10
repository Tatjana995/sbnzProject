package com.sbnz.project.service;

import com.sbnz.project.DTOs.RegistrationDTO;
import com.sbnz.project.model.User;

public interface UserService {
	
	User register(RegistrationDTO registerDTO) throws Exception;
	
	User findByUsername(String username);

}
