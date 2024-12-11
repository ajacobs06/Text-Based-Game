package org.uob.a2.gameobjects;

public class Score {
    static int score;

    public Score(){
        score = 100;
    }

    public static void addScore(int number){
        score += number;
    }

    public static void removeScore(int number){
        score -= number;
    }

    public static int getScore(){
        return score;
    }
}
