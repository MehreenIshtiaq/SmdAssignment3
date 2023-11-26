package com.mehreenishtiaq.smdassignment3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Search extends AppCompatActivity {

    ImageView arrowOne, arrowTwo, arrowThree, homeBtn, chatBtn, profileBtn, plusBtn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        arrowOne = findViewById(R.id.itemone);
        arrowTwo = findViewById(R.id.itemtwo);
        arrowThree = findViewById(R.id.itemthree);
        homeBtn = findViewById(R.id.homebtn);
        chatBtn = findViewById(R.id.chatbtn);
        profileBtn = findViewById(R.id.profilebtn);
        plusBtn = findViewById(R.id.plusbtn);

//        homeBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Search.this, FeaturedItems.class);
//                startActivity(intent);
//            }
//        });

        chatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Search.this, Chat.class);
                startActivity(intent);
            }
        });

        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Search.this, Profile.class);
                startActivity(intent);
            }
        });

//        plusBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Search.this, PostItem.class);
//                startActivity(intent);
//            }
//        });
        arrowOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Search.this, BestMatch.class);
                startActivity(intent);
            }
        });

        arrowTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Search.this, BestMatch.class);
                startActivity(intent);
            }
        });

        arrowThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Search.this, BestMatch.class);
                startActivity(intent);
            }
        });

    }
}