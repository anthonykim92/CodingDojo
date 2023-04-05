package com.codingdojo.loginReg.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.loginReg.models.LoginUser;
import com.codingdojo.loginReg.models.User;
import com.codingdojo.loginReg.repositories.UserRepository;
    

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    

    public User register(User newUser, BindingResult result) {
    	Optional<User> optUser=userRepo.findByEmail(newUser.getEmail());
    	if (optUser.isPresent()) {
    		result.rejectValue("email", null,"Email taken.");
    	}
   
        if (!newUser.getConfirm().equals(newUser.getPassword())) {
        	result.rejectValue("confirm", null,"Passwords do not match.");
        }
        
       
        String hashPW = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt()); 
        newUser.setPassword(hashPW);
        return userRepo.save(newUser);
    	}
   
    public User login(LoginUser newLoginObject, BindingResult result) {
    	Optional<User> optUser=userRepo.findByEmail(newLoginObject.getEmail());
    	if (optUser.isEmpty()) {
    		return null;
    	}
        User user=optUser.get();
        	if (!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
        		return null;
        	}
        	return user;
      
    }
    public User findById(Long id) {
    	Optional<User> potentialUser = userRepo.findById(id);
    	if(potentialUser.isPresent()) {
    		return potentialUser.get();
    	}
    	return null;
    }

}