package com.example.lambda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void up (View view){
        Intent next = new Intent(Intent.ACTION_VIEW, Uri.parse("http://192.168.0.22/index.php/register/"));
        startActivity(next);
    }
    public void login (View view){
        Intent next = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(next);
        finish();
    }
}