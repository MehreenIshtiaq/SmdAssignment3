package com.mehreenishtiaq.smdassignment3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        TextView resetPassword = findViewById(R.id.resetPasswordButton);

        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent CallIntent = new Intent(ForgotPassword.this, Login.class);
                startActivity(CallIntent);
            }
        });

        TextView goBack = findViewById(R.id.goBackText);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent CallIntent = new Intent(ForgotPassword.this, Login.class);
                startActivity(CallIntent);
            }
        });
    }

}