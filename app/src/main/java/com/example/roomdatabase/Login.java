package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText userId,password;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userId=findViewById(R.id.userID);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            final String userIdText=userId.getText().toString();
            final String passwordText=password.getText().toString();
            if(userIdText.isEmpty()||passwordText.isEmpty()){
                Toast.makeText(getApplicationContext(),"Incomplete fields", Toast.LENGTH_SHORT).show();
            }else{
                UserDatabase userDatabase =UserDatabase.getUserDatabase(getApplicationContext());
                final UserDao userDao = userDatabase.userDao();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        UserEntity userEntity=userDao.login(userIdText,passwordText);
                        if(userEntity==null){
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(),"Invalid login", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }else{
                            Intent intent=new Intent(Login.this,MainActivity2.class);
                            startActivity(intent);
                        }
                    }
                }).start();
            }
            }
        });
    }
}