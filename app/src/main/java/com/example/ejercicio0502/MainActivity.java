 package com.example.ejercicio0502;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

 public class MainActivity extends AppCompatActivity {

    EditText etNombre, etApellido, etEdad, etDatos;
    Spinner spProvincia;
    RadioGroup rgSexo;
    RadioButton rbHombre, rbMujer;
    CheckBox cbEstudiante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = (EditText)findViewById(R.id.etNombre);
        etApellido = (EditText)findViewById(R.id.etApellido);
        etEdad = (EditText)findViewById(R.id.etEdad);
        etDatos = (EditText)findViewById(R.id.etDatos);

        spProvincia = (Spinner)findViewById(R.id.spProvincia);
        String[] provincias = {"Selecciona", "Cádiz", "Zaragoza", "Barcelona", "Madrid"};
        ArrayAdapter<String> adaptadorProvincia = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, provincias);
        spProvincia.setAdapter(adaptadorProvincia);

        rgSexo = (RadioGroup)findViewById(R.id.rgSexo);
        rbHombre = (RadioButton)findViewById(R.id.rbHombre);
        rbMujer = (RadioButton)findViewById(R.id.rbMujer);

        cbEstudiante = (CheckBox)findViewById(R.id.cbEstudiante);

    }

    public void obtenerDatos(View view){

        //Recogemos el valor de los et nombre y apellidos
        String nombre = etNombre.getText().toString();
        String apellidos = etApellido.getText().toString();
        String edad = etEdad.getText().toString();
        String provinciaSeleccionada = spProvincia.getSelectedItem().toString();

        if(nombre.equals("") || apellidos.equals("") || edad.equals("")){
            Toast.makeText(getApplicationContext(), "*Debes de rellenar los campos obligatorios", Toast.LENGTH_SHORT).show();
        }else{
            etDatos.setText(nombre+" "+apellidos+"\n"+edad+"\n"+provinciaSeleccionada+"\n"+);
        }
    }

}
