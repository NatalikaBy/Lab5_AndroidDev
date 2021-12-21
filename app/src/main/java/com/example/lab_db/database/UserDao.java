package com.example.lab_db.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.lab_db.model.User;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM User")
    List<User> getAllUsers();

    @Query("SELECT * FROM User WHERE UPPER(name) LIKE '%' || :filter || '%' OR UPPER(surname) LIKE '%' || :filter || '%'")
    List<User> getFilteredUsers(String filter);

    @Query("SELECT COUNT(*) FROM User")
    int countAllUsers();

    @Query("SELECT COUNT(*) FROM User WHERE UPPER(name) LIKE '%' || :filter || '%' OR UPPER(surname) LIKE '%' || :filter || '%'")
    int countFilteredUsers(String filter);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User user);

}
