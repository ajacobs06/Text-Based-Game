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
    ArrayList<Exit> exitsList = new ArrayList<Exit>();
    ArrayList<Item> items = new ArrayList<Item>();
    ArrayList<Feature> features = new ArrayList<Feature>();
    ArrayList<Equipment> equipmentList = new ArrayList<Equipment>();
    ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();


    public Room(){}

    public Room(String id, String name, String description, boolean hidden){
        super(id, name, description, hidden);
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

    public String getItemsNames(){
        StringBuilder itemsNames = new StringBuilder();
        for(Item i : items){
            itemsNames.append(i.getName() + " ");
        }
        return itemsNames.toString();
    }

    public Item getItem(String id){
        Item found = null;
        for(Item i : items){
            if(i.id.equals(id)){
                found = i;
            }
        }
        return found;
    }

    public Item getItemByName(String name){
        Item found = null;
        for(Item i : items){
            if(i.getName().equals(name)){
                found = i;
            }
        }
        return found;
    }

    public Feature getFeatureByName(String name){
        Feature found = null;
        for(Feature i : features){
            if(i.name.equals(name)){
                found = i;
            }
        }
        return found;
    }

    public ArrayList<Equipment> getEquipments(){
        return equipmentList;
    }

    public String getEquipmentsNames(){
        StringBuilder equipments = new StringBuilder();
        for(Equipment e : equipmentList){
            equipments.append(e.getName() + " ");
        }
        return equipments.toString();
    }

    public Equipment getEquipmentByName(String name){
        Equipment found = null;
        for(Equipment i : equipmentList){
            if(i.name.equals(name)){
                found = i;
            }
        }
        return found;
    }

    public Equipment getEquipment(String id){
        Equipment found = null;
        for(Equipment i : equipmentList){
            if(i.id.equals(id)){
                found = i;
            }
        }
        return found;
    }

    public Exit getExit(String id){
        Exit found = null;
        for(Exit i : exitsList){
            if(i.id.equals(id)){
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
            if(i.id.equals(id)){
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
        boolean present = false;
        for(Item i : items){
            if(i.getName().equals(itemName)){
                present = true;
            }
        }
        return present;
    }

    public boolean hasEquipment(String equipmentName){
        boolean present = false;
        for(Equipment i : equipmentList){
            if(i.getName().equals(equipmentName)) {
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
        for (Equipment e : this.equipmentList) {
            out += e + "\n";
        }
        for (Feature f : this.features) {
            out += f + "\n";
        }
        for (Exit e : this.exitsList) {
            out += e + "\n";
        }
        return out + "\n";
    }
}
