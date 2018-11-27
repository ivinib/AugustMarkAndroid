package com.example.vi_ni.augustmark.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.vi_ni.augustmark.DAO.ServiceScheduleDAO;
import com.example.vi_ni.augustmark.R;

import java.util.List;

public class ScheduleAdapter  extends ArrayAdapter<ServiceScheduleDAO.ServiceScheduleJoin> {
    private int rIdSchedule;

    public ScheduleAdapter( Context context, int resource,  List<ServiceScheduleDAO.ServiceScheduleJoin> schedulesList){
        super(context,resource,schedulesList);
        this.rIdSchedule = resource;
    }

    @Override
    public View getView(int position, View currentView, ViewGroup parent) {
        View mView = currentView;

        if (mView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = inflater.inflate(this.rIdSchedule, null);
        }
        ServiceScheduleDAO.ServiceScheduleJoin scheduleJoin = getItem(position);

        TextView nameService = mView.findViewById(R.id.txtNameServiceSchedule);
        TextView dateSchedule = mView.findViewById(R.id.txtScheduleDate);
        TextView dateRequest = mView.findViewById(R.id.txtRequestDate);
        TextView nameUser = mView.findViewById(R.id.txtNameUserSchedule);
        TextView address = mView.findViewById(R.id.txtAddresSchedule);

        nameService.setText(scheduleJoin.serviceSchedule.getIdService());
        dateSchedule.setText(scheduleJoin.serviceSchedule.getSchedulingDate());
        dateRequest.setText(scheduleJoin.serviceSchedule.getRequestDate());
        nameUser.setText(String.valueOf(scheduleJoin.serviceSchedule.getIdUser()));
        address.setText(String.valueOf(scheduleJoin.serviceSchedule.getIdAddress()));

        return mView;
    }
}
