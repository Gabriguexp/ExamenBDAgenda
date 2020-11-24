package com.example.examenbdagenda.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.examenbdagenda.R;
import com.example.examenbdagenda.model.entity.Agenda;
import com.example.examenbdagenda.viewmodel.ViewModel;

import java.util.List;

public class AgendaActivity extends AppCompatActivity {

    Button editarbt,borrarbt;
    TextView nombretv, apellidostv, fechatv, telefonotv, localidadtv, calletv, numerotv;
    ViewModel viewModel;
    int id;
    Agenda vistaAgenda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);
        viewModel = new ViewModelProvider(this).get(ViewModel.class);
        init();
    }

    private void init() {
        vistaAgenda = (Agenda) getIntent().getSerializableExtra("agenda");
        id = vistaAgenda.getId();
        nombretv = findViewById(R.id.nombretv);
        apellidostv = findViewById(R.id.apellidostv);
        fechatv = findViewById(R.id.fechatv);
        telefonotv = findViewById(R.id.telefonotv);
        localidadtv = findViewById(R.id.localidadtv);
        calletv = findViewById(R.id.calletv);
        numerotv = findViewById(R.id.numerotv);

        nombretv.setText("Nombre: "+ vistaAgenda.getNombre());
        apellidostv.setText("Apellidos: "+ vistaAgenda.getApellidos());
        fechatv.setText("Fecha: "+ vistaAgenda.getFechaNac());
        telefonotv.setText("Telefono: "+ vistaAgenda.getTelefono());
        localidadtv.setText("Localidad: "+ vistaAgenda.getLocalidad());
        calletv.setText("Calle: "+ vistaAgenda.getCalle());
        numerotv.setText("Número: "+ vistaAgenda.getNumero());

        editarbt = findViewById(R.id.editarbt);
        borrarbt = findViewById(R.id.borrarbt);

        editarbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AgendaActivity.this,EditarActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("agenda", vistaAgenda);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        borrarbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.delete(vistaAgenda);
                finish();
            }
        });

        viewModel.getAll().observeForever( new Observer<List<Agenda>>() {
            @Override
            public void onChanged(List<Agenda> agenda) {

                for(Agenda a : agenda){
                    if (a.getId()== id){
                        vistaAgenda = a;
                    }
                }
                nombretv.setText("Nombre: "+ vistaAgenda.getNombre());
                apellidostv.setText("Apellidos: "+ vistaAgenda.getApellidos());
                fechatv.setText("Fecha: "+ vistaAgenda.getFechaNac());
                telefonotv.setText("Telefono: "+ vistaAgenda.getTelefono());
                localidadtv.setText("Localidad: "+ vistaAgenda.getLocalidad());
                calletv.setText("Calle: "+ vistaAgenda.getCalle());
                numerotv.setText("Número: "+ vistaAgenda.getNumero());
            }
        });
    }
}