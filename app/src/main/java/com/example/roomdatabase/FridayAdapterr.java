package com.example.roomdatabase;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import static com.example.roomdatabase.FridayViewHolder.*;

public class FridayAdapterr extends RecyclerView.Adapter<FridayViewHolder> {

    private List<FridayModel> modelList;


    public FridayAdapterr(List<FridayModel> modelList) {
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public FridayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.friday_row_example, parent, false);
        return new FridayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FridayViewHolder holder, int position) {
        FridayModel newModel = modelList.get(position);
        holder.setValues(newModel.getEmail(), Integer.toString(newModel.getAge()));
    }


    @Override
    public int getItemCount() {
        return modelList.size();
    }
}