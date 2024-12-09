package org.uob.a2.parser;

import java.util.ArrayList;

/**
 * The {@code Tokeniser} class is responsible for converting a string input into a list of tokens
 * that can be parsed into commands by the game.
 * 
 * <p>
 * The tokeniser identifies keywords, variables, and special symbols, assigning each a {@code TokenType}.
 * </p>
 */
public class Tokeniser {

    ArrayList<Token> tokens = new ArrayList<Token>();

   public Tokeniser() {
   }

   public ArrayList<Token> getTokens(){
       return tokens;
   }

   public String sanitise(String s){
          String lowercase_S = s.toLowerCase();
          String sanitisedString = lowercase_S.trim();
          return sanitisedString;
   }

   public void clearTokens(){
       tokens.clear();
   }

   public void tokenise(String s){
       int counter = 0;
       String s_sanitised = sanitise(s);
       String[] sSplit = s_sanitised.split("\\s+");
       for(String i : sSplit){
           switch(i){
               case "drop":
                   tokens.add(new Token(TokenType.DROP));
                   break;
               case "get":
                   tokens.add(new Token(TokenType.GET));
                   break;
               case "help":
                   tokens.add(new Token(TokenType.HELP));
                   break;
               case "look":
                   tokens.add(new Token(TokenType.LOOK));
                   break;
               case "move":
                   tokens.add(new Token(TokenType.MOVE));
                   break;
               case "quit":
                   tokens.add(new Token(TokenType.QUIT));
                   break;
               case "status":
                   tokens.add(new Token(TokenType.STATUS));
                   break;
               case "use":
                   tokens.add(new Token(TokenType.USE));
                   break;
               case "on":
                   tokens.add(new Token(TokenType.PREPOSITION, i));
                   break;
               case "with":
                   tokens.add(new Token(TokenType.PREPOSITION, i));
                   break;
               default:
                   tokens.add(new Token(TokenType.VAR, i));
           }
       }
       tokens.add(new Token(TokenType.EOL));
   }

}
