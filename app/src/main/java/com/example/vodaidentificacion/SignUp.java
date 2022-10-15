package com.example.vodaidentificacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class SignUp extends AppCompatActivity {

    private EditText fullname,usename,email,password;
    private Button register;
    private ProgressBar progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        //Refer Each Variable By its own ID
        fullname = (EditText)findViewById(R.id.ET_FullName);
        usename = (EditText)findViewById(R.id.ET_UserName);
        email = (EditText)findViewById(R.id.ET_Email);
        password = (EditText)findViewById(R.id.ET_Password);
        register = (Button)findViewById(R.id.BTN_Login);
        progressbar = (ProgressBar)findViewById(R.id.PB_ProgressBar);



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String str_fullname,str_username,str_email,str_password;
                str_fullname = String.valueOf(fullname.getText());
                str_email = String.valueOf(email.getText());
                str_password = String.valueOf(password.getText());
                str_username = String.valueOf(usename.getText());

                if(! str_fullname.equals("") && !str_email.equals("") && !str_password.equals("") && !str_username.equals("")) {


                    //Start ProgressBar first (Set visibility VISIBLE)
//                    progressbar.setVisibility(View.VISIBLE);
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[4];
                            field[0] = "fullname";
                            field[1] = "username";
                            field[2] = "email";
                            field[3] = "password";
                            //Creating array for data
                            String[] data = new String[4];
                            data[0] = str_fullname;
                            data[1] = str_username;
                            data[2] = str_email;
                            data[3] = str_password;

                            PutData putData = new PutData("http://192.168.1.23/LoginRegister/signup.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    progressbar.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    if(result.equals("Sign Up Success"))
                                    {
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
//                                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
//                                        startActivity(intent);
                                        finish();

                                    }
                                    else
                                    {
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                    }
                                    //End ProgressBar (Set visibility to GONE)

                                }
                            }
                            //End Write and Read data with URL
                        }
                    });
                    /////////////////////////////////////////////////////////////////////////////////
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"All Fields Required",Toast.LENGTH_SHORT).show();
                }
            }
        });




    }
}