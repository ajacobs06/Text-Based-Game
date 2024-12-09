package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * Represents the use command, allowing the player to use equipment on a specific target in the game.
 * 
 * <p>
 * The use command checks if the player has the specified equipment and whether it can interact with
 * the target. The target can be a feature, item, or the current room, depending on the game context.
 * </p>
 */
public class Use extends Command {
    String equipmentName;
    String target;

    public Use(String equipmentName, String target){
        this.equipmentName = equipmentName;
        this.target = target;
    }

    @Override
    public String toString(){
        return "USE" + equipmentName + "ON" + target;
    }

    @Override
    public String execute(GameState gameState){
        return "Executing USE";
    }
  
}
