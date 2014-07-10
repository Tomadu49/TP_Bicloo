package com.example.tpbicloo;

public class BikeStation {
	private String nomArret;
	private int nbrPlacesLibres;
	private int nbrPlaces;
	
	
	public BikeStation(String nomArret, int nbrPlacesLibres, int nbrPlaces) {
		this.nomArret = nomArret;
		this.nbrPlacesLibres = nbrPlacesLibres;
		this.nbrPlaces = nbrPlaces;
	}
	
	public String getNomArret() {
		return nomArret;
	}
	public void setNomArret(String nomArret) {
		this.nomArret = nomArret;
	}
	public int getNbrPlacesLibres() {
		return nbrPlacesLibres;
	}
	public void setNbrPlacesLibres(int nbrPlacesLibres) {
		this.nbrPlacesLibres = nbrPlacesLibres;
	}
	public int getNbrPlaces() {
		return nbrPlaces;
	}
	public void setNbrPlaces(int nbrPlaces) {
		this.nbrPlaces = nbrPlaces;
	}
	
	
}
