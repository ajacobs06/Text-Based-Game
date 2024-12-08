package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * Represents the drop command, allowing the player to drop an item from their inventory into the current room.
 * 
 * <p>
 * This command checks if the player possesses the specified item and, if so, removes it from their inventory
 * and adds it to the current room. If the player does not have the item, an error message is returned.
 * </p>
 */
public class Drop extends Command {
    String item;

    public Drop(item) {
        this.item = item;
    }

    @Override
    public String toString(){
        return "You drop: " + item;
    }

    public String execute(GameState gameState){
        if(gameState.getPlayer().hasItem(item)){
            gameState.getPlayer().removeItem(item);
            toString();
        } else if (gameState.getPlayer().hasEquipment(item)) {
            gameState.getPlayer().removeEquipment(item);
            toString();
        }
        else{
            System.out.println("You do not have this item to drop!")
        }
    }
   
}
