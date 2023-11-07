package com.example.promul_venta_videojuegos;

import static com.example.promul_venta_videojuegos.MainActivity.PRIMER_ACTIVITY_COMPRA;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

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
		if(intent == null){
			this.finishAffinity();
		}
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
		compra = (Compra) intent.getSerializableExtra(PRIMER_ACTIVITY_COMPRA);
		df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.UP);
		nombreClienteMostrar.setText(compra.getNombreUsuario());
		plataformaMostrar.setText(compra.getPlataforma());
		generoMostrar.setText(compra.getGenero());
		tituloMostrar.setText(compra.getTitulo());
		fechaYHoraMostrar.setText(compra.getFecha() + " " + compra.getHora());
		precioUnidadMostrar.setText(df.format(compra.getPrecioUnidad()));
		String esSocio = compra.getEsSocio() ? "Sí: 15% Dto." : "No: Sin descuento";
		esSocioMostrar.setText(esSocio);
		//------------------------------------------------------------------------------------------

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
}