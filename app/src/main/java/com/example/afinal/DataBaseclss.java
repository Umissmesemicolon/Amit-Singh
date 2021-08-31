package com.example.afinal;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;



@Database(entities = {UserInfo.class},version = 1)
public abstract class DataBaseclss extends RoomDatabase {

    public abstract DetailDao getDao();

    private static volatile DataBaseclss INSTANCE;
    public  static  DataBaseclss getInstance(Context context){
        if (INSTANCE == null){
            synchronized (Database.class){
                if (INSTANCE==null){
                    INSTANCE = Room.databaseBuilder(context, DataBaseclss.class,"db_Name").build();
                }
            }
        }
        return INSTANCE;
    }
}
