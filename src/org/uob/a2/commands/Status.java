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
        this.commandType = CommandType.STATUS;
    }

    @Override
    public String toString(){
        return "STATUS" + topic;
    }

    @Override
    public String execute(GameState gameState) {
        try {
            if (topic.equals("inventory")) {
                ArrayList<Equipment> equipment = gameState.getPlayer().getEquipment();
                ArrayList<Item> items = gameState.getPlayer().getInventory();
                ArrayList<String> inventory = new ArrayList<String>();
                if (items.size() > 0) {
                    for (Item i : items) {
                        inventory.add(i.getName() + ",");
                    }
                }
                if (equipment.size() > 0) {
                    for (Equipment i : equipment) {
                        inventory.add(i.getName() + ",");
                    }
                }
                if (inventory.equals("")) {
                    return "Inventory: There are no items in your inventory";
                } else {
                    return "Inventory: " + inventory.toString();
                }
            } else if (topic.equals("player")) {
                return gameState.getPlayer().toString();
            } else if (topic.equals("map")) {
                return gameState.getMap().display();
            } else if (gameState.getPlayer().hasEquipment(topic)) {
                return gameState.getPlayer().getEquipment(topic).getDescription();
            } else if (gameState.getPlayer().hasItem(topic)) {
                return gameState.getPlayer().getItem(topic).getDescription();
            } else if (gameState.getMap().getCurrentRoom().hasEquipment(topic)) {
                return gameState.getMap().getCurrentRoom().getEquipment(topic).getDescription();
            } else if (gameState.getMap().getCurrentRoom().hasItem(topic)) {
                return gameState.getMap().getCurrentRoom().getItem(topic).getDescription();
            }  else {
                return "";
            }
        }
        catch(NullPointerException e) {
            return "";
        }
    }

}
