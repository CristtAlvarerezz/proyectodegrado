package com.example.lambda;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    Button button;
    String User;
    TextView text;
    protected static String[]dat=new String[13];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        text = (TextView) findViewById(R.id.text);
        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User = text.getText().toString();
                new Task().execute();
            }
        });
    }

    class Task extends AsyncTask<Void, Void, Void> {
        String record = "", error = "";

        @Override
        protected Void doInBackground(Void... voids) {
            sync_worpress obj9 = new sync_worpress();
            dat = obj9.syncuser(User, "user_email");
            return null;
        }

        protected void onPostExecute(Void aVoid) {
            if (dat[4].equalsIgnoreCase("")) {
                mensajes();
            } else {
                Intent next = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(next);
                finish();
            }
            super.onPostExecute(aVoid);
        }
    }

    private void mensajes(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
        Toast.makeText(getApplicationContext(), "El usuario ingresado no existe",Toast.LENGTH_SHORT).show();
    }

}