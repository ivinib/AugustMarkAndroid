package com.example.vi_ni.augustmark.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vi_ni.augustmark.DAO.UserDAO;
import com.example.vi_ni.augustmark.R;
import com.example.vi_ni.augustmark.model.User;
import com.example.vi_ni.augustmark.repository.Repository;
import com.example.vi_ni.augustmark.repository.UserRepository;

import java.io.Serializable;

public class SignInActivity extends AppCompatActivity implements Serializable {

    private Repository repository;
    private User user;

    private EditText edtLogin,edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        edtLogin = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.edtPassword);
        repository = new Repository(getApplicationContext());
    }

    public void validateSignin(View view){
        String username = edtLogin.getText().toString();
        String password = edtPassword.getText().toString();

        if (username == null || username.equals("")){
            Toast.makeText(this, "Preencha o campo Usuário", Toast.LENGTH_SHORT).show();
        }else if (password == null || password.equals("")){
            Toast.makeText(this, "Preencha o campo Senha", Toast.LENGTH_SHORT).show();
        }
        user = new User();

        user = repository.getUserRepository().isExistUser(username,password);

        if (user != null){
            Intent homeScreen = new Intent(SignInActivity.this, HomeActivity.class);
            homeScreen.putExtra("user", user);
            startActivity(homeScreen);
        }
    }

}
