package com.example.vi_ni.augustmark.repository;

import android.content.Context;
import android.os.AsyncTask;

import com.example.vi_ni.augustmark.DAO.AddressDAO;
import com.example.vi_ni.augustmark.database.AugustMarkRoomDataBase;
import com.example.vi_ni.augustmark.model.Address;

import java.util.List;

public class AddressRepository {

    private AddressDAO mAddressDAO;
    private List<Address> mAddresses;
    private List<AddressDAO.AddressJoin> mAddressJoins;

    public AddressRepository(Context context){
        AugustMarkRoomDataBase dataBase = AugustMarkRoomDataBase.getDataBase(context);
        mAddressDAO = dataBase.addressDAO();
    }

    public List<Address> loadAllAddresses(){
        mAddresses = mAddressDAO.loadAllAddresses();
        return mAddresses;
    }

    public Address loadAddressById(Integer idAddress){
       return mAddressDAO.loadAddressById(idAddress);
    }

    public List<AddressDAO.AddressJoin> loadAddressJoin(){
        mAddressJoins = mAddressDAO.loadAddressJoin();
        return mAddressJoins;
    }

    public void insert(Address address){
        new insertAsyncTask(mAddressDAO).execute(address);
    }
    public void update(Address address){
        mAddressDAO.update(address);
    }
    public void delete(Integer idAddress){
        mAddressDAO.delete(idAddress);
    }

    private static class insertAsyncTask extends AsyncTask<Address,Void,Void>{
        private AddressDAO mAsyncTaskDAO;

        insertAsyncTask(AddressDAO addressDAO){
            mAsyncTaskDAO = addressDAO;
        }

        @Override
        protected Void doInBackground(final Address... params){
            mAsyncTaskDAO.insert(params[0]);
            return null;
        }
    }
}
