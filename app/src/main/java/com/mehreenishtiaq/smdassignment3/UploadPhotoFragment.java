//package com.mehreenishtiaq.smdassignment3;
//
//import android.annotation.SuppressLint;
//import android.app.Activity;
//import android.content.Intent;
//import android.content.pm.PackageManager;
//import android.net.Uri;
//import android.os.Bundle;
//import android.provider.MediaStore;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.Toast;
//
//import androidx.annotation.Nullable;
//import androidx.core.app.ActivityCompat;
//import androidx.core.content.ContextCompat;
//import androidx.fragment.app.Fragment;
//
//import java.io.IOException;
//
//import okhttp3.MediaType;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.RequestBody;
//
//public class UploadPhotoFragment extends Fragment {
//
//    private static final int PICK_IMAGE = 1;
//    private static final int REQUEST_PERMISSION = 2;
//    private static final String SERVER_URL = "https://your-upload-endpoint.com/upload"; // Replace with your upload URL
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_upload_photo, container, false);
//
//        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button uploadButton = view.findViewById(R.id.uploadButton);
//        uploadButton.setOnClickListener(v -> {
//            if (checkPermission()) {
//                openGallery();
//            } else {
//                requestPermission();
//            }
//        });
//
//        return view;
//    }
//
//    private boolean checkPermission() {
//        int result = ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.READ_EXTERNAL_STORAGE);
//        return result == PackageManager.PERMISSION_GRANTED;
//    }
//
//    private void requestPermission() {
//        ActivityCompat.requestPermissions(getActivity(), new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_PERMISSION);
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
//        switch (requestCode) {
//            case REQUEST_PERMISSION:
//                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    openGallery();
//                } else {
//                    Toast.makeText(getActivity(), "Permission Denied. Please provide the permission to continue.", Toast.LENGTH_LONG).show();
//                }
//                break;
//        }
//    }
//
//    private void openGallery() {
//        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//        startActivityForResult(intent, PICK_IMAGE);
//    }
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK && data != null && data.getData() != null) {
//            Uri imageUri = data.getData();
//            uploadImageToServer(imageUri);
//        }
//    }
//
//    private void uploadImageToServer(Uri imageUri) {
//        OkHttpClient client = new OkHttpClient();
//
//        RequestBody requestBody = null;
//        try {
//            requestBody = RequestBody.create(MediaType.parse("image/*"), MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), imageUri).toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        Request request = new Request.Builder()
//                .url(SERVER_URL)
//                .post(requestBody)
//                .build();
//
//        client.newCall(request).enqueue(new okhttp3.Callback() {
//            @Override
//            public void onFailure(okhttp3.Call call, IOException e) {
//                e.printStackTrace();
//            }
//
//            @Override
//            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
//                if (response.isSuccessful()) {
//                    // Handle successful upload response
//                    Toast.makeText(getActivity(), "Image uploaded successfully!", Toast.LENGTH_SHORT).show();
//                } else {
//                    // Handle error
//                    Toast.makeText(getActivity(), "Failed to upload image.", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }
//}
