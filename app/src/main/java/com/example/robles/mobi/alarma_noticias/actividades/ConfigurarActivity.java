package com.example.robles.mobi.alarma_noticias.actividades;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.robles.mobi.alarma_noticias.R;
import com.example.robles.mobi.alarma_noticias.dialogos.SimpleDialog;
import com.example.robles.mobi.alarma_noticias.fragmentos.MainFragment;

public class ConfigurarActivity extends AppCompatActivity implements
        DatePickerDialog.OnDateSetListener,
        TimePickerDialog.OnTimeSetListener,
        SimpleDialog.OnSimpleDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar);

        if (savedInstanceState == null) {
            MainFragment fragment = new MainFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(android.R.id.content, fragment, "MainFragment")
                    .commit();
        }

    }


    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        Toast.makeText(
                this,
                "Fecha: " + year + "-" + monthOfYear + "-" + dayOfMonth,
                Toast.LENGTH_LONG)
                .show();

    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Toast.makeText(
                this,
                "Tiempo: " + hourOfDay + ":" + minute,
                Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void onPossitiveButtonClick() {
        Toast.makeText(
                this,
                "Botón Positivo Pulsado",
                Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void onNegativeButtonClick() {
        Toast.makeText(
                this,
                "Botón Negativo Pulsado",
                Toast.LENGTH_LONG)
                .show();
    }
}