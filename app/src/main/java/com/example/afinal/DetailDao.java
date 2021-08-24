package com.example.afinal;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;


@Dao
public interface DetailDao {
    @Insert
    void insertUserDetails(UserInfo userInfo);


    @Query("Select * From Users")
    List<UserInfo> getAllUserinfos();

    @Query("Select * From Users where Username=(:username) and  Password =(:password)")
    UserInfo login (String username, String password);




    }
