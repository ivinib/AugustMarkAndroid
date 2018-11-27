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

    @Query("SELECT * FROM USER_TABLE WHERE USER_TABLE.IDUSER == :idUser")
    User loadUserById(Long idUser);

    @Query("DELETE FROM USER_TABLE WHERE USER_TABLE.IDUSER == :idUser")
    void delete(Long idUser);

    @Query("SELECT * FROM USER_TABLE ORDER BY NAME_USER ASC")
    List<User> loadUsers();

    @Query("SELECT NAME_USER FROM USER_TABLE")
    List<String> loadNamesFromUser();

    @Query("SELECT * FROM USER_TABLE U WHERE U.USERNAME == :username AND U.PASSWORD == :password")
    User isExistUser(String username, String password);

    /*@Query("SELECT * FROM USER_TABLE U WHERE U.USERNAME == :username AND U.PASSWORD == :password")
    User createUser(String username, String password);*/
}
