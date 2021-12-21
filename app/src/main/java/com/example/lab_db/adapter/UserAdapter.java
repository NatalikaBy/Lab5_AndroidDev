package com.example.lab_db.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab_db.R;
import com.example.lab_db.model.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder > {

    private Context context;
    private List<User> userList;

    public UserAdapter(Context context){
        this.context = context;
    }

    public void setUserList(List<User> userList){
        this.userList = userList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.getName().setText(this.userList.get(position).getName());
        holder.getSurname().setText(this.userList.get(position).getSurname());
        holder.getComment().setText(this.userList.get(position).getComment());
    }

    @Override
    public int getItemCount() {
        return  this.userList.size();
    }


}
