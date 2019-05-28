package com.javatpoint.java_couchdb;

import javax.json.JsonObject;

public interface ReizigerCouchDao {
	public void createDocument();
	public void addDocument(Reiziger rei);
	public Reiziger read(String id);
//	public void deleteDocument(Reiziger rei);
}

