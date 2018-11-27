package com.example.vi_ni.augustmark.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.vi_ni.augustmark.R;
import com.example.vi_ni.augustmark.model.User;

import java.util.List;

public class UserAdapter  extends ArrayAdapter<User> {
    private int rIdUser;

    public UserAdapter(Context context, int resource, List<User> usersList){
        super(context, resource,usersList);
        this.rIdUser = resource;
    }

    @Override
    public View getView(int position, View currentView, ViewGroup parent) {
        View mView = currentView;

        if (mView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = inflater.inflate(rIdUser, null);
        }
        User user = getItem(position);
        TextView txtNameUser = mView.findViewById(R.id.txtNameUser);
        TextView txtEmailUser = mView.findViewById(R.id.txtEmailUser);
        TextView txtPhoneUser = mView.findViewById(R.id.txtPhoneUser);
        TextView txtUsername = mView.findViewById(R.id.txtUsernameUser);

        txtNameUser.setText(user.getName());
        txtEmailUser.setText(user.getEmail());
        txtPhoneUser.setText(String.valueOf(user.getPhone()));
        txtUsername.setText(user.getUserName());

        return mView;
    }
}
