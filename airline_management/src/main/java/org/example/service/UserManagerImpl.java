package org.example.service;

import org.example.dto.User;

import java.util.ArrayList;
import java.util.List;

public class UserManagerImpl implements UserManager {

    List <User> users = new ArrayList<>();
//    @Override
//     public List<User> getAllUsers(){
//        return users;
//    }
//
    @Override
    public User addUser( int id, String userName, float amount){
        User user = new User(id,userName,amount);
        users.add(user);
        return user;
    }

    @Override
    public User getUserById(int id) {
        return users.stream().filter(u->u.getId()==id).findFirst().orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public User addUser(User user){
        User newUser = new User();
        users.add(newUser);
        return newUser;
    }




}
