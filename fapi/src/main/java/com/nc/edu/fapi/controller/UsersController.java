package com.nc.edu.fapi.controller;

import com.nc.edu.fapi.model.UsersModel;
import com.nc.edu.fapi.config.JwtTokenUtil;
import com.nc.edu.fapi.service.UsersService;
import com.nc.edu.fapi.model.StringResponseModel;
import com.nc.edu.fapi.model.AuthToken;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@RestController
@RequestMapping("/api/fusers")
public class UsersController {
@Autowired
    UsersService usersService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Iterable<UsersModel>> getAllUsers() {
        return ResponseEntity.ok(usersService.getAllUsers());
    }

    @RequestMapping(value = "/{idUser}", method = RequestMethod.GET)
    public ResponseEntity<UsersModel> getUserById(@PathVariable Integer idUser) {
        return ResponseEntity.ok(usersService.getUserById(Integer.valueOf(idUser)));
    }
    @RequestMapping(value = "/{email}", method = RequestMethod.GET)
    public ResponseEntity<UsersModel> getUserByEmail(@PathVariable String email) {
        return ResponseEntity.ok(usersService.getUserByEmail(String.valueOf(email)));
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<UsersModel> getUserByLogin(@RequestParam("login") String login) {
        return ResponseEntity.ok(usersService.getUserByLogin(String.valueOf(login)));
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UsersModel account) {
        if(account != null) {
            StringResponseModel response = usersService.saveUser(account);

            String login = account.getLogin();
            if(login == null) {
                login = account.getEmail();
            }

            if(response.getStringResponse().equals("Successful registration")) {
                final String token = jwtTokenUtil.generateTokenForSignUp(login, "USER");
                return ResponseEntity.ok(new AuthToken(token));
            } else {
                return ResponseEntity.ok(new AuthToken(response.getStringResponse()));
            }
        }
        else
            return null;
    }
    @RequestMapping(value = "/{idUser}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Integer idUser) {
        usersService.deleteUser(Integer.valueOf(idUser));
    }
}
