package com.example.rocketgame.api;

import com.example.rocketgame.models.User;

import java.util.HashMap;
import java.util.List;

import dagger.Component;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserService {
    @GET("/users.json")
    Call<HashMap<String, User>> getAllUsers();

    @GET("/users/{id}.json")
    Call<User> getUser(@Path("id") String id);
}
