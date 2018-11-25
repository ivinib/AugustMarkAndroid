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

    @Query("DELETE FROM SERVICE WHERE SERVICE.IDSERVICE == :idService")
    void delete(Integer idService);

    @Query("SELECT * FROM SERVICE WHERE SERVICE.IDSERVICE == :idService")
    Service loadServiceById(Integer idService);

    @Query("SELECT NAME FROM SERVICE")
    List<String> loadNamesServices();

    @Query("SELECT * FROM SERVICE")
    List<Service> loadServices();

    @Query("SELECT SE.NAME, SE.DESCRIPTION, ST.NAME, ST.EMAIL, ST.PHONE, ST.CNPJ " +
            "FROM SERVICE SE INNER JOIN STORE ST " +
            "ON ST.IDSTORE = SE.IDSTORE")
    List<ServiceJoin> loadServiceJoin();

    static class ServiceJoin{
        @Embedded
        public Service service;
        @Embedded
        public Store store;
    }
}
