package org.uob.a2.gameobjects;

public class Fighter extends Item {
    int health;
    String fighterClass;

    public Fighter(String id, String name, String description, boolean hidden, int health, String fighterClass){
        super(id, name, description, hidden);
        this.health = health;
        this.fighterClass = fighterClass;
    }

    public String getFighterClass(){
        return fighterClass;
    }

    public int getHealth(){
        return health;
    }

    public void loseHealth(int lost){
        this.health -= lost;
    }

    public void setFighterClass(String fighterClass){
        this.fighterClass = fighterClass;
    }

}
