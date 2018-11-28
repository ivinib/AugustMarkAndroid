package com.example.vi_ni.augustmark.repository;


import android.content.Context;

public class Repository {
    private ServiceScheduleRepository serviceScheduleRepository;
    private StoreRepository storeRepository;
    private UserRepository userRepository;

    public Repository(Context context){
        serviceScheduleRepository = new ServiceScheduleRepository(context);
        storeRepository = new StoreRepository(context);
        userRepository = new  UserRepository(context);
    }
    public ServiceScheduleRepository getServiceScheduleRepository() {
        return serviceScheduleRepository;
    }
    public StoreRepository getStoreRepository(){
        return storeRepository;
    }
    public UserRepository getUserRepository(){
        return userRepository;
    }

}
