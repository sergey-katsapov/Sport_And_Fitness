package com.example.sergey_katsapov.finally_project.activities;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.sergey_katsapov.finally_project.R;
import com.example.sergey_katsapov.finally_project.adapters.RecyclerViewAdapter;
import com.example.sergey_katsapov.finally_project.model.Sport;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FoodInfoActivity extends AppCompatActivity{

    private final String JSON_URL = "https://gist.githubusercontent.com/katsapov-sergey/ac7d449e59bf03ac731dfd6bb59ecffd/raw/5a8eb782d304984f427a7c877a395bf2424a0856/info_food2";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Sport> listSport;
    private RecyclerView recyclerView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_info_activity);

        listSport = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerviewid);
        jsonrequest();
    }

    private void jsonrequest() {

        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;
                for(int i = 0; i<response.length(); i++)
                {
                    try
                    {
                        jsonObject = response.getJSONObject(i);
                        Sport sport = new Sport();
                        sport.setName(jsonObject.getString("name"));
                        sport.setDescription(jsonObject.getString("description"));
                        sport.setImage_url(jsonObject.getString("img"));
                        listSport.add(sport);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                setuprecycleview(listSport);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue = Volley.newRequestQueue(FoodInfoActivity.this);
        requestQueue.add(request);


    }

    private void setuprecycleview(List<Sport> listSport) {
        RecyclerViewAdapter myadapter =  new RecyclerViewAdapter(  this, listSport );
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        recyclerView.setAdapter(myadapter);
    }
}
