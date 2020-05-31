package com.immersivex.studentstoolbox;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "User")
public class User {
    @PrimaryKey (autoGenerate = true)
    private Long id;
    private String studentName;
    private String studentSurname;
    private String studentEmail;
    //private Integer birthDate;

    public User(String studentName, String studentSurname, String studentEmail){
        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.studentEmail = studentEmail;
    }
    @Ignore
    public User(long id, String studentName, String studentSurname, String studentEmail){
        this.id = id;
        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.studentEmail = studentEmail;
    }

    public Long getId() {
        if (this.id == null) return 0L;
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    /*public Integer getBirthDate() {
        if (this.birthDate == null) return 0;
        return birthDate;
    }

    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }*/
}
