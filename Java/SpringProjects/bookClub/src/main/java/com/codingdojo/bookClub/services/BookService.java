package com.codingdojo.bookClub.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.bookClub.models.Book;
import com.codingdojo.bookClub.repositories.BookRepository;

@Service
public class BookService {
	

		@Autowired
		private BookRepository repo;
		
		public Book findById(Long id) {
			
			Optional<Book> result = repo.findById(id);
			if(result.isPresent()) {
				return result.get();
			}
			
			return null;
		}
		

		public List<Book> all() {
			return repo.findAll();
		}
		
		public Book create(Book book) {
			return repo.save(book);
		
}

		 public Book findBook(Long id) {
		        Optional<Book> optionalBook = repo.findById(id);
		        if(optionalBook.isPresent()) {
		            return optionalBook.get();
		        } else {
		            return null;
		        }
			
		}


		public void delete(Long id) {
			repo.deleteById(id);
			
		}
		 
}
