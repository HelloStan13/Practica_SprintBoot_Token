package com.DEMOJWT.demo.service;

import com.DEMOJWT.demo.dto.User;
import com.DEMOJWT.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(String username, String pwd) {

        User user = new User();
        user.setUser(username);
        user.setPwd(pwd);
        userRepository.save(user);
        return user;

    }


    public List<User> list() {

        Iterable<User> usuarios = new ArrayList<>();
        usuarios = userRepository.findAll();


        List<User> response = new ArrayList<>();

        for (User user : usuarios) {
            response.add(user);
        }
        return response;
    }


    public List<User> login(String username, String pwd, String token) {

        //Lista para obtener resultados desde la BD
        Iterable<User> usuarios = new ArrayList<>();
        usuarios = userRepository.findAll();
        List<User> listUser = new ArrayList<>();


        //Recorremos lista de entidad
        for (User user : usuarios) {
            if ((user.getUser().equals(username)) && (user.getPwd().equals(pwd))) {

                user.setToken(token);
                listUser.add(user);

            }

        }
        return listUser;

    }



}
