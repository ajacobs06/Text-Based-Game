package org.uob.a2.gameobjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;
import java.nio.file.*;
import java.lang.StringBuilder;

import org.uob.a2.utils.*;

/**
 * Represents the game map, which consists of a collection of rooms and the current room the player is in.
 * 
 * <p>
 * The map allows for navigation between rooms, adding new rooms, and managing the current room context.
 * </p>
 */
public class Map {

    ArrayList<Room> map = new ArrayList<Room>();
    String[][] roomDisplay = new String[5][9];
    int roomCounter = 0;
    Room currentRoom = new Room("r1","test room","This is a test room for testing. It's bland.",false);

    public Map() {

    }

    public Room getCurrentRoom(){
        return currentRoom;
    }

    public void addRoom(Room room){
        map.add(room);
        roomCounter++;
    }

    public void setCurrentRoom(String roomId){
        for(Room r : map){
            if(r.getId() == roomId){
                currentRoom = r;
            }
        }
    }

    public String display(){
        for(int y = 0; y < 5; y++){
            roomDisplay[y][0] = "|";
            roomDisplay[y][8] = "|";
            for(int x = 1; x < 8; x++){
                roomDisplay[y][x] = " ";
            }
        }
        for(int x = 0; x < 9; x++){
            roomDisplay[0][x] = "-";
            roomDisplay[4][x] = "-";
            }
        StringBuilder strbuildDisplay = new StringBuilder();
        for(int y = 0; y < 5; y++){
            for(int x = 0; x < 9; x++){
                strbuildDisplay.append(roomDisplay[y][x]);
            }
            strbuildDisplay.append("\n");
        }
        for(int i=0; i<roomCounter; i++){
            strbuildDisplay.append("\n");
            strbuildDisplay.append(strbuildDisplay.toString());
        }
        String strDisplay = strbuildDisplay.toString();
        return strDisplay;
    }


    /**
     * Returns a string representation of the map, including all rooms.
     *
     * @return a string describing the map and its rooms
     */
    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("Map:\n");
        for (Room r : map) {
            out.append(r.toString()).append("\n");
        }
        return out.toString();
    }
}

