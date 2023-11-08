package com.example.promul_venta_videojuegos;

import java.io.Serializable;

public class Compra implements Serializable{
	private final String nombreUsuario;
	private final String plataforma;
	private final String genero;
	private final String titulo;
	private final float precioUnidad;
	private final int cantidad;
	private final String fecha;
	private final String hora;
	private final boolean esSocio;

	public Compra(String nombreUsuario, String plataforma, String genero, String titulo,
				  float precioUnidad, int cantidad, String fecha, String hora, boolean esSocio){
		this.nombreUsuario = nombreUsuario;
		this.plataforma = plataforma;
		this.genero = genero;
		this.titulo = titulo;
		this.precioUnidad = precioUnidad;
		this.cantidad = cantidad;
		this.fecha = fecha;
		this.hora = hora;
		this.esSocio = esSocio;
	}

	public String getNombreUsuario(){
		return nombreUsuario;
	}

	public String getPlataforma(){
		return plataforma;
	}

	public String getGenero(){
		return genero;
	}

	public String getTitulo(){
		return titulo;
	}

	public float getPrecioUnidad(){
		return precioUnidad;
	}

	public int getCantidad(){
		return cantidad;
	}

	public String getFecha(){
		return fecha;
	}

	public String getHora(){
		return hora;
	}

	public boolean getEsSocio(){
		return esSocio;
	}
}
