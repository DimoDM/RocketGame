package com.example.rocketgame.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.ArraySet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rocketgame.R;
import com.example.rocketgame.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ClassationAdapter extends RecyclerView.Adapter<ClassationAdapter.ViewHolder>  {

    List<User> users;

    public ClassationAdapter() {
        users = new ArrayList<>();
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_records, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = users.get(position);
        holder.position.setText((position + 1) + "");
        holder.username.setText(user.getName());
        holder.score.setText(user.getHighScore() + "");
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public void setUsers(List<User> users) {
        this.users = users;
        sortUsers();
        notifyDataSetChanged();
    }

    private void sortUsers() {
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getHighScore() == 0) users.remove(i);
            else
            for (int j = i; j < users.size(); j++) {
                if(users.get(i).getHighScore() < users.get(j).getHighScore()) {
                    User u = users.get(i);
                    users.set(i, users.get(j));
                    users.set(j, u);
                }
            }
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView username;
        TextView score;
        TextView position;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.txtUsername);
            score = itemView.findViewById(R.id.txtScore);
            position = itemView.findViewById(R.id.txtPosition);
        }

    }
}
