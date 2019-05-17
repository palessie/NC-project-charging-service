package com.nc.edu.fapi.service.impl;


import com.nc.edu.fapi.model.RoleModel;
import com.nc.edu.fapi.service.RoleService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class RoleServiceImpl implements RoleService {
    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public RoleModel getRoleById(Integer idRole)
    {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/role/" + idRole, RoleModel.class);
    }
}
