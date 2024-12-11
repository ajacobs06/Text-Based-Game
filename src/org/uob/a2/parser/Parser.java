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
        ArrayList<Token> variables = new ArrayList<Token>();
        ArrayList<Integer> removeTokens = new ArrayList<Integer>();
        int count = 0;
        for(Token i : tokens){
            if(i.getTokenType() == TokenType.VAR){
                variables.add(i);
            }
            count++;
        }
        /*for(int j=0; j<tokens.size(); j++) {
            try {
                if (tokens.get(j).getTokenType() == TokenType.VAR) {
                    tokens.remove(j);
                }
            }
            catch(IndexOutOfBoundsException e){
                break;
            }
        }*/
        if(variables.size() != 0) {
            for(int i=0; i<tokens.size(); i++) {
                switch (tokens.get(i).getTokenType()) {
                    case DROP:
                        Drop drop = new Drop(variables.get(0).getValue());
                        return drop;
                    case GET:
                        Get get = new Get(variables.get(0).getValue());
                        return get;
                    case HELP:
                        Help help = new Help(variables.get(0).getValue());
                        return help;
                    case LOOK:
                        Look look = new Look(variables.get(0).getValue());
                        return look;
                    case MOVE:
                        Move move = new Move(variables.get(0).getValue());
                        return move;
                    case QUIT:
                        Quit quit = new Quit();
                        return quit;
                    case STATUS:
                        Status status = new Status(variables.get(0).getValue());
                        return status;
                    case USE:
                        if (variables.size() > 1) {
                            Use use = new Use(variables.get(0).getValue(), variables.get(1).getValue());
                            return use;
                        } else {
                            throw new CommandErrorException("Invalid number of arguments. 2 required.");
                        }
                    case ERROR:
                        throw new CommandErrorException("Invalid Command");
                    default:
                        return null;
                }
            }
        }
        else{
            switch(tokens.get(0).getTokenType()){
                case DROP:
                    throw new CommandErrorException("DROP requires an argument.");
                case GET:
                    throw new CommandErrorException("GET requires an argument.");
                case HELP:
                    Help help = new Help("topic");
                    return help;
                case LOOK:
                    throw new CommandErrorException("LOOK requires an argument.");
                case MOVE:
                    throw new CommandErrorException("MOVE requires an argument.");
                case QUIT:
                    Quit quit = new Quit();
                    return quit;
                case STATUS:
                    throw new CommandErrorException("STATUS requires an argument.");
                case USE:
                    throw new CommandErrorException("USE requires two arguments.");
                case ERROR:
                    throw new CommandErrorException("Invalid Command");
                default:
                    return null;
            }
        }
        return null;
    }

}
