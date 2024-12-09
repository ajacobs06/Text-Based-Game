package org.uob.a2.gameobjects;

public class gameLoop {
    public static boolean gameloop = true;

    public gameLoop(){

    }

    public static void endGame(){
        gameloop = false;
    }

    public static boolean getGameLoop(){
        return gameloop;
    }

}