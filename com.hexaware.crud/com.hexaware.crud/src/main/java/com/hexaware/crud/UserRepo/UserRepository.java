package com.hexaware.crud.UserRepo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.crud.Entity.User;

@Repository
public interface UserRepository extends CrudRepository<User,Integer>{
	

}
