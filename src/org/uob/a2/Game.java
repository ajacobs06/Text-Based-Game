package org.uob.a2;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

import org.uob.a2.commands.*;
import org.uob.a2.gameobjects.*;
import org.uob.a2.parser.*;
import org.uob.a2.utils.*;

/**
 * Main class for the game application. Handles game setup, input parsing, and game execution.
 * 
 * <p>
 * This class initializes the game state, reads user input, processes commands, and maintains the game loop.
 * </p>
 */
public class Game {

    public Game(){
    }

    public static void setup(){

        ArrayList<Room> roomArrayList = new ArrayList<Room>();
        ArrayList<Equipment> equipmentArrayList = new ArrayList<Equipment>();
        ArrayList<Container> containerArrayList = new ArrayList<Container>();
        ArrayList<Exit> exitArrayList = new ArrayList<Exit>();
        ArrayList<Feature> featureArrayList = new ArrayList<Feature>();
        ArrayList<Item> itemArrayList = new ArrayList<Item>();
        ArrayList<UseInformation> useInformationArrayList = new ArrayList<UseInformation>();

        File textFile = new File("game.txt");
        Scanner fileInput = new Scanner(textFile);
        while(fileInput.hasNextLine()){
            int counter = 0
            String line = fileInput.nextLine();
            String[] lineSplit = line.split(":");
            String[] objectParts = lineSplit[1].split(",");
            for(int i=0; i<objectParts.length; i++){
                if(objectParts[i].equalsIgnoreCase("true") || objectParts[i].equalsIgnoreCase("false")){
                    boolean hidden = Boolean.parseBoolean(objectParts[i]);
                }
            }
            switch(lineSplit[0]){
                case "player":
                    Player player = new Player(lineSplit[1]);
                    break;
                case "room":
                    roomArrayList.add(new Room(objectParts[0], objectParts[1], objectParts[2], objectParts[3]));
                    break;
                case "equipment":
                    useInformationArrayList.add(new UseInformation(false, objectParts[5], objectParts[6], objectParts[7]));
                    equipmentArrayList.add(new Equipment(objectParts[0], objectParts[1], objectParts[2], objectParts[3], useInformationArrayList[counter]));
                    break;
                case "container":
                    containerArrayList.add(new Container(objectParts[0], objectParts[1], objectParts[2], objectParts[3]));
                    break;
                case "exit":
                    exitArrayList.add(new Exit(objectParts[0], objectParts[1], objectParts[2], objectParts[3], objectParts[4]));
                    break;
                case "feature":
                    featureArrayList.add(new Feature(objectParts[0], objectParts[1], objectParts[2], objectParts[3]));

            }
            counter++;

        }
        Map map = new Map();
        GameState gameState = new GameState(map, player);

        System.out.println(roomArrayList);
        System.out.println(equipmentArrayList);
        System.out.println(containerArrayList);
        System.out.println(exitArrayList);
        System.out.println(featureArrayList);
    }

    public static void main(String[] args){

        setup();

    }

}
