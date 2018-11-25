package com.example.vi_ni.augustmark.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.nfc.tech.NfcA;

import java.util.Date;

@Entity(tableName = "SERVICE_SCHEDULE",
        foreignKeys = {
            @ForeignKey(entity = Service.class, parentColumns = "IDSERVICE", childColumns = "IDSERVICE"),
            @ForeignKey(entity = Address.class, parentColumns = "IDADDRESS", childColumns = "IDADDRESS") ,
            @ForeignKey(entity = User.class, parentColumns = "IDUSER", childColumns = "IDUSER"),
            @ForeignKey(entity = ServiceStatus.class, parentColumns = "IDSERVICE_STATUS", childColumns = "IDSERVICE_STATUS")
        })
public class ServiceSchedule {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "IDSERVICE_SCHEDULE")
    private Integer idServiceSchedule;

    @ColumnInfo(name = "SCHEDULING_DATE")
    private Date schedulingDate;

    @ColumnInfo(name = "REQUEST_DATE")
    private Date requestDate;

    @ColumnInfo(name = "IDSERVICE")
    private Integer idService;

    @ColumnInfo(name = "IDADDRESS")
    private Integer idAddress;

    @ColumnInfo(name = "IDUSER")
    private Integer idUser;

    @ColumnInfo(name = "IDSERVICE_STATUS")
    private Integer idServiceStatus;

    public ServiceSchedule(){}

    public ServiceSchedule(Integer idServiceSchedule, Date schedulingDate, Date requestDate){
        this.idServiceSchedule = idServiceSchedule;
        this.schedulingDate = schedulingDate;
        this.requestDate = requestDate;
    }

    public Integer getIdServiceSchedule() {
        return idServiceSchedule;
    }

    public Date getSchedulingDate() {
        return schedulingDate;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public Integer getIdService() {
        return idService;
    }

    public Integer getIdAddress() {
        return idAddress;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public Integer getIdServiceStatus() {
        return idServiceStatus;
    }

    public void setIdServiceSchedule(Integer idServiceSchedule) {
        this.idServiceSchedule = idServiceSchedule;
    }

    public void setSchedulingDate(Date schedulingDate) {
        this.schedulingDate = schedulingDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public void setIdService(Integer idService) {
        this.idService = idService;
    }

    public void setIdAddress(Integer idAddress) {
        this.idAddress = idAddress;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public void setIdServiceStatus(Integer idServiceStatus) {
        this.idServiceStatus = idServiceStatus;
    }
}
