package org.uob.a2.gameobjects;

import java.util.ArrayList;

public class itemList {

    ArrayList<Item> itemArrayList = new ArrayList<Item>();

    public itemList(){
    }

    public boolean isItem(String item){
        if(getObject(item) == null){
            return false;
        }
        else{
            return true;
        }
    }

    public static void addItem(Item item){
        itemArrayList.add(item);
    }

    public static Item getObject(String item){
        for(Item i : itemArrayList){
            if(i.getName() == item){
                return i;
            }
        }
    }



}