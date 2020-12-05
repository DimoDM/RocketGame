package com.example.rocketgame.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.example.rocketgame.R;
import com.example.rocketgame.api.ApiWrapper;
import com.example.rocketgame.models.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class TestActivity extends AppCompatActivity {
    private static final String TAG = "TestActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Button btnTest = findViewById(R.id.btnTest);
        btnTest.setOnClickListener(v->{

            ApiWrapper.getInstance().getAllUsers(new ApiWrapper.OnAllUsersListener() {
                @Override
                public void onUsersReceived(HashMap<String, User> users) {
                    Collection<User> users1 = users.values();
                    List<User> users2 = new ArrayList<>(users1);
                    for (User user : users2){
                        Log.d(TAG, user.toString());
                    }
                }

                @Override
                public void onFailure() {
                    Log.d(TAG, "NEEEEEEEEEEEEEEEE");
                }
            });

        });
    }
}