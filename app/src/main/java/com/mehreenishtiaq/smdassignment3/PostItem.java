package com.mehreenishtiaq.smdassignment3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class PostItem extends AppCompatActivity {

    private static final int PICK_MEDIA_REQUEST = 101;
    private Uri selectedMediaUri;
    private boolean isVideo = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_item);

        // Initialize your views here
        Button postButton = findViewById(R.id.postItem);
        EditText nameEditText = findViewById(R.id.enter_name);
        EditText hourlyRateEditText = findViewById(R.id.enter_email2);
        EditText descriptionEditText = findViewById(R.id.enter_contact_number);
        Spinner citySpinner = findViewById(R.id.citySpinner);

        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Assuming you have a method to upload the file and get its URL
                String fileUrl = uploadFileAndGetUrl(selectedMediaUri);
                postItemDetails(nameEditText.getText().toString(),
                        hourlyRateEditText.getText().toString(),
                        descriptionEditText.getText().toString(),
                        citySpinner.getSelectedItem().toString(),
                        fileUrl);
            }
        });
    }

    private String uploadFileAndGetUrl(Uri fileUri) {
        // Implement your file upload logic here
        // Return the URL of the uploaded file
        return "http://example.com/path/to/file";
    }

    private void postItemDetails(String name, String hourlyRate, String description, String city, String fileUrl) {
        String url = "http://192.168.10.6/post_item_details.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(PostItem.this, "Item posted successfully", Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(PostItem.this, "Error posting item", Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("name", name);
                params.put("hourlyRate", hourlyRate);
                params.put("description", description);
                params.put("city", city);
                params.put("fileUrl", fileUrl);
                return params;
            }
        };

        Volley.newRequestQueue(this).add(stringRequest);
    }

    public void openVideoChooser(View view) {
        Intent intent = new Intent();
        intent.setType("video/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_VIDEO_REQUEST);
    }

    private void openFileChooser() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_MIME_TYPES, new String[]{"image/*", "video/*"});
        startActivityForResult(intent, PICK_MEDIA_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_MEDIA_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            selectedMediaUri = data.getData();

            if (selectedMediaUri.toString().contains("image")) {
                isVideo = false;
                ImageView imageView = findViewById(R.id.uploadPicture);
                TextView uploadText = findViewById(R.id.uploadText);
                // Use Picasso to load and cache the image
                Picasso.get().load(selectedMediaUri).into(imageView);
                uploadText.setVisibility(View.GONE);
            } else if (selectedMediaUri.toString().contains("video")) {
                isVideo = true;
                VideoView videoView = findViewById(R.id.uploadVideoView);
                TextView uploadText = findViewById(R.id.uploadText);
                videoView.setVideoURI(selectedMediaUri);
                videoView.start();
                uploadText.setVisibility(View.GONE);
            }
        }
    }


}
