package edu.eci.ieti.betsGameOver.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.eci.ieti.betsGameOver.dto.UserDto;
import edu.eci.ieti.betsGameOver.model.User;
import edu.eci.ieti.betsGameOver.repository.UserRepository;
import edu.eci.ieti.betsGameOver.service.UserService;

@Service("userService")
public class UserServiceRepository implements UserService {
	
	@Resource(name = "userRepository")
	private UserRepository userRepository;

	@Override
	public User create(User user) {
		return userRepository.save(user);
	}

	@Override
	public User findById(String id) {
		User user = userRepository.findUserById(id);
		return user;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(UserDto userdto, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(User user, String userId) {
		// TODO Auto-generated method stub
		return null;
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