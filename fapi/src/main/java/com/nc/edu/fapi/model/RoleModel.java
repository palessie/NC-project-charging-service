package com.nc.edu.fapi.model;

import java.util.Collection;
import java.util.Objects;


public class RoleModel {
    private int idRole;
    private String roleName;
    private Collection<UsersModel> usersByIdRole;


    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }


    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleModel role = (RoleModel) o;
        return idRole == role.idRole &&
                Objects.equals(roleName, role.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRole, roleName);
    }



}
