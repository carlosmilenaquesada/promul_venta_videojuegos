package com.example.promul_venta_videojuegos;

import static com.example.promul_venta_videojuegos.MainActivity.PRIMER_ACTIVITY_COMPRA;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity{
	TextView textViewSecondNombreClienteMostrar;
	TextView textViewSecondPlataformaMostrar;
	TextView textViewSecondGeneroMostrar;
	TextView textViewSecondTituloMostrar;
	TextView textViewSecondCantidadMostrar;
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
		textViewSecondCantidadMostrar = findViewById(R.id.textViewSecondCantidadMostrar);
		compra = (Compra) intent.getSerializableExtra(PRIMER_ACTIVITY_COMPRA);

		textViewSecondNombreClienteMostrar.setText(compra.getNombreUsuario());
		Log.d("vacio", "1");
		textViewSecondPlataformaMostrar.setText(compra.getPlataforma());
		Log.d("vacio", "2");
		textViewSecondGeneroMostrar.setText(compra.getGenero());
		Log.d("vacio", "3");
		textViewSecondTituloMostrar.setText(compra.getTitulo());
		Log.d("vacio", "4");
		textViewSecondCantidadMostrar.setText(String.valueOf(compra.getCantidad()));
		Log.d("vacio", "5");

	}
}