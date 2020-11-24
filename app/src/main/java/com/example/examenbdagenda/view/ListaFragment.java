package com.example.examenbdagenda.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.examenbdagenda.R;
import com.example.examenbdagenda.model.entity.Agenda;
import com.example.examenbdagenda.view.adapter.AgendaAdapter;
import com.example.examenbdagenda.viewmodel.ViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class ListaFragment extends Fragment {
    private ViewModel viewModel;
    FloatingActionButton floatingActionButton;
    public ListaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication())).get(ViewModel.class);
        floatingActionButton = view.findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(ListaFragment.this)
                        .navigate(R.id.action_listaFragment_to_insertFragment);
            }
        });


        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        final AgendaAdapter adapter = new AgendaAdapter(new AgendaAdapter.AgendaDiff(), getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        viewModel.getAll().observe(getViewLifecycleOwner(), new Observer<List<Agenda>>() {
            @Override
            public void onChanged(List<Agenda> agenda) {
                adapter.submitList(agenda);
            }
        });
    }
}