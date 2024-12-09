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
        switch (target) {
            case "room":
                lookOutput = gameState.getMap().getCurrentRoom().getDescription();
                break;
            case "exits":
                for(int i=0; i<gameState.getMap().getCurrentRoom().getExits().size(); i++){
                    lookOutput += gameState.getMap().getCurrentRoom().getExits().get(i);
                }
                break;
            case "features":
                for(int i=0; i<gameState.getMap().getCurrentRoom().getFeatures().size(); i++){
                    lookOutput += gameState.getMap().getCurrentRoom().getFeatures().get(i);
                }
                break;
            default:
                break;
        }
        return lookOutput;

    }
   
}
