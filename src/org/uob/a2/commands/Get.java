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
    String removing;

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
                gameState.getPlayer().addItem(gameState.getMap().getCurrentRoom().getItemByName(item));
                removing = "item";
            }
            else{
                removing = "owned";
            }
        } else if(gameState.getMap().getCurrentRoom().hasEquipment(item)){
            if(!gameState.getPlayer().hasEquipment(item)){
                gameState.getPlayer().addEquipment(gameState.getMap().getCurrentRoom().getEquipmentByName(item));

            }
            else{
                removing = "owned";
            }
        }
        switch(removing){
            case "item":
                gameState.getMap().getCurrentRoom().removeItem(item);
                return toString();
            case "equipment":
                gameState.getMap().getCurrentRoom().removeEquipment(item);
                return toString();
            case "owned":
                return "You already have " + item;
            default:
                return "No " + item + " to get.";
        }
    }
   
}
