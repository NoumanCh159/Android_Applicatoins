package com.nouma.practiceapplication;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.location.GnssAntennaInfo;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private final Context context;
    private static final String DATABASE_NAME = "Semester.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "my_semester";
    private static final String COLUMN_FORM_NO = "form_no";
    private static final String COLUMN_STU_NAME = "stu_name";
    private static final String COLUMN_FAT_NAME = "fat_name";
    private static final String COLUMN_CNIC = "cnic";
    private static final String COLUMN_RELIGION = "religion";
    private static final String COLUMN_PHONE_NO = "phone_no";
    private static final String COLUMN_SEMESTER = "semester";

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_FORM_NO + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        COLUMN_STU_NAME + " TEXT, " + COLUMN_FAT_NAME + " TEXT, " + COLUMN_CNIC + " LONG," + COLUMN_RELIGION + " TEXT, " + COLUMN_PHONE_NO + " LONG, " + COLUMN_SEMESTER + " INTEGER);";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);

    }


    void addSemesterForm(String stuName, String fatName, long cNIC, String religion, long phoneNo, int semester){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_STU_NAME, stuName);
        cv.put(COLUMN_FAT_NAME, fatName);
        cv.put(COLUMN_CNIC, cNIC);
        cv.put(COLUMN_RELIGION, religion);
        cv.put(COLUMN_PHONE_NO, phoneNo);
        cv.put(COLUMN_SEMESTER, semester);
        
        long result = db.insert(TABLE_NAME, null, cv);
        
        if (result == -1){
            Toast.makeText(context, "Failed!", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "Success!", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllData(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;

        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery(query, null);
        }

        return cursor;
    }

    void updateData(String row_id, String stuName, String fatName, String cNIC, String religion, String phoneNo, String semester){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_STU_NAME, stuName);
        cv.put(COLUMN_FAT_NAME, fatName);
        cv.put(COLUMN_CNIC, cNIC);
        cv.put(COLUMN_RELIGION, religion);
        cv.put(COLUMN_PHONE_NO, phoneNo);
        cv.put(COLUMN_SEMESTER, semester);

        long result = db.update(TABLE_NAME, cv, "form_no=?", new String[]{row_id});

        if (result == -1){
            Toast.makeText(context, "Failed to Update!", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "Successfully Updated!", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteOneRow(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "form_no=?", new String[] {row_id});

        if (result == -1){
            Toast.makeText(context, "Failed to Delete!", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "Successfully Deleted!", Toast.LENGTH_SHORT).show();
        }
    }

}
