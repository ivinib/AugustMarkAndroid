package com.example.vi_ni.augustmark.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "STORE_TABLE",
        foreignKeys = @ForeignKey(entity = User.class, parentColumns = "IDUSER", childColumns = "IDUSER_FK"))
public class Store {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "IDSTORE")
    private Integer idStore;

    @ColumnInfo(name = "NAME_STORE")
    private String name;

    @ColumnInfo(name = "EMAIL_STORE")
    private String email;

    @ColumnInfo(name = "PHONE_STORE")
    private String phone;

    @ColumnInfo(name = "CNPJ")
    private String cnpj;

    @ColumnInfo(name = "IDUSER_FK")
    private Long idUser;

    public Store(){}

    public Store(Integer idStore, String name, String email, String phone, String cnpj){
        this.idStore = idStore;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.cnpj = cnpj;
    }

    public Integer getIdStore() {
        return idStore;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdStore(Integer idStore) {
        this.idStore = idStore;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

}
