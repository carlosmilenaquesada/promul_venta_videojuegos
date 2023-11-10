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

		public float getPrecioJuego(){
			return precioJuego;
		}

		public int getPortadaId(){
			return portadaId;
		}
	}

	public static final JuegoPrecioPortada[][] listaPs5 = {new JuegoPrecioPortada[]{
			new JuegoPrecioPortada("God of War: Ragnarok", 19.32f,
					R.drawable.playstation_gowragnarok),
			new JuegoPrecioPortada("Horizon Call of the Mountain", 27.89f,
					R.drawable.playstation_horizonmontain),
			new JuegoPrecioPortada("Stray", 53.71f, R.drawable.playstation_stray)},
			new JuegoPrecioPortada[]{
					new JuegoPrecioPortada("NBA 2K23", 39.68f, R.drawable.playstation_nba2k23),
					new JuegoPrecioPortada("FIFA 23", 14.52f, R.drawable.playstation_fifa23),
					new JuegoPrecioPortada("PGA TOUR 2K23", 62.45f,
							R.drawable.playstation_pga2k23)},
			new JuegoPrecioPortada[]{
					new JuegoPrecioPortada("CRUSADER KINGS III", 31.77f,
							R.drawable.playstation_crusaderkings3),
					new JuegoPrecioPortada("MINECRAFT LEGENDS", 48.99f,
							R.drawable.playstation_minecraftlegends),
					new JuegoPrecioPortada("TWO POINT CAMPUS", 12.46f,
							R.drawable.playstation_2pointcampus)}};
	public static final JuegoPrecioPortada[][] listaXBoxSeries = {new JuegoPrecioPortada[]{
			new JuegoPrecioPortada("DYING LIGHT 2: STAY HUMAN", 35.18f,
					R.drawable.xbox_dyinglight2),
			new JuegoPrecioPortada("RESIDENT EVIL 4 REMAKE", 10.23f,
					R.drawable.xbox_residentevil4),
			new JuegoPrecioPortada("FAR CRY 6", 56.87f, R.drawable.xbox_farcry6)},
			new JuegoPrecioPortada[]{
					new JuegoPrecioPortada("EA SPORTS FC 24", 21.94f, R.drawable.xbox_fc24),
					new JuegoPrecioPortada("RIDERS REPUBLIC", 44.12f,
							R.drawable.xbox_ridersrepublic),
					new JuegoPrecioPortada("NBA 2K23", 13.75f, R.drawable.xbox_nba2k23)},
			new JuegoPrecioPortada[]{
					new JuegoPrecioPortada("AGE OF EMPIRES II DEFINITIVE EDITION", 23.67f,
							R.drawable.xbox_ageofempire2),
					new JuegoPrecioPortada("JURASSIC WORLD EVOLUTION 2", 67.04f,
							R.drawable.xbox_jurassicworldevo2),
					new JuegoPrecioPortada("CRUSADER KINGS III", 29.91f,
							R.drawable.xbox_crusader_kings3)}};
	public static final JuegoPrecioPortada[][] listaNintendoSwitch = {new JuegoPrecioPortada[]{
			new JuegoPrecioPortada("BAYONETTA 3", 62.63f, R.drawable.nintendo_bayonetta3),
			new JuegoPrecioPortada("MONSTER HUNTER RISE", 17.49f,
					R.drawable.nintendo_monsterhunterrise),
			new JuegoPrecioPortada("BAYONETTA 2", 42.14f, R.drawable.nintendo_bayonetta2)},
			new JuegoPrecioPortada[]{
					new JuegoPrecioPortada("CAPTAIN TSUBASA: RISE OF NEW CHAMPIONS", 53.27f,
							R.drawable.nintendo_captainstsubasa),
					new JuegoPrecioPortada("MARIO STRIKERS BATTLE LEAGUE FOOTBALL", 26.88f,
							R.drawable.nintendo_mariostrike),
					new JuegoPrecioPortada("MARIO TENNIS ACES", 58.29f,
							R.drawable.nintendo_maritennis)},
			new JuegoPrecioPortada[]{
					new JuegoPrecioPortada("PIKMIN 4", 33.75f, R.drawable.nintendo_pikmin4),
					new JuegoPrecioPortada("KINGDOM MAJESTIC", 11.34f,
							R.drawable.nintendo_kindommagestic),
					new JuegoPrecioPortada("MARIO + RABBIDS: SPARKS OF HOPE", 49.63f,
							R.drawable.nintendo_mariorabbids)}};
	public static final String[] listaPlataformas = {"PlayStation 5", "XBOX Series",
			"Nintendo Switch"};
	public static final String[] listaGeneros = {"Acción", "Deportivo", "Estrategia"};
	public static final Object[] listaJuegos = {listaPs5, listaXBoxSeries, listaNintendoSwitch};


}
