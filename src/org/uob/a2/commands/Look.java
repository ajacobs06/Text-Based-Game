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
        this.commandType = CommandType.LOOK;
    }

    @Override
    public String toString() {
        return "LOOK " + target;
    }

    @Override
    public String execute(GameState gameState) {
        lookOutput = "";
        if (target != null) {
            switch (target) {
                case "room":
                    lookOutput += "You are in: " + gameState.getMap().getCurrentRoom().getName() + "\n";
                    lookOutput += gameState.getMap().getCurrentRoom().getDescription();
                    lookOutput += "\nVisible Equipment: " + gameState.getMap().getCurrentRoom().getVisibleEquipmentsDescriptions();
                    lookOutput += "\nVisible Items: " + gameState.getMap().getCurrentRoom().getVisibleItemsDescriptions();
                    break;
                case "exits":
                    lookOutput += "The available exits are: ";
                    for (int i = 0; i < gameState.getMap().getCurrentRoom().getExits().size(); i++) {
                        if (gameState.getMap().getCurrentRoom().getExits().get(i).getHidden() == false) {
                            lookOutput += "A path leading " + gameState.getMap().getCurrentRoom().getExits().get(i).getId();
                        }
                    }
                    break;
                case "features":
                    lookOutput += "You also see: ";
                    for (int i = 0; i < gameState.getMap().getCurrentRoom().getFeatures().size(); i++) {
                        lookOutput += gameState.getMap().getCurrentRoom().getFeatures().get(i).getName().toLowerCase();
                    }
                    break;
                default:
                    if (gameState.getPlayer().hasItem(target)) {
                        lookOutput = gameState.getPlayer().getItem(target).getDescription();
                    } else if (gameState.getPlayer().hasEquipment(target)) {
                        lookOutput = gameState.getPlayer().getEquipment(target).getDescription();
                    } else if (gameState.getMap().getCurrentRoom().hasItem(target)) {
                        try {
                            if (!gameState.getMap().getCurrentRoom().getItemByName(target).getHidden()) {
                                lookOutput = gameState.getMap().getCurrentRoom().getItemByName(target).getDescription();
                            } else {
                                lookOutput = "";
                            }
                        }
                        catch(NullPointerException e) {
                            if (!gameState.getMap().getCurrentRoom().getItem(target).getHidden()) {
                                lookOutput = gameState.getMap().getCurrentRoom().getItem(target).getDescription();
                            } else {
                                lookOutput = "";
                            }
                        }
                    } else if (gameState.getMap().getCurrentRoom().hasEquipment(target)) {
                        try {
                            if (!gameState.getMap().getCurrentRoom().getEquipmentByName(target).getHidden()) {
                                lookOutput = gameState.getMap().getCurrentRoom().getEquipmentByName(target).getDescription();
                            } else {
                                lookOutput = "";
                            }
                        }
                        catch(NullPointerException e) {
                            if (!gameState.getMap().getCurrentRoom().getEquipment(target).getHidden()) {
                                lookOutput = gameState.getMap().getCurrentRoom().getEquipment(target).getDescription();
                            } else {
                                lookOutput = "";
                            }
                        }
                    } else if (gameState.getMap().getCurrentRoom().getFeatureByName(target) != null || gameState.getMap().getCurrentRoom().getFeature(target) != null) {
                        if (!gameState.getMap().getCurrentRoom().getFeatureByName(target).getHidden()) {
                            lookOutput = gameState.getMap().getCurrentRoom().getFeatureByName(target).getDescription();
                        } else {
                            lookOutput = "";
                        }
                    } else {
                        lookOutput = "Invalid target";
                    }
                    break;
            }
            return lookOutput;
        } else {
            return "Invalid Target";
        }

    }

}
