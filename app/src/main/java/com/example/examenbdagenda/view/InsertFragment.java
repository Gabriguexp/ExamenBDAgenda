package com.example.examenbdagenda.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.examenbdagenda.R;
import com.example.examenbdagenda.model.entity.Agenda;
import com.example.examenbdagenda.viewmodel.ViewModel;
import com.google.android.material.snackbar.Snackbar;

public class InsertFragment extends Fragment {
    ViewModel viewModel;
    Button btadd;
    EditText nombreEt, apellidosEt, fechaEt, telefonoEt, localidadEt, calleEt, numeroEt;

    public InsertFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_insert, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication())).get(ViewModel.class);
        btadd = view.findViewById(R.id.btadd);
        nombreEt =view.findViewById(R.id.nombreEt);
        apellidosEt= view.findViewById(R.id.apellidosEt);
        fechaEt= view.findViewById(R.id.fechaEt);
        telefonoEt=view.findViewById(R.id.telefonoEt);
        localidadEt=view.findViewById(R.id.localidadEt);
        calleEt=view.findViewById(R.id.calleEt);
        numeroEt=view.findViewById(R.id.numeroEt);
        btadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String nombre = nombreEt.getText().toString() ;
                    String apellidos= apellidosEt.getText().toString() ;
                    String telefono= telefonoEt.getText().toString() ;
                    String fecha= fechaEt.getText().toString() ;
                    String localidad= localidadEt.getText().toString() ;
                    String calle= calleEt.getText().toString() ;
                    String numero= numeroEt.getText().toString() ;
                    if(nombre.isEmpty() || apellidos.isEmpty() || telefono.isEmpty() || fecha.isEmpty() ||
                            localidad.isEmpty() || calle.isEmpty() || numero.isEmpty()){
                        Snackbar.make(view, "Debes rellenar todos los campos", Snackbar.LENGTH_LONG)
                                .show();


                    } else {


                        int tlfn = Integer.parseInt(telefono);
                        int num = Integer.parseInt(numero);
                        Agenda agenda = new Agenda(nombre,apellidos,tlfn,fecha,localidad,calle,num);
                        viewModel.insert(agenda);
                        NavHostFragment.findNavController(InsertFragment.this)
                                .navigate(R.id.action_insertFragment_to_listaFragment);
                    }
                } catch (NumberFormatException ex){
                    Snackbar.make(view, "El numero de telefono no puede tener mas de 9 cifras", Snackbar.LENGTH_LONG)
                            .show();
                }

            }
        });

    }
}