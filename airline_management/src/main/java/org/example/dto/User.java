package org.example.dto;

import org.example.enums.UserType;
import org.example.enums.WalletState;

public class User {

    public int getId() {
        return id;
    }

    private int id;
    UserType userType;
    private String userName;
    private String password;
    private int age;
    private String firstName;
    private String lastName;
    private Wallet wallet;

    public User() {}
    public User(String userName, String password, int age, String firstName, String lastName) {
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(int id, String userName, float amount) {
       this.id = id;
       this.userName = userName;
       this.wallet = new Wallet(id, amount, WalletState.FULL);
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getPassword() {
        return password;
    }
}
