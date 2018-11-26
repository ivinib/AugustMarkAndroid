package com.example.vi_ni.augustmark.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.vi_ni.augustmark.model.Service;
import com.example.vi_ni.augustmark.model.Store;

import java.util.List;

@Dao
public interface ServiceDAO {
    @Insert
    void insert(Service service);

    @Update
    void update(Service service);

    @Query("DELETE FROM SERVICE_TABLE WHERE SERVICE_TABLE.IDSERVICE == :idService")
    void delete(Integer idService);

    @Query("SELECT * FROM SERVICE_TABLE WHERE SERVICE_TABLE.IDSERVICE == :idService")
    Service loadServiceById(Integer idService);

    @Query("SELECT NAME_SERVICE FROM SERVICE_TABLE")
    List<String> loadNamesServices();

    @Query("SELECT * FROM SERVICE_TABLE")
    List<Service> loadServices();

    @Query("SELECT SE.NAME_SERVICE, SE.DESCRIPTION, ST.NAME_STORE, ST.EMAIL_STORE, ST.PHONE_STORE, ST.CNPJ " +
            "FROM SERVICE_TABLE SE INNER JOIN STORE_TABLE ST " +
            "ON ST.IDSTORE = SE.IDSTORE_FK1")
    List<ServiceJoin> loadServiceJoin();

    static class ServiceJoin{
        @Embedded
        public Service service;
        @Embedded
        public Store store;
    }
}
