package weather;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
 * Jamie Gashler
 * 10/11/22 - 10/21/22
 * This is a program that collects the weather information and 
 * converts it to a Map in an HTML file with all of the weather 
 * information displayed at the top
 */

public class Map211 
{

	static String html;
	static String weather;
	static String mapFileName = "myMap.html"; //the HTML file that can be found in the projects folder
	static ArrayList<String> weatherInfo = new ArrayList<>();

	Map211 (ArrayList<String> weatherInfo, String mapType, int zoom) throws IOException
	{
		
		
		 // places all the information from the ArrayList based on the index from weatherInfo into individual strings
		
		String city = weatherInfo.get(0);
		String weatherNow = weatherInfo.get(1);
		String tempNow = weatherInfo.get(2);
		String tempLow = weatherInfo.get(3);
		String tempHigh = weatherInfo.get(4);
		String windSpeed = weatherInfo.get(5);
		String humidity = weatherInfo.get(6);


		// creates a single string of data using weatherInfo		
		weather= " "+ city.toUpperCase()+" | " + weatherNow +" | " + tempNow +" | " + tempLow +" | " + tempHigh +" | "  + windSpeed +" | "+ humidity +" | ";
		
		// writes a HTML file 	
		writeHTML(weather,city, mapType, zoom);
		
		// runs html file from java code		
		String url = mapFileName; 
		
		File htmlFile = new File(url);
		
		Desktop.getDesktop().browse(htmlFile.toURI());

	}

	//writes to the .html file so that the user can view the map and weather data
	public static void writeHTML(String weatherNow, String city, String mapType, int zoom) 
	{

		html = "<!DOCTYPE html>"

				+ "<html>"

				+ "<body>"

				+ "<h2>"

				+ weatherNow

				+ "</h2>"

				+ "<iframe"

				+ " width=1200"

				+ " height=900"

				+ " style=border:0"

				+ " loading=lazy"

				+ " allowfullscreen"

				+ " referrerpolicy=\"no-referrer-when-downgrade\""

				+ "src=\"https://www.google.com/maps/embed/v1/place?key= //INPUT ANOTHER API KEY HERE =" + city + "&zoom=" + zoom
				+ "&maptype=" + mapType + "\""

				+ "</iframe>"

				+ "</body>"

				+ "</html>";

		File f = new File(mapFileName);

		try 
		{

			BufferedWriter bw = new BufferedWriter(new FileWriter(f));

			bw.write(html);

			bw.close();

		} 
		catch (IOException e) 
		{

			e.printStackTrace();

		}

	}
}
