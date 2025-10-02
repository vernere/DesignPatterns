package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * A facade class that simplifies working with API calls and JSON parsing.
 * Provides methods to retrieve specific attribute values from JSON responses.
 */
public class ApiFacade {
    /**
     * Public method to extract an attribute value from a JSON response retrieved from the specified URL.
     * 
     * @param urlString URL to fetch the JSON data from
     * @param attributeName Name of the attribute to extract from the JSON
     * @return The value of the requested attribute or null if there was an error
     * @throws IllegalArgumentException If the URL is invalid
     * @throws IOException If there is an error connecting to the API
     */
    public String getAttributeValueFromJson(String urlString, String attributeName)
            throws IllegalArgumentException, IOException {
        try {
            return getData(urlString, attributeName);
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (IOException e) {
            throw e;
        } catch (Exception e) {
            throw new IOException("Error processing API request: " + e.getMessage(), e);
        }
    }

    /**
     * Gets data from the API and extracts the specified attribute.
     * 
     * @param url URL to fetch the JSON data from
     * @param attributeName Name of the attribute to extract
     * @return The value of the requested attribute
     * @throws Exception If there is an error during the API call or JSON parsing
     */
    public String getData(String url, String attributeName) throws Exception {
        String jsonResult = getJsonFromApi(url);
        return extractContentFromJson(jsonResult, attributeName);
    }

    /**
     * Makes an HTTP GET request to the specified API URL and returns the JSON response.
     * 
     * @param apiUrl URL to make the GET request to
     * @return The JSON response as a string
     * @throws Exception If there is an error connecting to or reading from the API
     */
    private String getJsonFromApi(String apiUrl) throws Exception {
        URL url = new URL(apiUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            return content.toString();
        } finally {
            con.disconnect();
        }
    }

    /**
     * Parses a JSON string and extracts the value of the specified attribute.
     * 
     * @param json The JSON string to parse
     * @param attributeName The name of the attribute to extract
     * @return The value of the attribute as a string, or null if the attribute doesn't exist
     * @throws Exception If there is an error parsing the JSON
     */
    private String extractContentFromJson(String json, String attributeName) throws Exception {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(json);
        
        // Add this check:
        if (!jsonObject.containsKey(attributeName)) {
            throw new IllegalArgumentException("Attribute '" + attributeName + "' not found in JSON response");
        }
        
        return jsonObject.get(attributeName).toString();
    }
}
