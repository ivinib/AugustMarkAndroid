package com.example.vi_ni.augustmark.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.vi_ni.augustmark.DAO.*;
import com.example.vi_ni.augustmark.model.*;

@Database(entities = {Address.class, Product.class, ProductCategory.class, Service.class, ServiceSchedule.class, ServiceStatus.class, Store.class, StoreCategory.class}, version = 1)
public abstract class AugustMarkRoomDataBase extends RoomDatabase {

    private static volatile AugustMarkRoomDataBase INSTANCE;
    public abstract AddressDAO addressDAO();
    public abstract ProductDAO productDAO();
    public abstract ProductCategoryDAO productCategoryDAO();
    public abstract ServiceDAO serviceDAO();
    public abstract ServiceScheduleDAO serviceScheduleDAO();
    public abstract ServiceStatusDAO serviceStatusDAO();
    public abstract StoreDAO storeDAO();
    public abstract StoreCategoryDAO storeCategoryDAO();
    public abstract UserDAO userDAO();

    public static AugustMarkRoomDataBase getDataBase(final Context context){
        if (INSTANCE == null){
            synchronized (AugustMarkRoomDataBase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AugustMarkRoomDataBase.class, "AUGUST_MARK").allowMainThreadQueries().build();
                }
            }
        }
        return INSTANCE;
    }
}
