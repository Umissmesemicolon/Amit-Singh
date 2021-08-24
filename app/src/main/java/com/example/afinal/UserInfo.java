package com.example.afinal;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Users")
public class UserInfo {
    @PrimaryKey(autoGenerate = true)
    private int id ;
    private String Username;
    private String Password;
    private String Confirm_Password;
    private String Email;

    public int getId() {
        return id;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public String getConfirm_Password() {
        return Confirm_Password;
    }

    public String getEmail() {
        return Email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.Username = username;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public void setConfirm_Password(String confirm_Password) {
        this.Confirm_Password = confirm_Password;
    }

    public void setEmail(String email) {
        this.Email = email;
    }
}
