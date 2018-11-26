package com.example.vi_ni.augustmark.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.vi_ni.augustmark.model.Address;
import com.example.vi_ni.augustmark.model.Service;
import com.example.vi_ni.augustmark.model.ServiceSchedule;
import com.example.vi_ni.augustmark.model.ServiceStatus;
import com.example.vi_ni.augustmark.model.User;

import java.util.List;

@Dao
public interface ServiceScheduleDAO {

    @Insert
    void insert(ServiceSchedule serviceSchedule);

    @Update
    void update(ServiceSchedule serviceSchedule);

    @Query("DELETE FROM SERVICE_SCHEDULE WHERE SERVICE_SCHEDULE.IDSERVICE_SCHEDULE == :idServiceSchedule")
    void delete(Integer idServiceSchedule);

    @Query("SELECT * FROM SERVICE_SCHEDULE WHERE SERVICE_SCHEDULE.IDSERVICE_SCHEDULE == :idServiceSchedule")
    ServiceSchedule loadScheduleById(Integer idServiceSchedule);

    @Query("SELECT * FROM SERVICE_SCHEDULE")
    List<ServiceSchedule> loadAllServiceSchedules();


    @Query("SELECT SSC.SCHEDULING_DATE, SSC.REQUEST_DATE, " +
            "S.NAME, S.DESCRIPTION, " +
            "A.COUNTRY, A.STATE, A.STREET, A.CITY, A.DISTRICT, A.NUM, " +
            "U.NAME, U.EMAIL, U.PHONE, U.CPF, " +
            "SST.NAME " +
            "FROM SERVICE_SCHEDULE SSC INNER JOIN SERVICE S " +
            "ON SSC.IDSERVICE = S.IDSERVICE " +
            "INNER JOIN ADDRESS A " +
            "ON A.IDADDRESS = SSC.IDADDRESS " +
            "INNER JOIN USER U " +
            "ON U.IDUSER = SSC.IDUSER " +
            "INNER JOIN SERVICE_STATUS SST " +
            "ON SST.IDSERVICE_STATUS = SSC.IDSERVICE_STATUS")
    List<ServiceScheduleJoin> loadServiceScheduleJoin();

    static class ServiceScheduleJoin{
        @Embedded
        public ServiceSchedule serviceSchedule;
        @Embedded
        public Service service;
        @Embedded
        public Address address;
        @Embedded
        public User user;
        @Embedded
        public ServiceStatus serviceStatus;
    }
}
