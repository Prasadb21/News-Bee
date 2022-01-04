package com.example.newsfeed;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class health_fragments extends Fragment{

    String API_KEY = "d37e88d125a740c7837af6b3a51dd14a";
    ArrayList<ModelClass> modelClassArraylists;
    Adapter adapter;
    String country = "in";
    private RecyclerView recyclerViewofhealth;
    private String categoryhealth = "health";



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.health_fragments , null);
        recyclerViewofhealth = v.findViewById(R.id.healthRecyclerView);
        modelClassArraylists = new ArrayList<>();
        recyclerViewofhealth.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext() , modelClassArraylists );
        recyclerViewofhealth.setAdapter(adapter);

        findNews();


        return v;
    }

    private void findNews() {
        ApiUtilites.getApiInterface().getCategoryNews(country , categoryhealth , 100, API_KEY).enqueue(new Callback<mainNews>() {
            @Override
            public void onResponse(Call<mainNews> call, Response<mainNews> response) {
                if (response.isSuccessful())
                {
                    modelClassArraylists.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();

                }

            }

            @Override
            public void onFailure(Call<mainNews> call, Throwable t) {

            }
        });
    }
}

