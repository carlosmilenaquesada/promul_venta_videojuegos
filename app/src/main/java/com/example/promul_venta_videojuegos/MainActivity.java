package com.example.promul_venta_videojuegos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    EditText editTextNombreUsuario;
    EditText editTextPasswordUsuario;

    Spinner spinnerGenero;
    Spinner spinnerTitulo;

    EditText editTextCantidad;

    RadioGroup radioButtonGrupo;
    RadioButton radioButtonSocio;
    RadioButton radioButtonNoSocio;

    CheckBox checkBoxCondiciones;
    Button buttonComprar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNombreUsuario = (EditText) findViewById(R.id.editTextNombreUsuario);
        editTextPasswordUsuario = (EditText) findViewById(R.id.editTextPasswordUsuario);
        spinnerGenero = (Spinner) findViewById(R.id.spinnerGenero);
        spinnerTitulo = (Spinner) findViewById(R.id.spinnerTitulo);
        editTextCantidad = (EditText) findViewById(R.id.editTextCantidad);
        radioButtonGrupo = (RadioGroup) findViewById(R.id.radioButtonGrupo);
        radioButtonSocio = (RadioButton) findViewById(R.id.radioButtonSocio);
        radioButtonNoSocio = (RadioButton) findViewById(R.id.radioButtonNoSocio);
        checkBoxCondiciones = (CheckBox) findViewById(R.id.checkBoxCondiciones);
        buttonComprar = (Button) findViewById(R.id.buttonComprar);



    }
}

















