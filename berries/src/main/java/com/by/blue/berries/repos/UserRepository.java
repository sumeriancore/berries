package com.by.blue.berries.repos;

import com.by.blue.berries.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
