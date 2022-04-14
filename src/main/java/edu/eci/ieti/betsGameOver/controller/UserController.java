package edu.eci.ieti.betsGameOver.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.ieti.betsGameOver.model.User;
import edu.eci.ieti.betsGameOver.dto.UserDto;
import edu.eci.ieti.betsGameOver.service.UserService;

@RestController
@RequestMapping("/v1/user")
public class UserController {
	
    private final UserService userService;
    
    private static class IdAutoIncrement {
		 
    	private static final Object mutex = new Object();
    	private static Long currentValue = -1L;
    	
    	private static Long getNextValue() {
    		synchronized(mutex) {
    			currentValue += 1;
        		return currentValue;
    		}
    	}
    }

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserDto userDto, @RequestParam String referedUser) {
        String id = String.valueOf(UserController.IdAutoIncrement.getNextValue());
        User user = new User(userDto, LocalDate.now(), id, referedUser);
        return ResponseEntity.status(HttpStatus.OK).body(userService.create(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@RequestBody UserDto userDto, @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.update(userDto, id));
    }

    @PostMapping("/{id}")
    @RolesAllowed("ADMIN")
    public ResponseEntity<Boolean> delete(@PathVariable String id) {
        try{
            userService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body((true));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.ordinal()).body((false));
        }
    }

    @GetMapping("/findUsersWithNameOrLastNameLike/{queryparam}")
    public ResponseEntity<List<User>> findUsersWithNameOrLastNameLike(@PathVariable String queryparam) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findUsersWithNameOrLastNameLike(queryparam));
    }
    
    @GetMapping("/FindByDate/{date}")
    public ResponseEntity<List<User>> findUsersCreatedAfter(@PathVariable String date) throws ParseException{
        Date formatedDate = new SimpleDateFormat("yyyy/MM/dd").parse(date);
        return new ResponseEntity<List<User>>(userService.findUsersCreatedAfter(formatedDate), HttpStatus.OK);
    }
}