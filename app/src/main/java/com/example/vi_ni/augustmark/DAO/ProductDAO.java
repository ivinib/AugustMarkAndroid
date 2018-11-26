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

    @Query("DELETE FROM PRODUCT WHERE PRODUCT.IDPRODUCT == :idProduct")
    void delete(Integer idProduct);

    @Query("SELECT * FROM PRODUCT WHERE PRODUCT.IDPRODUCT == :idProduct")
    Product loadProductById(Integer idProduct);

    @Query("SELECT NAME FROM PRODUCT")
    List<String> loadProductByName();

    @Query("SELECT * FROM PRODUCT")
    List<Product> loadAllProducts();

    @Query("SELECT P.NAME, P.PRICE, P.STOCK, PC.NAME, PC.DESCRIPTION, S.NAME, S.EMAIL, S.PHONE, S.CNPJ " +
            "FROM PRODUCT P INNER JOIN PRODUCT_CATEGORY PC " +
            "ON P.IDPRODUCT_CATEGORY = PC.IDPRODUCT_CATEGORY " +
            "INNER JOIN STORE S " +
            "ON S.IDSTORE = P.IDSTORE")
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
