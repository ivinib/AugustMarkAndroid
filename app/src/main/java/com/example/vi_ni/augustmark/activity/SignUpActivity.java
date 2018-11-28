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

public class SignUpActivity extends AppCompatActivity {

    private Repository repository;
    private User user;
    private EditText edtName, edtPhone, edtEmail,edtUserName, edtPassword, edtPasswordConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        edtName = findViewById(R.id.edtName);
        edtPhone = findViewById(R.id.edtPhone);
        edtEmail = findViewById(R.id.edtEmail);
        edtUserName = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.edtPassword);
        edtPasswordConfirm = findViewById(R.id.edtPasswordConfirm);
        repository = new Repository(getApplicationContext());
    }

    public void validadeSignup(View view){
        String name = edtName.getText().toString();
        String email = edtEmail.getText().toString();
        String phone = edtPhone.getText().toString();
        String userName = edtUserName.getText().toString();
        String password = edtPassword.getText().toString();
        String passwordConfirm = edtPasswordConfirm.getText().toString();

        if (name == null || name.equals("")){
            Toast.makeText(this, "Preencha o campo Nome", Toast.LENGTH_SHORT).show();
        }else if (email == null || email.equals("")){
            Toast.makeText(this, "Preencha o campo E-mail", Toast.LENGTH_SHORT).show();
        }else if (phone == null || phone.equals("")){
            Toast.makeText(this, "Preencha o campo Telefone", Toast.LENGTH_SHORT).show();
        }else if (edtUserName == null || edtUserName.equals("")){
            Toast.makeText(this, "Preencha o campo Usuário", Toast.LENGTH_SHORT).show();
        }else if (password == null || password.equals("")){
            Toast.makeText(this, "Preencha o campo senha", Toast.LENGTH_SHORT).show();
        }else if (passwordConfirm == null || passwordConfirm.equals("")){
            Toast.makeText(this, "Preencha a confirmação de senha", Toast.LENGTH_SHORT).show();
        }
        user = new User();

        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);
        user.setUserName(userName);
        user.setPassword(password);

        repository.getUserRepository().insert(user);

        Toast.makeText(this, "Cadastrado com sucesso", Toast.LENGTH_SHORT).show();

        Intent signin = new Intent(SignUpActivity.this, SignInActivity.class);
        startActivity(signin);

    }
}
