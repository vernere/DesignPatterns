package com.example;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages recommendation objects and provides functionality for storing,
 * retrieving, cloning, and listing recommendations.
 */
public class RecommendationManager {
    /** Storage for recommendations with their names as keys */
    public Map<String, Recommendation> recommendations;

    /**
     * Constructor initializes an empty recommendations map
     */
    public RecommendationManager() {
        this.recommendations = new HashMap<>();
    }

    /**
     * Displays all recommendation target audiences to the console
     */
    public void listRecommendations() {
        for (Recommendation recommendation : recommendations.values()) {
            System.out.println(recommendation.targetAudience);
        }
    }

    /**
     * Saves a recommendation with the given name if it doesn't already exist
     * 
     * @param recommendationName The key to store the recommendation under
     * @param recommendation The recommendation object to save
     */
    public void saveRecommendation(String recommendationName, Recommendation recommendation) {
        if (recommendations.containsKey(recommendationName)) {
            System.out.println("Duplicate!");
        } else {
            recommendations.put(recommendationName, recommendation);
        }
    }

    /**
     * Creates a clone of an existing recommendation
     * 
     * @param recommendationName The name of the recommendation to clone
     * @return A clone of the recommendation or null if not found
     */
    public Recommendation cloneRecommendation(String recommendationName) {
        Recommendation original = recommendations.get(recommendationName);
        if (original == null) {
            return null;
        }
        return original.clone();
    }

    /**
     * Retrieves a recommendation by name
     * 
     * @param recommendationName The name of the recommendation to retrieve
     * @return The recommendation object or null if not found
     */
    public Recommendation getRecommendation(String recommendationName) {
        return recommendations.get(recommendationName);
    }
}
