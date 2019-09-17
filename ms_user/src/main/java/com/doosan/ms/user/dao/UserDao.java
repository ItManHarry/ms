package com.doosan.ms.user.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.doosan.ms.user.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
