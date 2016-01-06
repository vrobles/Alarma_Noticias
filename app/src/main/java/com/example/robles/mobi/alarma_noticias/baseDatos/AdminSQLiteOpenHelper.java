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
        db.execSQL("create table dias(idDias int primary key NOT NULL AUTO_INCREMENT, nombre text )");
        db.execSQL("create table alarma_dias(idAlarmaNoticias int primary key NOT NULL AUTO_INCREMENT, idNoticias int, idDias int, " +
                "idNoticias int FOREIGN KEY REFERENCES noticias(idNoticias), idDias int FOREIGN KEY REFERENCES dias(idDias))");
        db.execSQL("INSERT INTO dias(nombre) VALUES(Lunes)");
        db.execSQL("INSERT INTO dias(nombre) VALUES(Martes)");
        db.execSQL("INSERT INTO dias(nombre) VALUES(Miercoles)");
        db.execSQL("INSERT INTO dias(nombre) VALUES(Jueves)");
        db.execSQL("INSERT INTO dias(nombre) VALUES(Viernes)");
        db.execSQL("INSERT INTO dias(nombre) VALUES(Sabado)");
        db.execSQL("INSERT INTO dias(nombre) VALUES(Domingo)");

        db.execSQL("INSERT INTO noticias(nombre,urlNoticias) VALUES(El Universo, http://www.eluniverso.com/servicios/rss)");
        db.execSQL("INSERT INTO noticias(nombre,urlNoticias) VALUES(El Comercio, http://www.elcomercio.com/pages/rss.html)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
