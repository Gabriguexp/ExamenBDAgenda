package com.example.examenbdagenda.model;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.examenbdagenda.model.dao.AgendaDao;
import com.example.examenbdagenda.model.entity.Agenda;
import com.example.examenbdagenda.model.room.AgendaDatabase;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AgendaRepository {

    private static final int NUMBER_OF_THREADS= Runtime.getRuntime().availableProcessors();
    public static final ExecutorService threadExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);


    private AgendaDatabase database;
    private AgendaDao agendaDao;

    private LiveData<List<Agenda>> lista;

    public AgendaRepository(Application context){
        database =AgendaDatabase.getDatabase(context);
        agendaDao = database.getAgendaDao();
        lista =agendaDao.getAll();
    }

    public LiveData<List<Agenda>> getLista() {
        return lista;
    }


    public void insert(Agenda agenda) {
        threadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                agendaDao.insert(agenda);
            }
        });
    }

    public void delete(Agenda agenda){
        threadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                agendaDao.delete(agenda);
            }
        });
    }

    public void update(Agenda agenda){
        threadExecutor.execute((new Runnable() {
            @Override
            public void run() {
                agendaDao.update(agenda);
            }
        }));
    }

    public LiveData<List<Agenda>> getAll(){
        return lista;
    }





}
