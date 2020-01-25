package com.example.myapplication.db;

import com.example.myapplication.db.entity.Student;
import java.util.List;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface StudentDao {

    @Insert
    Long addStudent(Student student);

    @Update
    public void updateStudent(Student student);

    @Delete
    public void deleteStudent(Student student);

    @Query("Select * from student")
    public List<Student> getAllStudents();

    @Query("Select * from student where student_id ==:studentId")
    public Student getStudent(Long studentId);
    
}
