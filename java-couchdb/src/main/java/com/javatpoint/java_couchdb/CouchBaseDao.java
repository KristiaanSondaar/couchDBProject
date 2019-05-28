package com.javatpoint.java_couchdb;

import java.net.MalformedURLException;

import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbInstance;

public class CouchBaseDao {
	public CouchDbInstance  getConnection() throws MalformedURLException {
		HttpClient httpClient = new StdHttpClient.Builder().url("http://admin:admin@localhost:5984").build();
		return new StdCouchDbInstance(httpClient);
	}
}
