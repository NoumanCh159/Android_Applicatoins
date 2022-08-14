package com.nouma.practiceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText student_name_input, father_name_input, cnic_input, religion_input, phone_no_input, semester_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        student_name_input = findViewById(R.id.student_name_input);
        father_name_input = findViewById(R.id.father_name_input);
        cnic_input = findViewById(R.id.cnic_input);
        religion_input = findViewById(R.id.religion_input);
        phone_no_input = findViewById(R.id.phone_no_input);
        semester_input = findViewById(R.id.semester_input);
        add_button = findViewById(R.id.add_button);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addSemesterForm(student_name_input.getText().toString().trim(),
                        father_name_input.getText().toString().trim(),
                        Long.parseLong(cnic_input.getText().toString().trim()),
                        religion_input.getText().toString().trim(),
                        Long.parseLong(phone_no_input.getText().toString().trim()),
                        Integer.parseInt(semester_input.getText().toString().trim()));

                Intent intent = new Intent(AddActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}