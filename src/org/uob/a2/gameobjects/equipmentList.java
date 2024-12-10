package org.uob.a2.gameobjects;

import java.util.ArrayList;

public class equipmentList {

    static ArrayList<Equipment> equipment = new ArrayList<Equipment>();
    static Equipment present;

    public equipmentList() {
    }

    public static void addEquipment(Equipment equipmentInput) {
        equipment.add(equipmentInput);
    }

    public static boolean isEquipment(String equipmentInput) {
        if(getEquipment(equipmentInput) == null){
            return false;
        }
        else{
            return true;
        }
    }

    public static Equipment getEquipment(String equipmentInput){
        present = null;
        for(Equipment i : equipment){
            if(i.getName().equals(equipmentInput)){
                present = i;
            }
        }
        return present;
    }


}