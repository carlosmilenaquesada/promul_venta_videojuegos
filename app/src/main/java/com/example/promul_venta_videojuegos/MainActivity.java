package com.example.promul_venta_videojuegos;

import static com.example.promul_venta_videojuegos.SimuladorBaseDeDatos.listaGeneros;
import static com.example.promul_venta_videojuegos.SimuladorBaseDeDatos.listaJuegos;
import static com.example.promul_venta_videojuegos.SimuladorBaseDeDatos.listaPlataformas;

import android.content.Intent;
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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
	private static final String PRIMER_ACTIVITY_COMPRA =
			"promul_venta_videojuegos.MainActivity" + ".PRIMER_ACTIVITY_COMPRA";
	EditText editTextNombreUsuario;
	EditText editTextPasswordUsuario;
	Spinner spinnerPlataforma;
	int plataforma = 0;
	Spinner spinnerGenero;
	int genero = 0;
	Spinner spinnerTitulo;
	int titulo = 0;
	EditText editTextCantidad;
	RadioGroup radioButtonGrupo;
	RadioButton radioButtonSocio;
	RadioButton radioButtonNoSocio;
	CheckBox checkBoxCondiciones;
	Button buttonComprar;
	ArrayAdapter<String> adapterPlataforma;
	ArrayAdapter<String> adapterGenero;
	ArrayAdapter<String> adapterTitulo;
	Compra compra;

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
		//La cantidad es un número, que si al voltear la pantalla está vacío, crashea el programa
		// al intentar parsear null a Integer, por eso es necesario hacer la comprobación de si
		// está vacío el campo de editTextCantidad antes de tomar su valor y parsear a Integer.
		int cantidad = 0;
		if(!String.valueOf(editTextCantidad.getText()).isEmpty()){
			cantidad = Integer.valueOf(String.valueOf(editTextCantidad.getText()));
		}
		compra = new Compra(String.valueOf(editTextNombreUsuario.getText()),
				String.valueOf(spinnerPlataforma.getSelectedItem()),
				String.valueOf(spinnerGenero.getSelectedItem()),
				String.valueOf(spinnerTitulo.getSelectedItem()), cantidad,
				radioButtonSocio.isSelected());
		outState.putSerializable(PRIMER_ACTIVITY_COMPRA, compra);
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

	public void irSiguiente(View view){
		boolean hayErrores = false;
		if(!checkBoxCondiciones.isChecked()){
			hayErrores = true;
			Toast.makeText(this, "Debe aceptar las condiciones.", Toast.LENGTH_SHORT).show();
		}
		if(String.valueOf(editTextNombreUsuario.getText()).isEmpty()){
			hayErrores = true;
			editTextNombreUsuario.setError("El nombre no puede estar vacío.");
		}
		if(String.valueOf(editTextPasswordUsuario.getText()).isEmpty()){
			hayErrores = true;
			editTextPasswordUsuario.setError("La contraseña no puede estar vacía.");
		}
		if(String.valueOf(editTextCantidad.getText()).isEmpty()){
			hayErrores = true;
			editTextCantidad.setError("La cantidad no puede estar vacía.");
		}
		if(hayErrores == false){
			compra = new Compra(String.valueOf(editTextNombreUsuario.getText()),
					String.valueOf(spinnerPlataforma.getSelectedItem()),
					String.valueOf(spinnerGenero.getSelectedItem()),
					String.valueOf(spinnerTitulo.getSelectedItem()),
					Integer.valueOf(String.valueOf(editTextCantidad.getText())),
					radioButtonSocio.isSelected());
			Intent intent = new Intent(this, SecondActivity.class);
			intent.putExtra(PRIMER_ACTIVITY_COMPRA, compra);

			startActivity(intent);
		}
	}
}

















