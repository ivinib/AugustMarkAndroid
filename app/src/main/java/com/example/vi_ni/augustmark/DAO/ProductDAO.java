package com.example.vi_ni.augustmark.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.vi_ni.augustmark.model.Product;
import com.example.vi_ni.augustmark.model.ProductCategory;
import com.example.vi_ni.augustmark.model.Store;

import java.util.List;

@Dao
public interface ProductDAO {
    @Insert
    void insert(Product product);

    @Update
    void update(Product product);

    @Query("DELETE FROM PRODUCT_TABLE WHERE PRODUCT_TABLE.IDPRODUCT == :idProduct")
    void delete(Integer idProduct);

    @Query("SELECT * FROM PRODUCT_TABLE WHERE PRODUCT_TABLE.IDPRODUCT == :idProduct")
    Product loadProductById(Integer idProduct);

    @Query("SELECT NAME_PRODUCT FROM PRODUCT_TABLE")
    List<String> loadProductByName();

    @Query("SELECT * FROM PRODUCT_TABLE")
    List<Product> loadAllProducts();

    @Query("SELECT P.NAME_PRODUCT, P.PRICE, P.STOCK, PC.NAME_PRODUCT_CATEGORY, PC.DESCRIPTION, S.NAME_STORE, S.EMAIL_STORE, S.PHONE_STORE, S.CNPJ " +
            "FROM PRODUCT_TABLE P INNER JOIN PRODUCT_CATEGORY_TABLE PC " +
            "ON P.IDPRODUCT_CATEGORY_FK = PC.IDPRODUCT_CATEGORY " +
            "INNER JOIN STORE_TABLE S " +
            "ON S.IDSTORE = P.IDSTORE_FK")
    List<ProductJoin> loadProductJoin();

    static class ProductJoin{
        @Embedded
        public Product product;
        @Embedded
        ProductCategory productCategory;
        @Embedded
        Store store;
    }
}
