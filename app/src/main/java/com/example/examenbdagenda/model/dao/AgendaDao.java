package com.example.examenbdagenda.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.examenbdagenda.model.entity.Agenda;

import java.util.List;

@Dao
public interface AgendaDao {

    @Insert
    void insert(Agenda agenda);

    @Update
    void update(Agenda agenda);

    @Delete
    void delete(Agenda agenda);

    @Query("Select * from agenda where id = :id")
    Agenda get(int id);

    @Query("Select * from agenda order by nombre DESC")
    LiveData<List<Agenda>> getAll();
}
