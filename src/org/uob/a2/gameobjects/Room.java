package org.uob.a2.gameobjects;

import java.util.ArrayList;

/**
 * Represents a room in the game, which is a type of {@code GameObject}.
 * 
 * <p>
 * Rooms can have items, equipment, features, and exits. They also manage navigation
 * and interactions within the game world.
 * </p>
 */
public class Room extends GameObject {
    String id;
    String name;
    String description;
    boolean hidden;
    ArrayList<Exit> exitsList = new ArrayList<Exit>;
    ArrayList<Item> items = new ArrayList<Item>;
    ArrayList<Feature> features = new ArrayList<Feature>;
    ArraList<Equipment> equipmentList = new ArrayList<Equipment>;
    ArrayList<GameObject> gameObjects = new ArrayList<GameObject>;


    public Room(){}

    public Room(id, name, description, hidden){
        this.id = id;
        this.name = name;
        this.description = description;
        this.hidden = hidden;
    }

    @Override
    public void setName(String name){
        this.name = name;
    }

    @Override
    public void setDescription(String description){
        this.description = description;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public String getId(){
        return id;
    }

    @Override
    public String getDescription(){
        return description;
    }

    public ArrayList<Exit> getExits(){
        return exitsList;
    }

    public void addExit(Exit exit){
        exitsList.add(exit);
    }

    public ArrayList<Item> getItems(){
        return items;
    }

    public Item getItem(String id){
        Item found = null;
        for(Item i : items){
            if(i.id == id){
                found = i;
            }
        }
        return found;
    }

    public Item getItemByName(String name){
        Item found = null;
        for(Item i : items){
            if(i.name == name){
                found = i;
            }
        }
        return found;
    }

    public Feature getFeatureByName(String name){
        Feature found = null;
        for(Feature i : features){
            if(i.name == name){
                found = i;
            }
        }
        return found;
    }

    public ArrayList<Equipment> getEquipments(){
        return equipmentList;
    }

    public Equipment getEquipmentByName(String name){
        Equipment found = null;
        for(Feature i : equipmentList){
            if(i.name == name){
                found = i;
            }
        }
        return found;
    }

    public Equipment getEquipment(String id){
        Equipment found = null;
        for(Equipment i : equipmentList){
            if(i.id == id){
                found = i;
            }
        }
        return found;
    }

    public Exit getExit(String id){
        Exit found = null;
        for(Exit i : exits){
            if(i.id == id){
                found = i;
            }
        }
        return found;
    }

    public void addEquipment(Equipment equipment){
        equipmentList.add(equipment);
    }

    public Feature getFeature(String id){
        Feature found = null;
        for(Feature i : features){
            if(i.id == id){
                found = i;
            }
        }
        return found;
    }

    public void addItem(Item item){
        items.add(item);
    }

    public ArrayList<Feature> getFeatures() {
        return features;
    }

    public ArrayList<GameObject> getAll(){
        return gameObjects;
    }

    public void addFeature(Feature feature){
        features.add(feature);
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

    public boolean hasEquipment(String equipmentName){
        present = false;
        for(Equipment i : equipmentList){
            if(i.equals(equipmentName)) {
                present = true;
            }
        }
        return present;
    }

    /**
     * Returns a string representation of the room, including its contents and description.
     *
     * @return a string describing the room
     */
    @Override
    public String toString() {
        String out = "[" + id + "] Room: " + name + "\nDescription: " + description + "\nIn the room there is: ";
        for (Item i : this.items) {
            out += i + "\n";
        }
        for (Equipment e : this.equipment) {
            out += e + "\n";
        }
        for (Feature f : this.features) {
            out += f + "\n";
        }
        for (Exit e : this.exits) {
            out += e + "\n";
        }
        return out + "\n";
    }
}
