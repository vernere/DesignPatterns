package com.example.graphics;

import java.util.HashMap;
import java.util.Map;

/**
 * Factory class for creating tile graphic objects based on tile type.
 * Implements the Factory design pattern to encapsulate object creation logic.
 * Also implements the Flyweight pattern to reuse tile graphic objects.
 */
public class TileGraphicFactory {
    // Map to store already created tile graphics (Flyweight pattern)
    // Prevents duplicate objects by storing and reusing existing instances
    private static final Map<String, TileGraphic> flyweights = new HashMap<>();

   /**
    * Factory method that returns a TileGraphic object based on the requested type.
    * Implements the Flyweight pattern by checking if the requested tile type already exists.
    * If it exists, returns the cached instance; otherwise creates a new one.
    *
    * @param tileType The type of tile to create ("F" for Forest, "S" for Swamp, etc.)
    * @return The appropriate TileGraphic object for the requested type
    */
   public static TileGraphic getTileGraphic(String tileType) {
    // Check if the tile type already exists in our flyweight cache
    if (flyweights.containsKey(tileType)) {
        System.out.println("Reused tile type: " + tileType);
    } else {
        System.out.println("Created new tile type: " + tileType);
    }
    
    // computeIfAbsent will only create a new object if the key doesn't exist
    // This is efficient for implementing the Flyweight pattern
    return flyweights.computeIfAbsent(tileType, type -> {
        // Factory pattern implementation - create objects based on type
        switch (type) {
            case "F": return new ForestGraphic();
            case "S": return new SwampGraphic();
            case "W": return new WaterGraphic();
            case "R": return new RoadGraphic();
            case "B": return new BuildingGraphic();
            default: break;
        }
        return null;
    });
   }
}
