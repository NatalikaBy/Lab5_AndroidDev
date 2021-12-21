package com.example.lab_db.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.lab_db.model.User;

@Database(entities = {User.class}, version=1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase DB;

    public static  AppDatabase getDatabaseInstance(Context context){
        if (DB == null) {
            DB = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "users")
                    .allowMainThreadQueries()
                    .build();
        }
        return DB;
    }

    public abstract UserDao userDao();
}
