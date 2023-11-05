package com.example.promul_venta_videojuegos;

import static com.example.promul_venta_videojuegos.SimuladorBaseDeDatos.listaGeneros;
import static com.example.promul_venta_videojuegos.SimuladorBaseDeDatos.listaJuegos;
import static com.example.promul_venta_videojuegos.SimuladorBaseDeDatos.listaPlataformas;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
	private static final String NOMBRE_USUARIO =
			"promul_venta_videojuegos.MainActivity" + ".NOMBRE_USUARIO";
	private static final String PASSWORD_USUARIO =
			"promul_venta_videojuegos.MainActivity" + ".PASSWORD_USUARIO";
	private static final String CANTIDAD = "promul_venta_videojuegos.MainActivity.CANTIDAD";
	EditText editTextNombreUsuario;
	EditText editTextPasswordUsuario;
	Spinner spinnerPlataforma;
	int plataforma = 0;
	Spinner spinnerGenero;
	int genero = 0;
	Spinner spinnerTitulo;
	int titulo = 0;
	String tituloElegido;
	EditText editTextCantidad;
	RadioGroup radioButtonGrupo;
	RadioButton radioButtonSocio;
	RadioButton radioButtonNoSocio;
	CheckBox checkBoxCondiciones;
	Button buttonComprar;
	ArrayAdapter<String> adapterPlataforma;
	ArrayAdapter<String> adapterGenero;
	ArrayAdapter<String> adapterTitulo;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editTextNombreUsuario = findViewById(R.id.editTextNombreUsuario);
		editTextPasswordUsuario = findViewById(R.id.editTextPasswordUsuario);
		spinnerPlataforma = findViewById(R.id.spinnerPlataforma);
		adapterPlataforma = configurarAdaptadoresSpinnerInmutable(spinnerPlataforma,
				listaPlataformas);
		spinnerGenero = findViewById(R.id.spinnerGenero);
		adapterGenero = configurarAdaptadoresSpinnerInmutable(spinnerGenero, listaGeneros);
		spinnerTitulo = findViewById(R.id.spinnerTitulo);
		adapterTitulo = configurarAdaptadoresSpinnerMutable(spinnerTitulo);
		editTextCantidad = findViewById(R.id.editTextCantidad);
		radioButtonGrupo = findViewById(R.id.radioButtonGrupo);
		radioButtonSocio = findViewById(R.id.radioButtonSocio);
		radioButtonNoSocio = findViewById(R.id.radioButtonNoSocio);
		checkBoxCondiciones = findViewById(R.id.checkBoxCondiciones);
		buttonComprar = findViewById(R.id.buttonSiguiente);
	}

	@Override
	protected void onSaveInstanceState(@NonNull Bundle outState){
		super.onSaveInstanceState(outState);
		outState.putString(NOMBRE_USUARIO, String.valueOf(editTextNombreUsuario.getText()));
		outState.putString(PASSWORD_USUARIO, String.valueOf(editTextNombreUsuario.getText()));
		//-> spinner (faltan)
		outState.putString(CANTIDAD, String.valueOf(editTextNombreUsuario.getText()));
		//-> radiobutton (faltan)
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
		switch(parent.getId()){
			case R.id.spinnerPlataforma:
				plataforma = position;
				break;
			case R.id.spinnerGenero:
				genero = position;
				break;
			case R.id.spinnerTitulo:
				titulo = position;
				break;
		}
		String[][] plat = (String[][]) listaJuegos[plataforma];
		String[] platGen = plat[genero];
		adapterTitulo.clear();
		adapterTitulo.addAll(Arrays.asList(platGen));
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent){
	}

	private ArrayAdapter<String> configurarAdaptadoresSpinnerInmutable(Spinner spinner,
																	   String[] contenido){
		ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
				androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, contenido);
		adapter.setDropDownViewResource(com.google.android.material.R.layout.support_simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(this);
		return adapter;
	}

	private ArrayAdapter<String> configurarAdaptadoresSpinnerMutable(Spinner spinner){
		ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
				androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
		adapter.setDropDownViewResource(com.google.android.material.R.layout.support_simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(this);
		return adapter;
	}
}

















