package com.example.vi_ni.augustmark.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.vi_ni.augustmark.model.ServiceSchedule;
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

    @Query("SELECT * FROM SERVICE_SCHEDULE_TABLE WHERE IDUSER_FK == :idUser")
    List<ServiceSchedule> loadServiceSchedulesByIdUser(Long idUser);


    @Query("SELECT S.SCHEDULING_DATE, S.REQUEST_DATE, U.NAME_USER " +
            "FROM SERVICE_SCHEDULE_TABLE S INNER JOIN USER_TABLE U " +
            "ON U.IDUSER = S.IDUSER_FK ")
    List<ServiceScheduleJoin> loadServiceScheduleJoin();

    static class ServiceScheduleJoin{
        @Embedded
        public ServiceSchedule serviceSchedule;
        @Embedded
        public User user;
    }
}
