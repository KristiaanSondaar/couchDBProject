package com.javatpoint.java_couchdb;

import java.util.List;

public interface OVCouchDao {
	public void createDocument();
	public void addDocument(OV ov);
	public OV read(String id);
// 	public void deleteDocument(OV ov);
	public List<OV> getKaartenVanReiziger(String id);
	public int getRows();
}
