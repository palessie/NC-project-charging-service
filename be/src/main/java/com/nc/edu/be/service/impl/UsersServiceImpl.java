package com.nc.edu.be.service.impl;


import com.nc.edu.be.entities.Users;
import com.nc.edu.be.service.UsersService;
import com.nc.edu.be.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class UsersServiceImpl implements UsersService{
    private UsersRepository repository;

    @Autowired
    public UsersServiceImpl(UsersRepository repository)
    {
        this.repository = repository;
    }
    @Override
    public Optional<Users> getUserById(Integer idUser)
    {
        return repository.findById(idUser);
    }
    @Override
    public Iterable<Users> getAllUsers()
    {
        return repository.findAll();
    }
    @Override
    public void deleteUser(Integer idUser){
        repository.deleteById(idUser);
    }
    @Override
    public Users saveUser(Users user)
    {
        return repository.save(user);
    }
    @Override
    public Users getUserByEmail(String email) {
        return repository.findByEmail(email);
    }
    @Override
    public Users getUserByLogin(String login) {
        return repository.findByLogin(login);
    }

}
