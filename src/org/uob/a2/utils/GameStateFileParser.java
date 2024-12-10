package org.uob.a2.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileNotFoundException;

import org.uob.a2.gameobjects.*;

/**
 * Utility class for parsing a game state from a file.
 * 
 * <p>
 * This class reads a structured text file to create a {@code GameState} object,
 * including the player, map, rooms, items, equipment, features, and exits.
 * </p>
 */
public class GameStateFileParser {

    public static GameState parse(String filename) {

        ArrayList<Room> roomArrayList = new ArrayList<Room>();
        ArrayList<Equipment> equipmentArrayList = new ArrayList<Equipment>();
        ArrayList<Container> containerArrayList = new ArrayList<Container>();
        ArrayList<Exit> exitArrayList = new ArrayList<Exit>();
        ArrayList<Feature> featureArrayList = new ArrayList<Feature>();
        ArrayList<Item> itemArrayList = new ArrayList<Item>();
        ArrayList<UseInformation> useInformationArrayList = new ArrayList<UseInformation>();

        boolean hidden = false;
        Player player = new Player("placeholder");
        Map map = new Map();
        String currentRoomId = "placeholder";

        try {
            File textFile = new File(filename);
            Scanner fileInput = new Scanner(textFile);
            while (fileInput.hasNextLine()) {
                int counter = 0;
                String line = fileInput.nextLine();
                line = line.trim();
                String[] lineSplit = line.split(":");
                String[] objectParts = lineSplit[1].split(",");
                for (int i = 0; i < objectParts.length; i++) {
                    if (objectParts[i].equalsIgnoreCase("true") || objectParts[i].equalsIgnoreCase("false")) {
                        hidden = Boolean.parseBoolean(objectParts[i]);
                    }
                }
                switch (lineSplit[0]) {
                    case "player":
                        player = new Player(lineSplit[1]);
                        break;
                    case "room":
                        roomArrayList.add(new Room(objectParts[0], objectParts[1], objectParts[2], hidden));
                        GameObjectList.addGameObject(roomArrayList.get(roomArrayList.size()-1));
                        map.addRoom(roomArrayList.get(roomArrayList.size()-1));
                        break;
                    case "equipment":
                        useInformationArrayList.add(new UseInformation(false, objectParts[4], objectParts[5], objectParts[6], objectParts[7]));
                        equipmentArrayList.add(new Equipment(objectParts[0], objectParts[1], objectParts[2], hidden, useInformationArrayList.get(useInformationArrayList.size()-1)));
                        GameObjectList.addGameObject(equipmentArrayList.get(equipmentArrayList.size()-1));
                        equipmentList.addEquipment(equipmentArrayList.get(equipmentArrayList.size()-1));
                        roomArrayList.get(roomArrayList.size()-1).addEquipment(equipmentArrayList.get(equipmentArrayList.size()-1));
                        break;
                    case "container":
                        containerArrayList.add(new Container(objectParts[0], objectParts[1], objectParts[2], hidden));
                        GameObjectList.addGameObject(containerArrayList.get(containerArrayList.size()-1));
                        roomArrayList.get(roomArrayList.size()-1).addFeature(containerArrayList.get(containerArrayList.size()-1));
                        break;
                    case "exit":
                        exitArrayList.add(new Exit(objectParts[0], objectParts[1], objectParts[2], objectParts[3], hidden));
                        GameObjectList.addGameObject(exitArrayList.get(exitArrayList.size()-1));
                        roomArrayList.get(roomArrayList.size()-1).addExit(exitArrayList.get(exitArrayList.size()-1));
                        break;
                    case "feature":
                        featureArrayList.add(new Feature(objectParts[0], objectParts[1], objectParts[2], hidden));
                        GameObjectList.addGameObject(featureArrayList.get(featureArrayList.size()-1));
                        roomArrayList.get(roomArrayList.size()-1).addFeature(featureArrayList.get(featureArrayList.size()-1));
                        break;
                    case "item":
                        itemArrayList.add(new Item(objectParts[0], objectParts[1], objectParts[2], hidden));
                        itemList.addItem(itemArrayList.get(itemArrayList.size()-1));
                        GameObjectList.addGameObject(itemArrayList.get(itemArrayList.size()-1));
                        roomArrayList.get(roomArrayList.size()-1).addItem(itemArrayList.get(itemArrayList.size()-1));
                        break;
                    case "map":
                        map = new Map();
                        currentRoomId = objectParts[0];

                }

            }
            map.setCurrentRoom(currentRoomId);
            GameState gameState = new GameState(map, player);

            return gameState;
        }

        catch(FileNotFoundException e){
            System.out.println("File not found");
            return null;
        }

    }
}
