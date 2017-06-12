package com.kalifa.kalifa_jms_rest.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.kalifa.kalifa_jms_rest.dto.User;
import com.kalifa.kalifa_jms_rest.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
  private Map<String,User> users;
 
  @PostConstruct
  private void loadUser() {
    users = new HashMap<>();
    users.put("1",new User("Tom",20));
    users.put("2",new User("Jerry",19));
    users.put("3",new User("Maria",29));
    users.put("4",new User("Paulo",14));
    users.put("5",new User("Tadeu",33));
    users.put("6",new User("Giovanna",5));
    users.put("7",new User("Marcia",40));
  }
 
  public User findById(String id) {
	  return users.get(id);
  }
  
  public Map<String,User> findAll() {
	  return users;
  }
}
