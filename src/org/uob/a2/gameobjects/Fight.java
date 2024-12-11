package org.uob.a2.gameobjects;

import java.util.Scanner;

public class Fight {
    Fighter player;
    Fighter opponent;
    Boolean won;
    Attack lightAttackPlayer;
    Attack heavyAttackPlayer;
    Attack lightAttackEnemy;
    Attack heavyAttackEnemy;
    Scanner sc = new Scanner(System.in);
    boolean fightState = false;
    String attack;

    public Fight(Fighter player, Fighter opponent){
        this.player = player;
        this.opponent = opponent;
    }

    public String initiateFight(){
        lightAttackPlayer = null;
        heavyAttackPlayer = null;
        heavyAttackEnemy = new Attack(30,0.3,opponent, player);
        lightAttackEnemy = new Attack(15, 0.6, opponent, player);
        switch(player.getFighterClass()){
            case "tank":
                heavyAttackPlayer = new Attack(50, 0.4, player, opponent);
                lightAttackPlayer = new Attack(10,0.8,player,opponent);
                break;
            case "assassin":
                heavyAttackPlayer = new Attack(30,0.4,player,opponent);
                lightAttackPlayer = new Attack(20, 0.9, player, opponent);
                break;
            case "warrior":
                heavyAttackPlayer = new Attack(40, 0.4, player, opponent);
                lightAttackPlayer = new Attack(20, 0.7, player, opponent);
                break;
        }
        while(player.getHealth()>0 && opponent.getHealth()>0) {
            System.out.println("Enter heavy or light for those respective attacks:");
            attack = sc.nextLine();
            if(attack.equals("heavy")){
                System.out.println(heavyAttackPlayer.doAttack());
            }
            else if(attack.equals("light")){
                System.out.println(lightAttackPlayer.doAttack());
            }
            if(Math.random()>0.5){
                System.out.println("Enemy uses heavy attack.");
                System.out.println(heavyAttackEnemy.doAttack());
            }
            else{
                System.out.println("Enemy uses light attack.");
                System.out.println(lightAttackEnemy.doAttack());
            }
            System.out.println("Player Health: " + player.getHealth());
            System.out.println("Opponent's Health: " + opponent.getHealth());

        }
        if(player.getHealth()>0 && opponent.getHealth()<1){
            Score.addScore(100);
            return "Player won - 100 points added to score";
        }
        else{
            Score.removeScore(50);
            return "Player lost - 50 points removed from score";
        }
    }

}
