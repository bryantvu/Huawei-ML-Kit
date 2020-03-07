package com.bvutest.mlkit.example.menu;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.bvutest.mlkit.example.R;
import com.bvutest.mlkit.example.classification.ImageClassificationAnalyseActivity;
import com.bvutest.mlkit.example.document.ImageDocumentAnalyseActivity;
import com.bvutest.mlkit.example.face.LiveFaceAnalyseActivity;
import com.bvutest.mlkit.example.face.StillFaceAnalyseActivity;
import com.bvutest.mlkit.example.landmark.ImageLandmarkAnalyseActivity;
import com.bvutest.mlkit.example.object.LiveObjectAnalyseActivity;
import com.bvutest.mlkit.example.text.ImageTextAnalyseActivity;

public class MainActivity extends AppCompatActivity{

    private static final String TAG = "MainMenu";

    private static final int PERMISSION_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ml);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
            Log.d(TAG, "Permissions granted, all good to go");
        } else {
            Log.d(TAG, "Permission not granted");
            requestPermission(Manifest.permission.INTERNET);
        }
    }

    private void requestPermission(String permissionType) {
        Log.d(TAG, "Requesting permission");
        final String[] permissions = new String[]{permissionType};
        if (!ActivityCompat.shouldShowRequestPermissionRationale(this,permissionType)) {
            ActivityCompat.requestPermissions(this, permissions, PERMISSION_CODE);
            return;
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode != PERMISSION_CODE) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            return;
        }
        if (grantResults.length != 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            // Add Bussiness code
            return;
        }else{
            Log.d(TAG, "Failed to get permission");
        }
    }

    public void ImageClassificationOnClick(View view) {
        Intent intent = new Intent(this, ImageClassificationAnalyseActivity.class);
        startActivity(intent);
    }

    public void ImageDocumentAnalyseOnClick(View view) {
        Intent intent = new Intent(this, ImageDocumentAnalyseActivity.class);
        startActivity(intent);
    }

    public void LiveFaceAnalyseOnClick(View view) {
        Intent intent = new Intent(this, LiveFaceAnalyseActivity.class);
        startActivity(intent);
    }

    public void StillFaceAnalyseOnClick(View view) {
        Intent intent = new Intent(this, StillFaceAnalyseActivity.class);
        startActivity(intent);
    }

    public void ImageLandmarkAnalyseOnClick(View view) {
        Intent intent = new Intent(this, ImageLandmarkAnalyseActivity.class);
        startActivity(intent);
    }

    public void LiveObjectAnalyseOnClick(View view) {
        Intent intent = new Intent(this, LiveObjectAnalyseActivity.class);
        startActivity(intent);
    }

    public void ImageTextAnalyseOnClick(View view) {
        Intent intent = new Intent(this, ImageTextAnalyseActivity.class);
        startActivity(intent);
    }

}
