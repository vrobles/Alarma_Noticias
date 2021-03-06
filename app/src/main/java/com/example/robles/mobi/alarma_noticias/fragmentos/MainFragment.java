package com.example.robles.mobi.alarma_noticias.fragmentos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;

import com.example.robles.mobi.alarma_noticias.R;
import com.example.robles.mobi.alarma_noticias.actividades.DetailActivity;
import com.example.robles.mobi.alarma_noticias.dialogos.DateDialog;
import com.example.robles.mobi.alarma_noticias.dialogos.SimpleDialog;
import com.example.robles.mobi.alarma_noticias.dialogos.ListCheckboxDialog;
import com.example.robles.mobi.alarma_noticias.dialogos.ListRadioDialog;
import com.example.robles.mobi.alarma_noticias.dialogos.LoginDialog;
import com.example.robles.mobi.alarma_noticias.dialogos.SimpleListDialog;
import com.example.robles.mobi.alarma_noticias.dialogos.TimeDialog;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Fragmento principal
 */
public class MainFragment extends Fragment {

    private RadioButton r1;
    private ListView lista;
    private StringBuilder mensaje = new StringBuilder();

    public MainFragment() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        View v = inflater.inflate(R.layout.fragment_main, container, false);

        lista = (ListView) v.findViewById(R.id.lista);

        // Datos de la lista
        String[] data = {
                "Activar Alarma",
                "Noticias",
                "Radio",
                "Repetir",
                "Iniciar Sesion Correo",
                "Fecha",
                "Ajustar Hora",
                "Configurar Email",
        };
        /*Button guardar = (Button) v.findViewById(R.id.crear_guardar);
        Button cancelar = (Button) v.findViewById(R.id.crear_cancelar);

        guardar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Crear Cuenta...
//                        dismiss();
                    }
                }
        );

        cancelar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Loguear...
  //                      dismiss();
                    }
                }

        );*/

        ArrayAdapter adaptador = new ArrayAdapter<String>(
                getActivity(),
                R.layout.list_item,
                R.id.list_item_textview,
                data
        );

        lista.setAdapter(adaptador);

        // Asignar acciones
        lista.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        // Obtención del manejador de fragmentos
                        FragmentManager fragmentManager = getFragmentManager();

                        switch (position) {
                            case 0:
                                new SimpleDialog().show(fragmentManager, "SimpleDialog");//Activar Alarma
                                break;
                            case 1:
                                new SimpleListDialog().show(fragmentManager, "SimpleListDialog");//RSS
                                break;
                            case 2:
                                new ListRadioDialog().show(fragmentManager, "ListRadioDialog");
                                break;
                            case 3:
                                new ListCheckboxDialog().show(fragmentManager, "ListCheckboxDialog");
                                break;
                            case 4:
                                new LoginDialog().show(fragmentManager, "LoginDialog");
                                break;
                            case 5:
                                new DateDialog().show(fragmentManager, "DatePickerFragment");
                                break;
                            case 6:
                                new TimeDialog().show(fragmentManager, "TimePickerFragment");
                                break;
                            case 7:
                                startActivity(new Intent(getActivity(), DetailActivity.class));
                                break;
                        }
                    }
                }
        );


        return v;
    }


}
