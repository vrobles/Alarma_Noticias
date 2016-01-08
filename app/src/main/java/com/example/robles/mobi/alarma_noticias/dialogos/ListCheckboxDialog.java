package com.example.robles.mobi.alarma_noticias.dialogos;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Diálogo con checkboxes
 */
public class ListCheckboxDialog extends DialogFragment {

    public ListCheckboxDialog() {
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return createMultipleListDialog();
    }

    /**
     * Crea un diálogo con una lista de checkboxes
     * de selección multiple
     *
     * @return Diálogo
     */
    public AlertDialog createMultipleListDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        final ArrayList itemsSeleccionados = new ArrayList();

        CharSequence[] items = new CharSequence[7];

        items[0] = "Lunes";
        items[1] = "Martes";
        items[2] = "Miercoles";
        items[3] = "Jueves";
        items[4] = "Viernes";
        items[5] = "Sabado";
        items[6] = "Domingo";

        builder.setTitle("Dias de la Semana")
                .setMultiChoiceItems(items, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if (isChecked) {
                            // Guardar indice seleccionado
                            itemsSeleccionados.add(which);
                            Toast.makeText(
                                    getActivity(),
                                    "Checks seleccionados:(" + itemsSeleccionados.size() + ")",
                                    Toast.LENGTH_SHORT)
                                    .show();
                        } else if (itemsSeleccionados.contains(which)) {
                            // Remover indice sin selección
                            itemsSeleccionados.remove(Integer.valueOf(which));
                        }
                    }
                });

        return builder.create();
    }

}