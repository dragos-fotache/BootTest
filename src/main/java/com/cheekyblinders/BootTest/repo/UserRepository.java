package com.cheekyblinders.BootTest.repo;

import org.springframework.data.repository.CrudRepository;

import com.cheekyblinders.BootTest.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
}
