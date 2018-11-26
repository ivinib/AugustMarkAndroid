package com.example.vi_ni.augustmark.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "SERVICE_TABLE",
        foreignKeys = @ForeignKey(entity = Store.class, parentColumns = "IDSTORE",childColumns = "IDSTORE_FK1"))
public class Service {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "IDSERVICE")
    private Integer idService;

    @ColumnInfo(name = "NAME_SERVICE")
    private String name;

    @ColumnInfo(name = "DESCRIPTION")
    private String description;

    @ColumnInfo(name = "IDSTORE_FK1")
    private Integer idStore;

    public Service(){}

    public Service(Integer idService, String name, String description){
        this.idService = idService;
        this.name = name;
        this.description = description;
    }

    public Integer getIdService() {
        return idService;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getIdStore() {
        return idStore;
    }

    public void setIdService(Integer idService) {
        this.idService = idService;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIdStore(Integer idStore) {
        this.idStore = idStore;
    }
}
