package com.example.examenbdagenda.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.examenbdagenda.R;
import com.example.examenbdagenda.model.entity.Agenda;
import com.example.examenbdagenda.view.AgendaActivity;
import com.example.examenbdagenda.view.ListaFragment;

public class AgendaAdapter extends ListAdapter<Agenda, AgendaViewHolder> {
    private Context context;
    public AgendaAdapter(@NonNull DiffUtil.ItemCallback<Agenda> diffCallback, Context context) {
        super(diffCallback);
        this.context = context;
    }

    @NonNull
    @Override
    public AgendaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return AgendaViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull AgendaViewHolder holder, int position) {
        Agenda actual = getItem(position);
        holder.bind(actual.getNombre());
        holder.constraintLayoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AgendaActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("agenda", actual);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }


    public static class AgendaDiff extends DiffUtil.ItemCallback<Agenda> {

        @Override
        public boolean areItemsTheSame(@NonNull Agenda oldItem, @NonNull Agenda newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Agenda oldItem, @NonNull Agenda newItem) {
            return oldItem.getNumero()== newItem.getNumero();
        }
    }
}
