package com.example.vi_ni.augustmark.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.vi_ni.augustmark.model.StoreCategory;

import java.util.List;

@Dao
public interface StoreCategoryDAO {

    @Insert
    void insert(StoreCategory storeCategory);

    @Update
    void update(StoreCategory storeCategory);

    @Query("SELECT * FROM STORE_CATEGORY_TABLE")
    List<StoreCategory> loadStoreCategory();

    @Query("DELETE FROM STORE_CATEGORY_TABLE WHERE STORE_CATEGORY_TABLE.IDSTORE_CATEGORY == :idStoreCategory")
    void delete(Integer idStoreCategory);

    @Query("SELECT * FROM STORE_CATEGORY_TABLE WHERE STORE_CATEGORY_TABLE.IDSTORE_CATEGORY == :idStoreCategory")
    StoreCategory loadStoreCategoryById(Integer idStoreCategory);
}
