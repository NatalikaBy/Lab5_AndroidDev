package com.example.lab_db;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.lab_db.database.AppDatabase;
import com.example.lab_db.model.User;


public class FormActivity extends AppCompatActivity {

    private EditText name;
    private EditText surname;
    private EditText comment;
    private Button save;
    private Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        this.name = (EditText) this.findViewById(R.id.nameInput);
        this.surname = (EditText) this.findViewById(R.id.surnameInput);
        this.comment = (EditText) this.findViewById(R.id.commentInput);
        this.save = (Button) this.findViewById(R.id.saveButton);
        this.cancel = (Button) this.findViewById(R.id.cancelButton);

        save.setOnClickListener(view -> {
            saveNewUser(name.getText().toString(),
                    surname.getText().toString(),
                    comment.getText().toString());
            finish();
        });

        cancel.setOnClickListener(view -> {
            finish();
        });
    }

    private void saveNewUser(String name, String surname, String comment){
        AppDatabase db = AppDatabase.getDatabaseInstance(this.getApplicationContext());

        User user = new User(name, surname, comment);
        db.userDao().insert(user);
    }

}