package com.nc.edu.be.service;

import com.nc.edu.be.entities.Role;

import java.util.Optional;

public interface RoleService {
    Optional<Role> getRoleById(Integer idRole);
}
