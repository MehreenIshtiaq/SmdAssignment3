package com.mehreenishtiaq.smdassignment3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class TakePhoto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_photo);



        // Get the FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();

        // Begin a fragment transaction
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        // Replace the FragmentContainerView with your fragment
        transaction.replace(R.id.cameraView, new UploadPhotoFragment());

        // Commit the transaction
        transaction.commit();

        Button photo = findViewById(R.id.photoButton);
        photo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = getSupportFragmentManager();

                fragmentManager.beginTransaction()
                        .replace(R.id.cameraView, UploadPhotoFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name") // Name can be null
                        .commit();
            }
        });


    }





}