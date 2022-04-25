package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText username,password,confirm;
    Button submit,signup;
    DBHelper DB;
    public Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=(EditText)findViewById(R.id.ed_username);
        password=(EditText)findViewById(R.id.ed_password);
        confirm=(EditText)findViewById(R.id.ed_confirm);
        submit=(Button)findViewById(R.id.btn_submit);
        signup=(Button)findViewById(R.id.btn_signup);
        DB = new DBHelper(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String conf = confirm.getText().toString();

                if (user.equals("") || pass.equals("") || conf.equals(""))
                    Toast.makeText(Login.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();

                else {
                    if (pass.equals(conf)) {
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(user,pass);
                            if(insert ==true){
                                Toast.makeText(Login.this,"Registered successfully",Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),Dashboard.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(Login.this,"Registration Failed",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(Login.this,"User already exist please sign in..!!",Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(Login.this,"Password not matching..!!",Toast.LENGTH_SHORT).show();
                    }

                }


            }

        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), SignUp.class);
                startActivity(intent);

            }
        });


    }
}