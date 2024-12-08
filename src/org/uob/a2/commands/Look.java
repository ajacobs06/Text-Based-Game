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

    public Look(String target) {
        this.target = target;
    }

    public String toString(){
    }

    public void execute(GameState gameState) {
        switch (target) {
            case "room":
                gameState.getCurrentRoom().getDescription();
                break;
            case "exits":
                gameState.getCurrentRoom().getExits();
                break;
            case "features":
                gameState.getCurrentRoom().getFeatures();
                break;
            default:
                if(/*target is an item/equipment/feature*/){
                    /* get description */
                }
        }

    }
   
}
