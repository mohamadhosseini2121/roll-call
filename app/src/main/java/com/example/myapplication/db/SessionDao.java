package com.example.myapplication.db;

import com.example.myapplication.db.entity.Session;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface SessionDao {

    @Insert
    Long addSession(Session session);

    @Update
    public void updateSession(Session session);

    @Delete
    public void deleteSession(Session session);


    @Query("Select * from Session where Session_id ==:sessionId")
    public List<Session> getSession(Long sessionId);

    @Query("select * from Session where course_id ==:courseId")
    public List<Session> getSessionsOfCourse (Long courseId);
    
}
