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

    public static void setup() {

        GameState gameState = GameStateFileParser.parse("game.txt");

    }

    public static void main(String[] args){

        setup();

    }

}
