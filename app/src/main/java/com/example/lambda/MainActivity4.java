package com.example.lambda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import static com.example.lambda.MainActivity2.dat;

public class MainActivity4 extends AppCompatActivity {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        text=(TextView) findViewById(R.id.text);
        text.setText(dat[9]+" ");
    }
    public void automatic (View view){
        Intent next = new Intent(MainActivity4.this, MainActivity5.class);
        startActivity(next);
    }
    public void manual (View view){
        Intent next = new Intent(MainActivity4.this, MainActivity6.class);
        startActivity(next);
    }
    public void record (View view){
        Intent next = new Intent(MainActivity4.this, MainActivity7.class);
        startActivity(next);
    }
    public void wordpress (View view){
        Intent next = new Intent(Intent.ACTION_VIEW, Uri.parse("http://192.168.0.22/"));
        startActivity(next);
    }
}