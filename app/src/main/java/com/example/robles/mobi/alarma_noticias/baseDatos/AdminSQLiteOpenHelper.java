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

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
