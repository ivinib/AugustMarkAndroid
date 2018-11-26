package com.example.vi_ni.augustmark.repository;

import android.content.Context;
import android.os.AsyncTask;

import com.example.vi_ni.augustmark.DAO.ProductCategoryDAO;
import com.example.vi_ni.augustmark.database.AugustMarkRoomDataBase;
import com.example.vi_ni.augustmark.model.ProductCategory;

import java.util.List;

public class ProductCategoryRepository {

    private ProductCategoryDAO mProductCategoryDAO;
    private List<ProductCategory> mproductCategories;

    public ProductCategoryRepository(Context context){
        AugustMarkRoomDataBase dataBase = AugustMarkRoomDataBase.getDataBase(context);
        mProductCategoryDAO = dataBase.productCategoryDAO();
    }

    public List<ProductCategory> loadAllProductCategories(){
        mproductCategories = mProductCategoryDAO.loadAllProductCategories();
        return mproductCategories;
    }

    public ProductCategory loadProductCategoryById(Integer idProductCategory){
        return mProductCategoryDAO.loadProductCategoryById(idProductCategory);
    }

    public void insert(ProductCategory productCategory){
        mProductCategoryDAO.insert(productCategory);
    }

    public void update(ProductCategory productCategory){
        mProductCategoryDAO.update(productCategory);
    }

    public void delete(Integer idProductCategory){
        mProductCategoryDAO.delete(idProductCategory);
    }

    private static class insertAsyncTask extends AsyncTask<ProductCategory,Void,Void>{
        private ProductCategoryDAO mAsyncTaskDAO;

        insertAsyncTask(ProductCategoryDAO productCategoryDAO){
            mAsyncTaskDAO = productCategoryDAO;
        }

        @Override
        protected Void doInBackground(final ProductCategory... params){
            mAsyncTaskDAO.insert(params[0]);
            return null;
        }
    }
}
