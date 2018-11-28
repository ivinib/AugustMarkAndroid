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

public class RequestScheduleActivity extends AppCompatActivity {

    private User user;
    private ServiceSchedule serviceSchedule;
    private Repository repository;
    private Intent intent;
    private EditText edtDateSchedule, edtDateRequest, edtTypeService;
    private Long idUser = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_schedule);

        edtDateRequest = findViewById(R.id.edtRequestDate);
        edtDateSchedule = findViewById(R.id.edtDateSchedule);
        edtTypeService = findViewById(R.id.edtType);

        repository = new Repository(getApplicationContext());

        intent = getIntent();
        Bundle bundle = intent.getExtras();
        idUser = bundle.getLong("idUser");

        if (user == null){
            user = new User();

            user = repository.getUserRepository().loadUserById(idUser);
        }
    }

    public void addSchedule(View view){
        serviceSchedule = new ServiceSchedule();
        serviceSchedule.setRequestDate(edtDateRequest.getText().toString());
        serviceSchedule.setSchedulingDate(edtDateSchedule.getText().toString());
        serviceSchedule.setIdUser(user.getIdUser());

        repository.getServiceScheduleRepository().insert(serviceSchedule);

        Toast.makeText(this, "Agendado", Toast.LENGTH_SHORT).show();

        intent = new Intent(this, ScheduleActivity.class);
        intent.putExtra("idUser",idUser);
        startActivity(intent);
    }
}
