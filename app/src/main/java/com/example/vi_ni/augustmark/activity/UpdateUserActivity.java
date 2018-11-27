package com.example.vi_ni.augustmark.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vi_ni.augustmark.R;
import com.example.vi_ni.augustmark.model.User;
import com.example.vi_ni.augustmark.repository.Repository;

public class UpdateUserActivity extends AppCompatActivity {

    private Intent intent;
    private Bundle bundle;
    private User user = null;
    private Repository repository;
    private Long idUser;
    private EditText edtName, edtPhone, edtEmail,edtUserName, edtPassword, edtPasswordConfirm;
    private TextView txtId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);

        edtName = findViewById(R.id.edtNameUpdate);
        edtPhone = findViewById(R.id.edtPhoneUpdate);
        edtEmail = findViewById(R.id.edtEmailUpdate);
        edtUserName = findViewById(R.id.edtUserNameUpdate);
        edtPassword = findViewById(R.id.edtPasswordUpdate);
        edtPasswordConfirm = findViewById(R.id.edtPasswordConfirmUpdate);
        txtId = findViewById(R.id.txtIdUserUpdate);

        repository = new Repository(getApplicationContext());

        intent = getIntent();
        bundle = intent.getExtras();

        idUser = bundle.getLong("idUser");

        if (user == null){
            user = new User();

            user = repository.getUserRepository().loadUserById(idUser);

            txtId.setText(String.valueOf(user.getIdUser()));
            edtName.setText(user.getName());
            edtEmail.setText(user.getEmail());
            edtPhone.setText(user.getPhone());
            edtPassword.setText(user.getPassword());
            edtPasswordConfirm.setText(user.getPassword());
            edtUserName.setText(user.getUserName());
        }
    }

    public void validadeUpdate(View view){
        if (edtPassword.equals(edtPasswordConfirm)){
            Toast.makeText(this, "Senhas não conferem", Toast.LENGTH_SHORT).show();
        }else {
            user.setName(edtName.getText().toString());
            user.setEmail(edtEmail.getText().toString());
            user.setPhone(edtPhone.getText().toString());
            user.setUserName(edtUserName.getText().toString());
            user.setPassword(edtPassword.getText().toString());

            repository.getUserRepository().update(user);
            callActivity();
        }
    }
    private void callActivity(){
        intent = new Intent(this, AllUsersActivity.class);
        startActivity(intent);
        finish();
    }
}

