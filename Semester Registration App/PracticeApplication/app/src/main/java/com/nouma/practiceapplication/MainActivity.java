package com.nouma.practiceapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton fabAdd, fabLogin;

    MyDatabaseHelper myDB;
    ArrayList form_no, stu_name, fat_name, cnic, religion, phone_no, semester;

    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        fabLogin = findViewById(R.id.fabLogin);
        fabAdd = findViewById(R.id.fabAdd);

        fabLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        myDB = new MyDatabaseHelper(MainActivity.this);
        form_no = new ArrayList<>();
        stu_name = new ArrayList<>();
        fat_name = new ArrayList<>();
        cnic = new ArrayList<>();
        religion = new ArrayList<>();
        phone_no = new ArrayList<>();
        semester = new ArrayList<>();

        storeDataInArrays();

        customAdapter = new CustomAdapter(MainActivity.this, this, form_no, stu_name, fat_name, cnic, religion, phone_no, semester);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            recreate();
        }
    }

    void storeDataInArrays(){
        Cursor cursor = myDB.readAllData();

        if (cursor.getCount() == 0){
            Toast.makeText(this, "No Data Found!", Toast.LENGTH_SHORT).show();
        }
        else {
            while(cursor.moveToNext()){
                form_no.add(cursor.getString(0));
                stu_name.add(cursor.getString(1));
                fat_name.add(cursor.getString(2));
                cnic.add(cursor.getString(3));
                religion.add(cursor.getString(4));
                phone_no.add(cursor.getString(5));
                semester.add(cursor.getString(6));
            }
        }
    }
}