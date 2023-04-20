Weather211.java is a program that uses an API key to read the weather from openweathermap.org 
and parses the data into a JSON object. This JSON object is called myObject, and from this 
object,nthis program gets the weather description, temperature, high, low, wind speed and 
humidity of a city if it exists. All this information is then added to an ArrayList called 
weatherInfo that will be made into an HTML file.

Map211.java contains the code that designs a layout for the HTML file that will be created 
from the weather data. It collects the weather information and converts it to a Map in an
HTML file with all of the weather information displayed at the top. You can see an example
of the working code in the supplemental screenshots. 

To see the working program, compile and run myWeatherApp.java. This is the test program for 
the Weather211.java. This program asks for user input and returns the weather data. for the 
city given, if the user input is valid for the city name, the map type, and the zoom level 
for the map, then it calls Map211.java to create a new Map with all of the weather info


The API keys that were used have been removed from the original code. 

You will need to input two separate API keys for this program to work as intended
One is in Weather211.java on line 39
The other is in Map211.java on line 86


Set up free Google API keys online using your Google account
or go to:
https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=&cad=rja&uact=8&ved=2ahUKEwiQp67vjLn-AhUfDjQIHVbkAMwQFnoECAwQAQ&url=https%3A%2F%2Fsupport.google.com%2Fgoogleapi%2Fanswer%2F6158862%3Fhl%3Den&usg=AOvVaw2B82tUsH0M884zBo23S1in
