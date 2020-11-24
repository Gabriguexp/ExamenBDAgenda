package com.example.examenbdagenda.model.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.examenbdagenda.model.dao.AgendaDao;
import com.example.examenbdagenda.model.entity.Agenda;
/*
Implementar una base de datos "agenda", con los campos id, nombre, apellidos, teléfono, fecha de
nacimiento, localidad, calle, número. Se deben implementar las siguientes operaciones:
 1) insertar nuevo registro
 2) editar un registro
 3) borrar un registro
 4) listar todos los registros. Todas las operaciones sobre la base de datos se deben implementar en Hebras.

En este caso como se trata de un "examen" se va a subir un archivo zip (generado con Android Studio) y además se debe publicar en GitHub.

Criterios de evaluación:

1º la aplicación debe funcionar
2º la aplicación debe hacer correctamente lo que se pide (las 4 operaciones) -> aprobado
3º funcionalidad, presentación, etc.


 */

@Database (entities = {Agenda.class}, version = 1, exportSchema = false)
public abstract class AgendaDatabase extends RoomDatabase {

    public abstract AgendaDao getAgendaDao();

    private volatile static AgendaDatabase INSTANCE;

    public static AgendaDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AgendaDatabase.class,
        "agenda.sqlite").build();
        }
        return INSTANCE;
    }



}
