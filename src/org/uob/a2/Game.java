package org.uob.a2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
    static Command userCommand;
    static Parser parser = new Parser();

    static GameState gameState = GameStateFileParser.parse("C:\\Users\\artyb\\OneDrive\\University\\Computer Science\\OOP\\Assignment 2\\data\\game.txt");
    static Scanner input = new Scanner(System.in);
    static Tokeniser tokeniser = new Tokeniser();

    public static void setup() {
    }

    public static void start() {
    }

    public static void turn(Command command){

    }

    public static void main(String[] args){
        System.out.println("Game Start.");

        UseInformation useInfo = new UseInformation(false, "open", "chest1", "item1", "You opened the chest!");
        Equipment equipment = new Equipment("key", "Key", "A rusty key.", false, useInfo);
        Container target = new Container("chest1", "Treasure Chest", "A locked chest.", false);
        Item hiddenItem = new Item("item1", "Gold Coin", "A shiny gold coin.", true);

        Room room = new Room("1", "Room", "A room with a chest.", false);
        room.addFeature(target);
        room.addItem(hiddenItem);

        Map map = new Map();
        map.addRoom(room);
        map.setCurrentRoom("1");

        GameState gameState = new GameState(map, new Player("Player"));

        // Use equipment
        String result = equipment.use(target, gameState);

        // Validate results
        boolean testPassed =
                !hiddenItem.getHidden() &&
                        result.contains("You opened the chest!");
        System.out.println(!hiddenItem.getHidden());
        System.out.println(result.contains("You opened the chest!"));

        System.out.println("AUTOMARK::Equipment.testUseOnValidTarget: " + (testPassed ? "PASS" : "FAIL"));

        while(gameLoop.getGameLoop()){
            System.out.println("\nYou are currently in the " + gameState.getMap().getCurrentRoom().getName());
            System.out.println("Please enter a command:");
            String userInput = input.nextLine();
            tokeniser.tokenise(tokeniser.sanitise(userInput));
            try {
                userCommand = parser.parse(tokeniser.getTokens());
                System.out.println(userCommand.execute(gameState));
            }
            catch(CommandErrorException e){
                System.out.println("Invalid command");
            }
            tokeniser.clearTokens();
        }


    }

}
