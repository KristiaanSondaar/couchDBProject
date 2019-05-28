package com.javatpoint.java_couchdb;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

public class OVCouchDaoImpl extends CouchBaseDao implements OVCouchDao {
	final String url = "http://admin:admin@localhost:5984/";
	final int count = 3;

	public void createDocument() {
		System.out.println("Creating Document OV...");
		Response r = ClientBuilder.newClient().target(url).path("ov").request().accept(MediaType.APPLICATION_JSON_TYPE)
				.put(Entity.form(new Form()));
		if (!r.getStatusInfo().getFamily().equals(Response.Status.Family.SUCCESSFUL)) {
			throw new RuntimeException("Failed to create document storage: " + r.getStatusInfo().getReasonPhrase());
		}
	}

	public void addDocument(OV ov) {
		System.out.println("OV document store created. Adding a OV...");
		String strbuilder = "{\n" + "   \"geldigtot\": \"" + ov.getGeldigtot() + "\",\n" + "   \"klasse\": \""
				+ ov.getKlasse() + "\",\n" + "   \"saldo\": \"" + ov.getSaldo() + "\",\n" + "   \"reizigerid\": \""
				+ ov.getReizigerid() + "\"\n" + "}";

		Response r = ClientBuilder.newClient().target(url).path("ov").path(ov.getReizigerid())
				.request(MediaType.APPLICATION_JSON_TYPE).put(Entity.text(strbuilder));
		if (!r.getStatusInfo().getFamily().equals(Response.Status.Family.SUCCESSFUL)) {
			throw new RuntimeException(
					"Failed to create ov document in the store: " + r.getStatusInfo().getReasonPhrase());
		}
	}

	public OV read(String id) {
		System.out.println("Reading the OV from the library...");
		Response r = ClientBuilder.newClient().target(url).path("ov").path(id)
				.request(MediaType.APPLICATION_JSON_TYPE).get();
		if (!r.getStatusInfo().getFamily().equals(Response.Status.Family.SUCCESSFUL)) {
			throw new RuntimeException(
					"Failed to read the ov document from the data store: " + r.getStatusInfo().getReasonPhrase());

		}
		String ec = r.readEntity(String.class);
		System.out.println(ec);
		JSONObject jobject = new JSONObject(ec);
		ReizigerCouchDao rdao = new ReizigerCouchDaoImpl();
		OV ovkaart = new OV(jobject.getString("_id"), jobject.getString("geldigtot"),
				jobject.getString("klasse"), jobject.getString("saldo"),
				jobject.getString("reizigerid"));
		return ovkaart;
	}
	
	public int getRows() {
		System.out.println("Reading the OV_rows from the library...");
		Response r = ClientBuilder.newClient().target(url).path("ov")
				.request(MediaType.APPLICATION_JSON_TYPE).get();
		if (!r.getStatusInfo().getFamily().equals(Response.Status.Family.SUCCESSFUL)) {
			throw new RuntimeException(
					"Failed to read the ov document from the data store: " + r.getStatusInfo().getReasonPhrase());
		}
		String ec = r.readEntity(String.class);
		JSONObject jobject = new JSONObject(ec);
		return jobject.getInt("doc_count");
	}
	
	public List<OV> getKaartenVanReiziger(String id) {
		List<OV> kaarten = new ArrayList<OV>();
		for(int i=0; i<getRows();i++) {
			OV newOV = read("000"+String.valueOf(i+1));
			if(newOV.getReizigerid().equals(id)) {
				System.out.println("reached");
				kaarten.add(newOV);
			}
		}
		return kaarten;
	}

//	public void deleteDocument(OV ov) {
//		System.out.println("Deleting reiziger with id: "+ov.getKaartnummer());
//        Response r = ClientBuilder.newClient().target(url).path("ov").path(ov.getKaartnummer()).queryParam("rev", secBook.getStringValue("_rev")).request().buildDelete().invoke();
//        if (!r.getStatusInfo().getFamily().equals(Response.Status.Family.SUCCESSFUL)) {
//            throw new RuntimeException("Failed to delete book document in the data store: " + r.getStatusInfo().getReasonPhrase());
//        }
//	}
}
