package com.example.myapplication.db;

import android.content.Context;
import com.example.myapplication.db.entity.Course;
import com.example.myapplication.db.entity.Session;
import com.example.myapplication.db.entity.Student;
import com.example.myapplication.db.entity.StudentCourse;
import com.example.myapplication.db.entity.StudentSession;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {Course.class, Student.class, Session.class, StudentSession.class, StudentCourse.class} , version = 1)
public abstract class ServerDatabase extends RoomDatabase {

    private static ServerDatabase instance;

    public abstract CourseDao getCourseDao();
    public abstract StudentDao getStudentDao();
    public abstract SessionDao getSessionDao();
    public abstract StudentCourseDao getStudentCourseDao();
    public abstract StudentSessionDao getStudentSessionDao();

    public static ServerDatabase getInstance(Context context) {

        if (instance == null) {
            instance = Room.databaseBuilder(context,
                    ServerDatabase.class,
                    "ServerDB").allowMainThreadQueries().build();
        }
        return instance;

    }


}
