package com.example.vi_ni.augustmark.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "PRODUCT",
        foreignKeys = {
            @ForeignKey(entity = Store.class, parentColumns = "IDSTORE",childColumns = "IDSTORE"),
            @ForeignKey(entity = ProductCategory.class, parentColumns = "IDPRODUCT_CATEGORY", childColumns = "IDPRODUCT_CATEGORY")
        })
public class Product {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "IDPRODUCT")
    private Integer idProduct;

    @ColumnInfo(name = "NAME")
    private String name;

    @ColumnInfo(name = "PRICE")
    private Double price;

    @ColumnInfo(name = "STOCK")
    private Integer stock;

    @ColumnInfo(name = "IDSTORE")
    private Integer idStore;

    @ColumnInfo(name = "IDPRODUCT_CATEGORY")
    private Integer idProductCategory;

    public Product(){}

    public Product(Integer idProduct, String name, Double price, Integer stock){
        this.idProduct = idProduct;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getStock() {
        return stock;
    }

    public Integer getIdStore() {
        return idStore;
    }

    public Integer getIdProductCategory() {
        return idProductCategory;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setIdStore(Integer idStore) {
        this.idStore = idStore;
    }

    public void setIdProductCategory(Integer idProductCategory) {
        this.idProductCategory = idProductCategory;
    }
}
