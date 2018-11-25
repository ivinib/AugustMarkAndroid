package com.example.vi_ni.augustmark.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Embedded;

import com.example.vi_ni.augustmark.model.Address;
import com.example.vi_ni.augustmark.model.Service;
import com.example.vi_ni.augustmark.model.ServiceSchedule;
import com.example.vi_ni.augustmark.model.ServiceStatus;
import com.example.vi_ni.augustmark.model.User;

@Dao
public interface ServiceScheduleDAO {

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
