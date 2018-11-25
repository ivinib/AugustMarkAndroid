package com.example.vi_ni.augustmark.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "SERVICE_STATUS")
public class ServiceStatus {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "IDSERVICE_STATUS")
    private Integer idServiceStatus;

    @ColumnInfo(name = "NAME")
    private String name;

    public ServiceStatus(){}

    public ServiceStatus(Integer idServiceStatus, String name){
        this.idServiceStatus = idServiceStatus;
        this.name = name;
    }

    public Integer getIdServiceStatus() {
        return idServiceStatus;
    }

    public String getName() {
        return name;
    }

    public void setIdServiceStatus(Integer idServiceStatus) {
        this.idServiceStatus = idServiceStatus;
    }

    public void setName(String name) {
        this.name = name;
    }
}
