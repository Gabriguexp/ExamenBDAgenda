package com.example.examenbdagenda.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examenbdagenda.R;

public class AgendaViewHolder extends RecyclerView.ViewHolder{
    private final TextView tvnombre;
    ConstraintLayout constraintLayoutItem;

    public AgendaViewHolder(@NonNull View itemView) {
        super(itemView);
        this.tvnombre = itemView.findViewById(R.id.tvnombre);
        constraintLayoutItem = itemView.findViewById(R.id.constraintLayoutItem);
    }

    public void bind(String text) {
        tvnombre.setText(text);
    }

    static AgendaViewHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.elemento_recycler, parent, false);
        return new AgendaViewHolder(view);
    }
}
