package com.example.vi_ni.augustmark.repository;

import android.content.Context;
import android.os.AsyncTask;

import com.example.vi_ni.augustmark.DAO.StoreDAO;
import com.example.vi_ni.augustmark.database.AugustMarkRoomDataBase;
import com.example.vi_ni.augustmark.model.Store;

import java.util.List;

public class StoreRepository {

    private StoreDAO mStoreDAO;
    private List<Store> mStores;
    private List<StoreDAO.StoreJoin> mStoresJoin;

    public StoreRepository(Context context){
        AugustMarkRoomDataBase dataBase = AugustMarkRoomDataBase.getDataBase(context);
        mStoreDAO = dataBase.storeDAO();
    }

    public List<Store> loadAllStores(){
        mStores = mStoreDAO.loadStores();
        return mStores;
    }

    public Store loadStoreById(Integer idStore){
        return mStoreDAO.loadStoreById(idStore);
    }

    public void insert(Store store){
        new insertAsyncTask(mStoreDAO).execute(store);
    }

    public void update(Store store){
        mStoreDAO.update(store);
    }
    public void delete(Integer idStore){
        mStoreDAO.delete(idStore);
    }

    private static class insertAsyncTask extends AsyncTask<Store,Void,Void>{
        private StoreDAO mAsyncTaskDAO;

        insertAsyncTask(StoreDAO storeDAO){
            mAsyncTaskDAO = storeDAO;
        }

        @Override
        protected Void doInBackground(final Store... params){
            mAsyncTaskDAO.insert(params[0]);
            return null;
        }
    }
}
