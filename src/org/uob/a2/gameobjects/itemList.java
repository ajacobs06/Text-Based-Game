package org.uob.a2.gameobjects;

import java.util.ArrayList;

public class itemList {

    public itemList(){
        ArrayList<Item> itemList = new ArrayList<Item>();
    }

    public boolean isItem(String item){
        if(getObject(item) == null){
            return false;
        }
        else{
            return true;
        }
    }

    public void addItem(Item item){
        itemList.add(item);
    }

    public Item getObject(String item){
        for(Item i : itemList){
            if(i.getName() == item){
                return i;
            }
        }
    }



}