package com.nc.edu.fapi.controller;

import com.nc.edu.fapi.model.RoleModel;
import com.nc.edu.fapi.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@RestController
@RequestMapping("/api/frole")
public class RoleController {

    @Autowired
    private RoleService roleService;
    @RequestMapping(value = "/{idRole}", method = RequestMethod.GET)
    public ResponseEntity<RoleModel> getRoleById(@PathVariable Integer idRole) {
        return ResponseEntity.ok(roleService.getRoleById(Integer.valueOf(idRole)));
    }
}
