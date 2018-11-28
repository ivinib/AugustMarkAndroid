package com.example.vi_ni.augustmark.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.vi_ni.augustmark.DAO.StoreDAO;
import com.example.vi_ni.augustmark.R;
import com.example.vi_ni.augustmark.adapter.StoreAdapter;
import com.example.vi_ni.augustmark.model.User;
import com.example.vi_ni.augustmark.repository.Repository;

import java.util.List;

public class StoreActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, AdapterView.OnItemClickListener {

    private User user = null;
    private ListView listView;
    private Repository repository;
    private Intent intent;
    private Long idUser;
    private ArrayAdapter<StoreDAO.StoreJoin> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        repository = new Repository(getApplicationContext());

        intent = getIntent();
        Bundle bundle = intent.getExtras();

        idUser = bundle.getLong("idUser");

        if (user == null){
            user = new User();

            user = repository.getUserRepository().loadUserById(idUser);
        }

        listView = findViewById(R.id.listStore);
        repository = new Repository(getApplicationContext());
        updateAdapter();
        listView.setOnItemClickListener(this);
    }

    public void newStore(View view){
        intent = new Intent(this, NewStoreActivity.class);
        intent.putExtra("idUser",user.getIdUser());
        startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
        final StoreDAO.StoreJoin storeJoin = (StoreDAO.StoreJoin) adapterView.getItemAtPosition(i);
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("O que fazer com " +  storeJoin.store.getName()).setItems(R.array.options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which){
                if (which == 0){
                    callActivityUpdate(storeJoin.store.getIdStore());
                    updateAdapter();
                }else if (which == 1){
                    repository.getStoreRepository().delete(storeJoin.store.getIdStore());
                }
            }
        }).create().show();
    }

    private void callActivityUpdate(Integer idStore){
        intent = new Intent(this, NewStoreActivity.class);
        intent.putExtra("idStore",idStore);
        startActivity(intent);
    }



    private void updateAdapter(){
        List<StoreDAO.StoreJoin> stores = repository.getStoreRepository().loadStoreJoin();
        adapter = new StoreAdapter(getApplicationContext(), R.layout.store_item, stores);
        listView.setAdapter(adapter);
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


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

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
            intent = new Intent(this, ProfileActivity.class);
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
}
