package com.example.myapplication.db.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Course.class,
        parentColumns = "course_id",
        childColumns = "course_id"))
public class Session {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "session_id")
    private Long seid;

    @ColumnInfo(name = "session_number")
    private long sessionNumber;

    @ColumnInfo(name = "course_id")
    private Long cid;


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

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }
}
