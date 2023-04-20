package weather;

/*
 * Jamie Gashler
 * 10/11/22 - 10/21/22
 * This is a program that uses an API key to read the weather from 
 * openweathermap.org and parses the data into a JSON object. This JSON
 * object is called myObject, and from this object, this program gets the 
 * weather description, temperature, high, low, wind speed and humidity of 
 * a city if it exists. All this information is then added to an ArrayList 
 * called weatherInfo
 */


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Weather211
{

	static ArrayList<String> weatherInfo = new ArrayList<>();

	public static boolean CityWeather (String cityName) throws Exception
	{

		boolean validCityName = false;

		try
		{

			///Creates a URL instance using my API key and openweathermap.org
			String firstPartURL = "https://api.openweathermap.org/data/2.5/weather?q=";	//the website with all the weather data
			String secondPartURL ="//INPUT KEY HERE "; //your API key here

			String theURL = firstPartURL + cityName + secondPartURL;

			URL url = new URL(theURL); 	///Reads information from URL

			InputStream inputStream = url.openStream();

			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

			BufferedReader br = new BufferedReader(inputStreamReader);	//JSON parser object to parse read file
			
			JSONParser jsonParser = new JSONParser();	//Reads JSON file. All the data for the city is stored in myObject
		
			JSONObject myObject = (JSONObject)jsonParser.parse(br);

			
			//initializes all of the elements that are needed in weatherInfo as strings
			String weatherNow, tempNow, tempLow, tempHigh, wind, humidity = new String();


			// 1. add city name to the data structure
			weatherInfo.add(cityName);

			
			// 2. Weather
			JSONArray weatherArray = (JSONArray)myObject.get("weather");

			JSONObject w = (JSONObject) weatherArray.get(0); // gets weather info from JSONObject w
			weatherNow =(String) w.get("description");
			weatherInfo.add(weatherNow);	// adds weather info to the data structure (see 1. add city name above)
			
			
			// 3. Temp
			// gets temp from myObject
			double cityTemp = (double)((JSONObject)myObject.get("main")).get("temp"); //casts JSON Object to a double
			
			cityTemp = ((cityTemp - 273.15)*9)/5 + 32; //converts to Fahrenheit;
			
			tempNow="temp: "+ String.format("%.1f", cityTemp)+"\u00B0";		
			
			weatherInfo.add(tempNow);	// adds temp to the data structure


			// 4. Temp_min
			// gets temp_min from myObject
			double cityTempMin = (double)((JSONObject)myObject.get("main")).get("temp_min"); //casts JSON Object to a double

			cityTempMin = ((cityTempMin - 273.15)*9)/5 + 32; //converts to Fahrenheit;

			tempLow="low: "+String.format("%.1f", cityTempMin)+"\u00B0"; 

			weatherInfo.add(tempLow); //adds tempLow to the data structure



			// 5. Temp_max
			// gets temp_max from myObject
			double cityTempMax = (double)((JSONObject)myObject.get("main")).get("temp_max"); //casts JSON Object to a double

			cityTempMax = ((cityTempMax - 273.15)*9)/5 + 32; //converts to Fahrenheit;

			tempHigh="high: "+String.format("%.1f", cityTempMax)+"\u00B0";	

			weatherInfo.add(tempHigh); //adds tempHigh to the data structure


			// 6. Wind_speed
			// gets wind speed from myObject
			double cityWindSpeed = (double)((JSONObject)myObject.get("wind")).get("speed"); //casts JSON Object to a double

			wind="wind: "+String.format("%.1f", cityWindSpeed)+"mph";

			weatherInfo.add(wind); //adds wind speed to the data structure


			// 7. Humidity	
			// gets humidity from myObject
			long cityHumidity = (long)((JSONObject)myObject.get("main")).get("humidity"); //casts JSON Object to a long
			
			humidity="humidity: "+String.format("%d", cityHumidity)+("%");
			
			weatherInfo.add(humidity); // adds humidity to the data structure

			
			validCityName = true; //returns true if is a valid city

		}
		catch (Exception ex)
		{

			//System.out.println("exception is thrown" + ex.toString());
			validCityName = false; //returns false if is an invalid city

		}
		return validCityName;
	}
	
	//a method that returns all the weather data as an ArrayList
	public static ArrayList<String> getCityWeatherNow()
	{
		return weatherInfo;
	}

}
