package com.example.vi_ni.augustmark.repository;

import android.content.Context;
import android.os.AsyncTask;

import com.example.vi_ni.augustmark.DAO.ProductDAO;
import com.example.vi_ni.augustmark.database.AugustMarkRoomDataBase;
import com.example.vi_ni.augustmark.model.Product;

import java.util.List;

public class ProductRepository {

    private ProductDAO mProductDAO;
    private List<Product> mProducts;
    private List<ProductDAO.ProductJoin> mProductJoins;

    public ProductRepository(Context context){
        AugustMarkRoomDataBase dataBase = AugustMarkRoomDataBase.getDataBase(context);
        mProductDAO = dataBase.productDAO();
    }

    public List<Product> loadAllProducts(){
        mProducts = mProductDAO.loadAllProducts();
        return mProducts;
    }

    public Product loadProductById(Integer idProduct){
        return mProductDAO.loadProductById(idProduct);
    }

    public List<ProductDAO.ProductJoin> loadProductsJoin(){
        mProductJoins = mProductDAO.loadProductJoin();
        return mProductJoins;
    }

    private static class insertAsyncTask extends AsyncTask<Product,Void,Void>{
        private ProductDAO mAsyncTaskDAO;

        insertAsyncTask(ProductDAO productDAO){
            mAsyncTaskDAO = productDAO;
        }

        @Override
        protected Void doInBackground(final Product... params){
            mAsyncTaskDAO.insert(params[0]);
            return null;
        }
    }
}
