package com.doosan.ms.user.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.doosan.ms.user.entity.User;
import com.doosan.ms.user.service.UserService;
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/all")
	public List<User> findAll(){
		return userService.findAll();
	}
	
	@GetMapping("/find/{id}")
	public User getUserById(@PathVariable Integer id) {
		return userService.findById(id);
	}
	
	@PostMapping("/add")
	public String add(@RequestBody User user) {
		userService.add(user);
		return "Add successfully!!!";
	}
	
	@PutMapping("/update/{id}")
	public String update(@RequestBody User user, @PathVariable Integer id) {
		user.setId(id);
		userService.update(user);
		return "Update successfully!!!";
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		userService.delete(id);
		return "Delete successfully!!!";
		
	}
}
