package com.example.promul_venta_videojuegos;

public class SimuladorBaseDeDatos{
	public static class JuegoPrecioPortada{
		private String nombreJuego;
		private float precioJuego;

		private int portadaId;

		public JuegoPrecioPortada(){
		}

		public JuegoPrecioPortada(String nombreJuego, float precioJuego, int portadaId){
			this.nombreJuego = nombreJuego;
			this.precioJuego = precioJuego;
			this.portadaId = portadaId;
		}

		public String getNombreJuego(){
			return nombreJuego;
		}

		public void setNombreJuego(String nombreJuego){
			this.nombreJuego = nombreJuego;
		}

		public float getPrecioJuego(){
			return precioJuego;
		}

		public void setPrecioJuego(float precioJuego){
			this.precioJuego = precioJuego;
		}

		public int getPortadaId(){
			return portadaId;
		}

		public void setPortadaId(int portadaId){
			this.portadaId = portadaId;
		}
	}

	public static final JuegoPrecioPortada[][] listaPs5 = {
			new JuegoPrecioPortada[]{new JuegoPrecioPortada("God of War: Ragnarok", 19.32f, R.drawable.gowragnarok),
					new JuegoPrecioPortada("Horizon Call of the Mountain", 27.89f),
					new JuegoPrecioPortada("Stray", 53.71f)},
			new JuegoPrecioPortada[]{new JuegoPrecioPortada("NBA 2K23", 39.68f),
					new JuegoPrecioPortada("FIFA 23", 14.52f), new JuegoPrecioPortada("PGA TOUR 2K23", 62.45f)},
			new JuegoPrecioPortada[]{new JuegoPrecioPortada("CRUSADER KINGS III", 31.77f),
					new JuegoPrecioPortada("MINECRAFT LEGENDS", 48.99f),
					new JuegoPrecioPortada("TWO POINT CAMPUS", 12.46f)}};
	public static final JuegoPrecioPortada[][] listaXBoxSeries = {
			new JuegoPrecioPortada[]{new JuegoPrecioPortada("DYING LIGHT 2: STAY HUMAN", 35.18f),
					new JuegoPrecioPortada("RESIDENT EVIL 4 REMAKE", 10.23f),
					new JuegoPrecioPortada("FAR CRY 6", 56.87f)},
			new JuegoPrecioPortada[]{new JuegoPrecioPortada("EA SPORTS FC 24", 21.94f),
					new JuegoPrecioPortada("RIDERS REPUBLIC", 44.12f),
					new JuegoPrecioPortada("NBA 2K23", 13.75f)},
			new JuegoPrecioPortada[]{new JuegoPrecioPortada("AGE OF EMPIRES II DEFINITIVE EDITION", 23.67f),
					new JuegoPrecioPortada("JURASSIC WORLD EVOLUTION 2", 67.04f),
					new JuegoPrecioPortada("CRUSADER KINGS III", 29.91f)}};
	public static final JuegoPrecioPortada[][] listaNintendoSwitch = {
			new JuegoPrecioPortada[]{new JuegoPrecioPortada("BAYONETTA 3", 62.63f),
					new JuegoPrecioPortada("MONSTER HUNTER RISE", 17.49f),
					new JuegoPrecioPortada("BAYONETTA 2", 42.14f)},
			new JuegoPrecioPortada[]{new JuegoPrecioPortada("CAPTAIN TSUBASA: RISE OF NEW CHAMPIONS", 53.27f),
					new JuegoPrecioPortada("MARIO STRIKERS BATTLE LEAGUE FOOTBALL", 26.88f),
					new JuegoPrecioPortada("MARIO TENNIS ACES", 58.29f)},
			new JuegoPrecioPortada[]{new JuegoPrecioPortada("PIKMIN 4", 33.75f),
					new JuegoPrecioPortada("KINGDOM MAJESTIC", 11.34f),
					new JuegoPrecioPortada("MARIO + RABBIDS: SPARKS OF HOPE", 49.63f)}};
	public static final String[] listaPlataformas = {"PlayStation 5", "XBOX Series",
			"Nintendo Switch"};
	public static final String[] listaGeneros = {"Acción", "Deportivo", "Estrategia"};
	public static final Object[] listaJuegos = {listaPs5, listaXBoxSeries, listaNintendoSwitch};
}
