package com.example.myapplication.db;

import com.example.myapplication.db.entity.StudentSession;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface StudentSessionDao {

    @Insert
    Long addStudentSession(StudentSession studentSession);

    @Update
    public void updateStudentSession(StudentSession studentSession);

    @Delete
    public void deleteStudentSession(StudentSession studentSession);

    @Query("Select * from StudentSession where session_id==:sessionId")
    public List<StudentSession> getStudentsOfSession(Long sessionId);


}
