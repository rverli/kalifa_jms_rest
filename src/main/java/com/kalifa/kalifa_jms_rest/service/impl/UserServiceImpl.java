package com.kalifa.kalifa_jms_rest.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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
    users.put("1",new User(1, "Tom",20));
    users.put("2",new User(2, "Jerry",19));
    users.put("3",new User(3, "Maria",29));
    users.put("4",new User(4, "Paulo",14));
    users.put("5",new User(5, "Tadeu",33));
    users.put("6",new User(6, "Giovanna",5));
    users.put("7",new User(7, "Marcia",40));
  }
 
  private int getNextId() {
	  
	  List<User> list = new ArrayList<User>( users.values() );
	  
	  Collections.reverse( list );
	  
	  User user = (User) list.get( 0 );
	  
	  return user.getId() + 1;
  }
  
  @Override
  public User findById(String id) {
	  return users.get(id);
  }
  
  @Override
  public Map<String,User> findAll() {
	  return users;
  }
  
  @Override
  public void addUser(User user) {
	  
	 users.put( "" + this.getNextId(), user);
  }
  
  @Override
  public void updateUser(String id, User user) {
	// TODO Auto-generated method stub
  }

  @Override
  public void deleteBook(String id) {
	// TODO Auto-generated method stub
  }
}
