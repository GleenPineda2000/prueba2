package com.example.pgm12023;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import configuracion.SQLLiteconexion;
import transacciones.Personas;
import transacciones.Transacciones;

public class ActivityListView extends AppCompatActivity {
// variables globales
SQLLiteconexion conexion;
ListView listView;

    ArrayList<Personas> listapersonas;

 ArrayList<String> Arreglopersonas;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

conexion = new SQLLiteconexion(this, Transacciones.NameDatabase, null, 1);
       listView = (ListView)  findViewById(R.id.list_view);

ObtenerListaPersonas();

        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1, Arreglopersonas);
        listView.setAdapter(adp);


    }

    private void ObtenerListaPersonas() {

        SQLiteDatabase db = conexion.getReadableDatabase();
        Personas person = null;
        listapersonas = new ArrayList<Personas>();

        // cursor

        Cursor cursor = db.rawQuery("SELECT * FROM personas", null);

        while(cursor.moveToNext()){

            person = new Personas();
            person.setId(cursor.getInt(0));
            person.setNombres(cursor.getString(1));
            person.setApellidos(cursor.getString(2));
            person.setEdad(cursor.getInt(3));
            person.setCorreo(cursor.getString(4));

            listapersonas.add(person);
        }
cursor.close();
        FileList();


    }

    private void FileList(){
Arreglopersonas = new ArrayList<String>();
for(int i = 0; i < listapersonas.size(); i++){


    Arreglopersonas.add(listapersonas.get(i).getId() + " | "+
            listapersonas.get(i).getNombres() + " | "+
            listapersonas.get(i).getApellidos()+ " | ");






}



    }
}