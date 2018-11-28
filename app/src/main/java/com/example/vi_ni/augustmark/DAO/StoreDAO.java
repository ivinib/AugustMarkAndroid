package com.example.vi_ni.augustmark.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.vi_ni.augustmark.model.Store;
import com.example.vi_ni.augustmark.model.StoreCategory;
import com.example.vi_ni.augustmark.model.User;

import java.util.List;

@Dao
public interface StoreDAO {

    @Insert
    void insert(Store store);

    @Update
    void update(Store store);

    @Query("DELETE FROM STORE_TABLE WHERE STORE_TABLE.IDSTORE == :idStore")
    void delete(Integer idStore);

    @Query("SELECT * FROM STORE_TABLE WHERE STORE_TABLE.IDSTORE == :idStore")
    Store loadStoreById(Integer idStore);

    @Query("SELECT * FROM STORE_TABLE ORDER BY NAME_STORE ASC")
    List<Store> loadStores();

    @Query("SELECT S.NAME_STORE, S.EMAIL_STORE, S.PHONE_STORE, S.CNPJ, U.NAME_USER " +
            "FROM STORE_TABLE S INNER JOIN USER_TABLE U " +
            "ON S.IDUSER_FK = U.IDUSER ")
    List<StoreJoin> loadStoreJoin();

    @Query("SELECT NAME_STORE FROM STORE_TABLE")
    List<String> loadStoresNames();

    static class StoreJoin{
        @Embedded
        public Store store;
        @Embedded
        public User user;
    }
}
