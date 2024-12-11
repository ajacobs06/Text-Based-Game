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
    String useTypes;

    public Use(String equipmentName, String target){
        this.equipmentName = equipmentName;
        this.target = target;
        this.commandType = CommandType.USE;
    }

    @Override
    public String toString(){
        return "USE" + equipmentName + "ON" + target;
    }

    @Override
    public String execute(GameState gameState){
        String targetId = null;
        String revealedId = null;
        if(gameState.getPlayer().hasEquipment(equipmentName)) {
            try {
                targetId = gameState.getMap().getCurrentRoom().getObject(target).getId();
            }
            catch(NullPointerException e) {
                if(gameState.getMap().getCurrentRoom().getName().equals(target)) {
                    targetId = gameState.getMap().getCurrentRoom().getId();
                }
            }
            revealedId = gameState.getPlayer().getEquipment(equipmentName).getUseInformation().getResult();
            if (gameState.getPlayer().getEquipment(equipmentName).getUseInformation().getTarget().equals(targetId) && gameState.getPlayer().getEquipment(equipmentName).getUseInformation().isUsed() == false) {
                gameState.getPlayer().getEquipment(equipmentName).getUseInformation().setUsed(true);
                useTypes = gameState.getPlayer().getEquipment(equipmentName).getUseInformation().getAction();
                switch(useTypes){
                    case "reveal":
                        gameState.getMap().getCurrentRoom().revealAll();
                        break;
                    case "open":
                        try {
                            gameState.getMap().getCurrentRoom().getObjectById(revealedId).setHidden(false);
                            return gameState.getPlayer().getEquipment(equipmentName).getUseInformation().getMessage();
                        }
                        catch(NullPointerException e) {
                            return gameState.getPlayer().getEquipment(equipmentName).getUseInformation().getMessage();
                        }

                }
                return gameState.getPlayer().getEquipment(equipmentName).getUseInformation().getMessage();
            } else if (gameState.getPlayer().getEquipment(equipmentName).getUseInformation().isUsed() == true) {
                return "You have already used " + equipmentName;
            } else {
                return "Invalid use target";
            }
        }
        else{
            return "You do not have this piece of equipment";
        }
    }
  
}
