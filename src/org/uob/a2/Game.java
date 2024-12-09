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
    static Scanner input;
    static Tokeniser tokeniser;
    static Command userCommand;
    static Parser parser;
    static GameState gameState;

    public static void setup() {

        GameState gameState = GameStateFileParser.parse("game.txt");
        Scanner input = new Scanner(System.in);
        Tokeniser tokeniser = new Tokeniser();

    }

    public static void turn(Command command){
        command.execute(gameState);
    }


    public static void start() {
        while(gameLoop.getGameLoop()){
            String userInput = input.nextLine();
            tokeniser.tokenise(tokeniser.sanitise(userInput));
            userCommand = parser.parse(tokeniser.getTokens());
            turn(userCommand);
        }
    }

    public static void main(String[] args){

        setup();
        start();

    }

}
