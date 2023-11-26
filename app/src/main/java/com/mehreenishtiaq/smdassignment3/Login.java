package com.mehreenishtiaq.smdassignment3;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {

    EditText eTEmail, eTPassword;
    Button loginButton;
    TextView goToRegistration;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dialog = new ProgressDialog(Login.this);
        dialog.setCancelable(true);

        eTEmail = findViewById(R.id.eTEmailAddress);
        eTPassword = findViewById(R.id.eTPassword);
        loginButton = findViewById(R.id.loginButton);
        goToRegistration = findViewById(R.id.signUp);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = eTEmail.getText().toString();
                String password = eTPassword.getText().toString();

                if (!email.isEmpty() && !password.isEmpty()) {
                    userLogin(email, password);
                } else {
                    if (email.isEmpty()) {
                        eTEmail.setError("Required");
                    }
                    if (password.isEmpty()) {
                        eTPassword.setError("Required");
                    }
                }
            }
        });

        goToRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Registration.class);
                startActivity(intent);
            }
        });
    }

    private void userLogin(String email, String password) {
        String url = "http://192.168.10.6/login.php"; // Replace with your server URL

        dialog.setTitle("Logging In");
        dialog.setMessage("Please wait while we log you in");
        dialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                response -> {
                    dialog.dismiss();
                    Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();
//                    if (response.contains("successful")) {
//                        Intent intent = new Intent(Login.this, FeaturedItems.class);
//                        startActivity(intent);
//                    }
                },
                error -> {
                    dialog.dismiss();
                    Toast.makeText(getApplicationContext(), "Error: " + error.toString(), Toast.LENGTH_LONG).show();
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("Email", email);
                params.put("Password", password);
                return params;
            }
        };

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);
    }
}
