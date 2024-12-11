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

    public Drop(String item) {
        this.item = item;
        this.commandType = CommandType.DROP;
    }

    @Override
    public String toString(){
        return "You drop: " + item;
    }

    @Override
    public String execute(GameState gameState){
        if(gameState.getPlayer().hasItem(item)){
            Item droppedItem = gameState.getPlayer().getItem(item);
            gameState.getPlayer().removeItem(droppedItem);
            gameState.getMap().getCurrentRoom().addItem(droppedItem);
            return toString();
        } else if (gameState.getPlayer().hasEquipment(item)) {
            Equipment droppedItem = gameState.getPlayer().getEquipment(item);
            gameState.getPlayer().removeEquipment(droppedItem);
            gameState.getMap().getCurrentRoom().addEquipment(droppedItem);
            return toString();
        }
        else{
            return "You cannot drop " + item;
        }
    }
   
}
