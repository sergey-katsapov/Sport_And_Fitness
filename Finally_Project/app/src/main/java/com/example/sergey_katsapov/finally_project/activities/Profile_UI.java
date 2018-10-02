package com.example.sergey_katsapov.finally_project.activities;



import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import com.example.sergey_katsapov.finally_project.R;

import android.net.Uri;










public class Profile_UI extends AppCompatActivity implements View.OnClickListener{

    private CardView tinstagram, tvk, ttelegram;


    @Override
    protected  void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_ui);


        tinstagram = (CardView) findViewById(R.id.instagramI);
        tinstagram.setOnClickListener(this);


        tvk= (CardView) findViewById(R.id.vkI);
        tvk.setOnClickListener(this);


        ttelegram = (CardView) findViewById(R.id.telegramI);
        ttelegram.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {

        Intent inst ;
        Intent vk;
        Intent telega;


        switch (v.getId()) {
            case R.id.instagramI : inst =  new Intent (Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/sergey_katsapov/"));
                startActivity(inst); break;
            case R.id.vkI : vk =  new Intent(Intent.ACTION_VIEW, Uri.parse("https://vk.com/katsapov_sergey"));
                startActivity(vk); break;
            case R.id.telegramI : telega =  new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/sergey_katsapov"));
                startActivity(telega); break;


            default:break;
        }

    }

}
