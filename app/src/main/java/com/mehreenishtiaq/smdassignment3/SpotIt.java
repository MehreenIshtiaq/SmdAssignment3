package com.mehreenishtiaq.smdassignment3;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class SpotIt extends AppCompatActivity {

    FirebaseAuth mAuth;

    private static final int SPLASH_DURATION = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spot_it);

        mAuth = FirebaseAuth.getInstance();

        if (mAuth.getCurrentUser() != null) {
            // User is already logged in, go directly to the FeaturedItems screen
            Intent intent = new Intent(SpotIt.this, FeaturedItems.class);
            startActivity(intent);
            finish();
        } else {
            // User is not logged in, show the splash screen for 5 seconds
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SpotIt.this, Login.class);
                    startActivity(intent);
                    finish();
                }
            }, SPLASH_DURATION);
        }
    }
}
