package com.example.pgm12023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import configuracion.SQLLiteconexion;
import transacciones.Transacciones;

public class MainActivity extends AppCompatActivity {

    // global
    EditText nombres, apellidos, correo, edad;
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombres = (EditText) findViewById(R.id.nombres);
        apellidos = (EditText) findViewById(R.id.apellidos);
        correo = (EditText) findViewById(R.id.correo);
        edad = (EditText) findViewById(R.id.edad);
        btn1 = (Button) findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               AgregarPersona();
            }
        });
    }
private void AgregarPersona(){

        try{
    SQLLiteconexion conexion = new SQLLiteconexion(this, Transacciones.NameDatabase, null, 1);
    SQLiteDatabase db = conexion.getWritableDatabase();

    ContentValues valores = new ContentValues();
    valores.put("nombres", nombres.getText().toString());
    valores.put("apellidos", apellidos.getText().toString());
    valores.put("correo", correo.getText().toString());
    valores.put("edad", edad.getText().toString());


            Long Resultado = db.insert(Transacciones.tablapersonas, "id", valores);
    Toast.makeText(this, Resultado.toString(), Toast.LENGTH_SHORT).show();
            ClearScreen();
        }
        catch (Exception ex){
            Toast.makeText(this,  "error no se puedo ingresar los datos", Toast.LENGTH_LONG).show();

        }

}

    private void ClearScreen() {
        nombres.setText(Transacciones.empty);
        apellidos.setText(Transacciones.empty);
        correo.setText(Transacciones.empty);
        edad.setText(Transacciones.empty);
    }

    private void MostrarCliente(){
        String mensaje = nombres.getText().toString() +
                " | " + apellidos.getText().toString() +
                " | " + correo.getText().toString();


            Toast.makeText(this,  "Hola como estas", Toast.LENGTH_SHORT).show();

        }

    }

