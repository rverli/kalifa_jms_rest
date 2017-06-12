package com.kalifa.kalifa_jms_rest.service;

import java.util.Map;

import com.kalifa.kalifa_jms_rest.dto.User;

public interface UserService {

	User findById(String id);
	
	Map<String,User> findAll();
}
