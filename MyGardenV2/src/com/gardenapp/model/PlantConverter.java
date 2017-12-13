package com.gardenapp.model;

import com.mongodb.DBObject;

public class PlantConverter {
	
	public Plant getPlant(DBObject dbobj) {
		Plant p = new Plant();
		p.setName((String) dbobj.get("name"));
		p.setHeight((Double) dbobj.get("height"));
		p.setZone((String) dbobj.get("zone"));
		
		return p;
	}

}
