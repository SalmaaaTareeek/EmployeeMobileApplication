package com.example.vodaidentificacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class Login extends AppCompatActivity {

    private EditText usename,password;
    private Button login;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usename = (EditText)findViewById(R.id.ET_UserName);
        password = (EditText)findViewById(R.id.ET_Password);


        login = (Button)findViewById(R.id.BTN_Login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String str_fullname,str_username,str_email,str_password;
                str_password = String.valueOf(password.getText());
                str_username = String.valueOf(usename.getText());

                if( !str_password.equals("") && !str_username.equals("")) {
                    if(str_username.equals("salma.elmosalamy@vodafone.com") && str_password.equals("asd"))
                    {
                        Toast.makeText(getApplicationContext(),"Correct!",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                        finish();

                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"UserName Or Password are Incorrect",Toast.LENGTH_SHORT).show();

                    }

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"All Fields Required",Toast.LENGTH_SHORT).show();
                }
            }
        });



        }

//    public String getUserName() {
//        return usename.toString();
//    }
//
//    public String getPassword() {
//        return password.toString();
//    }

}