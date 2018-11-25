package com.example.vi_ni.augustmark.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "STORE_CATEGORY")
public class StoreCategory {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "IDSTORE_CATEGORY")
    private Integer idStoreCategory;

    @ColumnInfo(name = "NAME")
    private String name;

    @ColumnInfo(name = "DESCRIPTION")
    private String description;

    public StoreCategory(){}

    public StoreCategory(Integer idStoreCategory, String name, String description){
        this.idStoreCategory = idStoreCategory;
        this.name = name;
        this.description = description;
    }

    public Integer getIdStoreCategory() {
        return idStoreCategory;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setIdStoreCategory(Integer idStoreCategory) {
        this.idStoreCategory = idStoreCategory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
