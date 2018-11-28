package com.example.vi_ni.augustmark.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vi_ni.augustmark.R;
import com.example.vi_ni.augustmark.model.ServiceSchedule;
import com.example.vi_ni.augustmark.model.User;
import com.example.vi_ni.augustmark.repository.Repository;

public class UpdateSchedule extends AppCompatActivity {

    private ServiceSchedule serviceSchedule = null;
    private User user;
    private Repository repository;
    private Intent intent;
    private EditText edtDateSchedule, edtDateRequest, edtTypeService;
    private Long idUser = null;
    private Integer idSchedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_schedule);

        edtDateRequest = findViewById(R.id.edtRequestDate);
        edtDateSchedule = findViewById(R.id.edtDateSchedule);

        repository = new Repository(getApplicationContext());

        intent = getIntent();
        Bundle bundle = intent.getExtras();
        idUser = bundle.getLong("idUser");
        idSchedule = bundle.getInt("idSchedule");

        if (user == null){
            user = new User();

            user = repository.getUserRepository().loadUserById(idUser);
        }

        if (serviceSchedule == null){
            serviceSchedule = repository.getServiceScheduleRepository().loadServiceScheduleById(idSchedule);

            edtDateRequest.setText(serviceSchedule.getRequestDate());
            edtDateSchedule.setText(serviceSchedule.getSchedulingDate());
        }

    }

    public void updateSchedule(View view){
        serviceSchedule.setRequestDate(edtDateRequest.getText().toString());
        serviceSchedule.setSchedulingDate(edtDateSchedule.getText().toString());

        repository.getServiceScheduleRepository().update(serviceSchedule);

        Toast.makeText(this, "Agendado", Toast.LENGTH_SHORT).show();

        intent = new Intent(this, ScheduleActivity.class);
        intent.putExtra("idUser",idUser);
        startActivity(intent);
    }
}
