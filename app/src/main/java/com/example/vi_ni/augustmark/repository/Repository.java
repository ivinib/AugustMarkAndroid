package com.example.vi_ni.augustmark.repository;


import android.content.Context;

public class Repository {
    private AddressRepository addressRepository;
    private ProductCategoryRepository productCategoryRepository;
    private ProductRepository productRepository;
    private ServiceRepository serviceRepository;
    private ServiceScheduleRepository serviceScheduleRepository;
    private ServiceStatusRepository serviceStatusRepository;
    private StoreRepository storeRepository;
    private StoreCategoryRepository storeCategoryRepository;
    private UserRepository userRepository;

    public Repository(Context context){
        addressRepository = new AddressRepository(context);
        productCategoryRepository = new ProductCategoryRepository(context);
        productRepository = new ProductRepository(context);
        serviceRepository = new ServiceRepository(context);
        serviceScheduleRepository = new ServiceScheduleRepository(context);
        serviceStatusRepository = new ServiceStatusRepository(context);
        storeRepository = new StoreRepository(context);
        storeCategoryRepository = new StoreCategoryRepository(context);
        userRepository = new  UserRepository(context);
    }

    public AddressRepository getAddressRepository(){
        return addressRepository;
    }
    public ProductCategoryRepository getProductCategoryRepository(){
        return productCategoryRepository;
    }
    public ProductRepository getProductRepository(){
        return productRepository;
    }
    public ServiceRepository getServiceRepository(){
        return serviceRepository;
    }
    public ServiceScheduleRepository getServiceScheduleRepository(){
        return serviceScheduleRepository;
    }
    public ServiceStatusRepository getServiceStatusRepository(){
        return serviceStatusRepository;
    }
    public StoreRepository getStoreRepository(){
        return storeRepository;
    }
    public StoreCategoryRepository getStoreCategoryRepository(){
        return storeCategoryRepository;
    }
    public UserRepository getUserRepository(){
        return userRepository;
    }

}
