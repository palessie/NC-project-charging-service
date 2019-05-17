package com.nc.edu.fapi.model;

import java.sql.Timestamp;


public class UsersModel {
    private int idUser;
    private String email;
    private String login;
    private String password;
    private WalletModel wallet;
    private Timestamp lastDateLogin;
    private RoleModel role;
    private String name;
    private String surname;



    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public WalletModel getWallet() {
        return wallet;
    }

    public void setWallet(WalletModel wallet) {
        this.wallet = wallet;
    }

    public Timestamp getLastDateLogin() {
        return lastDateLogin;
    }

    public void setLastDateLogin(Timestamp lastDateLogin) {
        this.lastDateLogin = lastDateLogin;
    }

    public RoleModel getRole() {
        return role;
    }

    public void setRole(RoleModel role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }




}
