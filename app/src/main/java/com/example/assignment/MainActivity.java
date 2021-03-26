package com.example.assignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new FeedFragment()).commit();

        BottomNavigationView bnv = (BottomNavigationView) findViewById(R.id.navigation);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                Fragment temp=null;

                switch (item.getItemId())
                {
                    case R.id.action_feed : temp=new FeedFragment();
                        break;
                    case R.id.action_chats: temp=new ChatFragment();
                        break;
                    case R.id.action_alert : temp=new AlertFragment();
                        break;
                    case R.id.action_profile: temp = new ProfileFragment();
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,temp).commit();

                return true;
            }
        });

    }
}