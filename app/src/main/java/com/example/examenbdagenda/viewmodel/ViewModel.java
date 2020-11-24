package com.example.examenbdagenda.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.examenbdagenda.model.AgendaRepository;
import com.example.examenbdagenda.model.entity.Agenda;

import java.util.List;

public class ViewModel extends AndroidViewModel {
    AgendaRepository repository;

    public ViewModel(@NonNull Application application) {
        super(application);
        repository = new AgendaRepository(application);
    }

    public void insert(Agenda agenda) {
        repository.insert(agenda);
    }

    public void delete(Agenda agenda){
        repository.delete(agenda);
    }

    public void update (Agenda agenda){
        repository.update(agenda);
    }

    public LiveData<List<Agenda>> getAll(){
        return repository.getAll();
    }



}
