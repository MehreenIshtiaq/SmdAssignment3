//package com.mehreenishtiaq.smdassignment3;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.ArrayAdapter;
//import android.widget.EditText;
//import android.widget.Spinner;
//import android.widget.TextView;
//import android.widget.Toast;
//import androidx.appcompat.app.AppCompatActivity;
//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.StringRequest;
//import com.android.volley.toolbox.Volley;
//import org.json.JSONException;
//import org.json.JSONObject;
//import java.util.HashMap;
//import java.util.Map;
//
//public class EditProfile extends AppCompatActivity {
//    private EditText nameEditText, emailEditText, contactEditText;
//    private Spinner countrySpinner, citySpinner;
//    private TextView saveChangesButton;
//
//    String[] countries = {"Pakistan", "India", "Afghanistan", "Turkey", "Russia"};
//    String[] cities = {"Islamabad", "Delhi", "Istanbul", "Lahore", "Tokyo"};
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_edit_profile);
//
//        nameEditText = findViewById(R.id.eTName);
//        emailEditText = findViewById(R.id.eTEmail);
//        contactEditText = findViewById(R.id.eTContactNumber);
//        countrySpinner = findViewById(R.id.spinnerCountry);
//        citySpinner = findViewById(R.id.spinnerCity);
//        saveChangesButton = findViewById(R.id.saveChanges);
//
//        loadUserData();
//
//        saveChangesButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                saveUserChanges();
//            }
//        });
//    }

package com.mehreenishtiaq.smdassignment3;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class EditProfile extends AppCompatActivity {
    private EditText nameEditText, emailEditText, contactEditText;
    private Spinner countrySpinner, citySpinner;
    private TextView saveChangesButton;

    String[] countries = {"Pakistan", "India", "Afghanistan", "Turkey", "Russia"};
    String[] cities = {"Islamabad", "Delhi", "Istanbul", "Lahore", "Tokyo"};

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        nameEditText = findViewById(R.id.eTName);
        emailEditText = findViewById(R.id.eTEmail);
        contactEditText = findViewById(R.id.eTContactNumber);
        countrySpinner = findViewById(R.id.spinnerCountry);
        citySpinner = findViewById(R.id.spinnerCity);
        saveChangesButton = findViewById(R.id.saveChanges);

        sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String userId = sharedPreferences.getString("userId", ""); // Retrieve the stored user ID

        loadUserData(userId);

        saveChangesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUserChanges(userId);
            }
        });

        loadCountries();
        loadCities();
    }

    private void loadUserData(String userId) {
        // Implement the logic to load user data from your server
        // You can use Volley or any other network library
        // Example: Send a request to your server with the userId and populate the fields upon response
    }

    private void saveUserChanges(String userId) {
        // Implement the logic to save user changes to your server
        // You can use Volley or any other network library
        // Example: Send a request to your server with the updated user data and the userId
    }

    private void loadCountries() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, countries);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countrySpinner.setAdapter(adapter);
    }

    private void loadCities() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cities);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citySpinner.setAdapter(adapter);
    }
}
