package com.mehreenishtiaq.smdassignment3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Profile extends AppCompatActivity {

    ImageView editBtn;
    ImageView homeBtn, searchBtn, chatBtn, plusBtn;
    TextView viewItem;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        homeBtn = findViewById(R.id.homebtn);
        searchBtn = findViewById(R.id.searchtn);
        chatBtn = findViewById(R.id.chatbtn);
        plusBtn = findViewById(R.id.plusbtn);
        viewItem = findViewById(R.id.viewItem);

        editBtn = findViewById(R.id.edit);

        viewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this, ItemDescription.class);
                startActivity(intent);
            }
        });
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this, EditProfile.class);
                startActivity(intent);
            }
        });
//        homeBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Profile.this, FeaturedItems.class);
//                startActivity(intent);
//            }
//        });

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this, Search.class);
                startActivity(intent);
            }
        });

        chatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this, Chat.class);
                startActivity(intent);
            }
        });

//        plusBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Profile.this, PostItem.class);
//                startActivity(intent);
//            }
//        });
    }
}