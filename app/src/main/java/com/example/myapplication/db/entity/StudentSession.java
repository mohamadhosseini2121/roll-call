package com.example.myapplication.db.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {
        @ForeignKey(entity = Student.class,
                parentColumns = "student_id",
                childColumns = "student_id"
        ),
        @ForeignKey(entity = Session.class,
                parentColumns = "session_id",
                childColumns = "session_id"
        )
})
public class StudentSession {

    @PrimaryKey(autoGenerate = true)
    private Long id;

    @ColumnInfo(name = "student_id")
    private Long stid;

    @ColumnInfo(name = "session_id")
    private Long seid;



    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() { return id; }

    public Long getStid() {
        return stid;
    }

    public void setStid(Long stid) {
        this.stid = stid;
    }

    public Long getSeid() {
        return seid;
    }

    public void setSeid(Long seid) {
        this.seid = seid;
    }
}
