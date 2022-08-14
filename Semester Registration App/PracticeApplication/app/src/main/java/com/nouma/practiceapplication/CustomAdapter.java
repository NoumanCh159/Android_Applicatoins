package com.nouma.practiceapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    Activity activity;
    private ArrayList form_no, student_name, father_name, cnic, religion, phone_no, semester;

    CustomAdapter(Activity activity, Context context, ArrayList form_no, ArrayList student_name, ArrayList father_name, ArrayList cnic, ArrayList religion, ArrayList phone_no, ArrayList semester){
        this.activity = activity;
        this.context = context;
        this.form_no = form_no;
        this.student_name = student_name;
        this.father_name = father_name;
        this.cnic = cnic;
        this.religion = religion;
        this.phone_no = phone_no;
        this.semester = semester;
    }
    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {


        holder.form_no_txt.setText(String.valueOf(form_no.get(position)));
        holder.student_name_txt.setText(String.valueOf(student_name.get(position)));
        holder.father_name_txt.setText(String.valueOf(father_name.get(position)));
        holder.cnic_txt.setText(String.valueOf(cnic.get(position)));
        holder.religion_txt.setText(String.valueOf(religion.get(position)));
        holder.phone_no_txt.setText(String.valueOf(phone_no.get(position)));
        holder.semester_txt.setText(String.valueOf(semester.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("form_no", String.valueOf(form_no.get(position)));
                intent.putExtra("student_name", String.valueOf(student_name.get(position)));
                intent.putExtra("father_name", String.valueOf(father_name.get(position)));
                intent.putExtra("cnic", String.valueOf(cnic.get(position)));
                intent.putExtra("religion", String.valueOf(religion.get(position)));
                intent.putExtra("phone_no", String.valueOf(phone_no.get(position)));
                intent.putExtra("semester", String.valueOf(semester.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });

    }

    @Override
    public int getItemCount() {
        return form_no.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView form_no_txt, student_name_txt, father_name_txt, cnic_txt, religion_txt, phone_no_txt, semester_txt;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            form_no_txt = itemView.findViewById(R.id.form_no_txt);
            student_name_txt = itemView.findViewById(R.id.student_name_txt);
            father_name_txt = itemView.findViewById(R.id.father_name_txt);
            cnic_txt = itemView.findViewById(R.id.cnic_txt);
            religion_txt = itemView.findViewById(R.id.religion_txt);
            phone_no_txt = itemView.findViewById(R.id.phone_no_txt);
            semester_txt = itemView.findViewById(R.id.semester_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
