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

    @Query("DELETE FROM STORE WHERE STORE.IDSTORE == :idStore")
    void delete(Integer idStore);

    @Query("SELECT * FROM STORE WHERE STORE.IDSTORE == :idStore")
    Store loadStoreById(Integer idStore);

    @Query("SELECT * FROM STORE ORDER BY NAME ASC")
    List<Store> loadStores();

    @Query("SELECT S.NAME, S.EMAIL, S.PHONE, S.CNPJ, U.NAME, U.CPF, U.EMAIL, U.PHONE, SC.NAME " +
            "FROM STORE S INNER JOIN USER U " +
            "ON S.IDUSER = U.IDUSER " +
            "INNER JOIN STORE_CATEGORY SC " +
            "ON S.IDSTORE_CATEGORY = SC.IDSTORE_CATEGORY " +
            "ORDER BY S.NAME")
    List<StoreJoin> loadStoresJoin();

    @Query("SELECT NAME FROM STORE")
    List<String> loadStoresNames();

    static class StoreJoin{
        @Embedded
        public Store store;
        @Embedded
        public User user;
        @Embedded
        StoreCategory storeCategory;
    }
}
