package com.example.ac1_2;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Local1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_local1);

        Button buttonMap = findViewById(R.id.mapButton1);
        buttonMap.setOnClickListener(v -> {
            Uri gmmIntentUri = Uri.parse("google.navigation:q=Estádio+Municipal+de+Sorocaba+Walter+Ribeiro");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            startActivity(mapIntent);
        });

        Button buttonSite = findViewById(R.id.siteButton1);
        buttonSite.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://ecsaobento.com.br/site/page.php?id=62");
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            startActivity(intent);
        });

        Button buttonTel = findViewById(R.id.telButton1);
        buttonTel.setOnClickListener(v -> {
            String telephone = "+5515123456789";
            Uri uri = Uri.parse("tel:"+telephone);
            Intent intent = new Intent(Intent.ACTION_DIAL,uri);
            int permissionCheck = ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE);
            if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,new String[]{android.Manifest.permission.CALL_PHONE},1);
            } else {
                startActivity(intent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}