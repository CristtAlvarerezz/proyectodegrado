package com.example.lambda;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import static com.example.lambda.MainActivity2.dat;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    TextView text, password;
    Button iniciarbutton, olvidastebutton;
    String Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        text=(TextView) findViewById(R.id.text);
        text.setText(dat[4]+" ");
        password=(TextView)findViewById(R.id.password);
        iniciarbutton=(Button) findViewById(R.id.iniciarbutton);
        iniciarbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Password=password.getText().toString();
                metod();

            }
        });
        olvidastebutton=(Button)findViewById(R.id.olvidastebutton);
        olvidastebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(MainActivity3.this, MainActivity8.class);
                startActivity(next);
                finish();
            }
        });
    }



    public void metod (){

        char arrayd[] = dat[11].toCharArray();
        for (int i = 0; i < arrayd.length; i++) {
            arrayd[i] = (char) (arrayd[i] - (char) 128);

        }
        if (Password.equalsIgnoreCase(String.valueOf(arrayd))) {
            Intent next = new Intent(MainActivity3.this, MainActivity4.class);
            startActivity(next);
            finish();

        } else {
            mensajes();
        }

    }

    private void mensajes(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity3.this);
        Toast.makeText(getApplicationContext(), "La contraseña ingresada es incorecta",Toast.LENGTH_SHORT).show();
    }


}