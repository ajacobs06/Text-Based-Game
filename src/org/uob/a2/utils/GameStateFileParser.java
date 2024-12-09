package org.uob.a2.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

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

        try {
            File textFile = new File(filename);
        }
        catch(Exception e){
            System.out.println("File not found");
        }
        Scanner fileInput = new Scanner(textFile);
        while (fileInput.hasNextLine()) {
            int counter = 0;
            String line = fileInput.nextLine();
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
                    break;
                case "equipment":
                    useInformationArrayList.add(new UseInformation(false, objectParts[4], objectParts[5], objectParts[6], objectParts[7]));
                    equipmentArrayList.add(new Equipment(objectParts[0], objectParts[1], objectParts[2], hidden, useInformationArrayList.get(counter)));
                    equipmentList.addEquipment(equipmentArrayList.get(counter));
                    break;
                case "container":
                    containerArrayList.add(new Container(objectParts[0], objectParts[1], objectParts[2], hidden));
                    break;
                case "exit":
                    exitArrayList.add(new Exit(objectParts[0], objectParts[1], objectParts[2], objectParts[3], hidden));
                    break;
                case "feature":
                    featureArrayList.add(new Feature(objectParts[0], objectParts[1], objectParts[2], hidden));
                    break;
                case "item":
                    itemArrayList.add(new Item(objectParts[0], objectParts[1], objectParts[2], hidden));
                    itemList.addItem(itemArrayList.get(counter));
                    break;

            }
            counter++;

        }
        Map map = new Map();
        GameState gameState = new GameState(map, player);
        map.setCurrentRoom("r1");

        return gameState;


    }
}
