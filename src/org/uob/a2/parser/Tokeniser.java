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

   public void tokenise(String s){
       int counter = 0;
       String[] sSplit = s.split("\\s+");
       for(int i = 0; i < sSplit.length; i++){
           sSplit[i] = sSplit[i].toLowerCase();
       }
       String s_sanitised = sanitise(s);
       for(String i : sSplit){
           for(TokenType t : TokenType.values()){
               if(i.equalsIgnoreCase(t.toString())){
                   tokens.add(new Token(t));
               }
               else if(i.equalsIgnoreCase("with")){
                   tokens.add(new Token(TokenType.PREPOSITION), "with");
               }
               else if(i.equalsIgnoreCase("on")){
                   tokens.add(new Token(TokenType.PREPOSITION, "on"));
               }
               else{
                   tokens.add(new Token(TokenType.VAR, i));
               }
           }
       }
       tokens.add(new Token(TokenType.EOL));
   }

}
