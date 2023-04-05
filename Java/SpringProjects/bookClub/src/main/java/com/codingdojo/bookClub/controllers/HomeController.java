package com.codingdojo.bookClub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.codingdojo.bookClub.models.Book;
import com.codingdojo.bookClub.models.LoginUser;
import com.codingdojo.bookClub.models.User;
import com.codingdojo.bookClub.services.BookService;
import com.codingdojo.bookClub.services.UserService;

@Controller
public class HomeController {
    
    
     @Autowired
    private UserService userServ;
     @Autowired
 	private BookService books;
    
    @GetMapping("/")
    public String index(Model model) {
    
       
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
    	User user = userServ.register(newUser, result);
        
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        
        session.setAttribute("userId", user.getId());
    
        return "redirect:/books";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
 
        User newUser = userServ.login(newLogin, result);
    
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
    
        session.setAttribute("userId", newUser.getId());
    
        return "redirect:/books";
    }
    
    @GetMapping("/books")
    public String welcome(Model model, HttpSession session) {
   	 Long userId = (Long) session.getAttribute("userId");
   	 if(userId==null) {
   		 return "redirect:/";
   	 }
   	model.addAttribute("books", books.all());
	model.addAttribute("user", userServ.findById((Long)session.getAttribute("userId")));
	return "home.jsp";
    }
    
    @GetMapping("/addPage")
    public String addPage(@ModelAttribute("book") Book book, Model model, HttpSession session) {
    	
    	User user = userServ.findById((Long)session.getAttribute("userId"));
    	model.addAttribute("user", user);
    	
    	return "add.jsp";
    }
    @PostMapping("/books")
    public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {

    	if (result.hasErrors()) {
    		return "add.jsp";
    	}
    	
    	books.create(book);
    	
    	return "redirect:/books";
    }
    @GetMapping("/books/{id}")
    public String detail(Model model, @PathVariable("id") Long id, HttpSession session) {
    	if (session.getAttribute("userId")==null) {
    		return "redirect:/";
    	}
    	Book book=books.findById(id);
    	model.addAttribute("book", book);
    	model.addAttribute("user", userServ.findById((Long)session.getAttribute("userId")));
    	
    	return "detail.jsp";
    }
    @GetMapping("/books/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model, HttpSession session) {
    	  Book book = books.findById(id);
          model.addAttribute("book", book);
          model.addAttribute("user", userServ.findById((Long)session.getAttribute("userId")));
          return "edit.jsp";
      }
    @PutMapping("/books/edit/{id}")
    public String update(@Valid @ModelAttribute("book")Book book, BindingResult result) {
    	 if (result.hasErrors()) {
             return "edit.jsp";
         } else {
             books.create(book);
             return "redirect:/books";
         }
     }
    
    @DeleteMapping("/books/edit/{id}")
    public String destroy(@PathVariable("id") Long id, HttpSession session) {
    	if (session.getAttribute("userId")==null) {
    		return "redirect:/books/edit/{id}";
    	}
    	books.delete(id);
        return "redirect:/books";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
   	 session.setAttribute("userId", null);
   	 return "redirect:/";
}
}