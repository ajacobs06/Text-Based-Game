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
    ArrayList<Equipment> visibleEquipment = new ArrayList<Equipment>();
    ArrayList<Item> visibleItems = new ArrayList<Item>();

    StringBuilder visibleItemNames = new StringBuilder();
    StringBuilder visibleEquipmentNames = new StringBuilder();

    Item removableI;
    Equipment removableE;

    GameObject placeHolderG;


    public Room(){}

    public Room(String id, String name, String description, boolean hidden){
        super(id, name, description, hidden);
    }

    public ArrayList<Exit> getExits(){
        return exitsList;
    }

    public void addExit(Exit exit){
        exitsList.add(exit);
        gameObjects.add(exit);
    }

    public ArrayList<Item> getItems(){
        return items;
    }

    public String getVisibleItemsNames(){
        visibleItemNames = new StringBuilder();
        for(Item i : items){
            if(i.getHidden() == false){
                visibleItems.add(i);
                visibleItemNames.append(i.getName()+",");
            }
        }
        return visibleItemNames.toString();
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

    public String getVisibleEquipmentsNames(){
        visibleEquipmentNames = new StringBuilder();
        for(Equipment e : equipmentList){
            if(e.getHidden() == false){
                visibleEquipment.add(e);
                visibleEquipmentNames.append(e.getName()+",");
            }
        }
        return visibleEquipmentNames.toString();
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
        gameObjects.add(equipment);
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
        gameObjects.add(item);
    }

    public ArrayList<Feature> getFeatures() {
        return features;
    }

    public ArrayList<GameObject> getAll(){
        return gameObjects;
    }

    public void revealAll(){
        for(GameObject g : gameObjects){
            g.setHidden(false);
        }
    }

    public void addFeature(Feature feature){
        features.add(feature);
        gameObjects.add(feature);
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

    public void removeItem(String itemName){
        for(Item i : items){
            if(i.getName().equals(itemName)){
                removableI = i;
            }
        }
        items.remove(removableI);
        gameObjects.remove(removableI);
    }

    public void removeEquipment(String equipmentName){
        for(Equipment i : equipmentList){
            if(i.getName().equals(equipmentName)) {
                removableE = i;
            }
        }
        equipmentList.remove(removableE);
        gameObjects.remove(removableI);
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
