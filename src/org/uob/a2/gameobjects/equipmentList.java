package org.uob.a2.gameobjects;

import java.util.ArrayList;

public class equipmentList {

    public static equipmentList() {
         ArrayList<Equipment> equipment = new ArrayList<Equipment>;
    }

    public void addEquipment(Equipment equipmentInput) {
        equipment.add(equipment);
    }

    public boolean isEquipment(String equipmentInput) {
        if(getEquipment(equipmentInput) == null){
            return false;
        }
        else{
            return true;
        }
    }

    public Equipment getEquipment(String equipmentInput){
        for(Equipment i : equipment){
            if(i.getName() == equipmentInput){
                return i;
            }
        }
    }


}