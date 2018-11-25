package com.example.vi_ni.augustmark.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.vi_ni.augustmark.model.Address;
import com.example.vi_ni.augustmark.model.Store;

import java.util.List;

@Dao
public interface AddressDAO {
    @Insert
    void insert(Address address);

    @Update
    void update(Address address);

    @Query("DELETE FROM ADDRESS WHERE ADDRESS.IDADDRESS == :idAddress")
    void delete(Integer idAddress);

    @Query("SELECT * FROM ADDRESS WHERE ADDRESS.IDADDRESS == :idAddress")
    Address loadAddressById(Integer idAddress);

    @Query("SELECT A.COUNTRY, A.STATE, A.CITY, A.STREET, A.DISTRICT, A.NUM, S.NAME, S.EMAIL, S.PHONE, S.CNPJ " +
           "FROM ADDRESS A INNER JOIN STORE S " +
           "ON A.IDSTORE = S.IDSTORE")
    List<AddressJoin> loadAddressJoin();

    static class AddressJoin{
        @Embedded
        public Address address;
        @Embedded
        Store store;
    }
}
