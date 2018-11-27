package com.example.vi_ni.augustmark.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.vi_ni.augustmark.R;
import com.example.vi_ni.augustmark.adapter.UserAdapter;
import com.example.vi_ni.augustmark.model.User;
import com.example.vi_ni.augustmark.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class AllUsersActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private Long idUser;
    private User user;
    private List<User> users;
    private ListView listViewUsers;
    private Repository repository;
    private ArrayAdapter<User> adapter;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_users);

        listViewUsers = findViewById(R.id.listUsers);

        repository = new Repository(getApplicationContext());
        updateAdapter();

        intent = getIntent();
        Bundle bundle = intent.getExtras();

        idUser = bundle.getLong("idUser");

        if (user == null){
            user = new User();

            user = repository.getUserRepository().loadUserById(idUser);
        }

        listViewUsers.setOnItemClickListener(this);
    }

    private void updateAdapter(){
        users = repository.getUserRepository().getAllUsers();
        adapter = new UserAdapter(getApplicationContext(),R.layout.user_item, users);
        listViewUsers.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        final User user = (User) adapterView.getItemAtPosition(i);
        AlertDialog.Builder dialog = new AlertDialog.Builder(AllUsersActivity.this);
        dialog.setTitle("O que fazer com " + user.getName()).setItems(R.array.options,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        if(which == 0) {
                            callActivity(user.getIdUser());
                        }
                        else if(which == 1){
                            repository.getUserRepository().delete(user.getIdUser());
                            updateAdapter();
                        }
                    }
                }).create().show();
    }

    private void callActivity(Long idUser) {
        intent = new Intent(this,UpdateUserActivity.class);
        intent.putExtra("idUser",idUser);
        startActivity(intent);
    }
}
