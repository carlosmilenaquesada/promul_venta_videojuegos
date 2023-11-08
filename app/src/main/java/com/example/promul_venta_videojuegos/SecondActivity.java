package com.example.promul_venta_videojuegos;

import static com.example.promul_venta_videojuegos.MainActivity.PRIMER_ACTIVITY_COMPRA;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.math.RoundingMode;
import java.text.DecimalFormat;

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

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		Intent intent = getIntent();
		if(intent != null){
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
			this.finishAffinity();
		}
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
		String esSocio = compra.getEsSocio() ? "Sí: 15% Dto." : "No: Sin descuento";
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
		String texto = "Debe elegir una forma de pago";
		if(idSeleccionada == R.id.radioButtonPagoEfectivo){
			texto = "Se ha tramitado el pago en efectivo en la entrega.";
		}else{
			if(idSeleccionada == R.id.radioButtonTarjeta){
				texto = "Se ha tramitado el pago con tarjeta.";
			}else{
				if(idSeleccionada == R.id.radioButtonPayPal){
					texto = "Se ha tramitado el pago con PayPal.";
				}
			}
		}
		Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();
	}
}