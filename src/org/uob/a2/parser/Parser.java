package org.uob.a2.parser;

import java.util.ArrayList;

import org.uob.a2.commands.*;
import org.uob.a2.gameobjects.*;

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
        ArrayList<Token> variables = new ArrayList<Token>();
        for(Token i : variables){
            if(i.getTokenType() == TokenType.VAR){
                variables.add(i);
            }
        }
        switch(tokens.get(0).getTokenType()){
            case DROP:
                Drop drop = new Drop(variables.get(0).getValue());
                return drop;
                break;
            case GET:
                Get get = new Get(variables.get(0).getValue());
                return get;
                break;
            case HELP:
                Help help = new Help(tokens.get(1).getValue());
                break;
            case LOOK:
                Look look = new Look(tokens.get(1).getValue());
                break;
            case MOVE:
                Move move = new Move(tokens.get(1).getValue());
                break;
            case QUIT:
                Quit quit = new Quit();
                break;
            case STATUS:
                Status status = new Status(tokens.get(1).getValue());
                break;
            case USE:
                if(equipment != null) {
                    Use use = new Use(variables.get(0).getValue(), variables.get(1).getValue());
                }
                break;
            default:
                CommandErrorException error = new CommandErrorException("Error");
                error.toString();
                break;
        }
    }

}
