package com.javatpoint.java_couchdb;

import java.io.StringReader;

import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

public class ReizigerCouchDaoImpl extends CouchBaseDao implements ReizigerCouchDao{
	final String url = "http://admin:admin@localhost:5984/";

	public void createDocument() {
		System.out.println("Creating Document Reiziger...");
        Response r = ClientBuilder.newClient().target(url).path("reiziger").request().accept(MediaType.APPLICATION_JSON_TYPE).put(Entity.form(new Form()));
        if (!r.getStatusInfo().getFamily().equals(Response.Status.Family.SUCCESSFUL)) {
            throw new RuntimeException("Failed to create document storage: " + r.getStatusInfo().getReasonPhrase());
        }
	}
	
	public void addDocument(Reiziger rei) {
		System.out.println("Reiziger document store created. Adding a Reiziger...");
        Response r = ClientBuilder.newClient().target(url).path("reiziger").path(rei.getReizigerID()).request(MediaType.APPLICATION_JSON_TYPE).put(Entity.text("{\n" +
                "   \"achternaam\": \""+rei.getAchternaam()+"\",\n" +
                "   \"voorletters\": \""+rei.getVoorletters()+"\",\n" +
                "   \"tussenvoegsel\": \""+rei.getTussenvoegsel()+"\",\n" +
                "   \"geboortedatum\": \""+rei.getGeboortedatum()+"\"\n" +
                "}"));
        if (!r.getStatusInfo().getFamily().equals(Response.Status.Family.SUCCESSFUL)) {
            throw new RuntimeException("Failed to create reiziger document in the store: " + r.getStatusInfo().getReasonPhrase());
        }
	}
	
	public Reiziger read(String id) {
		OVCouchDao ovdao = new OVCouchDaoImpl();
        System.out.println("Reading the Reiziger from the library...");
        Response r = ClientBuilder.newClient().target(url).path("reiziger").path(id).request(MediaType.APPLICATION_JSON_TYPE).get();
        if (!r.getStatusInfo().getFamily().equals(Response.Status.Family.SUCCESSFUL)) {
            throw new RuntimeException("Failed to read the book document from the data store: " + r.getStatusInfo().getReasonPhrase());

        }
        String ec = r.readEntity(String.class);
        System.out.println(ec);
        JSONObject jobject = new JSONObject(ec);
        Reiziger reiziger = new Reiziger(jobject.getString("_id"), jobject.getString("achternaam"), jobject.getString("voorletters"), jobject.getString("tussenvoegsel"), jobject.getString("geboortedatum"));
        reiziger.setOvKaarten(ovdao.getKaartenVanReiziger(jobject.getString("_id")));
        return reiziger;
    }
	
//	public void deleteDocument(Reiziger rei) {
//		System.out.println("Deleting reiziger with id: "+rei.getReizigerID());
//        Response r = ClientBuilder.newClient().target(url).path("reiziger").path(rei.getReizigerID()).queryParam("rev", secBook.getStringValue("_rev")).request().buildDelete().invoke();
//        if (!r.getStatusInfo().getFamily().equals(Response.Status.Family.SUCCESSFUL)) {
//            throw new RuntimeException("Failed to delete book document in the data store: " + r.getStatusInfo().getReasonPhrase());
//        }
//	}
}
