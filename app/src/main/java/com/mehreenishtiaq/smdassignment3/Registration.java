package com.mehreenishtiaq.smdassignment3;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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

public class Registration extends AppCompatActivity {

    EditText eTName, eTEmail, eTContactNumber, eTPassword;
    Spinner spinnerCountry, spinnerCity;
    Button signUpButton;
    ProgressDialog dialog;

    String[] countries = {"Pakistan", "India", "Afghanistan", "Turkey", "Russia"};
    String[] cities = {"Islamabad", "Delhi", "Istanbul", "Lahore", "Tokyo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        dialog = new ProgressDialog(Registration.this);
        dialog.setCancelable(true);

        signUpButton = findViewById(R.id.signUpButton);
        eTName = findViewById(R.id.eTName);
        eTEmail = findViewById(R.id.eTEmail);
        eTContactNumber = findViewById(R.id.eTContactNumber);
        eTPassword = findViewById(R.id.eTPassword);
        spinnerCountry = findViewById(R.id.spinnerCountry);
        spinnerCity = findViewById(R.id.spinnerCity);

        ArrayAdapter<String> countryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, countries);
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountry.setAdapter(countryAdapter);

        ArrayAdapter<String> cityAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cities);
        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCity.setAdapter(cityAdapter);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = eTName.getText().toString();
                String email = eTEmail.getText().toString();
                String password = eTPassword.getText().toString();
                String phone = eTContactNumber.getText().toString();
                String country = spinnerCountry.getSelectedItem().toString();
                String city = spinnerCity.getSelectedItem().toString();

                if (validateInput(name, email, password, phone)) {
                    userRegister(name, email, password, phone, country, city);
                }
            }
        });
    }

    private boolean validateInput(String name, String email, String password, String phone) {
        if (name.isEmpty()) {
            eTName.setError("Required");
            return false;
        }
        if (email.isEmpty()) {
            eTEmail.setError("Required");
            return false;
        }
        if (password.isEmpty()) {
            eTPassword.setError("Required");
            return false;
        }
        if (phone.isEmpty() || phone.length() != 11) {
            eTContactNumber.setError("Invalid Phone");
            return false;
        }
        return true;
    }

    private void userRegister(String name, String email, String password, String phone, String country, String city) {
        String url = "http://192.168.10.6/rentingApp/signup.php";

        dialog.setTitle("Registering");
        dialog.setMessage("Please wait...");
        dialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                response -> {
                    dialog.dismiss();
                    Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();
                    if (response.contains("successfully")) {
                        Intent intent = new Intent(Registration.this, EditProfile.class);
                        startActivity(intent);
                        finish();
                    }
                },
                error -> {
                    dialog.dismiss();
                    Toast.makeText(getApplicationContext(), "Error: " + error.toString(), Toast.LENGTH_LONG).show();
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("Name", name);
                params.put("Email", email);
                params.put("Password", password);
                params.put("PhoneNumber", phone);
                params.put("Country", country);
                params.put("City", city);
                return params;
            }
        };

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);
    }
}
