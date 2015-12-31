package com.example.robles.mobi.alarma_noticias.baseDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {


    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table mail(idMail int primary key NOT NULL AUTO_INCREMENT, nombre text, correo text, password text  )");
        db.execSQL("create table noticias(idNoticias int primary key NOT NULL AUTO_INCREMENT, nombre text, urlNoticias text  )");
        db.execSQL("create table radio(idRadio int primary key NOT NULL AUTO_INCREMENT, nombre text, urlRadio text  )");
        db.execSQL("create table alarma(idAlarma int primary key NOT NULL AUTO_INCREMENT, hora text, fecha text, etiqueta text, idNoticias int, " +
                "idNoticias int FOREIGN KEY REFERENCES noticias(idNoticias), idRadio int, idRadio int FOREIGN KEY REFERENCES radio(idRadio)" +
                "idMail int,  idMail int FOREIGN KEY REFERENCES mail(idMail) )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
