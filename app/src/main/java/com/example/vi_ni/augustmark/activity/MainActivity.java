package com.example.vi_ni.augustmark.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.vi_ni.augustmark.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void signin(View view){
        Intent signin = new Intent(MainActivity.this, SignInActivity.class);
        startActivity(signin);
    }

    public void signup(View view){
        Intent signup = new Intent(MainActivity.this, SignUpActivity.class);
        startActivity(signup);
    }
}
