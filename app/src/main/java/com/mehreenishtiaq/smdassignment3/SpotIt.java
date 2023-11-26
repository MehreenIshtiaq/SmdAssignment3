package com.mehreenishtiaq.smdassignment3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SpotIt extends AppCompatActivity {

    private static final int SPLASH_DURATION = 5000;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spot_it);

        sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                checkLoginStatus();
            }
        }, SPLASH_DURATION);
    }

    private void checkLoginStatus() {
        // Check if user is logged in using Shared Preferences
        boolean isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false);

        if (isLoggedIn) {
            // User is logged in, go directly to the FeaturedItems screen
            Intent intent = new Intent(SpotIt.this, FeaturedItems.class);
            startActivity(intent);
        } else {
            // User is not logged in, redirect to Login screen
            Intent intent = new Intent(SpotIt.this, Login.class);
            startActivity(intent);
        }
        finish();
    }
}
