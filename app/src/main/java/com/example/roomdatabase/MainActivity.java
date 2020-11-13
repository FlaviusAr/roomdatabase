package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
EditText userId,password,name;
Button register,login;
protected static List<FridayModel> FridayModelList;
protected static List<FridayModel> FridayModelList1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeList();
        userId=findViewById(R.id.userID);
        password=findViewById(R.id.password);
        name=findViewById(R.id.name);
        register=findViewById(R.id.register);
        login=findViewById(R.id.login);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserEntity userEntity=new UserEntity();
                userEntity.setUserId(userId.getText().toString());
                userEntity.setPassword(password.getText().toString());
                userEntity.setName(name.getText().toString());

                if (validateInput(userEntity)){
                    UserDatabase userDatabase=UserDatabase.getUserDatabase(getApplicationContext());
                    final UserDao userDao = userDatabase.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            userDao.registerUser(userEntity);
                            runOnUiThread(new Runnable() {
                                              @Override
                                              public void run() {
                                                  Toast.makeText(getApplicationContext(), "Utilizator inregistrat", Toast.LENGTH_SHORT).show();
                                              }
                                          });
                        }
                    }).start();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Incomplete fields",Toast.LENGTH_SHORT).show();
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Login.class));
            }
        });
    }

    private Boolean validateInput(UserEntity userEntity){
        if(userEntity.getName().isEmpty()||userEntity.getPassword().isEmpty()||userEntity.getName().isEmpty()){
            return false;
        }
        return true;
    }


    private void initializeList(){
        FridayModelList=new ArrayList<>();
        FridayModelList1=new ArrayList<>();
        FridayModelList.add(new FridayModel( "Ana","Trae","@ana@yahoo.com",23));
        FridayModelList.add(new FridayModel( "Iustin","Iosif","@iustin@yahoo.com",43));
        FridayModelList.add(new FridayModel( "Ema","Dancescu","@adaaemaa@gmail.com",20));
        FridayModelList.add(new FridayModel( "Cristian","Laurentiu","@laur@yahoo.com",18));
        FridayModelList.add(new FridayModel( "Gica","Dan","@adsgsa5emaa@gmail.com",30));
        FridayModelList.add(new FridayModel( "Cristian","Marius","@lggggaar@yahoo.com",18));
        FridayModelList1.add(new FridayModel( "Ana","Trae","ana@yahoo.com",23));
        FridayModelList1.add(new FridayModel( "Iustin","Iosif","iustin@yahoo.com",43));
        FridayModelList1.add(new FridayModel( "Ema","Dancescu","adaaemaa@gmail.com",20));
        FridayModelList1.add(new FridayModel( "Cristian","Laurentiu","laur@yahoo.com",18));
        FridayModelList1.add(new FridayModel( "Gica","Dan","gica@gmail.com",30));
        FridayModelList1.add(new FridayModel( "Cristian","Marius","cristi@yahoo.com",18));
    }




}