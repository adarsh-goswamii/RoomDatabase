package com.example.roomdatabase;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/** we need to annotate the class with @Entity this class will work as a table in our db.
 *
 *  By default the class name is used as a table name but we can change that by specifying table name
 *  with our @Entity (tableName= "Name")
 *
 *  Or u can just use the default table name and leave it to just
 *  @Entity
 *  class Student {
 *
 *  }
 */

@Entity(tableName = "StudentTable")
public class Student {
    /**
     * Every entity needs a primary key as Room database works as ORM(object relational mapping) and
     * thats why room database needs a key to map the objects of this class Student.
     */

    @PrimaryKey (autoGenerate = true)
    private int id;
    private String email, number, name;

    /**
     * We know that all the class data members will be changed to columns, so what if i want to add
     * a class object inside out Student class in that case how will the room database convert
     * the object to column for that reason, we annotate the object with @Embedded this will
     * create diff column depending on the data members of that object added.
     *
     * Here, we will have a table which will have columns as zipcode, city and state.
     */

    @Embedded
    private Address address;

    /**
     * If we have more than one constructors or any extra functions that's not needed by room database
     * annotate them with @Ignore.
     *
     * @Ignore
     * public Student() {
     *     this.email= "";
     * }
     */


    public Student(String email, String number, String name, Address address) {
        this.email = email;
        this.number = number;
        this.name = name;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Its important to make a setter for the primary key as room database will need it when student object
     * needs to created.
     */



    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
