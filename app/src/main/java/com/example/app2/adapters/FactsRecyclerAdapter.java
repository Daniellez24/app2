package com.example.app2.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app2.models.Fact;
import com.example.app2.R;
import com.example.app2.viewHolders.FactViewHolder;

import java.util.List;

public class FactsRecyclerAdapter  extends RecyclerView.Adapter<FactViewHolder> {

    LayoutInflater inflater;
    List<Fact> data;

    public void setData(List<Fact> data){
        this.data = data;
    }

    public FactsRecyclerAdapter(LayoutInflater inflater, List<Fact> data) {
        this.inflater = inflater;
        this.data = data;
    }

    @NonNull
    @Override
    public FactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // creates a row view
        View view = inflater.inflate(R.layout.fact_item, parent, false);
        return new FactViewHolder(view, data);
    }

    @Override
    public void onBindViewHolder(@NonNull FactViewHolder holder, int position) {
        // connects between the data and the row view
        Fact fact = data.get(position);
        holder.bind(fact, position);
    }

    @Override
    public int getItemCount() {
        if(data == null)
            return 0;
        return data.size();
    }
}
