package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * Represents the move command, allowing the player to navigate to a different room in the game world.
 * 
 * <p>
 * The move command checks if the specified direction corresponds to an available exit in the current room.
 * If a matching exit is found, the player's location is updated to the connected room.
 * </p>
 */
public class Move extends Command {
    String direction;
    boolean successfulExit = false;

    public Move(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString(){
        return "MOVE " + direction;
    }

    @Override
    public String execute(GameState gameState) {
        for (int i = 0; i < gameState.getMap().getCurrentRoom().getExits().size(); i++){
            if (gameState.getMap().getCurrentRoom().getExits().get(i).getName().equalsIgnoreCase(direction)) {
                gameState.getMap().setCurrentRoom(gameState.getCurrentRoom().getExits().get(i).getNextRoom());
                successfulExit = true;
            }
        }
        if (!successfulExit){
            return "That is an invalid exit.";
        }
        else{
            return "Move successful.\nYou are now in the " + gameState.getMap().getCurrentRoom().getName();
        }
    }

}
