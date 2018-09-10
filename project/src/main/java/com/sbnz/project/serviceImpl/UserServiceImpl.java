package com.sbnz.project.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sbnz.project.DTOs.RegistrationDTO;
import com.sbnz.project.model.Role;
import com.sbnz.project.model.User;
import com.sbnz.project.repository.UserRepository;
import com.sbnz.project.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User register(RegistrationDTO regDTO) throws Exception{
		if(!regDTO.getPassword().equals(regDTO.getRepeatedPassword()))
			throw new Exception("Repeated password doesn't match with password!");
		User user = new User();
		PasswordEncoder enc = new BCryptPasswordEncoder();
		String encoded = enc.encode(regDTO.getPassword());
		user.setName(regDTO.getName());
		user.setPassword(encoded);
		user.setSurname(regDTO.getSurname());
		user.setRole(Role.DOCTOR);
		user.setUsername(regDTO.getUsername());
		return userRepository.save(user);
	}
	
	@Override
	public User findByUsername(String username){
		return userRepository.findByUsername(username);
	}
}
