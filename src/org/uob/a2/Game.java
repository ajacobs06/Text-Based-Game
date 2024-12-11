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
