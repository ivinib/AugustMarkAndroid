package com.example.vi_ni.augustmark.repository;

import android.content.Context;
import android.os.AsyncTask;

import com.example.vi_ni.augustmark.DAO.ServiceScheduleDAO;
import com.example.vi_ni.augustmark.database.AugustMarkRoomDataBase;
import com.example.vi_ni.augustmark.model.ServiceSchedule;

import java.util.List;

public class ServiceScheduleRepository {

    private ServiceScheduleDAO mServiceScheduleDAO;
    private List<ServiceSchedule> mServiceSchedules;
    private List<ServiceScheduleDAO.ServiceScheduleJoin> mServiceScheduleJoins;
    private List<ServiceSchedule> mServiceSchedulesByUser;

    public ServiceScheduleRepository(Context context){
        AugustMarkRoomDataBase dataBase = AugustMarkRoomDataBase.getDataBase(context);
        mServiceScheduleDAO = dataBase.serviceScheduleDAO();
    }

    public List<ServiceSchedule> loadAllServiceSchedules(){
        mServiceSchedules = mServiceScheduleDAO.loadAllServiceSchedules();
        return mServiceSchedules;
    }
    public ServiceSchedule loadServiceScheduleById(Integer idServiceSchedule){
        return mServiceScheduleDAO.loadScheduleById(idServiceSchedule);
    }
    public List<ServiceScheduleDAO.ServiceScheduleJoin> loadServiceScheduleJoin(){
        mServiceScheduleJoins = mServiceScheduleDAO.loadServiceScheduleJoin();
        return mServiceScheduleJoins;
    }

    public List<ServiceSchedule> loadServiceSchedulesByUser(Long idUser){
        mServiceSchedulesByUser = mServiceScheduleDAO.loadServiceSchedulesByIdUser(idUser);
        return mServiceSchedulesByUser;
    }

    public void insert(ServiceSchedule serviceSchedule){
        new insertAsyncTask(mServiceScheduleDAO).execute(serviceSchedule);
    }
    public void update(ServiceSchedule serviceSchedule){
        mServiceScheduleDAO.update(serviceSchedule);
    }
    public void delete(Integer idScheduleService){
        mServiceScheduleDAO.delete(idScheduleService);
    }

    private static class insertAsyncTask extends AsyncTask<ServiceSchedule,Void,Void> {
        private ServiceScheduleDAO mAsyncTaskDAO;

        insertAsyncTask(ServiceScheduleDAO serviceScheduleDAO){
            mAsyncTaskDAO = serviceScheduleDAO;
        }

        @Override
        protected Void doInBackground(final ServiceSchedule... params){
            mAsyncTaskDAO.insert(params[0]);
            return null;
        }
    }
}
