package com.codingdojo.bookClub.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.bookClub.models.LoginUser;
import com.codingdojo.bookClub.models.User;
import com.codingdojo.bookClub.repositories.UserRepository;
    

@Service
public class UserService {
	@Autowired 
	private UserRepository repo;
    
    @Autowired
    private UserRepository userRepo;
    

    public User register(User newUser, BindingResult result) {
    	Optional<User> optUser=userRepo.findByEmail(newUser.getEmail());
    	if (optUser.isPresent()) {
    		result.rejectValue("email", "Unique","Email taken.");
    	}
   
        if (!newUser.getConfirm().equals(newUser.getPassword())) {
        	result.rejectValue("confirm", "Matches","Invalid password.");
        }
        if(result.hasErrors()) {
    		return null;
    	}
    
       
        String hashPW = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt()); 
        newUser.setPassword(hashPW);
        return userRepo.save(newUser);
    	}
   
    public User login(LoginUser newLoginObject, BindingResult result) {
    	Optional<User> optUser=userRepo.findByEmail(newLoginObject.getEmail());
    	if (!optUser.isPresent()) {
    		result.rejectValue("email", "Missing Account","Invalid email.");
    		return null;
    	
    	}
        User user=optUser.get();
        	if (!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
        		result.rejectValue("password", null,"Invalid password.");
        		return null;
        	}
        	 if(result.hasErrors()) {
         		return null;
         			
         	}
         
        	return user;
      
    }
	public User findByEmail(String email) {
		
		Optional<User> result = repo.findByEmail(email);
		if(result.isPresent()) {
			return result.get();
		}
		
		return null;
	}
    public User findById(Long id) {
    	Optional<User> potentialUser = userRepo.findById(id);
    	if(potentialUser.isPresent()) {
    		return potentialUser.get();
    	}
    	return null;
    }

}