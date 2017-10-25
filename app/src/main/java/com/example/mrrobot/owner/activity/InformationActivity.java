package com.example.mrrobot.owner.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.mrrobot.owner.MainActivity;
import com.example.mrrobot.owner.MySingleton;
import com.example.mrrobot.owner.Owner;
import com.example.mrrobot.owner.R;
import com.example.mrrobot.owner.adapter.RecyclerAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.List;

public class InformationActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);





//        CardView cardView = (CardView)findViewById(R.id.cardView1);
        ImageButton imageButton = (ImageButton)findViewById(R.id.imageButton6);
        ImageButton imageButton1 = (ImageButton)findViewById(R.id.imageButton9);
        ImageButton imageButton2 = (ImageButton)findViewById(R.id.imageButton10);
        ImageButton imageButton3 = (ImageButton)findViewById(R.id.imageButton8);
        Button btn = (Button)findViewById(R.id.addNew);

//        cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(getApplicationContext(), DetailInformationActivity.class);
//                startActivity(i);
//            }
//        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), AddNewActivity.class);
                startActivity(i);
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), HistoryActivity.class);
                startActivity(i);
            }
        });

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), UserActivity.class);
                startActivity(i);
            }
        });

        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), PaymentActivity.class);
                startActivity(i);
            }
        });

    }

    public void addNew(View view){

        startActivity(new Intent(this,AddNewActivity.class));

    }

    public void cardView1(View view){

        startActivity(new Intent(this,InformationActivity.class));

    }





}
