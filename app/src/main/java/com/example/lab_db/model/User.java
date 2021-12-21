package com.example.lab_db.model;


import androidx.annotation.NonNull;
import androidx.room.Entity;

@Entity (primaryKeys = {"name", "surname"})
public class User {
    @NonNull
    private String name;
    @NonNull
    private String surname;
    private String comment;

    public User(String name, String surname, String comment){
        this.name = name;
        this.surname = surname;
        this.comment = comment;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getSurname() {
        return surname;
    }

    public void setSurname(@NonNull String surname) {
        this.surname = surname;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
