package com.nc.edu.be.repository;

import com.nc.edu.be.entities.Users;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<Users, Integer> {
    Users findByEmail(String email);
    Users findByLogin(String login);
}
