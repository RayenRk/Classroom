package com.example.classroom;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.ktx.Firebase;

import java.util.HashMap;
import java.util.Map;

public class AddActivity extends AppCompatActivity {

    EditText name, email, image;
    Button addBtn,backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        image = findViewById(R.id.image);
        addBtn = findViewById(R.id.add);
        backBtn = findViewById(R.id.back);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddActivity.this, MainActivity.class));
                finish();
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // check if the fields are empty and use SetError to show the error, else call the dataInsert() and dataReset() methods
                if (name.getText().toString().isEmpty() || email.getText().toString().isEmpty() || image.getText().toString().isEmpty()){
                    if (name.getText().toString().isEmpty()){
                        name.setError("Name cannot be empty");
                    }
                    if (email.getText().toString().isEmpty()){
                        email.setError("Email cannot be empty");
                    }
                    if (image.getText().toString().isEmpty()){
                        image.setError("Image cannot be empty");
                    }
                } else {
                    dataInsert();
                    dataReset();
                }
            }
        });


    }

    private void dataInsert(){
        Map<String, Object> map = new HashMap<>();
        map.put("name", name.getText().toString());
        map.put("email", email.getText().toString());
        map.put("image", image.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("user").push()
                .setValue(map).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(AddActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(AddActivity.this, "Data Insertion Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void dataReset(){
        name.setText("");
        email.setText("");
        image.setText("");
    }
}