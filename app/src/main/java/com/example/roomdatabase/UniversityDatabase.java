package com.example.roomdatabase;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

/**
 * There are few things which are imp as we defining UniversityDatabase
 * 1. It should be abstract.
 * 2. It should extend RoomDatabase
 * 3. For every Dao interface that has been created we need to specify one function for it in the
 * university Database.
 */

/**
 * We need to annotate abstract class with @Database which takes two parameters.
 * 1. a array of entities, here we just have 1 entity so we can just write it but when we have
 * multiple entities we can name them as @Database(entites= {entity1.class, entity2.class}, ver........
 * 2. The version of our database, as in future with app updates our database can be updated as well.
 */
@Database(entities = Student.class, version = 1)
public abstract class UniversityDatabase extends RoomDatabase {
    public abstract StudentDao studentDao();

    /**
     * Making instances of room database is quite heavy that's why we need to ensure that there is just
     * one instance of University Database for that reason we will use singleton pattern.
     */

    private static UniversityDatabase instance;

    public static synchronized UniversityDatabase getInstance(Context context) {
        if (instance == null) {
            /**
             * we need to create a instance if its null database builder takes 3 parameters
             * 1. context
             * 2. class which extends RoomDatabase
             * 3. Name of the database
             *
             * .fallbackToDestructiveMigration() : So in sqlite we had onUpgrade and downgrade for updating the database but in room
             * database this is handled using migration. Here we want to create our database from scratch that's why we mention
             * fallbackToDestructiveMigration().
             *
             * .allowMainThreadQueries() : So generally it is advised to create or make queries from database in some other thread other
             * than main but here we have very small database and for simplicity we will do it in main thread only so that's why we add
             * allowMainThreadQueries().
             *
             * .addCallback() : So we want to add some initial values to our database that's why we use call back.
             *
             * we have created a diff thread and in which we will be adding three student to our table.
             */

            instance = Room.databaseBuilder(context, UniversityDatabase.class, "university_db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .addCallback(initialCallback)
                    .build();
        }
        return instance;
    }

    public static RoomDatabase.Callback initialCallback = new RoomDatabase.Callback() {

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            new PopulateInitialData(instance).execute();
        }
    };

    private static class PopulateInitialData extends AsyncTask<Void, Void, Void> {

        private StudentDao studentDao;

        public PopulateInitialData(UniversityDatabase db) {
            this.studentDao = db.studentDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            studentDao.addSingleStudent(new Student("email1", "num1", "Name1"));
            studentDao.addSingleStudent(new Student("email2", "num2", "Name2"));
            studentDao.addSingleStudent(new Student("email3", "num3", "Name3"));

            return null;
        }
    }
}
