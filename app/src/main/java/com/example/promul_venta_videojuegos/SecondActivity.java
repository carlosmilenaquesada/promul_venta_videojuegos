package com.example.promul_venta_videojuegos;

import static com.example.promul_venta_videojuegos.MainActivity.IDIOMA;
import static com.example.promul_venta_videojuegos.MainActivity.PRIMER_ACTIVITY_COMPRA;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Locale;

public class SecondActivity extends AppCompatActivity{
	TextView nombreClienteMostrar;
	TextView plataformaMostrar;
	TextView generoMostrar;
	TextView tituloMostrar;
	TextView fechaYHoraMostrar;
	TextView precioUnidadMostrar;
	TextView esSocioMostrar;
	//----------------------------------------------------------------------------------------------
	TextView cantidadMostrar;
	TextView precioUnidadSinIvaMostrar;
	TextView descuentoMostrar;
	//----------------------------------------------------------------------------------------------
	TextView subtotalMostrar;
	TextView ivaMostrar;
	TextView totalAPagarMostrar;
	RadioGroup radioGroupPagar;
	Compra compra;
	//----------------------------------------------------------------------------------------------
	float precioUdSinIVa = 0.0f;
	float subtotalSinIva = 0.0f;
	float descuento = 0.0f;
	float subtotalMenosDescuento = 0.0f;
	float importeIva = 0.0f;
	float totalAPagar = 0.0f;
	DecimalFormat df;

	Locale locale;
	@Override
	protected void onCreate(Bundle savedInstanceState){

		Intent intent = getIntent();
		if(intent != null){
			//Establecer el mismo idioma que en el MainActivity
			locale = (Locale) intent.getSerializableExtra(IDIOMA);
			getResources().getConfiguration().setLocale(locale);
			getResources().updateConfiguration(getResources().getConfiguration(), getResources().getDisplayMetrics());
			//El idioma no puede establcerse a través del savedInstanceState, debe guardarse en una
			//variable Locale, y ser cargado manualmente. Tras la carga, es necesario repintar el activity,
			//por eso pongo el onCreate justo después, para aprovechar el re-cargado.
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_second);
			nombreClienteMostrar = findViewById(R.id.textViewSecondNombreClienteMostrar);
			plataformaMostrar = findViewById(R.id.textViewSecondPlataformaMostrar);
			generoMostrar = findViewById(R.id.textViewSecondGeneroMostrar);
			tituloMostrar = findViewById(R.id.textViewSecondTituloMostrar);
			fechaYHoraMostrar = findViewById(R.id.textViewSecondFechaYHoraMostrar);
			precioUnidadMostrar = findViewById(R.id.textViewSecondPrecioUnidadMostrar);
			esSocioMostrar = findViewById(R.id.textViewSecondEsSocioMostrar);
			//------------------------------------------------------------------------------------------
			cantidadMostrar = findViewById(R.id.textViewSecondCantidadMostrar);
			precioUnidadSinIvaMostrar = findViewById(R.id.textViewSecondPrecioUnidadSinIvaMostrar);
			descuentoMostrar = findViewById(R.id.textViewSecondDescuentoMostrar);
			//------------------------------------------------------------------------------------------
			subtotalMostrar = findViewById(R.id.textViewSecondSubtotalMostrar);
			ivaMostrar = findViewById(R.id.textViewSecondIvaMostrar);
			totalAPagarMostrar = findViewById(R.id.textViewSecondTotalAPagarMostrar);
			//------------------------------------------------------------------------------------------
			radioGroupPagar = findViewById(R.id.radioGroupPagar);
			//------------------------------------------------------------------------------------------
			rellenarDatosCompra(intent);
			//------------------------------------------------------------------------------------------
			rellenarDesgloseImporte();
		}else{
			//Si el intent está vacío, es que ha ocurrido algún problema en la optención de datos,
			//por lo tanto, finalizo el programa.
			this.finishAffinity();
		}

	}

	@Override
	protected void onSaveInstanceState(@NonNull Bundle outState){
		super.onSaveInstanceState(outState);
		outState.putSerializable("locale", locale);
	}

	private void rellenarDatosCompra(Intent intent){
		compra = (Compra) intent.getSerializableExtra(PRIMER_ACTIVITY_COMPRA);
		df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.UP);
		nombreClienteMostrar.setText(compra.getNombreUsuario());
		plataformaMostrar.setText(compra.getPlataforma());
		generoMostrar.setText(compra.getGenero());
		tituloMostrar.setText(compra.getTitulo());
		String fechaHora = compra.getFecha() + " - " + compra.getHora();
		fechaYHoraMostrar.setText(fechaHora);
		precioUnidadMostrar.setText(df.format(compra.getPrecioUnidad()));
		String esSocio = compra.getEsSocio() ? getString(R.string.si_15_descuento) :
								 getString(R.string.no_sin_descuento);
		esSocioMostrar.setText(esSocio);
	}

	private void rellenarDesgloseImporte(){
		cantidadMostrar.setText(String.valueOf(compra.getCantidad()));
		precioUdSinIVa = Float.parseFloat((String) precioUnidadMostrar.getText()) / 1.21f;
		precioUnidadSinIvaMostrar.setText(df.format(precioUdSinIVa));
		subtotalSinIva = compra.getCantidad() * precioUdSinIVa;
		descuento = compra.getEsSocio() ? 0.15f * subtotalSinIva : 0f;
		descuentoMostrar.setText(df.format(descuento));
		subtotalMenosDescuento = subtotalSinIva - descuento;
		subtotalMostrar.setText(df.format(subtotalMenosDescuento));
		importeIva = subtotalMenosDescuento * 0.21f;
		ivaMostrar.setText(df.format(importeIva));
		totalAPagar = subtotalMenosDescuento * 1.21f;
		totalAPagarMostrar.setText(df.format(totalAPagar));
	}

	public void realizarPago(View view){
		int idSeleccionada = radioGroupPagar.getCheckedRadioButtonId();
		String texto = getString(R.string.debe_elegir_forma_pago);
		if(idSeleccionada == R.id.radioButtonPagoEfectivo){
			texto = getString(R.string.pago_efectivo_entrega);
		}else{
			if(idSeleccionada == R.id.radioButtonTarjeta){
				texto = getString(R.string.pago_con_tarjeta);
			}else{
				if(idSeleccionada == R.id.radioButtonPayPal){
					texto = getString(R.string.pago_con_paypal);
				}
			}
		}
		Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();
	}
}