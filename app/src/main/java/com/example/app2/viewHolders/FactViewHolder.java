package com.example.app2.viewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app2.models.Fact;
import com.example.app2.R;

import java.util.List;

public class FactViewHolder extends RecyclerView.ViewHolder {
    TextView body;
    List<Fact> data;


    public FactViewHolder(@NonNull View itemView, List<Fact> data) {
        super(itemView);
        this.data = data;
        this.body = itemView.findViewById(R.id.fact_tv);
    }

    public void bind(Fact fact, int pos){
        body.setText(fact.getFactBody());
    }
}
