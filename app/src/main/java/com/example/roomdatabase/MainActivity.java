package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UniversityDatabase db= UniversityDatabase.getInstance(this);
        final List<Student> studentList= db.studentDao().getAllStudents();

        Log.e("database", studentList.get(0).getName()+ studentList.get(2).getName());

        /**
         * Suppose we want to do certain task whenever a new Student is added to our database then we can
         * use live data observe to make the changes whenever a student has been added.
         */

        LiveData<List<Student>> liveData= db.studentDao().getAllStudentLiveData();
        liveData.observe(this, new Observer<List<Student>>() {
            @Override
            public void onChanged(List<Student> students) {
                StringBuilder name= new StringBuilder("");
                for(Student i: students)
                    name.append(i.getName()+"\n");

                Log.e("Names", name.toString());
            }
        });
    }
}