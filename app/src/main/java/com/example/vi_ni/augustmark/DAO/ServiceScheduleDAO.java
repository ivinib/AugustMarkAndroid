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

    @Query("DELETE FROM SERVICE_SCHEDULE_TABLE WHERE SERVICE_SCHEDULE_TABLE.IDSERVICE_SCHEDULE == :idServiceSchedule")
    void delete(Integer idServiceSchedule);

    @Query("SELECT * FROM SERVICE_SCHEDULE_TABLE WHERE SERVICE_SCHEDULE_TABLE.IDSERVICE_SCHEDULE == :idServiceSchedule")
    ServiceSchedule loadScheduleById(Integer idServiceSchedule);

    @Query("SELECT * FROM SERVICE_SCHEDULE_TABLE")
    List<ServiceSchedule> loadAllServiceSchedules();


    @Query("SELECT SSC.SCHEDULING_DATE, SSC.REQUEST_DATE, " +
            "S.NAME_SERVICE, S.DESCRIPTION, " +
            "A.COUNTRY, A.STATE, A.STREET, A.CITY, A.DISTRICT, A.NUM, " +
            "U.NAME_USER, U.EMAIL_USER, U.PHONE_USER, U.CPF, " +
            "SST.NAME_SERVICE_STATUS " +
            "FROM SERVICE_SCHEDULE_TABLE SSC INNER JOIN SERVICE_TABLE S " +
            "ON SSC.IDSERVICE_FK = S.IDSERVICE " +
            "INNER JOIN ADDRESS_TABLE A " +
            "ON A.IDADDRESS = SSC.IDADDRESS_FK " +
            "INNER JOIN USER_TABLE U " +
            "ON U.IDUSER = SSC.IDUSER_FK " +
            "INNER JOIN SERVICE_STATUS_TABLE SST " +
            "ON SST.IDSERVICE_STATUS = SSC.IDSERVICE_STATUS_FK")
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
