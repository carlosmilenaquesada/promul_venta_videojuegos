package com.example.promul_venta_videojuegos;

import static com.example.promul_venta_videojuegos.SimuladorBaseDeDatos.JuegoPrecioPortada;
import static com.example.promul_venta_videojuegos.SimuladorBaseDeDatos.listaGeneros;
import static com.example.promul_venta_videojuegos.SimuladorBaseDeDatos.listaJuegos;
import static com.example.promul_venta_videojuegos.SimuladorBaseDeDatos.listaPlataformas;

import android.content.Intent;
//import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
//import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
	public static final String PRIMER_ACTIVITY_COMPRA =
			"promul_venta_videojuegos.MainActivity" + ".PRIMER_ACTIVITY_COMPRA";
	public static final String IDIOMA = "promul_venta_videojuegos.MainActivity.IDIOMA";
	EditText editTextNombreUsuario;
	EditText editTextPasswordUsuario;
	Spinner spinnerPlataforma;
	int plataforma = 0;
	Spinner spinnerGenero;
	int genero = 0;
	Spinner spinnerTitulo;
	int titulo = 0;
	EditText editTextCantidad;
	EditText editTextFechaEntrega;
	EditText editTextHoraEntrega;
	ImageView imageViewPortadaJuego;
	RadioGroup radioButtonGrupo;
	RadioButton radioButtonSocio;
	RadioButton radioButtonNoSocio;
	TextView textViewPrecioMostrar;
	CheckBox checkBoxCondiciones;
	Button buttonComprar;
	ArrayAdapter<String> adapterPlataforma;
	ArrayAdapter<String> adapterGenero;
	ArrayAdapter<String> adapterTitulo;
	Compra compra;
	JuegoPrecioPortada juegoPrecioPortada;
	DecimalFormat dm;
	Locale locale;

	//@RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
	@Override
	protected void onCreate(Bundle savedInstanceState){
		if(savedInstanceState != null){
			titulo = savedInstanceState.getInt("titulo");
			//El idioma personalizado no se establece automáticamente mediante savedInstanceState,
			// así
			// que debe guardarse en una  variable Locale en el método onSaveInstanceState(), y ser
			// cargado manualmente. Tras la carga, es necesario repintar el activity,
			//por eso pongo el onCreate justo después, para aprovechar el re-cargado.
			Serializable s = savedInstanceState.getSerializable("locale");
			if(s != null){
				locale = (Locale) s;
				cambiarIdioma(locale.getLanguage());
			}
		}
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
		editTextFechaEntrega = findViewById(R.id.editTextFechaEntrega);
		editTextHoraEntrega = findViewById(R.id.editTextHoraEntrega);
		imageViewPortadaJuego = findViewById(R.id.imageViewPortadaJuego);
		radioButtonGrupo = findViewById(R.id.radioButtonGrupo);
		radioButtonSocio = findViewById(R.id.radioButtonSocio);
		radioButtonNoSocio = findViewById(R.id.radioButtonNoSocio);
		checkBoxCondiciones = findViewById(R.id.checkBoxCondiciones);
		textViewPrecioMostrar = findViewById(R.id.textViewPrecioMostrar);
		buttonComprar = findViewById(R.id.buttonSiguiente);
		juegoPrecioPortada = new JuegoPrecioPortada();
		dm = new DecimalFormat("0.00");
		locale = getResources().getConfiguration().getLocales().get(0);
	}

	@Override
	protected void onSaveInstanceState(@NonNull Bundle outState){
		super.onSaveInstanceState(outState);
		outState.putInt("titulo", titulo);
		outState.putSerializable("locale", locale);
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
		int parentId = parent.getId();
		if(parentId == R.id.spinnerPlataforma){
			plataforma = position;
		}else{
			if(parentId == R.id.spinnerGenero){
				genero = position;
			}else{
				if(parentId == R.id.spinnerTitulo){
					titulo = position;
				}
			}
		}
		JuegoPrecioPortada[][] plat = (JuegoPrecioPortada[][]) listaJuegos[plataforma];
		JuegoPrecioPortada[] platGen = plat[genero];
		if(parentId != R.id.spinnerTitulo){
			adapterTitulo.clear();
			ArrayList<String> titulos = new ArrayList<>();
			for(JuegoPrecioPortada jp : platGen){
				titulos.add(jp.getNombreJuego());
			}
			adapterTitulo.addAll(titulos);
		}
		spinnerTitulo.setSelection(titulo);
		juegoPrecioPortada = new JuegoPrecioPortada(platGen[titulo].getNombreJuego(),
				platGen[titulo].getPrecioJuego(), platGen[titulo].getPortadaId());
		imageViewPortadaJuego.setImageResource(juegoPrecioPortada.getPortadaId());
		actualizarPrecioJuego();
	}

	public void setLocale(View view){
		String idiomaActual = locale.getLanguage();
		String idiomaNuevo;
		if(idiomaActual.equals("es")){
			idiomaNuevo = "en-us";
		}else{
			idiomaNuevo = "es";
		}
		cambiarIdioma(idiomaNuevo);
		recreate();
	}

	public void cambiarIdioma(String codigoNuevoIdioma){
		this.locale = new Locale(codigoNuevoIdioma);
		getResources().getConfiguration().setLocale(locale);
		getResources().updateConfiguration(getResources().getConfiguration(),
				getResources().getDisplayMetrics());
	}

	public void actualizarPrecioJuego(){
		float precioJuego = juegoPrecioPortada.getPrecioJuego();
		String mensajePrecio = getString(R.string.sin_descuento) + "\n" + dm.format(precioJuego) +
							   getString(R.string.simbolo_euro);
		if(radioButtonSocio.isChecked()){
			precioJuego = precioJuego / 1.15f;
			mensajePrecio = getString(R.string.n15_descuento) + "\n" + dm.format(precioJuego) +
							getString(R.string.simbolo_euro);
		}
		textViewPrecioMostrar.setText(mensajePrecio);
	}

	public void checkeoEsSocio(View view){
		actualizarPrecioJuego();
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent){
	}

	private ArrayAdapter<String> configurarAdaptadoresSpinnerInmutable(Spinner spinner,
																	   String[] contenido){
		ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_cerrado,
				contenido);
		adapter.setDropDownViewResource(R.layout.spinner_desplegado);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(this);
		return adapter;
	}

	private ArrayAdapter<String> configurarAdaptadoresSpinnerMutable(Spinner spinner){
		ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_cerrado);
		adapter.setDropDownViewResource(R.layout.spinner_desplegado);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(this);
		return adapter;
	}

	public void irSiguiente(View view){
		boolean hayErrores = false;
		if(!checkBoxCondiciones.isChecked()){
			hayErrores = true;
			Toast.makeText(this, getString(R.string.debe_aceptar_condiciones), Toast.LENGTH_SHORT).show();
		}
		String nombreUsuario = String.valueOf(editTextNombreUsuario.getText());
		if(nombreUsuario.isEmpty()){
			hayErrores = true;
			editTextNombreUsuario.setError(getString(R.string.nombre_no_puede_estar_vacio));
		}
		if(String.valueOf(editTextPasswordUsuario.getText()).isEmpty()){
			hayErrores = true;
			editTextPasswordUsuario.setError(getString(R.string.contrasena_no_puede_estar_vacia));
		}
		String cantidad = String.valueOf(editTextCantidad.getText());
		if(cantidad.isEmpty()){
			hayErrores = true;
			editTextCantidad.setError(getString(R.string.cantidad_no_puede_estar_vacia));
		}
		String fechaEntrega = String.valueOf(editTextFechaEntrega.getText());
		if(fechaEntrega.isEmpty()){
			hayErrores = true;
			editTextFechaEntrega.setError(getString(R.string.debe_introducir_fecha));
		}
		String horaEntrega = String.valueOf(editTextHoraEntrega.getText());
		if(horaEntrega.isEmpty()){
			hayErrores = true;
			editTextHoraEntrega.setError(getString(R.string.debe_introducir_hora));
		}
		if(!hayErrores){
			compra = new Compra(nombreUsuario, String.valueOf(spinnerPlataforma.getSelectedItem())
					, String.valueOf(spinnerGenero.getSelectedItem()),
					juegoPrecioPortada.getNombreJuego(), juegoPrecioPortada.getPrecioJuego(),
					Integer.parseInt(cantidad), fechaEntrega, horaEntrega,
					radioButtonSocio.isChecked());
			Intent intent = new Intent(this, SecondActivity.class);
			intent.putExtra(PRIMER_ACTIVITY_COMPRA, compra);
			intent.putExtra(IDIOMA, locale);
			startActivity(intent);
		}
	}

	public void mostrarCalendario(View view){
		DatePickerFragment dpf = new DatePickerFragment();
		dpf.show(getSupportFragmentManager(), "DatePicker");
	}

	public void crearFecha(int year, int month, int dayOfMonth){
		String fecha = dayOfMonth + "/" + (month + 1) + "/" + year;
		editTextFechaEntrega.setText(fecha);
	}

	public void mostarHora(View view){
		TimePickerFragment tpf = new TimePickerFragment();
		tpf.show(getSupportFragmentManager(), "TimePicker");
	}

	public void crearHora(int hourOfDay, int minute){
		String horas = hourOfDay < 10 ? "0" + hourOfDay : "" + hourOfDay;
		String minutos = minute < 10 ? "0" + minute : "" + minute;
		String hora = horas + ":" + minutos;
		if(hourOfDay < 12){
			hora += " AM";
		}else{
			hora += " PM";
		}
		editTextHoraEntrega.setText(hora);
	}
}

















