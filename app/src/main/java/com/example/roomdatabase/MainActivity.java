package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UniversityDatabase db= UniversityDatabase.getInstance(this);
        List<Student> studentList= db.studentDao().getAllStudents();

        Log.e("database", studentList.get(0).getName()+ studentList.get(2).getName());
    }
}