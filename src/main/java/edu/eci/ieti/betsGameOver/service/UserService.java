package edu.eci.ieti.betsGameOver.service;

import java.util.Date;
import java.util.List;

import edu.eci.ieti.betsGameOver.model.User;
import edu.eci.ieti.betsGameOver.dto.UserDto;

public interface UserService {
	
    User create(User user);
    
    User findById(String id);
    
    List<User> getAll();
    
    Boolean deleteById(String id);
    
    User update(UserDto userdto, String userId);
    
    User update(User user, String userId);
    
    List<User> findUsersWithNameOrLastNameLike(String queryText);
    
    List<User> findUsersCreatedAfter(Date startDate);
    
    User findByEmail(String queryText);
}