package com.mehreenishtiaq.smdassignment3;

import android.annotation.SuppressLint;
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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

public class PostItem extends AppCompatActivity {

    private static final int PICK_MEDIA_REQUEST = 101;
    private static final int PICK_VIDEO_REQUEST = 2;

    private Uri selectedMediaUri;
    private StorageReference storageRef;
    private FirebaseFirestore db;
    private boolean isVideo = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_item);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView uploadImageView = findViewById(R.id.uploadPicture);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) VideoView videoView = findViewById(R.id.uploadVideoView); // New VideoView
        EditText nameEditText = findViewById(R.id.enter_name);
        EditText hourlyRateEditText = findViewById(R.id.enter_email2);
        EditText descriptionEditText = findViewById(R.id.enter_contact_number);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Spinner citySpinner = findViewById(R.id.citySpinner);
        Button postButton = findViewById(R.id.postItem);

        storageRef = FirebaseStorage.getInstance().getReference("uploads");
        db = FirebaseFirestore.getInstance();

        uploadImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });



        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedMediaUri != null) {
                    StorageReference fileReference;
                    if (isVideo) {
                        fileReference = storageRef.child(System.currentTimeMillis() + ".mp4");
                    } else {
                        fileReference = storageRef.child(System.currentTimeMillis() + ".jpg");
                    }
                    UploadTask uploadTask = fileReference.putFile(selectedMediaUri);
                    Task<Uri> uriTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                        @Override
                        public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                            if (!task.isSuccessful()) {
                                throw task.getException();
                            }
                            return fileReference.getDownloadUrl();
                        }
                    }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                        @Override
                        public void onComplete(@NonNull Task<Uri> task) {
                            if (task.isSuccessful()) {
                                Uri downloadUri = task.getResult();
                                String name = nameEditText.getText().toString();
                                String hourlyRate = hourlyRateEditText.getText().toString();
                                String description = descriptionEditText.getText().toString();
                                String city = citySpinner.getSelectedItem().toString();

                                Map<String, Object> item = new HashMap<>();
                                item.put("name", name);
                                item.put("hourlyRate", hourlyRate);
                                item.put("description", description);
                                item.put("city", city);
                                item.put("mediaUrl", downloadUri.toString());

                                db.collection("items").add(item)
                                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                            @Override
                                            public void onSuccess(DocumentReference documentReference) {
                                                Toast.makeText(PostItem.this, "Item posted successfully", Toast.LENGTH_LONG).show();
                                            }
                                        })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Toast.makeText(PostItem.this, "Error posting item", Toast.LENGTH_LONG).show();
                                            }
                                        });
                            } else {
                                Toast.makeText(PostItem.this, "Upload failed", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                } else {
                    Toast.makeText(PostItem.this, "No media selected", Toast.LENGTH_SHORT).show();
                }
            }
        });
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
