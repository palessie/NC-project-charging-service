package com.nc.edu.fapi.service;

import com.nc.edu.fapi.model.LoginUser;
import com.nc.edu.fapi.model.StringResponseModel;
import com.nc.edu.fapi.model.UsersModel;

import java.util.Optional;

public interface UsersService {
    UsersModel getUserById(Integer idUser);
    Iterable<UsersModel> getAllUsers();
    void deleteUser(Integer idUser);
    StringResponseModel saveUser(UsersModel user);
    UsersModel getUserByEmail(String email);
    UsersModel getUserByLogin(String login);
    boolean verifyUser(LoginUser user);

}


