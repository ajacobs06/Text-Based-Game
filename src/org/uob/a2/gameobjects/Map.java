package org.uob.a2.gameobjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;
import java.nio.file.*;

import org.uob.a2.utils.*;

/**
 * Represents the game map, which consists of a collection of rooms and the current room the player is in.
 * 
 * <p>
 * The map allows for navigation between rooms, adding new rooms, and managing the current room context.
 * </p>
 */
public class Map {
    String[][] mapArray;
    final char EMPTY = '.';
    int height = 5;
    int width = 9;

    public Map(){
        //initialising the map
        mapArray = new String[height][width];
        for(int y=0; y<height; y++){
            for(int x=0; x<width; x++){
                map[y][x] = "" + EMPTY;
            }
    }

    public Room getCurrentRoom(){
    }

    public void addRoom(Room room){

    }

    public void setCurrentRoom(String roomId){

    }

    public String display() {
        displayMap = "";
        for(int y=0; y<height; y++) {
            for (int x = 0; x < width; x++) {
                displayMap = displayMap + map[y][x];
            }
            displayMap = displayMap + "\n";
        }
        return displayMap;
    }


    /**
     * Returns a string representation of the map, including all rooms.
     *
     * @return a string describing the map and its rooms
     */
    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("Map:\n");
        for (Room r : this.rooms) {
            out.append(r.toString()).append("\n");
        }
        return out.toString();
    }
}

