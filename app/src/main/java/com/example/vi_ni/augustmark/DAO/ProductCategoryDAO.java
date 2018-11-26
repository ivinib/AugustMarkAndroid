package com.example.vi_ni.augustmark.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.vi_ni.augustmark.model.ProductCategory;

import java.util.List;

@Dao
public interface ProductCategoryDAO {

    @Insert
    void insert(ProductCategory productCategory);

    @Update
    void update(ProductCategory productCategory);

    @Query("DELETE FROM PRODUCT_CATEGORY WHERE PRODUCT_CATEGORY.IDPRODUCT_CATEGORY == :idProductCategory")
    void delete (Integer idProductCategory);

    @Query("SELECT * FROM PRODUCT_CATEGORY WHERE PRODUCT_CATEGORY.IDPRODUCT_CATEGORY == :idProductCategory")
    ProductCategory loadProductCategoryById(Integer idProductCategory);

    @Query("SELECT * FROM PRODUCT_CATEGORY")
    List<ProductCategory> loadAllProductCategories();
}
