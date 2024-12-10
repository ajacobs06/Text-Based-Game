package org.uob.a2.gameobjects;

import java.util.ArrayList;

public class GameObjectList {

    static ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
    static GameObject present;

    public GameObjectList() {
    }

    public static void addGameObject(GameObject gameObject) {
        gameObjects.add(gameObject);
    }


    public static GameObject getGameObject(String gameObjectInput) {
        for (GameObject i : gameObjects) {
            if (i.getName().equalsIgnoreCase(gameObjectInput)) {
                present = i;
            }
        }
        return present;
    }
}