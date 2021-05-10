package com.example.roomdatabase;

import androidx.room.Database;

/**
 * There are few things which are imp as we defining UniversityDatabase
 * 1. It should be abstract.
 * 2. It should extend RoomDatabase
 * 3. For every Dao interface that has been created we need to specify one function for it in the
 * university Database.
 *
 */

/**
 * We need to annotate abstract class with @Database which takes two parameters.
 * 1. a array of entities, here we just have 1 entity so we can just write it but when we have
 * multiple entities we can name them as @Database(entites= {entity1.class, entity2.class}, ver........
 * 2. The version of our database, as in future with app updates our database can be updated as well.
 */
@Database(entities = Student.class, version = 1)
public abstract class UniversityDatabase {
    public abstract StudentDao studentDao();

    /**
     * Making instances of room database is quite heavy that's why we need to ensure that there is just
     * one instance of University Database for that reason we will use singleton.
     */
}
