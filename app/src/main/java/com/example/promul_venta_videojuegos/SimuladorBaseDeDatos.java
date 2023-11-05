package com.example.promul_venta_videojuegos;

public class SimuladorBaseDeDatos{
	public static final String[][] listaPs5 = {
			new String[]{"God of War: Ragnarok", "Horizon Call of the Mountain", "Stray"},
			new String[]{"NBA 2K23", "FIFA 23", "PGA TOUR 2K23"},
			new String[]{"CRUSADER KINGS III", "MINECRAFT LEGENDS", "TWO POINT CAMPUS"}};
	public static final String[][] listaXBoxSeries = {
			new String[]{"DYING LIGHT 2: STAY HUMAN", "RESIDENT EVIL 4 REMAKE", "FAR CRY 6"},
			new String[]{"EA SPORTS FC 24", "RIDERS REPUBLIC", "NBA 2K23"},
			new String[]{"AGE OF EMPIRES II DEFINITIVE EDITION", "JURASSIC WORLD EVOLUTION 2",
					"CRUSADER KINGS III"}};
	public static final String[][] listaNintendoSwitch = {
			new String[]{"BAYONETTA 3", "MONSTER HUNTER RISE", "BAYONETTA 2"},
			new String[]{"CAPTAIN TSUBASA: RISE OF NEW CHAMPIONS",
					"MARIO STRIKERS BATTLE LEAGUE FOOTBALL", "MARIO TENNIS ACES"},
			new String[]{"PIKMIN 4", "KINGDOM MAJESTIC", "MARIO + RABBIDS: SPARKS OF HOPE"}};
	public static final String[] listaPlataformas = {"PlayStation 5", "XBOX Series",
			"Nintendo Switch"};
	public static final String[] listaGeneros = {"Acción", "Deportivo", "Estrategia"};
	public static final Object[] listaJuegos = {listaPs5, listaXBoxSeries, listaNintendoSwitch};
}
