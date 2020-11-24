package com.example.examenbdagenda.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.examenbdagenda.R;
import com.example.examenbdagenda.model.entity.Agenda;
import com.example.examenbdagenda.viewmodel.ViewModel;

public class EditarActivity extends AppCompatActivity {
    EditText editarnombretv, editarapellidostv, editarfechatv, editartelefonotv, editarlocalidadtv,
            editarcalletv, editarnumerotv;
    Button guardarBt, cancelarBt;
    ViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);
        viewModel = new ViewModelProvider(this).get(ViewModel.class);
        init();
    }

    private void init() {
        Agenda agenda = (Agenda) getIntent().getSerializableExtra("agenda");
        editarnombretv = findViewById(R.id.editarnombreet);
        editarapellidostv = findViewById(R.id.editarapellidoset);
        editarfechatv= findViewById(R.id.editarfechaet);
        editartelefonotv= findViewById(R.id.editartelefonoet);
        editarlocalidadtv= findViewById(R.id.editarlocalidadet);
        editarcalletv= findViewById(R.id.editarcalleet);
        editarnumerotv= findViewById(R.id.editarnumeroet);
        editarnombretv.setText(agenda.getNombre());
        editarapellidostv.setText(agenda.getApellidos());;
        editarfechatv.setText(agenda.getFechaNac());;
        editartelefonotv.setText(""+agenda.getTelefono());;
        editarlocalidadtv.setText(agenda.getLocalidad());;
        editarcalletv.setText(agenda.getCalle());;
        editarnumerotv.setText(""+agenda.getNumero());;

        guardarBt = findViewById(R.id.guardarbt);
        guardarBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    agenda.setNombre(editarnombretv.getText().toString());
                    agenda.setApellidos(editarapellidostv.getText().toString());
                    agenda.setTelefono(Integer.parseInt(editartelefonotv.getText().toString()));
                    agenda.setFechaNac(editarfechatv.getText().toString());
                    agenda.setLocalidad(editarlocalidadtv.getText().toString());
                    agenda.setCalle(editarcalletv.getText().toString());
                    agenda.setNumero(Integer.parseInt(editarnumerotv.getText().toString()));
                    viewModel.update(agenda);
                    finish();

            }
        });


        cancelarBt = findViewById(R.id.cancelarbt);
        cancelarBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}