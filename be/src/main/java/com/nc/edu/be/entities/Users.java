package com.nc.edu.be.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Users {
    private int idUser;
    private String email;
    private String login;
    private String password;
    private Wallet wallet;
    private Timestamp lastDateLogin;
    private Role role;
    private String name;
    private String surname;



    @Id
    @Column(name = "id_user")
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @OneToOne
    @JoinColumn(name = "id_wallet", referencedColumnName = "id_wallet", nullable = false)
    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    @Basic
    @Column(name = "last_date_login")
    public Timestamp getLastDateLogin() {
        return lastDateLogin;
    }

    public void setLastDateLogin(Timestamp lastDateLogin) {
        this.lastDateLogin = lastDateLogin;
    }


    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return idUser == users.idUser &&
                wallet == users.wallet &&

                Objects.equals(email, users.email) &&
                Objects.equals(login, users.login) &&
                Objects.equals(password, users.password) &&
                Objects.equals(lastDateLogin, users.lastDateLogin) &&
                Objects.equals(name, users.name) &&
                Objects.equals(surname, users.surname);
    }

    @Override
    public String toString() {
        return "Users{" +
                "idUser=" + idUser +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", wallet=" + wallet +
                ", lastDateLogin=" + lastDateLogin +

                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +


                '}';
    }
    @ManyToOne
    @JoinColumn(name = "id_role", referencedColumnName = "id_role", nullable = false)
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, email, login, password, wallet, lastDateLogin,  name, surname);
    }




}
