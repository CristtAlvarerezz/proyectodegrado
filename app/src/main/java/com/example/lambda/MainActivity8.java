package com.example.lambda;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import static com.example.lambda.MainActivity2.dat;

public class MainActivity8 extends AppCompatActivity {

    String correo, contraseña, User, cuerpo, titulo, code, code2;
    TextView text, num;
    Button enviar;
    Session session;
    String[] ramdom = new String[5];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        text = (EditText) findViewById(R.id.text);
        num = (TextView) findViewById(R.id.nume);
        enviar = (Button) findViewById(R.id.enviar);
        correo = "lambdasasud@gmail.com";
        contraseña = "lambdasas2017";
        titulo = "Recovery pin Lambda Computer Corporation";

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User = text.getText().toString();
                new Task().execute();
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                Properties properties = new Properties();
                properties.put("mail.smtp.host","smtp.googlemail.com");
                properties.put("mail.smtp.socketFactory.port","465");
                properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
                properties.put("mail.smtp.auth","true");
                properties.put("mail.smtp.port","465");


                try {
                    session= Session.getDefaultInstance(properties, new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(correo,contraseña);
                        }
                    });

                    if (session!=null){
                        codigo();
                        Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(correo));
                        message.setSubject(titulo);
                        message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(text.getText().toString()));
                        message.setContent( dat[9] +""+ "En el siguiente mensaje se te envio tu nuevo PIN para que pueda ingresar de nuevo a la plataforma" +""+ code + " <br> Muchas gracias por parte de <br> Lambda Team.", "text/html; charset=utf-8");
                        Transport.send(message);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
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
                rasp();
            }
            else {
                rp();
            }
            super.onPostExecute(aVoid);
        }
    }


    private void rasp(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity8.this);
        Toast.makeText(getApplicationContext(), "El usuario ingresado no existe",Toast.LENGTH_SHORT).show();
    }

    private void rp(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity8.this);
        Toast.makeText(getApplicationContext(), "Por favor revise su correo para continuar con el proceso",Toast.LENGTH_SHORT).show();
    }

    public void codigo(){
        code ="";
        if(dat[10].equalsIgnoreCase("YES")){
            for (int i = 0; i <= 4; i++) {
                ramdom[i] = String.valueOf((int) (Math.random() * (10 - 1) + 1));
                code = code + ramdom[i];
                num.setText(code);
            }
        }
    }

}