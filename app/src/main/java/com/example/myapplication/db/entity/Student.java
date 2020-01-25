package com.example.myapplication.db.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Student {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "student_id")
    private Long stid;

    @ColumnInfo(name = "first_name")
    private String firstName;

    @ColumnInfo(name = "last_name")
    private String lastName;

    @ColumnInfo(name = "student_number")
    private String studentNumber;

    @ColumnInfo(name = "card_rfid")
    private String cardRfid;


    public void setStid(Long stid) {
        this.stid = stid;
    }

    public Long getStid() {
        return stid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getCardRfid() {
        return cardRfid;
    }

    public void setCardRfid(String cardRfid) {
        this.cardRfid = cardRfid;
    }
}
