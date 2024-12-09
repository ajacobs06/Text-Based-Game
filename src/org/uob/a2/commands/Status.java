package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;
import java.util.ArrayList;

/**
 * Represents the status command, allowing the player to retrieve information
 * about their inventory, specific items, or their overall status.
 * 
 * <p>
 * The status command can display a list of items in the player's inventory, 
 * provide details about a specific item, or show the player's general status.
 * </p>
 */
public class Status extends Command {
    String topic;

    public Status(String topic) {
        this.topic = topic;
    }

    @Override
    public String toString(){
        return "STATUS" + topic;
    }

    @Override
    public String execute(GameState gameState) {
        if(topic == "inventory") {
            ArrayList<Equipment> equipment = gameState.getPlayer().getEquipment();
            ArrayList<Item> items = gameState.getPlayer().getInventory();
            String inventory = "";
            for (Item i : items) {
                inventory = inventory + i.getName() + ",";
            }
            for (Equipment i : equipment) {
                inventory = inventory + i.getName() + ",";
            }
            return inventory;
        }
        else if(equipmentList.isEquipment(topic)){
            return equipmentList.getEquipment(topic).getDescription();
        }
        else if(itemList.isItem(topic)){
            return itemList.getItem(topic).getDescription();
        }
        else if(topic == "player"){
            return gameState.getPlayer().toString();
        }
        else{
            return null;
        }
    }

}
