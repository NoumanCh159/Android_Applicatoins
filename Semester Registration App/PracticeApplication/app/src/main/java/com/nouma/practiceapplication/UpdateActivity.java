package com.nouma.practiceapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText student_name_input, father_name_input, cnic_input, religion_input, phone_no_input, semester_input;
    Button update_button, delete_button;

    String form_no, student_name, father_name, cnic, religion, phone_no, semester;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        student_name_input = findViewById(R.id.student_name_input2);
        father_name_input = findViewById(R.id.father_name_input2);
        cnic_input = findViewById(R.id.cnic_input2);
        religion_input = findViewById(R.id.religion_input2);
        phone_no_input = findViewById(R.id.phone_no_input2);
        semester_input = findViewById(R.id.semester_input2);
        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);

        getAndSetIntentData();

        //Set student name in actionbar of selected item
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(student_name);
        }

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                myDB.updateData(form_no, student_name, father_name, cnic, religion, phone_no, semester);

            }
        });

        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                confirmDialog();
            }
        });



    }

    void getAndSetIntentData(){
        if (getIntent().hasExtra("form_no") && getIntent().hasExtra("student_name") && getIntent().hasExtra("father_name") &&
                getIntent().hasExtra("cnic") && getIntent().hasExtra("religion") && getIntent().hasExtra("phone_no") &&
                getIntent().hasExtra("semester")) {

            //Getting data from Intent
            form_no = getIntent().getStringExtra("form_no");
            student_name = getIntent().getStringExtra("student_name");
            father_name = getIntent().getStringExtra("father_name");
            cnic = getIntent().getStringExtra("cnic");
            religion = getIntent().getStringExtra("religion");
            phone_no = getIntent().getStringExtra("phone_no");
            semester = getIntent().getStringExtra("semester");

            //Setting Intent data
            student_name_input.setText(student_name);
            father_name_input.setText(father_name);
            cnic_input.setText(cnic);
            religion_input.setText(religion);
            phone_no_input.setText(phone_no);
            semester_input.setText(semester);
        }
        else {
            Toast.makeText(this, "No Data Found!", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle("Delete " + student_name + "?");
        builder.setMessage("Are you sure you want to delete " + student_name + "?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                myDB.deleteOneRow(form_no);
                finish();

            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.create().show();
    }
}