package org.uob.a2.gameobjects;

import java.util.Scanner;

public class Equipment extends GameObject implements Usable {
   
    /**
     * Returns a string representation of this equipment, including the attributes inherited from {@code GameObject}
     * and the associated use information.
     *
     * @return a string describing the equipment
     */

    protected UseInformation useInformation;
    Fight fight;
    Scanner sc = new Scanner(System.in);

    public Equipment(String id, String name, String description, boolean hidden, UseInformation useInformation){
        super(id, name, description, hidden);
        this.useInformation = useInformation;
    }

    @Override
    public UseInformation getUseInformation(){
        return useInformation;
    }

    @Override
    public void setUseInformation(UseInformation useInformation){
        this.useInformation = useInformation;
    }

    public String use(GameObject target, GameState gameState){
        String useTypes = getUseInformation().getAction();
        String resultId;
        switch(useTypes){
            case "reveal":
                gameState.getPlayer().getEquipment(name).getUseInformation().setUsed(true);
                gameState.getMap().getCurrentRoom().revealAll();
                Score.addScore(15);
                return getUseInformation().getMessage();
            case "open":
                gameState.getPlayer().getEquipment(name).getUseInformation().setUsed(true);
                resultId = getUseInformation().getResult();
                Score.addScore(15);
                try{
                    gameState.getMap().getCurrentRoom().getObjectById(resultId).setHidden(false);
                }
                catch(NullPointerException e){
                    gameState.getMap().getCurrentRoom().setHidden(true);
                }
                return getUseInformation().getMessage();
            case "fight":
                if(gameState.getPlayer().getFighter() != null) {
                    gameState.getPlayer().getEquipment(name).getUseInformation().setUsed(true);
                    System.out.println("You have the choice of fighter class. Tank/Assasin/Warrior.\nTank has a strong heavy attack but a weak light attack\nAssassin has a strong light attack but a weak heavy attack.\nWarrior is a balance of both.");
                    String fighterClass = sc.nextLine();
                    gameState.getPlayer().getFighter().setFighterClass(fighterClass);
                    fight = new Fight(gameState.getPlayer().getFighter(), gameState.getMap().getCurrentRoom().getFighter());
                    return fight.initiateFight();
                }
                else{
                    return "You do not have a bot to fight with";
                }
            default:
                return "Not a valid use type.";

        }
    }

    @Override
    public String toString() {
        return super.toString() + ", useInformation=" + useInformation;
    }

}
