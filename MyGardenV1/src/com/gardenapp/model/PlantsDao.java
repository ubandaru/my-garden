package com.gardenapp.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;

public class PlantsDao {

	public List<String> getPlants(ServletContext sc) {
		
		ArrayList<String> plantNames = new ArrayList<String>();
		
		try {
			FileReader fr = new FileReader(new File(sc.getRealPath("files/plants.txt")));
			BufferedReader br = new BufferedReader(fr);
			plantNames = (ArrayList<String>) br.lines().collect(Collectors.toList());
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			return plantNames;
		}
	}
}
