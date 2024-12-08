package org.uob.a2.gameobjects;

import java.util.ArrayList;



/**
 * Represents the player in the game, including their name, inventory, and equipment.
 * 
 * <p>
 * The player can carry items and equipment, interact with the game world, and perform
 * actions using their inventory or equipment.
 * </p>
 */
public class Player {
    ArrayList<Item> items = new ArrayList<Item>();
    ArrayList<Equipment> equipmentList = new ArrayList<Equipment>();
    boolean present = false;
    String name;
    public Player(){}

    public Player(){}

    public Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Item> getInventory(){
        return items;
    }

    public boolean hasItem(String itemName){
        present = false;
        for(Item i : Item){
            if(i.equals(itemName)){
                present = true;
            }
        }
        return present;
    }

    public Item getItem(String itemName){
        if(hasItem(itemName)){
            for(Item i : items)
                if(i == itemName){
                    return i;
                }
        }
        else{
            return null;
        }
    }

    public void addItem(Item item){
        items.add(item);
    }

    public ArrayList<Equipment> getEquipment(){
        return equipmentList;
    }

    public boolean hasEquipment(String equipmentName){
        present = false;
        for(Equipment i : equipmentList){
            if(i.equals(equipmentName)) {
                present = true;
            }
        }
        return present;
    }

    public Equipment getEquipment(String equipment){
        if(hasEquipment(equipment)){
            for(Equipment i : equipmentList){
                return i;
            }
        }
        else{
            return null;
        }
    }

    public void addEquipment(Equipment equipment){
        equipmentList.add(equipment);
    }

    public void removeEquipment(String equipmentName){
        equipmentList.remove(equipmentName);
    }

    public void removeItem(String itemName){
        items.remove(itemName);
    }

    /**
     * Returns a string representation of the player's current state, including their name,
     * inventory, and equipment descriptions.
     *
     * @return a string describing the player, their inventory, and equipment
     */
    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("Player Name: " + this.name + "\nInventory:\n");
        for (Item i : this.inventory) {
            out.append("- ").append(i.getDescription()).append("\n");
        }
        out.append("Equipment:\n");
        for (Equipment e : this.equipment) {
            out.append("- ").append(e.getDescription()).append("\n");
        }
        return out.toString();
    }
}
