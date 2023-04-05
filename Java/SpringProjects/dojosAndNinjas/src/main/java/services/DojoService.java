package services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import models.Dojo;
import repositories.DojoRepository;

@Service
public class DojoService {
	
	private final DojoRepository repo;
    
    public DojoService(DojoRepository repo) {
        this.repo = repo;
    }
    // returns all the books
    public List<Dojo> all() {
        return repo.findAll();
    }
    // creates a book
    public Dojo create(Dojo dojo) {
    	System.out.println(dojo.getId());
        return repo.save(dojo);
    }
    // retrieves a book
    public Dojo find(Long id) {
        Optional<Dojo> result = repo.findById(id);
        if(result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }
}