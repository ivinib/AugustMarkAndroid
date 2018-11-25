package com.example.vi_ni.augustmark.repository;

import android.content.Context;
import android.os.AsyncTask;

import com.example.vi_ni.augustmark.DAO.StoreCategoryDAO;
import com.example.vi_ni.augustmark.database.AugustMarkRoomDataBase;
import com.example.vi_ni.augustmark.model.StoreCategory;

import java.util.List;

public class StoreCategoryRepository {
    private StoreCategoryDAO mStoreCategoryDAO;
    private List<StoreCategory> mstoreCategories;

    public StoreCategoryRepository(Context context){
        AugustMarkRoomDataBase dataBase = AugustMarkRoomDataBase.getDataBase(context);
        mStoreCategoryDAO = dataBase.storeCategoryDAO();
    }

    public List<StoreCategory> getAllStoreCategories(){
        mstoreCategories = mStoreCategoryDAO.loadStoreCategory();
        return mstoreCategories;
    }

    public StoreCategory loadStoreCategoryById(Integer idStoreCategory){
        return mStoreCategoryDAO.loadStoreCategoryById(idStoreCategory);
    }

    public void insert(StoreCategory storeCategory){
        new insertAsyncTask(mStoreCategoryDAO).execute(storeCategory);
    }
    public void update(StoreCategory storeCategory){
        mStoreCategoryDAO.update(storeCategory);
    }
    public void delete(Integer idStoreCategory){
        mStoreCategoryDAO.delete(idStoreCategory);
    }

    private static class insertAsyncTask extends AsyncTask<StoreCategory,Void,Void>{
        private StoreCategoryDAO mAsyncTaskDAO;

        insertAsyncTask(StoreCategoryDAO storeCategoryDAO){
            mAsyncTaskDAO = storeCategoryDAO;
        }

        @Override
        protected Void doInBackground(final StoreCategory... params){
            mAsyncTaskDAO.insert(params[0]);
            return null;
        }
    }
}
