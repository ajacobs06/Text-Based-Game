package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

public class Combine extends Command {
    String item1, item2;
    Item Item1, Item2;

    public Combine(String item1, String item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    @Override
    public String execute(GameState gameState) {
        Item1 = gameState.getPlayer().getItem(item1);
        Item2 = gameState.getPlayer().getItem(item2);
        if(Item1.isCombinable() && Item2.isCombinable()) {
            if(Item1.getTarget().equals(Item2.getId()) && Item2.getTarget().equals(Item1.getId()) && Item1.getResult().equals(Item2.getResult())) {
                gameState.getMap().getCurrentRoom().getItem(Item1.getResult()).setHidden(false);
                gameState.getPlayer().addItem(gameState.getMap().getCurrentRoom().getItem(Item1.getResult()));
                gameState.getMap().getCurrentRoom().removeItem(gameState.getMap().getCurrentRoom().getItem(Item1.getResult()).getName());
                gameState.getPlayer().removeItem(Item1);
                gameState.getPlayer().removeItem(Item2);
                return "Items Combined\nNew Item: " + gameState.getPlayer().getItem(Item1.getResult()).getName();
            }
            else{
                return "Items are not combinable";
            }
        }
        else{
            return "Items are not combinable";
        }


    }
}
