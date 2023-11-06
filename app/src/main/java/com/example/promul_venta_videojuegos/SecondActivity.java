package com.example.promul_venta_videojuegos;

import static com.example.promul_venta_videojuegos.MainActivity.PRIMER_ACTIVITY_COMPRA;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity{
	TextView textViewSecondNombreClienteMostrar;
	TextView textViewSecondPlataformaMostrar;
	TextView textViewSecondGeneroMostrar;
	TextView textViewSecondTituloMostrar;
	TextView textViewSecondFechaYHoraMostrar;
	TextView textViewSecondPrecioUnidadMostrar;
	TextView textViewSecondEsSocioMostrar;
	//----------------------------------------------------------------------------------------------
	TextView textViewSecondCantidadMostrar;
	TextView textViewSecondPrecioUnidadSinIvaMostrar; //(Precio unidad / 1.21)
	TextView textViewSecondDescuentoMostrar; //(%descuento * (cantidad * (Precio unidad - %IVA)))
	//----------------------------------------------------------------------------------------------
	TextView textViewSecondSubtotalMostrar;// (cantidad * (Precio unidad - IVA)) - totaldescuento
	TextView textViewSecondIvaMostrar;//cantidad de IVA
	TextView textViewSecondTotalAPagarMostrar;//Total a pagar
	Compra compra;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		Intent intent = getIntent();
		if(intent == null){
			this.finishAffinity();
		}
		textViewSecondNombreClienteMostrar = findViewById(R.id.textViewSecondNombreClienteMostrar);
		textViewSecondPlataformaMostrar = findViewById(R.id.textViewSecondPlataformaMostrar);
		textViewSecondGeneroMostrar = findViewById(R.id.textViewSecondGeneroMostrar);
		textViewSecondTituloMostrar = findViewById(R.id.textViewSecondTituloMostrar);
		textViewSecondFechaYHoraMostrar = findViewById(R.id.textViewSecondFechaYHoraMostrar);
		textViewSecondPrecioUnidadMostrar = findViewById(R.id.textViewSecondPrecioUnidadMostrar);
		textViewSecondEsSocioMostrar = findViewById(R.id.textViewSecondEsSocioMostrar);
		//------------------------------------------------------------------------------------------
		textViewSecondCantidadMostrar = findViewById(R.id.textViewSecondCantidadMostrar);
		textViewSecondPrecioUnidadSinIvaMostrar =
				findViewById(R.id.textViewSecondPrecioUnidadSinIvaMostrar);
		textViewSecondDescuentoMostrar = findViewById(R.id.textViewSecondDescuentoMostrar);
		//------------------------------------------------------------------------------------------
		textViewSecondSubtotalMostrar = findViewById(R.id.textViewSecondSubtotalMostrar);
		textViewSecondIvaMostrar = findViewById(R.id.textViewSecondIvaMostrar);
		textViewSecondTotalAPagarMostrar = findViewById(R.id.textViewSecondTotalAPagarMostrar);
		//------------------------------------------------------------------------------------------
		compra = (Compra) intent.getSerializableExtra(PRIMER_ACTIVITY_COMPRA);
		textViewSecondNombreClienteMostrar.setText(compra.getNombreUsuario());
		textViewSecondPlataformaMostrar.setText(compra.getPlataforma());
		textViewSecondGeneroMostrar.setText(compra.getGenero());
		textViewSecondTituloMostrar.setText(compra.getTitulo());
		textViewSecondFechaYHoraMostrar.setText(compra.getFecha() + " " + compra.getHora());
		textViewSecondPrecioUnidadMostrar.setText(String.valueOf(compra.getPrecioUnidad()));
		String esSocio = compra.getEsSocio() ? "Sí: 15% Dto." : "No: Sin descuento";
		textViewSecondEsSocioMostrar.setText(esSocio);
		//------------------------------------------------------------------------------------------
		textViewSecondCantidadMostrar.setText(String.valueOf(compra.getCantidad()));
		float precioUdSinIVa =
				Float.parseFloat((String) textViewSecondPrecioUnidadMostrar.getText()) / 1.21f;
		textViewSecondPrecioUnidadSinIvaMostrar.setText(String.valueOf(precioUdSinIVa));
		float subtotalSinIva = compra.getCantidad() * precioUdSinIVa;
		float descuento = compra.getEsSocio() ? 0.15f * subtotalSinIva : 0f;
		textViewSecondDescuentoMostrar.setText(String.valueOf(descuento));
		float subtotalMenosDescuento = subtotalSinIva - descuento;
		textViewSecondSubtotalMostrar.setText(String.valueOf(subtotalMenosDescuento));
		float importeIva = subtotalMenosDescuento * 0.21f;
		textViewSecondIvaMostrar.setText(String.valueOf(importeIva));
		float totalAPagar = subtotalMenosDescuento * 1.21f;
		textViewSecondTotalAPagarMostrar.setText(String.valueOf(totalAPagar));
	}
}