package com.example.rocketgame.ui.fragments;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.rocketgame.R;
import com.example.rocketgame.RocketGameApplication;
import com.example.rocketgame.api.ApiWrapper;
import com.example.rocketgame.core.contract.ClassationFragmentContract;
import com.example.rocketgame.core.contract.GameFragmentContract;
import com.example.rocketgame.databinding.FrgmentClassationBinding;
import com.example.rocketgame.models.User;
import com.example.rocketgame.ui.adapter.ClassationAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
public class ClassationFragment extends BaseFragment<FrgmentClassationBinding, ClassationFragment.OnClassationFragmentInteractionListener>
implements ClassationFragmentContract.ViewListener{

    @Inject
    ClassationFragmentContract.PresentListener presentListener;
    private ClassationAdapter adapter;

    @Override
    protected int getLayoutRes() {
        return R.layout.frgment_classation;
    }

    @Override
    protected void onFragmentCreated(View view, Bundle savedInstanceState) {
        presentListener.setViewListener(this);
        binding.resView.setLayoutManager(new LinearLayoutManager(RocketGameApplication.APP.getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        binding.backToMenu.setOnClickListener(v -> presentListener.onHomeBtnClicked());
        adapter = new ClassationAdapter();
        refreshList();
        SwipeRefreshLayout pullToRefresh = view.findViewById(R.id.swiperefresh);
        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshList();
                pullToRefresh.setRefreshing(false);
            }
        });
        binding.resView.setAdapter(adapter);
    }

    private void refreshList() {
        ApiWrapper.getInstance().getAllUsers(new ApiWrapper.OnAllUsersListener() {
            @Override
            public void onUsersReceived(HashMap<String, User> users) {
                Collection<User> users1 = users.values();
                List<User> users2 = new ArrayList<>(users1);
                for (User user : users2){
                    Log.d(TAG, user.toString());
                }
                adapter.setUsers(users2);
            }
        });
    }


    @Override
    public void goToMainMenu() {
        activityListener.goToMainMenu();
    }

    public interface OnClassationFragmentInteractionListener {

        void goToMainMenu();
    }
}
