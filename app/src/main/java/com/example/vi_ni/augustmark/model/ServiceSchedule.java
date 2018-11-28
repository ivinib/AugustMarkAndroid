package com.example.vi_ni.augustmark.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.nfc.tech.NfcA;

import java.util.Date;

@Entity(tableName = "SERVICE_SCHEDULE_TABLE",
        foreignKeys = @ForeignKey(entity = User.class, parentColumns = "IDUSER", childColumns = "IDUSER_FK"))
public class ServiceSchedule {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "IDSERVICE_SCHEDULE")
    private Integer idServiceSchedule;

    @ColumnInfo(name = "SCHEDULING_DATE")
    private String schedulingDate;

    @ColumnInfo(name = "REQUEST_DATE")
    private String requestDate;

    @ColumnInfo(name = "IDUSER_FK")
    private Long idUser;

    public ServiceSchedule(){}

    public ServiceSchedule(Integer idServiceSchedule, String schedulingDate, String requestDate){
        this.idServiceSchedule = idServiceSchedule;
        this.schedulingDate = schedulingDate;
        this.requestDate = requestDate;
    }

    public Integer getIdServiceSchedule() {
        return idServiceSchedule;
    }

    public String getSchedulingDate() {
        return schedulingDate;
    }

    public String getRequestDate() {
        return requestDate;
    }


    public Long getIdUser() {
        return idUser;
    }

    public void setIdServiceSchedule(Integer idServiceSchedule) {
        this.idServiceSchedule = idServiceSchedule;
    }

    public void setSchedulingDate(String schedulingDate) {
        this.schedulingDate = schedulingDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

}
