package org.uob.a2.gameobjects;

import java.util.Random;

public class Attack {
    int damage;
    double probability;
    Fighter attacker;
    Fighter defender;
    Random rand = new Random();

    public Attack(int damage, double probability, Fighter attacker, Fighter defender) {
        this.damage = damage;
        this.probability = probability;
        this.attacker = attacker;
        this.defender = defender;
    }

    public String doAttack(){
        float chanceAttack = rand.nextFloat(0,1);
        if(chanceAttack<probability){
            defender.loseHealth(damage);
            return defender.getName() + "lost " + damage + " health";
        }
        else{
            return "Attack missed";
        }
    }


}
