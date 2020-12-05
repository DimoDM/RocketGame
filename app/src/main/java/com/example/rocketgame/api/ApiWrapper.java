package com.example.rocketgame.api;

import com.example.rocketgame.models.User;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiWrapper {
    private static ApiWrapper instance;
    private final UserService service;

    public static ApiWrapper getInstance(){
        if(instance==null)
            instance = new ApiWrapper();
        return instance;
    }

    private ApiWrapper(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://rocket-game-a659a.firebaseio.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(UserService.class);
    }

    public void getAllUsers(final OnAllUsersListener listener){
        service.getAllUsers().enqueue(new Callback<HashMap<String, User>>() {
            @Override
            public void onResponse(Call<HashMap<String, User>> call, Response<HashMap<String, User>> response) {
                if(response.isSuccessful()){
                    listener.onUsersReceived(response.body());
                }
                //else listener.onFailure();
            }

            @Override
            public void onFailure(Call<HashMap<String, User>> call, Throwable t) {
                //listener.onFailure();
            }
        });
    }

    public void getAllUser(final OnUserListener listener){
        service.getUser(FirebaseAuth.getInstance().getUid()).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful())
                    listener.onUserReceived(response.body());
                //else listener.onFailure();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                //listener.onFailure();
            }
        });
    }

    public interface OnUserListener{
        void onUserReceived(User user);
       // void onFailure();
    }

    public interface OnAllUsersListener{
        void onUsersReceived(HashMap<String, User> users);
      //  void onFailure();
    }
}
