package com.example.myapplication.db.entity;

import android.content.Context;

import com.example.myapplication.db.ServerDatabase;

public class DataFakeGenerator {

    public static void addFakeCourses(Context context){

        ServerDatabase serverDatabase = ServerDatabase.getInstance(context);
        Course course;
        for (int i = 1; i < 21; i++) {

            course = new Course(String.valueOf("درس " + i),1,"97-98",2);
            serverDatabase.getCourseDao().addCourse(course);

        }
        course = new Course("درس محاسبات الگوریتم و انتگرالیسم شمس تبریزی و برادران به غیر از اصغر" ,1,"97-98",2);
        serverDatabase.getCourseDao().addCourse(course);

    }
}
