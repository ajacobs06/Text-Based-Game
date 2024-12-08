package org.uob.a2.parser;

import java.util.ArrayList;

import org.uob.a2.commands.*;
import.org.uob.a2.gameobjects.*

/**
 * The {@code Parser} class processes a list of tokens and converts them into {@code Command} objects
 * that can be executed by the game.
 * 
 * <p>
 * The parser identifies the type of command from the tokens and creates the appropriate command object.
 * If the command is invalid or incomplete, a {@code CommandErrorException} is thrown.
 * </p>
 */
public class Parser {
    Equipment equipment;
    Item item;

    public Parser(){

    }

    public Command parse(ArrayList<Token> tokens) throws CommandErrorException{
        ArrayList<Token> variables = new ArrayList<Tokens>();
        for(Token i : variables){
            if(i.getTokenType() == TokenType.VAR){
                variables.add(i);
            }
        }
        for(Token token : variables){
            if(equipmentList.isEquipment(token.getValue())){
                Equipment equipment = equipmentList.getEquipment(token.getValue());
            } else if (itemList.isEquipment(token.getValue())) {
                Item item = item.getItem(token.getValue());
            }
        }
        switch(tokens[0].getTokenType()){
            case TokenType.DROP:
                if(equipment != null) {
                    Drop drop = new Drop(equipment);
                }
                else if(item != null) {
                    Drop drop = new Drop(item);
                }
                return drop;
                break;
            case TokenType.GET:
                if(equipment != null) {
                    Get get = new Get(equipment);
                }
                else if(item != null) {
                    Get get = new Get(item);
                }
                return get;
                break;
            case TokenType.HELP:
                Help help = new Help(tokens[1].getValue());
                break;
            case TokenType.LOOK:
                Look look = new Look(tokens[1].getValue());
                break;
            case TokenType.MOVE:
                Move move = new Move(tokens[1].getValue());
                break;
            case TokenType.QUIT:
                Quit quit = new Quit();
                break;
            case TokenType.STATUS:
                Status status = new Status(tokens[1].getValue());
                break;
            case TokenType.USE:
                if(equipment != null) {
                    Use use = new Use(equipment, variables[1].getValue());
                }
                break;
            default:
                CommandErrorException error = new CommandErrorException();
                error.toString();
                break;
        }
    }

}
