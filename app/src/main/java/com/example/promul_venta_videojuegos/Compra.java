package com.example.promul_venta_videojuegos;

import java.io.Serializable;

public class Compra implements Serializable{
	String nombreUsuario;
	String plataforma;
	String genero;
	String titulo;
	int cantidad;
	String fecha;
	String hora;
	boolean esSocio;

	public Compra(String nombreUsuario, String plataforma, String genero, String titulo,
				  int cantidad, String fecha, String hora, boolean esSocio){
		this.nombreUsuario = nombreUsuario;
		this.plataforma = plataforma;
		this.genero = genero;
		this.titulo = titulo;
		this.cantidad = cantidad;
		this.fecha = fecha;
		this.hora = hora;
		this.esSocio = esSocio;
	}
}
