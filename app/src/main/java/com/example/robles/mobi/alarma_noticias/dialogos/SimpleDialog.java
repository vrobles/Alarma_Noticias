package com.example.robles.mobi.alarma_noticias.dialogos;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.example.robles.mobi.alarma_noticias.actividades.MainActivity;
import com.example.robles.mobi.alarma_noticias.fragmentos.MainFragment;


public class SimpleDialog extends DialogFragment {
String itemp;

    public SimpleDialog() {

    }

    public interface OnSimpleDialogListener {
        void onPossitiveButtonClick();
        void onNegativeButtonClick();
    }

    // Interfaz de comunicación

    OnSimpleDialogListener listener;

    public Dialog onCreateDialog(Bundle savedInstanceState) {

        return createSimpleDialog();
    }

    public AlertDialog createSimpleDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //Aqui debo coger el valor de activado o desactivado

        final CharSequence[] items = new CharSequence[2];

        items[0] = "Activada";
        items[1] = "Desactivada";

        builder.setTitle("Activar Alarma")
                .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                    @Override

                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(getActivity(),
                                "Seleccionaste: " + items[which],
                                Toast.LENGTH_SHORT).show();
                        itemp = items[which].toString();

                    }
                });


        return builder.create();
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            listener = (OnSimpleDialogListener) activity;

        } catch (ClassCastException e) {
            throw new ClassCastException(
                    activity.toString() +
                            " no implementó OnSimpleDialogListener");

        }
    }

}

