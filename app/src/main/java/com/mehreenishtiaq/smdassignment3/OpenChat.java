package com.mehreenishtiaq.smdassignment3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class OpenChat extends AppCompatActivity {



    public class Messages2{

        String message;

        String date;

        int user; //1 if me, 2 if other

        public Messages2(String message, String date, int user) {
            this.message = message;
            this.date = date;
            this.user = user;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getUser() {
            return user;
        }

        public void setUser(int user) {
            this.user = user;
        }






    }


    List<Messages2> messagesList2;

    OpenChatAdapter adapter;


    RecyclerView rv;


    ImageView voicecall, videocall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_chat);

        rv = findViewById(R.id.openChatRV);

        List<Messages2> messagesList= new ArrayList<>();
        messagesList.add(new Messages2("Hey?","19:56",1));
        messagesList.add(new Messages2("Hi","19:57",2));
        messagesList.add(new Messages2("Are you going to university tmrw?","19:57",2));
        messagesList.add(new Messages2("yes","20:01",1));
        messagesList.add(new Messages2("Are you?","20:01",1));
        messagesList.add(new Messages2("Not sure","20:01",2));
        messagesList.add(new Messages2("...","20:01",1));


        adapter = new OpenChatAdapter(OpenChat.this, messagesList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(OpenChat.this);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(adapter);

        voicecall = findViewById(R.id.voiceCall);
        videocall = findViewById(R.id.videoCall);

        voicecall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpenChat.this, AudioCall.class);
                startActivity(intent);
            }
        });

        videocall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpenChat.this, VideoCall.class);
                startActivity(intent);
            }
        });



    }

    void letsChat(){

    }



}