package com.example.roomdatabase;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import static com.example.roomdatabase.MainActivity.FridayModelList;
import static com.example.roomdatabase.MainActivity.FridayModelList1;
import java.util.ArrayList;
import java.util.List;


public class Fragment1 extends Fragment{

    private EditText editName,editPass,editEmail,editAge;
    private Button button1;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_fragment1, container, false);
        editName=view.findViewById(R.id.editName);
        editPass=view.findViewById(R.id.editPass);
        editEmail=view.findViewById(R.id.editEmail);
        editAge=view.findViewById(R.id.editAge);
        button1=view.findViewById(R.id.button1);


        onclikers();
        return view;
    }




    public void adauga(String nume,String parola,String email,int varsta){
        FridayModelList.add(new FridayModel(nume,parola,email,varsta));
        FridayModelList1.add(new FridayModel(nume,parola,email,varsta));
    }


    public void onclikers(){
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                adauga(editName.getText().toString(),editPass.getText().toString(),editEmail.getText().toString(),Integer.valueOf(editAge.getText().toString()));
                editName.getText().clear();
                editPass.getText().clear();
                editEmail.getText().clear();
                editAge.getText().clear();
            }
        });
    }

}


