package com.example.lab_db.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.lab_db.R;

public class UserViewHolder extends RecyclerView.ViewHolder{
    private TextView name;
    private TextView surname;
    private TextView comment;

    public UserViewHolder(View v){
        super(v);
        this.name = v.findViewById(R.id.nameView);
        this.surname = v.findViewById(R.id.surnameView);
        this.comment = v.findViewById(R.id.commentView);
    }

    public TextView getName() {
        return name;
    }

    public void setName(TextView name) {
        this.name = name;
    }

    public TextView getSurname() {
        return surname;
    }

    public void setSurname(TextView surname) {
        this.surname = surname;
    }

    public TextView getComment() {
        return comment;
    }

    public void setComment(TextView comment) {
        this.comment = comment;
    }
}