package com.example;

public class Main {
    public static void main(String[] args) {
        ApiFacade api = new ApiFacade();

        // Successful API call
        try {
            System.out.println("Successful call:");
            System.out.println(api.getAttributeValueFromJson("https://api.chucknorris.io/jokes/random", "value"));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Successfull API call
        try {
            System.out.println("Successful call:");
            System.out.println(api.getAttributeValueFromJson("https://dogapi.dog/api/v2/breeds", "data"));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // IOException case - invalid URL
        try {
            System.out.println("\nIOException demonstration:");
            System.out.println(api.getAttributeValueFromJson("https://invalid-domain-that-does-not-exist.xyz", "data"));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // IllegalArgumentException case - invalid field
        try {
            System.out.println("\nIllegalArgumentException demonstration:");
            System.out.println(api.getAttributeValueFromJson("https://api.chucknorris.io/jokes/random", "nonexistent_field"));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}