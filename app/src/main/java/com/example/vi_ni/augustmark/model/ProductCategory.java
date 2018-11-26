package com.example.vi_ni.augustmark.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "PRODUCT_CATEGORY_TABLE")
public class ProductCategory {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "IDPRODUCT_CATEGORY")
    private Integer idProductCategory;

    @ColumnInfo(name = "NAME_PRODUCT_CATEGORY")
    private String name;

    @ColumnInfo(name = "DESCRIPTION")
    private String description;

    public ProductCategory(){}

    public ProductCategory(Integer idProductCategory, String name, String description){
        this.idProductCategory = idProductCategory;
        this.name = name;
        this.description = description;
    }

    public Integer getIdProductCategory() {
        return idProductCategory;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setIdProductCategory(Integer idProductCategory) {
        this.idProductCategory = idProductCategory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
