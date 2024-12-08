package org.uob.a2.gameobjects;

/**
 * Represents an exit in the game, allowing the player to move from one room to another.
 * 
 * <p>
 * Exits have a destination (next room), a description, and can be hidden or visible based on game logic.
 * </p>
 */
public class Exit extends GameObject {

    public void Exit(String id, String name, String description, String nextRoom, boolean Hidden){
        this.id = id;
        this.name = name;
        this.description = description;
        this.nextRoom = nextRoom;
        this.Hidden = Hidden;
    }

    public String getNextRoom(){
        return nextRoom();
    }


   

    /**
     * Returns a string representation of the exit, including attributes inherited from {@code GameObject}
     * and the identifier of the next room.
     *
     * @return a string describing the exit
     */
    @Override
    public String toString() {
        return super.toString() + ", nextRoom=" + nextRoom;
    }
}
