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

   public Tokeniser() {
   }

   public ArrayList<Token> getTokens(){
       return tokens;
   }

   public String sanitise(String s){
          String lowercase_S = s.toLowerCase();
          String sanitisedStrig = lowercase_S.replaceAll(" ", "");
          return sanitisedString;
   }

   public void tokenise(String s){
       int counter = 0
       String[] sSplit = s.split(" ");
       String[] vars = new String[10];
       for(int i = 0; i < sSplit.length; i++){
           sSplit[i] = sSplit[i].toLowerCase();
       }
       String s = sanitise(s);
       ArrayList<Token> tokens = new ArrayList<Token>();
       for(String i : sSplit){
           for(TokenType t : TokenType.values()){
               if(i.equalsIgnoreCase(TokenType.t.toString())){
                   tokens.add(new Token(TokenType.t));
               }
               else if(i.equalsIgnoreCase("with") || i.equalsIgnoreCase("on")){
                   tokens.add(new Token(TokenType.PREPOSITION))
               }
               else{
                   vars[counter] = i;
                   counter++;
               }
           }
       }
       for(String i : vars){
           if(i != null) {
               tokens.add(new Token(TokenType.VAR, i));
           }
       }
       tokens.add(new Token(TokenType.EOL));
   }

}
