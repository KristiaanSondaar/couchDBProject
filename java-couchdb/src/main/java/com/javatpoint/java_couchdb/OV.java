package com.javatpoint.java_couchdb;

import java.util.ArrayList;
import java.util.List;

public class OV {
	private String kaartnummer;
	private String geldigtot;
	private String klasse;
	private String saldo;
	private String reizigerid;
	public static List<OV> alleOVkaarten = new ArrayList<OV>();

	public OV() {}

	public OV(String kaartnummer, String geldigtot, String klasse, String saldo, String reizigerid) {
		super();
		this.kaartnummer = kaartnummer;
		this.geldigtot = geldigtot;
		this.klasse = klasse;
		this.saldo = saldo;
		this.reizigerid = reizigerid;
		alleOVkaarten.add(this);
	}

	public String getKaartnummer() {
		return kaartnummer;
	}

	public void setKaartnummer(String kaartnummer) {
		this.kaartnummer = kaartnummer;
	}

	public String getGeldigtot() {
		return geldigtot;
	}

	public void setGeldigtot(String geldigtot) {
		this.geldigtot = geldigtot;
	}

	public String getKlasse() {
		return klasse;
	}

	public void setKlasse(String klasse) {
		this.klasse = klasse;
	}

	public String getSaldo() {
		return saldo;
	}

	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}

	public String getReizigerid() {
		return reizigerid;
	}

	public void setReizigerid(String reizigerid) {
		this.reizigerid = reizigerid;
	}
	
	public List<OV> getAlleOVkaarten() {
		return alleOVkaarten;
	}

	public void setAlleOVkaarten(List<OV> alleOVkaarten) {
		this.alleOVkaarten = alleOVkaarten;
	}
}
