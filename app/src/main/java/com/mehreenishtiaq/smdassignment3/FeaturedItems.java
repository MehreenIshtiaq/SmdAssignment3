package com.mehreenishtiaq.smdassignment3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class FeaturedItems extends AppCompatActivity {

    Button logout;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_featured_items);

        ImageView searchBtn = findViewById(R.id.searchtn);
        ImageView chatBtn = findViewById(R.id.chatbtn);
        ImageView profileBtn = findViewById(R.id.profilebtn);
        ImageView plusBtn = findViewById(R.id.plusbtn);
        logout = findViewById(R.id.logout);
        mAuth = FirebaseAuth.getInstance();

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FeaturedItems.this, "Logging out", Toast.LENGTH_LONG).show();

                mAuth.signOut();
                Intent intent = new Intent(FeaturedItems.this, Login.class);
                startActivity(intent);
            }
        });

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FeaturedItems.this, Search.class);
                startActivity(intent);
            }
        });

        chatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FeaturedItems.this, ChatFragment.class);
                startActivity(intent);
            }
        });

        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FeaturedItems.this, Profile.class);
                startActivity(intent);
            }
        });

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FeaturedItems.this, PostItem.class);
                startActivity(intent);
            }
        });
    }
}