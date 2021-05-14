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
                    name.append(i.getAddress().getState()+"\n");

                Log.e("Names", name.toString());
            }
        });

        List<AbstractStudent> list= db.studentDao().getAllAbstractStudent();
        StringBuilder name= new StringBuilder("");
        for(AbstractStudent i: list)
            name.append(i.getName()+" "+i.getEmail()+"\n");

        Log.e("Names", name.toString());
    }
}