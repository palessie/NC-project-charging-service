package com.nc.edu.be.service;

import com.nc.edu.be.entities.Users;
import java.util.Optional;

public interface UsersService {
    Optional<Users> getUserById(Integer idUser);
    Iterable<Users> getAllUsers();
    void deleteUser(Integer idUser);
    Users saveUser(Users user);
    Users getUserByEmail(String email);
    Users getUserByLogin(String login);

}
