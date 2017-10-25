package com.example.mrrobot.owner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.mrrobot.owner.activity.AddNewActivity;
import com.example.mrrobot.owner.activity.HistoryActivity;
import com.example.mrrobot.owner.activity.InformationActivity;
import com.example.mrrobot.owner.activity.PaymentActivity;
import com.example.mrrobot.owner.activity.UserActivity;
import com.example.mrrobot.owner.database.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);




        ImageButton imgButton = (ImageButton)findViewById(R.id.imageButton7);
        ImageButton imgButton3 = (ImageButton)findViewById(R.id.imageButton8);
        ImageButton imgButton1 = (ImageButton)findViewById(R.id.imageButton9);
        ImageButton imgButton2 = (ImageButton)findViewById(R.id.imageButton10);


        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), InformationActivity.class);
                startActivity(i);
            }
        });

        imgButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), HistoryActivity.class);
                startActivity(i);
            }
        });

        imgButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), UserActivity.class);
                startActivity(i);
            }
        });

        imgButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), PaymentActivity.class);
                startActivity(i);
            }
        });

    }

//    public void addNew(View view){
//
//        startActivity(new Intent(this,AddNewActivity.class));
//
//    }
//
//    public void cardView1(View view){
//
//        startActivity(new Intent(this,InformationActivity.class));
//
//    }



}
