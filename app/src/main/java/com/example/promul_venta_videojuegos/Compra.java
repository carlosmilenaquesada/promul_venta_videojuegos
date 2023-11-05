package com.example.promul_venta_videojuegos;

import java.io.Serializable;

public class Compra implements Serializable{
	String nombreUsuario;
	String plataforma;
	String genero;
	String titulo;
	int cantidad;
	boolean esSocio;

	public Compra(String nombreComprador, String plataforma, String genero, String titulo,
				  int cantidad, boolean esSocio){
		this.nombreUsuario = nombreComprador;
		this.plataforma = plataforma;
		this.genero = genero;
		this.titulo = titulo;
		this.cantidad = cantidad;
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

	public int getCantidad(){
		return cantidad;
	}

	public void setCantidad(int cantidad){
		this.cantidad = cantidad;
	}

	public boolean isEsSocio(){
		return esSocio;
	}

	public void setEsSocio(boolean esSocio){
		this.esSocio = esSocio;
	}

	@Override
	public String toString(){
		return "Compra{" + "nombreUsuario='" + nombreUsuario + '\'' + '}';
	}
}
