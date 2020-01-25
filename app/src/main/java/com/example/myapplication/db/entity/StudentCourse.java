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
        @ForeignKey(entity = Course.class,
                parentColumns = "course_id",
                childColumns = "course_id"
        )
})
public class StudentCourse {

    @PrimaryKey(autoGenerate = true)
    private Long id;

    @ColumnInfo(name = "student_id")
    private Long stid;

    @ColumnInfo(name = "course_id")
    private Long cid;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getStid() {
        return stid;
    }

    public void setStid(Long stid) {
        this.stid = stid;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }
}
