package com.javatpoint.java_couchdb;

import java.io.IOException;
import java.net.MalformedURLException;  
	import org.ektorp.CouchDbConnector;  
	import org.ektorp.CouchDbInstance;  
	import org.ektorp.http.HttpClient;  
	import org.ektorp.http.StdHttpClient;  
	import org.ektorp.impl.StdCouchDbConnector;  
	import org.ektorp.impl.StdCouchDbInstance;  
	import org.ektorp.support.DesignDocument;
import org.json.JSONArray;
import org.json.JSONObject;  
public class Main {  
public static void main(String[] args) throws IOException {  
		OVCouchDao ovdao = new OVCouchDaoImpl();
		ReizigerCouchDao rdao = new ReizigerCouchDaoImpl();
//		
//		ovdao.createDocument();
//		rdao.createDocument();
//		
//		Reiziger r1 = new Reiziger("000001", "K", "", "Keesen", "29-10-1995");
//		Reiziger r2 = new Reiziger("000002", "S", "", "Jansen", "29-10-1990");
//		Reiziger r3 = new Reiziger("000003", "T", "", "Gerritsen", "29-10-1981");
//		Reiziger r4 = new Reiziger("000004", "R", "", "Klaasen", "29-10-1900");
//		OV ov1 = new OV("1", "29-05-2019", "2", "25,00", "0001");
//		OV ov2 = new OV("2", "29-05-2019", "2", "25,00", "0002");
//		OV ov3 = new OV("3", "29-05-2019", "2", "25,00", "0003");
//		OV ov4 = new OV("4", "29-05-2019", "2", "25,00", "0003");
//		rdao.addDocument(r1);
//		rdao.addDocument(r2);
//		rdao.addDocument(r3);
//		rdao.addDocument(r4);
//		ovdao.addDocument(ov1);
//		ovdao.addDocument(ov2);
//		ovdao.addDocument(ov3);
//		ovdao.addDocument(ov4);
				
		Reiziger r1 = rdao.read("000001");
		Reiziger r2 = rdao.read("000003");
		
		System.out.println("Kaarten van Reiziger: "+r1.getReizigerID());
		for(OV ovkaart : r1.getOvKaarten()) {
			System.out.println(ovkaart.getKaartnummer());
		}
		
		System.out.println("-------------------------------------------------\n\n");
		
		System.out.println("Kaarten van Reiziger: "+r2.getReizigerID());
		for(OV ovkaart : r2.getOvKaarten()) {
			System.out.println(ovkaart.getKaartnummer());
		}	
	}
}