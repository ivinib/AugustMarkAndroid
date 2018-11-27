package com.example.vi_ni.augustmark.repository;

import android.content.Context;
import android.os.AsyncTask;

import com.example.vi_ni.augustmark.DAO.UserDAO;
import com.example.vi_ni.augustmark.database.AugustMarkRoomDataBase;
import com.example.vi_ni.augustmark.model.User;

import java.util.List;

public class UserRepository {
    private UserDAO mUserDAO;
    private List<User> mUsers;

    public UserRepository(Context context){
        AugustMarkRoomDataBase dataBase = AugustMarkRoomDataBase.getDataBase(context);
        mUserDAO = dataBase.userDAO();
    }
    public List<User> getAllUsers(){
        mUsers = mUserDAO.loadUsers();
        return mUsers;
    }

    public User loadUserById(Long idUser){
        return mUserDAO.loadUserById(idUser);
    }

    public void insert(User user){
        new insertAsyncTask(mUserDAO).execute(user);
    }

    public void update(User user){
        mUserDAO.update(user);
    }
    public void delete (Long idUser){
        mUserDAO.delete(idUser);
    }

    public User isExistUser(String username, String password){
        User user = new User();

        user = mUserDAO.isExistUser(username,password);

        return user;
    }

    private static class insertAsyncTask extends AsyncTask<User,Void,Void>{
        private UserDAO mAsyncTaskDAO;

        insertAsyncTask(UserDAO userDAO){
            mAsyncTaskDAO = userDAO;
        }

        @Override
        protected Void doInBackground(final User... params){
            mAsyncTaskDAO.insert(params[0]);
            return null;
        }
    }
}
