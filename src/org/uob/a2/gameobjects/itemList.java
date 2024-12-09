package org.uob.a2.gameobjects;

import java.util.ArrayList;

public class itemList {

    static ArrayList<Item> itemArrayList = new ArrayList<Item>();
    static Item present;

    public itemList(){
    }

    public static boolean isItem(String item){
        if(getItem(item) == null){
            return false;
        }
        else{
            return true;
        }
    }

    public static void addItem(Item item){
        itemArrayList.add(item);
    }

    public static Item getItem(String item){
        for(Item i : itemArrayList){
            if(i.getName() == item){
                present = i;
            }
        }
        return present;
    }



}