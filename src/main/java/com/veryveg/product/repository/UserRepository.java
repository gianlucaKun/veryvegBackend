package com.veryveg.product.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.veryveg.product.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

	Optional<User> findByEmail(String email);

	Optional<User> findByEmailAndPassword(String email, String password);

	User findByUsername(String username);

}
