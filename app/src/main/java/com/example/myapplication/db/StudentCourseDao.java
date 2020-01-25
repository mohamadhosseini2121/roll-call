package com.example.myapplication.db;

import com.example.myapplication.db.entity.StudentCourse;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface StudentCourseDao {

    @Insert
    Long addStudentCourse(StudentCourse studentCourse);

    @Update
    public void updateStudentCourse(StudentCourse studentCourse);

    @Delete
    public void deleteStudentCourse(StudentCourse studentCourse);

    @Query("select * from StudentCourse where course_id ==:courseId")
    public List<StudentCourse> getStudentsOfCourse (Long courseId);

}
