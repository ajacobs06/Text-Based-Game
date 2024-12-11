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
    ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
    boolean present = false;
    String name;
    Equipment placeHolderEq;
    Item placeHolderI;
    GameObject placeHolderG;

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

    public boolean hasItem(String item){
        present = false;
        for(Item i : items){
            if(i.getName().equals(item)){
                present = true;
            }
        }
        for(Item i : items){
            if(i.getId().equals(item)){
                present = true;
            }
        }
        return present;
    }



    public Item getItem(String itemName){
        if(hasItem(itemName)){
            for(Item i : items){
                if(i.getName().equals(itemName) || i.getId().equals(itemName)) {
                    placeHolderI = i;
                }
            }
        }
        else{
            placeHolderI = null;
        }
        return placeHolderI;
    }

    public void addItem(Item item){
        items.add(item);
        gameObjects.add(item);
    }

    public ArrayList<Equipment> getEquipment(){
        return equipmentList;
    }

    public boolean hasEquipment(String equipment){
        present = false;
        for(Equipment i : equipmentList){
            if(i.getName().equals(equipment)) {
                present = true;
            }
        }
        for(Equipment i : equipmentList){
            if(i.getId().equals(equipment)) {
                present = true;
            }
        }
        return present;
    }

    public Equipment getEquipment(String equipment){
        if(hasEquipment(equipment)){
            for(Equipment i : equipmentList){
                if(i.getName().equals(equipment) || i.getId().equals(equipment)) {
                    placeHolderEq = i;
                }
            }
        }
        else{
            placeHolderEq = null;
        }
        return placeHolderEq;
    }

    public void addEquipment(Equipment equipment){
        equipmentList.add(equipment);
        gameObjects.add(equipment);
    }

    public void removeEquipment(Equipment equipmentName){
        equipmentList.remove(equipmentName);
        gameObjects.remove(equipmentName);
    }

    public void removeItem(Item itemName){
        items.remove(itemName);
        gameObjects.remove(itemName);
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
        for (Item i : this.items) {
            out.append("- ").append(i.getDescription()).append("\n");
        }
        out.append("Equipment:\n");
        for (Equipment e : this.equipmentList) {
            out.append("- ").append(e.getDescription()).append("\n");
        }
        return out.toString();
    }
}
