package com.example.vi_ni.augustmark.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "USER_TABLE")
public class User {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "IDUSER")
    private Long idUser;

    @ColumnInfo(name = "USERNAME")
    private String userName;

    @ColumnInfo(name = "EMAIL_USER")
    private String email;

    @ColumnInfo(name = "PHONE_USER")
    private String phone;

    @ColumnInfo(name = "PASSWORD")
    private String password;

    @ColumnInfo(name = "NAME_USER")
    private String name;

    @ColumnInfo(name = "CPF")
    private String cpf;

    @ColumnInfo(name = "ROLE")
    private String role;

    public User(){}
    public User(Long idUser, String userName, String email, String phone, String password, String name, String cpf, String role){
        this.idUser = idUser;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.name = name;
        this.cpf = cpf;
        this.role = role;
    }

    public Long getIdUser() { return idUser; }

    public String getUserName() { return userName; }

    public String getEmail() { return email; }

    public String getPhone() { return phone; }

    public String getPassword() { return password; }

    public String getName() { return name; }

    public String getCpf() { return cpf;  }

    public String getRole() { return role; }

    public void setIdUser(Long idUser) { this.idUser = idUser;  }

    public void setUserName(String userName) { this.userName = userName; }

    public void setEmail(String email) { this.email = email; }

    public void setPhone(String phone) { this.phone = phone; }

    public void setPassword(String password) { this.password = password; }

    public void setName(String name) { this.name = name; }

    public void setCpf(String cpf) { this.cpf = cpf; }

    public void setRole(String role) { this.role = role; }
}
