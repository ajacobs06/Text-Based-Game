package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * Represents the get command, allowing the player to pick up an item from the current room and add it to their inventory.
 * 
 * <p>
 * This command checks if the specified item is present in the current room. If the item exists and the player
 * does not already have it, the item is added to the player's inventory and removed from the room. Otherwise,
 * an appropriate message is returned.
 * </p>
 */
public class Get extends Command {
    String item;

    public Get(String item){
        this.item = item;
    }

    @Override
    public String toString(){
        return "You pick up: " + item;
    }

    @Override
    public String execute(GameState gameState){
        if(gameState.getMap().getCurrentRoom().hasItem(item)){
            if(!gameState.getPlayer().hasItem(item)) {
                gameState.getPlayer().addItem(gameState.getPlayer().getItem(item));
                return toString();
            }
            else{
                return "You already have this item!";
            }
        } else if(gameState.getMap().getCurrentRoom().hasEquipment(item)){
            if(!gameState.getPlayer().hasEquipment(item)){
                gameState.getPlayer().addEquipment(gameState.getPlayer().getEquipment(item));
                return toString();
            }
            else{
                return "You already have this item!";
            }
        }
        else{
            return "There is no " + item + " in the room.";
        }
    }
   
}
