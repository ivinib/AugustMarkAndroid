package com.example.vi_ni.augustmark.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.vi_ni.augustmark.DAO.StoreDAO;
import com.example.vi_ni.augustmark.R;

import java.util.List;

public class StoreAdapter extends ArrayAdapter<StoreDAO.StoreJoin> {
    private int rIdAdapter;

    public StoreAdapter(@NonNull Context context, int resource, @NonNull List<StoreDAO.StoreJoin> storeList) {
        super(context, resource, storeList);
        this.rIdAdapter = resource;
    }

    @Override
    public View getView(int position, View currentView, ViewGroup parent) {
        View mView = currentView;

        if (mView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = inflater.inflate(rIdAdapter, null);

        }
        StoreDAO.StoreJoin storeJoin = getItem(position);

        TextView txtNameStore = mView.findViewById(R.id.txtNameStore);
        TextView txtEmailStore = mView.findViewById(R.id.txtEmailStore);
        TextView txtPhoneStore = mView.findViewById(R.id.txtPhoneStore);
        TextView txtCNPJ = mView.findViewById(R.id.txtCnpj);

        txtNameStore.setText(storeJoin.store.getName());
        txtEmailStore.setText(storeJoin.store.getEmail());
        txtPhoneStore.setText(storeJoin.store.getPhone());
        txtCNPJ.setText(storeJoin.store.getCnpj());

        return mView;

    }
}
