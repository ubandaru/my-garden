package com.gardenapp.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class PlantsDao {

	public List<Plant> getPlants(ServletContext sc) {
		
		
		List<Plant> plants = new ArrayList<Plant>();
		try {
			/*FileReader fr = new FileReader(new File(sc.getRealPath("files/plants.txt")));
			BufferedReader br = new BufferedReader(fr);
			plantNames = (ArrayList<String>) br.lines().collect(Collectors.toList());
			br.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			return plantNames;
		}*/
			MongoClient mongo = (MongoClient) sc.getAttribute("mongoclient");
			DB db = mongo.getDB("umadb");
			DBCollection plantsCollection = db.getCollection("plants");
			
			BasicDBObject whereQuery = new BasicDBObject();
			whereQuery.put("Zone", "9B");
			DBCursor cursor = plantsCollection.find(whereQuery);
			
			
			while (cursor.hasNext()) {
				DBObject plantDb = cursor.next();
				PlantConverter plantConverter = new PlantConverter();
				Plant thisPlant = plantConverter.getPlant(plantDb);
				plants.add(thisPlant);
			}
					
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			return plants;
		}
	}
}
