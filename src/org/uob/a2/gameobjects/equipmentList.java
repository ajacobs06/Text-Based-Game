package org.uob.a2.gameobjects;

import java.util.ArrayList;

public class equipmentList {

    static ArrayList<Equipment> equipment = new ArrayList<Equipment>();
    Equipment present;

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
        for(Equipment i : equipment){
            if(i.getName() == equipmentInput){
                present = i;
            }
        }
        return present;
    }


}