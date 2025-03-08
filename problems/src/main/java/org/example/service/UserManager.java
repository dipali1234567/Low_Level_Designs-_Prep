package org.example.service;


import org.example.dto.User;

import java.util.List;

public interface UserManager {



    default User getUser(){
        return new User();
    }

    public List<User> getAllUsers();

    public User addUser(User user);

    public User addUser( int id, String userName, float amount);

    default User updateUser(User user){
        return user;
    }
    default User removeUser(User user){
        return new User();
    }
    default User findUser(User user){
        return new User();
    }

    public User getUserById(int id);

}
