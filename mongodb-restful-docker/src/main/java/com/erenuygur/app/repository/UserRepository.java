package com.erenuygur.app.repository;

import com.erenuygur.app.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
