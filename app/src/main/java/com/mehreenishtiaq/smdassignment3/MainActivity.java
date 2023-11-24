package com.mehreenishtiaq.smdassignment3;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navbar = findViewById(R.id.navbar);

        navbar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selected = null;
                int itemid = item.getItemId();

                if(itemid==R.id.home){
                    selected = new HomeFragment();
                }
                else if(itemid==R.id.search){
                    selected = new SearchFragment();
                }
                else if(itemid==R.id.add){
                    selected = new AddFragment();
                }
                else if(itemid==R.id.chat){
                    selected = new ChatFragment();
                }
                else if(itemid==R.id.profile){
                    selected = new ProfileFragment();
                }
                if(selected!=null){
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,selected).commit();
                }
                return true;
            }
        });
    }
}