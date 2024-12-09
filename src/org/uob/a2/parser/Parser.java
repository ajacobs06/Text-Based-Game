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

    public Parser(){

    }

    public Command parse(ArrayList<Token> tokens) throws CommandErrorException{
        //CommandErrorException exception = new CommandErrorException("Invalid input");
        ArrayList<Token> variables = new ArrayList<Token>();
        for(Token i : variables){
            if(i.getTokenType() == TokenType.VAR){
                variables.add(i);
            }
        }
        switch (tokens.get(0).getTokenType()) {
            case DROP:
                Drop drop = new Drop(variables.get(0).getValue());
                return drop;
            case GET:
                Get get = new Get(variables.get(0).getValue());
                return get;
            case HELP:
                Help help = new Help(tokens.get(1).getValue());
                return help;
            case LOOK:
                Look look = new Look(tokens.get(1).getValue());
                return look;
            case MOVE:
                Move move = new Move(tokens.get(1).getValue());
                return move;
            case QUIT:
                Quit quit = new Quit();
                return quit;
            case STATUS:
                Status status = new Status(tokens.get(1).getValue());
                return status;
            case USE:
                Use use = new Use(variables.get(0).getValue(), variables.get(1).getValue());
                return use;
            case ERROR:
                throw new CommandErrorException("Invalid Command");
            default:
                return null;
        }
    }

}
