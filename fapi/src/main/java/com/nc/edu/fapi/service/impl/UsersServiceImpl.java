package com.nc.edu.fapi.service.impl;


import com.nc.edu.fapi.model.UsersModel;
import com.nc.edu.fapi.model.LoginUser;
import com.nc.edu.fapi.model.StringResponseModel;
import com.nc.edu.fapi.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;


@Service("usersService")
public class UsersServiceImpl implements UsersService,UserDetailsService{

    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final String loginValidation = "^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$";
    private static final String passwordValidation = "^(?=.{8,}$)(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9._]+$";
    private static final String emailValidation = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public UsersModel getUserById(Integer idUser)
    {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/users/" + idUser, UsersModel.class);
    }
    @Override
    public Iterable<UsersModel> getAllUsers()
    {
        RestTemplate restTemplate = new RestTemplate();
        UsersModel[] usersModelResponse = restTemplate.getForObject(backendServerUrl + "/api/users/", UsersModel[].class);
        return usersModelResponse == null ? Collections.emptyList() : Arrays.asList(usersModelResponse);
    }
    @Override
    public void deleteUser(Integer idUser) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/users/" + idUser);
    }
    @Override
    public StringResponseModel saveUser(UsersModel user){
        if(user.getEmail() == null || user.getPassword() == null)
            return null;

        if(!user.getLogin().matches(loginValidation) || !user.getPassword().matches(passwordValidation) || !user.getEmail().matches(emailValidation)) {
            System.out.println("Validation false");
            return null;
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        UsersModel loginModel = getUserByLogin(user.getLogin());
        UsersModel emailModel = getUserByEmail(user.getEmail());

        if(loginModel != null)
            return new StringResponseModel("This login already exists");
        if(emailModel != null)
            return new StringResponseModel("This email already exists");

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity(backendServerUrl + "/api/users/login", user, UsersModel.class).getBody();
        return new StringResponseModel("Successful registration");
}

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        UsersModel user = getUserByLogin(name);
        if (user == null) {
           return null;
  //         throw new UsernameNotFoundException("Invalid username or password.");
        }
       return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), getAuthority(user));
    }
@Override
    public UsersModel getUserByEmail(String email)
{
    RestTemplate restTemplate = new RestTemplate();
    return restTemplate.getForObject(backendServerUrl + "/api/users/email" + email, UsersModel.class);
}
    @Override
    public UsersModel getUserByLogin(String login)
    {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/users/" + login, UsersModel.class);
    }
    private Set<SimpleGrantedAuthority> getAuthority(UsersModel user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
        return authorities;
    }

    @Override
    public boolean verifyUser(LoginUser user) {

        if(user.getLogin() == null || user.getPassword() == null)
            return false;

        if(!user.getLogin().matches(loginValidation) || !user.getPassword().matches(passwordValidation)) {
            System.out.println("Validation false");
            return false;
        }
        else {
            UsersModel currentUser = getUserByLogin(user.getLogin());
            if(currentUser != null) {
                if(passwordEncoder.matches(user.getPassword(), currentUser.getPassword())) {
                    return true;
                }
                else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
