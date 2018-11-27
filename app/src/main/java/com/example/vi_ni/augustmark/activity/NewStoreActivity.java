package com.example.vi_ni.augustmark.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vi_ni.augustmark.R;
import com.example.vi_ni.augustmark.model.Store;
import com.example.vi_ni.augustmark.repository.Repository;

public class NewStoreActivity extends AppCompatActivity {

    private Intent intent;
    private EditText edtNameStore, edtEmailStore, edtPhoneStore, edtCNPJStore;
   // private TextView textView7;
    private Repository repository;
    private Store store;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_store);

        intent = getIntent();
        Bundle bundle = intent.getExtras();

        edtNameStore = findViewById(R.id.edtNameStore);
        edtEmailStore = findViewById(R.id.edtEmailStore);
        edtPhoneStore = findViewById(R.id.edtPhoneStore);
        edtCNPJStore = findViewById(R.id.edtCnpj);
        //txtIdStore = findViewById(R.id.txtIdStore);

        repository = new Repository(getApplicationContext());
        /*Integer idStore = bundle.getInt("idStore");

        if (idStore != null){
            store = new Store();
            store = repository.getStoreRepository().loadStoreById(idStore);

            edtNameStore.setText(store.getName());
            edtPhoneStore.setText(store.getPhone());
            edtEmailStore.setText(store.getEmail());
            edtCNPJStore.setText(store.getCnpj());
        }*/
    }
    public void addStore(View view){
        //Integer id = Integer.parseInt(txtIdStore.getText().toString());

        store = new Store();

        store.setName(edtNameStore.getText().toString());
        store.setEmail(edtEmailStore.getText().toString());
        store.setPhone(edtPhoneStore.getText().toString());
        store.setCnpj(edtCNPJStore.getText().toString());

        repository.getStoreRepository().insert(store);
        Toast.makeText(this, "Loja cadastrada com sucesso", Toast.LENGTH_SHORT).show();

        /*intent = new Intent(this, StoreActivity.class);
        startActivity(intent);*/

        repository.getStoreRepository().loadStoreById(1);

    }
}
