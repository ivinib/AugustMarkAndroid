package com.example.vi_ni.augustmark.repository;

import android.content.Context;
import android.os.AsyncTask;

import com.example.vi_ni.augustmark.DAO.ServiceStatusDAO;
import com.example.vi_ni.augustmark.database.AugustMarkRoomDataBase;
import com.example.vi_ni.augustmark.model.ServiceStatus;

import java.util.List;

public class ServiceStatusRepository {

    private ServiceStatusDAO mServiceStatusDAO;
    private List<ServiceStatus> mServiceStatuses;

    public ServiceStatusRepository(Context context){
        AugustMarkRoomDataBase dataBase = AugustMarkRoomDataBase.getDataBase(context);
        mServiceStatusDAO = dataBase.serviceStatusDAO();
    }

    public List<ServiceStatus> getAllServiceStatuses(){
        mServiceStatuses = mServiceStatusDAO.loadServiceStatuses();
        return mServiceStatuses;
    }

    public ServiceStatus loadServiceStatusByID(Integer idServiceStatus) {
        return mServiceStatusDAO.loadServiceStatusById(idServiceStatus);
    }

    public void insert(ServiceStatus serviceStatus){
        new insertAsyncTask(mServiceStatusDAO).execute(serviceStatus);
    }
    public void delete(Integer idServiceStatus){
        mServiceStatusDAO.delete(idServiceStatus);
    }
    public void update(ServiceStatus serviceStatus) {
        mServiceStatusDAO.update(serviceStatus);
    }


    private static class insertAsyncTask extends AsyncTask<ServiceStatus,Void,Void> {

        private ServiceStatusDAO mAsyncTaskDAO;

        insertAsyncTask(ServiceStatusDAO dao){
            mAsyncTaskDAO = dao;
        }

        @Override
        protected Void doInBackground(final ServiceStatus... params){
            mAsyncTaskDAO.insert(params[0]);
            return null;
        }
    }
}
