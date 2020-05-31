package com.immersivex.studentstoolbox;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface UserDao {

    @Insert
    void addUser(User user);

    @Update
    void updateUser(User user);

    @Query("SELECT * FROM User")
    List<User> getAll();

    @Query("SELECT studentName FROM User")
    String getstudentName();

    @Query("SELECT studentSurname FROM User")
    String getstudentSurname();

    @Query("SELECT studentEmail FROM User")
    String getstudentEmail();

    @Query("SELECT * FROM user WHERE id = :id LIMIT 1")
    User getUserById(long id);

    @Query("SELECT studentName FROM user WHERE studentName = :name")
    String searchFor(String name);
}
