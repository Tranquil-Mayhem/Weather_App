package weather;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Jamie Gashler
 * 10/11/22 - 10/21/22
 * This is the test program for the Weather211.java
 * This program asks for user input and returns the weather data. 
 * For the city given, if the user input is valid for the city name, 
 * the map type, and the zoom level for the map, then it calls
 * Map211.java to create a new Map with all of the weather info
 */

public class myWeatherApp 
{
	//scans for the user input
	static Scanner consol = new Scanner(System.in);

	//initializes new ArrayList, map type and zoom level for the weather info
	private static ArrayList<String> weatherInfo = new ArrayList<>();
	static String mapType;
	static int zoom;

	public static void main(String[] args) throws Exception 
	{
		//intro	
		System.out.println("Welcome to Weather 211 - Fall 2022");

		System.out.println();

		//calls inputCityName() so that the user can view the weather for the input city
		inputCityName();

		//calls getWeatherInfo() so that the weather information of the city can be passed to the map
		getWeatherInfo();

	}

	public static void inputCityName() throws Exception 
	{
		boolean validCityName = false;
		
		//checks to see if the city name is valid, and if so, continues to the map type and zoom level 
		//if invalid, prints an error message, asks for a new city name
		while (!validCityName) 
		{

			System.out.println("Input a city name:");

			String city = consol.nextLine();

			System.out.println();
			boolean valid = Weather211.CityWeather(city);
		
			if (valid) 
			{
		
				int min = 0; //min zoom level
				int max = 21; //max zoom level
				int mapTypeNumber = 0;
				int zoomNumber = 0;
				boolean roadmapValid = false;
				boolean zoomValid = false;
				
				//asks for map type: either roadmap or satellite
				//if roadmap is valid, the map type is set to the user input, otherwise it prints an error message
				while (!roadmapValid) 
				{
					System.out.println("Select map type: 1) roadmap 2) satellite");
					
					mapTypeNumber = consol.nextInt();
					
					//the two user options are 1 or 2. Nothing else is valid
					if(mapTypeNumber == 1) 
					{
						mapType = "roadmap";
						roadmapValid = true;
					}
					else if (mapTypeNumber == 2)
					{
						mapType = "satellite";
						roadmapValid = true;
					}
					else
					{
						System.out.println("Invalid map type. Type 1 or 2.\n");
					}
				}
				System.out.println();
				
				
				//asks for zoom level 0 - 21 
				//if zoom level is valid, the map type is set to the user input, otherwise it prints an error message
				while (!zoomValid) 
				{
					System.out.println("Select the zoom level of the map: 0 ~ 21  (default=14)");
					
					zoomNumber = consol.nextInt();
					
					//includes 0 and 21
					if(zoomNumber > min - 1 && zoomNumber < max + 1) 
					{
						zoom = zoomNumber;
						zoomValid = true;
					}
					else
					{
						System.out.println("Invalid zoom level. Type a number from 0 - 21 \n");

					}
					System.out.println();
				}
								
				//only prints if the city name, map type, and zoom level are all valid
				System.out.println("Current Weather [" + city + "]\n");
				System.out.println();
				
				break;
			} 
			else 
			{
				System.out.println("Invalid city name. Type again.\n");
			}
		}
	}

	public static void getWeatherInfo() throws Exception 
	{
		weatherInfo = Weather211.getCityWeatherNow();
		//prints text version
		for (int i = 0; i < weatherInfo.size(); i++) 
		{
			System.out.println(weatherInfo.get(i));
		}

		//calls Map211 using the weather data in the ArrayList, the user input mapType and zoom level
		new Map211(weatherInfo, mapType, zoom);

	}

}
