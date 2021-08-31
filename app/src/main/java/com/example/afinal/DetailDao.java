package com.example.afinal;

import android.graphics.Bitmap;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.afinal.UserInfo;

import java.util.List;


@Dao
public interface DetailDao {
    @Insert
    void insertUserDetails(UserInfo userInfo);


    @Query("Select * From Users")
    List<UserInfo> getAllUserinfos();

    @Query("Select * From Users where Username=(:username) and  Password =(:password)")
    UserInfo login (String username, String password);

    /*@Query("select * from Users where id like :idx")
    UserInfo getId(int idx);*/

    @Delete
    void deleteUser(UserInfo userInfo);
    @Query("Select * from Users where Id = (:iD)")
    UserInfo getId (int iD);

  /*  @Query("select `captured image`from users where id = :id")
    Bitmap getProfileImg(int id);*/


    }
