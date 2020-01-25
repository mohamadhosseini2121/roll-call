package com.example.myapplication.db;

import com.example.myapplication.db.entity.Course;
import java.util.List;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface CourseDao {

    @Insert
    Long addCourse(Course course);

    @Update
    public void updateCourse(Course course);

    @Delete
    public void deleteCourse(Course course);

    @Query("Select * from Course")
    public List<Course> getAllCourses();

    @Query("Select * from course where course_id ==:courseId")
    public Course getCourse(Long courseId);

}
