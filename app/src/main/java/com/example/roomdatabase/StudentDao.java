package com.example.roomdatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * Dao: Data Access Object
 * As we don't directly communicate with our table we do through Dao interface
 * We need to annotate our interface with @Dao
 */

@Dao
public interface StudentDao {
    /**
     * In this interface we define all the functions we need to interact with the table.
     * for ex: @Insert , @Update , @Delete and many more.
     *
     * All we need to do is just annotate the functions, and pass a Student object and depending
     * on the function insertion of that object, deletion of that object etc will be taken care of
     * by room database.
     *
     * This is why it was important to have a primary key in our entity as that will help room database to
     * carry out insertions and deletions smoothly.
     */

    // As we know we don't define the function definition in our interface so we will just declare them here.
    @Insert
    void addSingleStudent(Student student);

    @Insert
    void addMultipleStudent(List<Student> list);

    @Update
    void updateSingleStudent(Student student);

    // In the same manner we can define functions for delete as well

    /**
     * @Query
     * annotation before a function is one of the major advantages of room database over sqlite
     * As we get compile time error for wrong SQL statements, but in sqlite we don't get that.
     * So only way of knowing whether something is wrong or not was when we run our application.
     *
     * Plus we get auto complete feature for the table name and column name which is imp
     * as in sqlite we don't get that and we have just remember every name.
     */

    @Query("SELECT * FROM StudentTable ;")
    List<Student> getAllStudents();

    @Query("SELECT * FROM StudentTable ;")
    LiveData<List<Student>> getAllStudentLiveData();

    @Query("SELECT name, email from StudentTable")
    List<AbstractStudent> getAllAbstractStudent();

}
