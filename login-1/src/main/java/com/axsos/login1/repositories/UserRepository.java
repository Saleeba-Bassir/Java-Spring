package com.axsos.login1.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.login1.models.User;

//.. imports .. //

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
 
 Optional<User> findByEmail(String email);
 
}
