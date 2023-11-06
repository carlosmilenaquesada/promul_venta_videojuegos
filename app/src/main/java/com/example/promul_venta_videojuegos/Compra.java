package com.example.promul_venta_videojuegos;

import java.io.Serializable;

public class Compra implements Serializable{
	private String nombreUsuario;
	private String plataforma;
	private String genero;
	private String titulo;
	private float precioUnidad;
	private int cantidad;
	private String fecha;
	private String hora;
	private boolean esSocio;

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

	public void setNombreUsuario(String nombreUsuario){
		this.nombreUsuario = nombreUsuario;
	}

	public String getPlataforma(){
		return plataforma;
	}

	public void setPlataforma(String plataforma){
		this.plataforma = plataforma;
	}

	public String getGenero(){
		return genero;
	}

	public void setGenero(String genero){
		this.genero = genero;
	}

	public String getTitulo(){
		return titulo;
	}

	public void setTitulo(String titulo){
		this.titulo = titulo;
	}

	public float getPrecioUnidad(){
		return precioUnidad;
	}

	public void setPrecioUnidad(float precioUnidad){
		this.precioUnidad = precioUnidad;
	}

	public int getCantidad(){
		return cantidad;
	}

	public void setCantidad(int cantidad){
		this.cantidad = cantidad;
	}

	public String getFecha(){
		return fecha;
	}

	public void setFecha(String fecha){
		this.fecha = fecha;
	}

	public String getHora(){
		return hora;
	}

	public void setHora(String hora){
		this.hora = hora;
	}

	public boolean getEsSocio(){
		return esSocio;
	}

	public void setEsSocio(boolean esSocio){
		this.esSocio = esSocio;
	}
}
