package com.nc.edu.be.controller;

import com.nc.edu.be.entities.Users;
import com.nc.edu.be.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Users> getUserById(@PathVariable(name = "id") Integer idUser) {
        Optional<Users> user = usersService.getUserById(idUser);
        if(user.isPresent())
            return ResponseEntity.ok(user.get());
        else
            return ResponseEntity.notFound().build();
    }
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Users> getAllUsers() { return usersService.getAllUsers(); }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Users saveUser(@RequestBody Users account) {
        return usersService.saveUser(account);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Users> deleteUser(@PathVariable(name = "id") Integer idUser) {
        usersService.deleteUser(idUser);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/email/{email}", method = RequestMethod.GET)
    public ResponseEntity<Users> getUserByEmail(@PathVariable (name="email") String email){
        Users user = usersService.getUserByEmail(email);

            return ResponseEntity.ok(user);

    }
    @RequestMapping(value="/{login}", method = RequestMethod.GET)
    public ResponseEntity<Users> getUserByLogin(@PathVariable (name="login") String login){
        Users user = usersService.getUserByLogin(login);

        return ResponseEntity.ok(user);

    }
}
