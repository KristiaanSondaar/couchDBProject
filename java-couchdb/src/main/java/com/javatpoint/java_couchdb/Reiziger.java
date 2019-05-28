package com.javatpoint.java_couchdb;

import java.util.ArrayList;
import java.util.List;

public class Reiziger {
	private String reizigerID;
	private String voorletters;
	private String tussenvoegsel;
	private String achternaam;
	private String geboortedatum;
	private List<OV> ovKaarten = new ArrayList<OV>();
	public List<Reiziger> alleReizigers = new ArrayList<Reiziger>();

	public Reiziger() {};

	public Reiziger(String reizigerID, String voorletters, String tussenvoegsel, String achternaam,
			String geboortedatum) {
		super();
		this.reizigerID = reizigerID;
		this.voorletters = voorletters;
		this.tussenvoegsel = tussenvoegsel;
		this.achternaam = achternaam;
		this.geboortedatum = geboortedatum;
		alleReizigers.add(this);
	}

	public String getReizigerID() {
		return reizigerID;
	}

	public void setReizigerID(String reizigerID) {
		this.reizigerID = reizigerID;
	}

	public String getVoorletters() {
		return voorletters;
	}

	public void setVoorletters(String voorletters) {
		this.voorletters = voorletters;
	}

	public String getTussenvoegsel() {
		return tussenvoegsel;
	}

	public void setTussenvoegsel(String tussenvoegsel) {
		this.tussenvoegsel = tussenvoegsel;
	}

	public String getAchternaam() {
		return achternaam;
	}

	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}

	public String getGeboortedatum() {
		return geboortedatum;
	}

	public void setGeboortedatum(String geboortedatum) {
		this.geboortedatum = geboortedatum;
	}

	public List<OV> getOvKaarten() {
		return ovKaarten;
	}

	public void setOvKaarten(List<OV> ovKaarten) {
		this.ovKaarten = ovKaarten;
	};
	
	
}
