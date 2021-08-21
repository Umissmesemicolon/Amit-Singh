package com.example.afinal;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Users")
public class UserInfo {
    @PrimaryKey(autoGenerate = true)
    private int id ;
    private String Username;
    private int Password;
    private int Confirm_Password;
    private String Email;

    public int getId() {
        return id;
    }

    public String getUsername() {
        return Username;
    }

    public int getPassword() {
        return Password;
    }

    public int getConfirm_Password() {
        return Confirm_Password;
    }

    public String getEmail() {
        return Email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setPassword(int password) {
        Password = password;
    }

    public void setConfirm_Password(int confirm_Password) {
        Confirm_Password = confirm_Password;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
