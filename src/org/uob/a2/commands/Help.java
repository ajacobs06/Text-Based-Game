package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * Represents the help command, providing the player with instructions or information
 * about various topics related to the game.
 * 
 * <p>
 * The help command displays information on how to play the game, including details about 
 * available commands, their syntax, and their purpose.
 * </p>
 */
public class Help extends Command {
    String topic = "topic";
    String helpOutput;

    public Help(String topic) {
        this.topic = topic;
    }

    @Override
    public String toString(){
        return "Help " + topic;
    }

    @Override
    public String execute(GameState gameState) {
        switch(topic) {
            case "move":
                helpOutput = "Use 'move' followed by an exit to leave the room and move into the next.";
                break;
            case "look":
                helpOutput = "Use 'look' followed by one of the following things to explore the world: \n    room\n    exit\n" +
                        "    features\n    item name\n    equipment name\n    feature name";
                break;
            case "use":
                helpOutput = "Use 'use' in the following format to interact with equipments, features and items:\n    use <equipment name> on|with <feature|item>";
                break;
            case "drop":
                helpOutput = "Use 'drop' follwed by one of the following things to remove it from your player:\n    item name\n    equipment name";
                break;
            case "get":
                helpOutput = "Use 'get' followed by one of the following things to pick them up:\n    item name\n    equipment name";
                break;
            case "status":
                helpOutput = "Use 'status' followed by one of the following:\n    inventory\n    player\n    item name\n    equipment name\n    map\n    score";
                break;
            case "combine":
                helpOutput = "Use 'combine' in the following format:\n    combine <item1> <item2>";
                break;
            case "topic":
                helpOutput = "Here are a list of commands and the ways to use them:\n" +
                        "Use 'move' followed by an exit to leave the room and move into the next.\n" +
                        "Use 'look' followed by one of the following things to explore the world: \n    room\n    exit\n" +
                        "features\n    item name\n    equipment name\n    feature name\n" +
                        "Use 'use' in the following format to interact with equipments, features and items:\n    use <equipment name> on|with <feature|item>\n" +
                        "Use 'drop' follwed by one of the following things to remove it from your player:\n    item name\n    equipment name\n" +
                        "Use 'get' followed by one of the following things to pick them up:\n    item name\n    equipment name\n" +
                        "Use 'status' followed by one of the following:\n    inventory\n    player\n    item name\n    equipment name\n    map\n    score\n" +
                        "Use 'combine' in the following format:\n    combine <item1> <item2>";
                break;
            default:
                helpOutput = "That is not a valid topic for the help command. Try just typing 'help'.";
                break;

        }
        return helpOutput;
    }
  
}
