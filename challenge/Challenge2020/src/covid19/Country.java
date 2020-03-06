package covid19;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;



public class Country {
	private static class CovidReport {
		String date;
		int numCases;
		
		public CovidReport(String date, int numCases){
			this.date = date;
			this.numCases = numCases;
		}
		String getDate() {
			return this.date;
		}
		int getNumCases() {
			return this.numCases;
		}
	}
	
	private String countryName; 
	private int population;
	private ArrayList <CovidReport> covidCase;
	private int numCovidCases;
	private double infectionRate;
	private int numDeath;
	private double deathRate;
	
	
	public Country(String name,int population) {
		this.countryName = name;
		this.population = population;
		this.covidCase = new ArrayList<>();
		this.numCovidCases = 0;
		this.numDeath = 0;
		this.infectionRate = 0.0;
		this.deathRate = 0.0;
	}


	public String getCountryName() {
		return countryName;
	}


	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}


	public int getPopulation() {
		return population;
	}


	public void setPopulation(int population) {
		this.population = population;
	}


	public ArrayList<CovidReport> getCovidCase() {
		return covidCase;
	}


	public int getNumCovidCases() {
		return numCovidCases;
	}


	public void setNumCovidCases(int numCovidCases) {
		this.numCovidCases = numCovidCases;
	}

	public double getInfectionRate() {
		return this.infectionRate;
	}
	public double getDeathRate() {
		return this.deathRate;
	}
	public int getNumDeath() {
		return numDeath;
	}
	
	public void addCovidCase(String date, int numCases) {
		this.numCovidCases += numCases;
		this.infectionRate = (double)this.getNumCovidCases()/(double)this.getPopulation();
		this.getCovidCase().add(new CovidReport(date, numCases));
	}
	
	public void addNumDeaths(int death) {
		this.numDeath += death;
		this.deathRate = (double)this.getNumDeath()/(double)this.getNumCovidCases();
		
	}

	public void setNumDeath(int numDeath) {
		this.numDeath = numDeath;
	}

	public static void main(String[] args) {
//		Country Ghana = new Country("Ghana",28569569);
//		Ghana.addCovidCase("27/03/20", 8);
//		Ghana.addCovidCase("27/03/20", 89);
//		Ghana.addNumDeaths(50);
////		Ghana.getNumDeath();
//		System.out.println("This is the death rate: "+ Ghana.getDeathRate());
//		System.out.println("This is the death number: "+ Ghana.getNumDeath());
		String filename;
        Hashtable<String,Country>record;
        
            filename = "/home/hussein/Desktop/Challenge/challenge/population_data.csv";
            record = new Hashtable<>(21320);
                try{
                    Scanner scanIn = new Scanner(new BufferedReader(new FileReader(filename)));
                    scanIn.nextLine();
                    while(scanIn.hasNextLine()){
                        String[] data = scanIn.nextLine().split(",");
                        try {
                        record.put(data[0],new Country(data[0],Integer.parseInt(data[2])));
                        }catch(Exception e) {
                        	System.out.println("-------------");
                        	if(data.length==5) {
                        		record.put(data[0],new Country(data[0],Integer.parseInt(data[data.length-2])));
                        		
                        		System.out.println(data[data.length-2]);
                        	}
                        		
//                        	System.out.println(data.length);
                        	System.out.println("-------------");
                        	continue;
                        }
                    }   
                    scanIn.close();
                }catch(FileNotFoundException e){
                    e.printStackTrace();
                }
            
		
		
	
	}
	
}
