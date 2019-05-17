package com.nc.edu.be.service.impl;



import com.nc.edu.be.entities.Role;
import com.nc.edu.be.service.RoleService;
import com.nc.edu.be.repository.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Component
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository repository) {
        this.roleRepository=repository;
    }

    @Override
    public Optional<Role> getRoleById(Integer idRole){
        return roleRepository.findById(idRole);
    }

}
