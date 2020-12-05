package com.example.rocketgame.api;

import com.example.rocketgame.models.MultiPlayerUser;
import com.example.rocketgame.models.User;

import java.util.HashMap;
import java.util.List;

import dagger.Component;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("/users.json")
    Call<HashMap<String, User>> getAllUsers();

    @GET("/users/{id}.json")
    Call<User> getUser(@Path("id") String id);

    @GET("/rooms/{roomid}/player1")
    Call<MultiPlayerUser> getRoomPlayer1(@Path("roomid") String roomid);

    @GET("/rooms/{roomid}/player2")
    Call<MultiPlayerUser> getRoomPlayer2(@Path("roomid") String roomid);
}
