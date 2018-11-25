package com.example.vi_ni.augustmark.repository;

import android.content.Context;
import android.os.AsyncTask;

import com.example.vi_ni.augustmark.DAO.ServiceDAO;
import com.example.vi_ni.augustmark.database.AugustMarkRoomDataBase;
import com.example.vi_ni.augustmark.model.Service;

import java.util.List;

public class ServiceRepository {

    private ServiceDAO mServiceDAO;
    private List<Service> mServices;
    private List<ServiceDAO.ServiceJoin> mServicesJoin;

    public ServiceRepository(Context context){
        AugustMarkRoomDataBase dataBase = AugustMarkRoomDataBase.getDataBase(context);
        mServiceDAO = dataBase.serviceDAO();
    }

    public List<Service> loadAllServices(){
        mServices = mServiceDAO.loadServices();
        return mServices;
    }

    public List<ServiceDAO.ServiceJoin> loadAllServicesJoin(){
        mServicesJoin = mServiceDAO.loadServiceJoin();
        return mServicesJoin;
    }

    public Service loadServiceByID(Integer idService) {
        return mServiceDAO.loadServiceById(idService);
    }

    public void insert(Service service){
        new insertAsyncTask(mServiceDAO).execute(service);
    }
    public void delete(Integer idService){
        mServiceDAO.delete(idService);
    }
    public void update(Service service) {
        mServiceDAO.update(service);
    }

    private static class insertAsyncTask extends AsyncTask<Service,Void,Void> {

        private ServiceDAO mAsyncTaskDAO;

        insertAsyncTask(ServiceDAO dao){
            mAsyncTaskDAO = dao;
        }

        @Override
        protected Void doInBackground(final Service... params){
            mAsyncTaskDAO.insert(params[0]);
            return null;
        }
    }
}
