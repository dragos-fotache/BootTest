package com.cheekyblinders.BootTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cheekyblinders.BootTest.model.User;
import com.cheekyblinders.BootTest.repo.UserRepository;

@Controller
@RequestMapping(path = "/user")
public class MainController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/all")
	public @ResponseBody Iterable<User> findAll() {
		return userRepository.findAll();
	}

	@GetMapping("/{id}")
	public @ResponseBody User findById(@PathVariable("id") Long id) {
		return userRepository.findById(id).orElse(null);
	}
	
	@GetMapping("/add")
	public @ResponseBody String addUser(
					@RequestParam String name, 
					@RequestParam String email) {
		
		User u = new User();
		u.setName(name);
		u.setEmail(email);
		
		this.userRepository.save(u);
		
		return "saved";
	}
	
}
