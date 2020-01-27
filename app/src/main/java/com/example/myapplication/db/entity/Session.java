package com.example.myapplication.db.entity;

import java.sql.Time;
import java.util.Date;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Course.class,
        parentColumns = "course_id",
        childColumns = "course_id"),
indices = {@Index(value = "course_id")})
public class Session {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "session_id")
    private Long seid;

    @ColumnInfo(name = "session_number")
    private long sessionNumber;

    private String date;

    @ColumnInfo(name = "course_id")
    private Long courseId;


    public Session (long sessionNumber, String date, Long courseId){

        this.sessionNumber = sessionNumber;
        this.date = date;
        this.courseId = courseId;
    }


    public void setSeid(Long seid) {
        this.seid = seid;
    }

    public Long getSeid() {
        return seid;
    }

    public long getSessionNumber() {
        return sessionNumber;
    }

    public void setSessionNumber(long sessionNumber) {
        this.sessionNumber = sessionNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long cid) {
        this.courseId = cid;
    }
}
