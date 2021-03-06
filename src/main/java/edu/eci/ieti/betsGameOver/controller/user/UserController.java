package edu.eci.ieti.betsGameOver.controller.user;

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
        User user = new User(userDto, referedUser);
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
}