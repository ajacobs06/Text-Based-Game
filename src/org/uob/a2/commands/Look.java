package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * Represents the look command, allowing the player to examine various elements of the game world.
 * 
 * <p>
 * The look command can provide details about the current room, its exits, features, or specific items and equipment.
 * Hidden objects are not included in the output unless explicitly revealed.
 * </p>
 */
public class Look extends Command {
    String target;
    String lookOutput = "";

    public Look(String target) {
        this.target = target;
    }

    @Override
    public String toString(){
        return "LOOK " + target;
    }

    @Override
    public String execute(GameState gameState) {
        if(target != null) {
            switch (target) {
                case "room":
                    lookOutput = gameState.getMap().getCurrentRoom().getDescription() + "\nVisible Equipment: " + gameState.getMap().getCurrentRoom().getEquipmentsNames() + "\nVisible Items: "+ gameState.getMap().getCurrentRoom().getItemsNames();
                    break;
                case "exits":
                    for (int i = 0; i < gameState.getMap().getCurrentRoom().getExits().size(); i++) {
                        lookOutput += gameState.getMap().getCurrentRoom().getExits().get(i).getName();
                    }
                    break;
                case "features":
                    for (int i = 0; i < gameState.getMap().getCurrentRoom().getFeatures().size(); i++) {
                        lookOutput += gameState.getMap().getCurrentRoom().getFeatures().get(i).getName();
                    }
                    break;
                default:
                    if(gameState.getPlayer().hasItem(target)){
                        lookOutput = gameState.getPlayer().getItem(target).getDescription();
                    }
                    else if(gameState.getPlayer().hasEquipment(target)){
                        lookOutput = gameState.getPlayer().getEquipment(target).getDescription();
                    }
                    else if(gameState.getMap().getCurrentRoom().hasItem(target)){
                        lookOutput = gameState.getMap().getCurrentRoom().getItemByName(target).getDescription();
                    }
                    else if(gameState.getMap().getCurrentRoom().hasEquipment(target)) {
                        lookOutput = gameState.getMap().getCurrentRoom().getEquipmentByName(target).getDescription();
                    }
                    else if(gameState.getMap().getCurrentRoom().getFeatureByName(target) != null){
                        lookOutput = gameState.getMap().getCurrentRoom().getFeatureByName(target).getDescription();
                        }
                    else{
                        lookOutput = "Invalid target";
                    }
                    break;
            }
            return lookOutput;
        }
        else{
            return "Invalid Target";
        }

    }
   
}
