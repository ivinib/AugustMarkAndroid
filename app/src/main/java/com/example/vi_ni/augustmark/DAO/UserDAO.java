package com.example.vi_ni.augustmark.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.vi_ni.augustmark.model.User;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert
    void insert(User user);

    @Update
    void update(User user);

    @Query("SELECT * FROM USER WHERE USER.IDUSER == :idUser")
    User loadUserById(Integer idUser);

    @Query("DELETE FROM USER WHERE USER.IDUSER == :idUser")
    void delete(Integer idUser);

    @Query("SELECT * FROM USER ORDER BY NAME ASC")
    List<User> loadUsers();

    @Query("SELECT NAME FROM USER")
    List<User> loadNamesFromUser();
}
