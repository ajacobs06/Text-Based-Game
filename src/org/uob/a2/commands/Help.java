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
    String helpOutput;

    public Help(String topic) {
        this.topic = topic;
        this.commandType = CommandType.HELP;
    }

    @Override
    public String toString(){
        return "HELP " + topic;
    }

    @Override
    public String execute(GameState gameState) {
        if(topic != null) {
            switch (topic) {
                case "move":
                    helpOutput = "MOVE Command: Use the 'move' command followed by the direction of an exit to leave the room and move into the next.";
                    break;
                case "look":
                    helpOutput = "LOOK Command: Use the 'look' command followed by one of the following things to explore the world: \n    room\n    exit\n" +
                            "    features\n    item name\n    equipment name\n    feature name";
                    break;
                case "use":
                    helpOutput = "USE Command: Use the 'use' command in the following format to interact with equipments, features and items:\n    use <equipment name> on|with <feature|item>";
                    break;
                case "drop":
                    helpOutput = "DROP Command: Use the 'drop' command follwed by one of the following things to remove it from your player:\n    item name\n    equipment name";
                    break;
                case "get":
                    helpOutput = "GET Command: Use the 'get' command followed by one of the following things to pick them up:\n    item name\n    equipment name";
                    break;
                case "status":
                    helpOutput = "STATUS Command: Use the 'status' command followed by one of the following:\n    inventory\n    player\n    item name\n    equipment name\n    map\n    score";
                    break;
                case "combine":
                    helpOutput = "COMBINE Command: Use the 'combine' command in the following format:\n    combine <item1> <item2>";
                    break;
                default:
                    helpOutput = "No help available for the topic: " + topic;
                    break;

            }
        }
        else{
            helpOutput = "Welcome to the game! Here are a list of commands and the ways to use them:\n" +
                    "- MOVE - Use 'move' followed by an exit to leave the room and move into the next.\n" +
                    "- LOOK - Use 'look' followed by one of the following things to explore the world: \n    room\n    exit\n" +
                    "- features\n    item name\n    equipment name\n    feature name\n" +
                    "- USE - Use 'use' in the following format to interact with equipments, features and items:\n    use <equipment name> on|with <feature|item>\n" +
                    "- DROP - Use 'drop' follwed by one of the following things to remove it from your player:\n    item name\n    equipment name\n" +
                    "- GET - Use 'get' followed by one of the following things to pick them up:\n    item name\n    equipment name\n" +
                    "- STATUS - Use 'status' followed by one of the following:\n    inventory\n    player\n    item name\n    equipment name\n    map\n    score\n" +
                    "- COMBINE - Use 'combine' in the following format:\n    combine <item1> <item2>" +
                    "- HELP - Use 'help' followed by a command to learn about the specific command.";
        }
        return helpOutput;
    }
  
}
