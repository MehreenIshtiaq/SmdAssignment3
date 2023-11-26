package com.mehreenishtiaq.smdassignment3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class FeaturedItems extends AppCompatActivity {

    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_featured_items);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView searchBtn = findViewById(R.id.searchbtn);
        ImageView chatBtn = findViewById(R.id.chatbtn);
        ImageView profileBtn = findViewById(R.id.profilebtn);
        ImageView plusBtn = findViewById(R.id.plusbtn);
        logout = findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performLogout();
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

//        plusBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(FeaturedItems.this, PostItem.class);
//                startActivity(intent);
//            }
//        });
    }

    private void performLogout() {
        String url = "http://192.168.10.6:80/rentingApp/logout.php"; // Replace with your server's logout URL

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Handle successful logout response
                        Toast.makeText(FeaturedItems.this, "Logged out successfully", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(FeaturedItems.this, Login.class);
                        startActivity(intent);
                        finish();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Handle error
                Toast.makeText(FeaturedItems.this, "Logout failed", Toast.LENGTH_LONG).show();
            }
        });

        queue.add(stringRequest);
    }
}
