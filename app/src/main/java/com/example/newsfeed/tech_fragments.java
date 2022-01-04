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


public class tech_fragments extends Fragment{


    String API_KEY = "d37e88d125a740c7837af6b3a51dd14a";
    ArrayList<ModelClass> modelClassArraylists;
    Adapter adapter;
    String country = "in";
    private RecyclerView recyclerViewoftech;
    private String category = "technology";



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.technology_fragments , null);
        recyclerViewoftech = v.findViewById(R.id.techRecyclerView);
        modelClassArraylists = new ArrayList<>();
        recyclerViewoftech.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext() , modelClassArraylists );
        recyclerViewoftech.setAdapter(adapter);

        findNews();


        return v;
    }

    private void findNews() {
        ApiUtilites.getApiInterface().getCategoryNews(country , category , 100, API_KEY).enqueue(new Callback<mainNews>() {
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

