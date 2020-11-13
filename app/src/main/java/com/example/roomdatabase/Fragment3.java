package com.example.roomdatabase;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import static com.example.roomdatabase.MainActivity.FridayModelList1;


public class Fragment3 extends Fragment {
    private RecyclerView FridayRv;
    private FridayAdapterr FridayAdapterr;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment3, container, false);
        FridayRv = view.findViewById(R.id.rv_test_fridaylist);
        FridayAdapterr = new FridayAdapterr(FridayModelList1);
        FridayRv.setLayoutManager(new LinearLayoutManager(getContext()));
        FridayRv.setAdapter(FridayAdapterr);

        return view;
    }
}