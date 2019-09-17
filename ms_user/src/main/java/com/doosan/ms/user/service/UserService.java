package com.doosan.ms.user.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.doosan.ms.user.dao.UserDao;
import com.doosan.ms.user.entity.User;
@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public List<User> findAll(){
		return userDao.findAll();
	}
	
	public User findById(Integer id) {
		return userDao.findById(id).get();
	}
	
	public void add(User user) {
		userDao.save(user);
	}
	
	public void update(User user) {
		userDao.save(user);
	}
	
	public void delete(Integer id) {
		userDao.delete(userDao.findById(id).get());
	}
}
