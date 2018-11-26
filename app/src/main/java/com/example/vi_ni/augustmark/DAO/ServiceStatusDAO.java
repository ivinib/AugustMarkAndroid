package com.example.vi_ni.augustmark.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.vi_ni.augustmark.model.ServiceStatus;

import java.util.List;

@Dao
public interface ServiceStatusDAO {
    @Insert
    void insert(ServiceStatus serviceStatus);

    @Update
    void update(ServiceStatus serviceStatus);

    @Query("DELETE FROM SERVICE_STATUS_TABLE WHERE SERVICE_STATUS_TABLE.IDSERVICE_STATUS == :idServiceStatus")
    void delete(Integer idServiceStatus);

    @Query("SELECT * FROM SERVICE_STATUS_TABLE WHERE SERVICE_STATUS_TABLE.IDSERVICE_STATUS == :idServiceStatus")
    ServiceStatus loadServiceStatusById(Integer idServiceStatus);

    @Query("SELECT * FROM SERVICE_STATUS_TABLE")
    List<ServiceStatus> loadServiceStatuses();

}
