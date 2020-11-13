package com.example.roomdatabase;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import static com.example.roomdatabase.MainActivity.FridayModelList;


public class Fragment2 extends Fragment {
    private RecyclerView FridayRv;
    private FridayAdapter FridayAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment2, container, false);

        FridayRv=view.findViewById(R.id.rv_test_fridaylist);
        FridayAdapter = new FridayAdapter(FridayModelList);
        FridayRv.setLayoutManager(new LinearLayoutManager(getContext()));
        FridayRv.setAdapter(FridayAdapter);

        return view;
    }

}