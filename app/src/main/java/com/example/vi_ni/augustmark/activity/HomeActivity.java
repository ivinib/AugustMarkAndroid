package com.example.vi_ni.augustmark.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.vi_ni.augustmark.R;
import com.example.vi_ni.augustmark.model.Address;
import com.example.vi_ni.augustmark.model.ProductCategory;
import com.example.vi_ni.augustmark.model.ServiceStatus;
import com.example.vi_ni.augustmark.model.User;
import com.example.vi_ni.augustmark.repository.Repository;

import java.io.Serializable;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, Serializable {

    private Repository repository;
    private User user;
    private Long idUser;
    private  TextView txtTeste, txtNameUser;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        txtNameUser = findViewById(R.id.txtNameUser);

        repository = new Repository(getApplicationContext());

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        idUser = bundle.getLong("idUser");

       if (user == null){
           user = new User();

           user = repository.getUserRepository().loadUserById(idUser);
       }

        txtNameUser.setText("Olá "+user.getName());

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.schedule) {
            intent = new Intent(this, ScheduleActivity.class);
            intent.putExtra("idUser", user.getIdUser());
            startActivity(intent);

        } else if (id == R.id.profile) {
            intent.putExtra("idUser", user.getIdUser());
            startActivity(intent);

        } else if (id == R.id.store){
            intent = new Intent(this, StoreActivity.class);
            intent.putExtra("idUser", user.getIdUser());
            startActivity(intent);

        } else if (id == R.id.requestSchedule){
            intent = new Intent(this, RequestScheduleActivity.class);
            intent.putExtra("idUser", user.getIdUser());
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void schedule(View view){
        intent = new Intent(this, ScheduleActivity.class);
        intent.putExtra("idUser", user.getIdUser());
        startActivity(intent);
    }

    public void requestSchedule(View view){
        intent = new Intent(this, RequestScheduleActivity.class);
        intent.putExtra("idUser", user.getIdUser());
        startActivity(intent);
    }

    public void store(View view){
        intent = new Intent(this, StoreActivity.class);
        intent.putExtra("idUser", user.getIdUser());
        startActivity(intent);
    }

    public void allUsers(View view){
        intent = new Intent(this, AllUsersActivity.class);
        intent.putExtra("idUser", user.getIdUser());
        startActivity(intent);
    }
}
