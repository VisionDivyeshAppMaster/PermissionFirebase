package com.example.permission;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private TextView tv_text;
    private Button btn_click, btn_snackbar, btn_camera;

    String permission [] = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA};
    int permsRequestCode = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         tv_text=findViewById(R.id.tv_text);
         btn_click=findViewById(R.id.btn_click);
         btn_snackbar=findViewById(R.id.btn_snackbar);
        btn_camera=findViewById(R.id.btn_camera);

         btn_click.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 // Check permission
                 if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                     if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED) {
                         ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, permsRequestCode);

                         //if app has no permission than above condition first granted the permission then call this block.
                         Toast.makeText(getApplicationContext(),"If block is called...", Toast.LENGTH_SHORT).show();
                     }else{
                        // if app already has a permission than this else path is called.
                         Toast.makeText(getApplicationContext(), "Calling else part...", Toast.LENGTH_SHORT).show();
                     }
                 }
             }
         });

         btn_camera.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 // Check permission
                 if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                     if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA)!=PackageManager.PERMISSION_GRANTED) {
                         ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA}, permsRequestCode);

                         //if app has no permission than above condition first granted the permission then call this block.
                         Toast.makeText(getApplicationContext(),"camera if called", Toast.LENGTH_SHORT).show();
                     }else{
                         // if app already has a permission than this else path is called.
                         Toast.makeText(getApplicationContext(), "camera else called", Toast.LENGTH_SHORT).show();
                     }
                 }
             }
         });


         btn_snackbar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 snackbar();
             }
         });
   }

   private void snackbar() {
        View parentLayout = findViewById(android.R.id.content);
        Snackbar.make(parentLayout, "Click here for visit vision infotech. ", Snackbar.LENGTH_LONG)
                .setAction("Visit", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String url = "https://visioninfotech.net/";

                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(intent);
                    }
                })
                .setActionTextColor(getResources().getColor(android.R.color.holo_red_light ))
                .show();
    }

}