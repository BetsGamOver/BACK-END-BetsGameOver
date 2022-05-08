package edu.eci.ieti.betsGameOver.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCrypt;

import edu.eci.ieti.betsGameOver.data.RoleEnum;
import edu.eci.ieti.betsGameOver.dto.UserDto;

@Document(collection = "users")
public class User {
	
	private static class IdSequence {
    	private static final Object mutex = new Object();
    	private static Long currentValue = -1L;	
    	private static Long getNextValue() {
    		synchronized(mutex) {
    			currentValue += 1;
        		return currentValue;
    		}
    	}
    };
	
    @Id
    private String id;
    private String name;
    private String lastName;
    @Indexed(unique = true)
    private String email;
    @Indexed(unique = true)
    private String username;
    private LocalDate createdAt;
    private String passwordHash;
    private List<RoleEnum> roles;
    private int amount = 0;
    private String referedUser;

    public User(){

    }

    public User(UserDto userDto, String referedUser) { 
        this.id = String.valueOf(User.IdSequence.getNextValue());
        this.name = userDto.getName();
        this.lastName = userDto.getLastName();
        this.email = userDto.getEmail();
        this.username = userDto.getUsername();
        this.createdAt = LocalDate.now();
        this.passwordHash = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt());
        roles = new ArrayList<>(Collections.singleton( RoleEnum.USER ));
        this.referedUser = referedUser; 
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public List<RoleEnum> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEnum> roles) {
        this.roles = roles;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
    public String getId() {
        return String.valueOf(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getReferedUser() {
		return referedUser;
	}

	public void setReferedUser(String referedUser) {
		this.referedUser = referedUser;
	}

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}