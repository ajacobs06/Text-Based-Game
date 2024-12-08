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
    String topic;

    public Help(String topic) {
        this.topic = topic;
    }

    public String toString(){

    }

    public String execute(GameState gameState) {
        switch topic {
            case "move":
                return "Use 'move' followed by an exit to leave the room and move into the next.";
                break;
            case "look":
                return "Use 'look' followed by one of the following things to explore the world: \n    room\n    exit\n" +
                        "    features\n    item name\n    equipment name\n    feature name";
                break;
            case "use":
                return "Use 'use' in the following format to interact with equipments, features and items:\n    use <equipment name> on|with <feature|item>";
                break;
            case "drop":
                return "Use 'drop' follwed by one of the following things to remove it from your player:\n    item name\n    equipment name";
                break;
            case "get":
                return "Use 'get' followed by one of the following things to pick them up:\n    item name\n    equipment name";
                break;
            case "status":
                return "Use 'status' followed by one of the following:\n    inventory\n    player\n    item name\n    equipment name\n    map\n    score";
                break;
            case "combine":
                return "Use 'combine' in the following format:\n    combine <item1> <item2>";
                break;
            case null:
                return "Here are a list of commands and the ways to use them:\n" +
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
                return "That is not a valid topic for the help command. Try just typing 'help'.";
                break;

        }
    }
  
}
