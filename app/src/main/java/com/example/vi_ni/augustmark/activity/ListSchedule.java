package com.example.vi_ni.augustmark.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.vi_ni.augustmark.DAO.ServiceScheduleDAO;
import com.example.vi_ni.augustmark.R;
import com.example.vi_ni.augustmark.adapter.ScheduleAdapter;
import com.example.vi_ni.augustmark.model.ServiceSchedule;
import com.example.vi_ni.augustmark.model.User;
import com.example.vi_ni.augustmark.repository.Repository;

import java.util.List;

public class ListSchedule extends AppCompatActivity {

    private ListView listViewSchedule;
    private Repository repository;
    private User user;
    private ServiceSchedule schedule;
    private List<ServiceSchedule> scheduleList;
    ArrayAdapter<ServiceScheduleDAO.ServiceScheduleJoin> adapterSchedule;
    private Long idUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_schedule);
        repository = new Repository(getApplicationContext());

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        idUser = bundle.getLong("idUser");

        if (user == null){
            user = new User();
            schedule = new ServiceSchedule();

            user = repository.getUserRepository().loadUserById(idUser);
            scheduleList = repository.getServiceScheduleRepository().loadServiceSchedulesByUser(idUser);
        }
        listViewSchedule = findViewById(R.id.listSchedules);
        updateAdapter();
    }

    private void updateAdapter(){
        List<ServiceScheduleDAO.ServiceScheduleJoin> scheduleJoins = repository.getServiceScheduleRepository().loadServiceScheduleJoin();
        adapterSchedule = new ScheduleAdapter(getApplicationContext(), R.layout.schedule_item, scheduleJoins);
        listViewSchedule.setAdapter(adapterSchedule);
    }
}
