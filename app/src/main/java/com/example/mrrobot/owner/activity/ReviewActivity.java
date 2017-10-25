package com.example.mrrobot.owner.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mrrobot.owner.R;

public class ReviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        TabLayout tLayout = (TabLayout)findViewById(R.id.tabLayout);
        tLayout.getTabAt(3).select();

        tLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Intent i = null;
                switch (tab.getPosition()) {
                    case 0:
                        i = new Intent(getApplicationContext(), DetailInformationActivity.class);
                        break;
                    case 1:
                        i = new Intent(getApplicationContext(), ServiceActivity.class);
                        break;
                    case 2:
                        i = new Intent(getApplicationContext(), StylishActivity.class);
                        break;
                    case 3:
                        i = new Intent(getApplicationContext(), ReviewActivity.class);
                        break;
                    case 4:
                        i = new Intent(getApplicationContext(), PromosActivity.class);
                        break;
                    case 5:
                        i = new Intent(getApplicationContext(), SubscribesActivity.class);
                        break;
                }
                startActivity(i);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });
    }
}
