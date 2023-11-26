package com.mehreenishtiaq.smdassignment3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Chat extends AppCompatActivity {

    TextView txtName;
    ImageView homeBtn, searchBtn, profileBtn, plusBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        homeBtn = findViewById(R.id.homebtn);
        searchBtn = findViewById(R.id.searchtn);
        profileBtn = findViewById(R.id.profilebtn);
        plusBtn = findViewById(R.id.plusbtn);

        txtName = findViewById(R.id.nametxt1);
        txtName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Chat.this, MainActivity.class);
                startActivity(intent);
            }
        });

//        homeBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Chat.this, FeaturedItems.class);
//                startActivity(intent);
//            }
//        });

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Chat.this, Search.class);
                startActivity(intent);
            }
        });

        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Chat.this, Profile.class);
                startActivity(intent);
            }
        });

//        plusBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Chat.this, PostItem.class);
//                startActivity(intent);
//            }
//        });
    }
}