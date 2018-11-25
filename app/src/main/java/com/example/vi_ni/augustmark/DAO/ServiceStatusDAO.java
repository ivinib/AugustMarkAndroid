package com.example.vi_ni.augustmark.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.vi_ni.augustmark.model.ServiceStatus;

@Dao
public interface ServiceStatusDAO {
    @Insert
    void insert(ServiceStatus serviceStatus);

    @Update
    void update(ServiceStatus serviceStatus);

    @Query("DELETE FROM SERVICE_STATUS WHERE SERVICE_STATUS.IDSERVICE_STATUS == :idServiceStatus")
    void delete(Integer idServiceStatus);

    @Query("SELECT * FROM SERVICE_STATUS WHERE SERVICE_STATUS.IDSERVICE_STATUS == :idServiceStatus")
    ServiceStatus loadServiceStatusById(Integer idServiceStatus);

}
