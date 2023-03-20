package com.phase2.FlyAway.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.phase2.FlyAway.model.User;

@Repository
public interface UserReop extends CrudRepository<User, Integer> {

}
