package edu.eci.ieti.betsGameOver.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import edu.eci.ieti.betsGameOver.data.User;
import edu.eci.ieti.betsGameOver.dto.UserDto;
import edu.eci.ieti.betsGameOver.service.UserService;

@Service("userService")
public class UserServiceHashMap implements UserService {
	
	private Map<String, User> users;
	
	public UserServiceHashMap() {
		users = new HashMap<String, User>();
	}
	
	@Override
	public User create(User user) {
		users.put(user.getId(), user);
		return user;
	}
	
	@Override
	public User findById(String id) {
		User user = users.get(id); 
		return user;
	}

	@Override
	public List<User> getAll() {
		List<User> allUsers = new ArrayList<>(users.values());
		return allUsers;
	}

	@Override
	public Boolean deleteById(String id) {
		Boolean wasDeleted;
		User deletedUser = users.remove(id);
		if (deletedUser == null) {
			wasDeleted = true;
		}
		else {
			wasDeleted = false;
		}
		return wasDeleted;
	}
	
	@Override
	public User update(UserDto userDto, String userId) {
		User user = users.get(userId);
		if (user != null) {
			user.setName(userDto.getName());
			user.setEmail(userDto.getEmail());
			user.setLastName(userDto.getLastName());
			users.put(userId, user);
		}
		return users.get(userId);
	}
	
	@Override
	public User update(User user, String userId) {
		users.put(userId, user);
		return users.get(userId);
	}
	
	@Override
	public List<User> findUsersWithNameOrLastNameLike(String queryText) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<User> findUsersCreatedAfter(Date startDate) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public User findByEmail(String queryText) {
		// TODO Auto-generated method stub
		return null;
	}
}