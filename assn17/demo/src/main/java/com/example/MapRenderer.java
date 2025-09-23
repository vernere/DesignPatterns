package com.example;

import com.example.graphics.TileGraphic;
import com.example.graphics.TileGraphicFactory;
import com.example.model.Map;

import javafx.scene.canvas.GraphicsContext;

/**
 * Responsible for rendering map tiles to a JavaFX graphics context.
 * Uses a flyweight pattern via TileGraphicFactory to create and reuse tile graphics.
 */
public class MapRenderer {
    // The map data to be rendered
    public Map map;
    // JavaFX graphics context for rendering
    public GraphicsContext gc;

    /**
     * Sets the map to be rendered
     * @param map The map containing tile data
     */
    public void setMap(Map map){
        this.map = map;
    }

    /**
     * Sets the canvas graphics context for rendering
     * @param gc The graphics context to draw on
     */
    public void setCanvas(GraphicsContext gc){
        this.gc = gc;
    }
    
    /**
     * Renders all tiles in the map to the graphics context
     * Iterates through the map grid and draws each tile
     */
    public void renderTiles(){
        if (map == null) {
            System.out.println("No map to render");
            return;
        }

        for (int y = 0; y < map.height; y++) {
            for (int x = 0; x < map.width; x++) {
                if (map.tiles[y][x] != null) {
                    // Get the tile type and its corresponding graphic
                    String type = map.tiles[y][x].getCharacter();
                    // Use factory to get (or create) the appropriate tile graphic
                    TileGraphic graphic = TileGraphicFactory.getTileGraphic(type);
                    // Draw the tile at position (x,y)
                    graphic.draw(gc, x, y);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
