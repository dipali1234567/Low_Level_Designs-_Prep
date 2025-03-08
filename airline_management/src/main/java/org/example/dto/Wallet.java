package org.example.dto;

import org.example.enums.WalletState;

public class Wallet {

    private int user_id;
    private float amount;
    WalletState state;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public float getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public WalletState getState() {
        return state;
    }
    public void setState(WalletState state) {
        this.state = state;
    }

    public Wallet() {}
    public Wallet(int user_id, float amount, WalletState state) {
        this.user_id = user_id;
    }
}
