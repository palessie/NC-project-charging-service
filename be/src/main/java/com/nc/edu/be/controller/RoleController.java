package com.nc.edu.be.controller;

import com.nc.edu.be.entities.Role;
import com.nc.edu.be.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/{idRole}", method = RequestMethod.GET)
    public ResponseEntity<Role> getUserById(@PathVariable Integer idRole) {
        Optional<Role> user = roleService.getRoleById(idRole);
        if(user.isPresent())
            return ResponseEntity.ok(user.get());
        else
            return ResponseEntity.notFound().build();
    }
}
