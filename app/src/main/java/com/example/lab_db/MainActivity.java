package com.example.lab_db;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lab_db.adapter.UserAdapter;
import com.example.lab_db.database.AppDatabase;
import com.example.lab_db.model.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private Button addButton;
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private EditText searchInput;
    private TextView totalRecords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.addButton = (Button) this.findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, FormActivity.class), 100);
            }
        });
        this.searchInput = (EditText) this.findViewById(R.id.searchInput);
        final TextView foundRecords = findViewById(R.id.foundRecords);
        this.totalRecords = (TextView) this.findViewById(R.id.totalRecords);

        searchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void afterTextChanged(Editable editable) {
                findUserList(editable.toString());
                if(editable.toString().length() > 0) {
                    foundRecords.setVisibility(View.VISIBLE);
                    totalRecords.setVisibility(View.INVISIBLE);
                    foundRecords.setText("Found records: " + countFilteredUsers(editable.toString()));
                } else {
                    foundRecords.setVisibility(View.INVISIBLE);
                    totalRecords.setVisibility(View.VISIBLE);
                    totalRecords.setText("Total records: " + countAllUsers());
                }
            }
        });


        totalRecords.setText("Total records: " + countAllUsers());
        initRecyclerView();
        loadUserList();
    }

    private void initRecyclerView(){
        recyclerView = (RecyclerView) this.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        userAdapter = new UserAdapter(this);
        recyclerView.setAdapter(userAdapter);
    }

    private void loadUserList(){
        AppDatabase db = AppDatabase.getDatabaseInstance(this.getApplicationContext());
        userAdapter.setUserList(db.userDao().getAllUsers());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 100){
            totalRecords.setText("Total records: " + countAllUsers());
            loadUserList();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private int countAllUsers() {
        AppDatabase db = AppDatabase.getDatabaseInstance(this.getApplicationContext());
        return db.userDao().countAllUsers();
    }

    private int countFilteredUsers(String filter) {
        AppDatabase db = AppDatabase.getDatabaseInstance(this.getApplicationContext());
        return db.userDao().countFilteredUsers(filter);
    }

    private void findUserList(String filter) {
        AppDatabase db = AppDatabase.getDatabaseInstance(this.getApplicationContext());
        userAdapter.setUserList(db.userDao().getFilteredUsers(filter));
    }


}