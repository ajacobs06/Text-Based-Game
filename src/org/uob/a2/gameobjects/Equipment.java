package org.uob.a2.gameobjects;

public class Equipment extends GameObject implements Usable {
   
    /**
     * Returns a string representation of this equipment, including the attributes inherited from {@code GameObject}
     * and the associated use information.
     *
     * @return a string describing the equipment
     */

    public Equipment(String id, String name, String description, boolean hidden, UseInformation useInformation){
        this.id = id;
        this.name = name;
        this.description = description;
        this.useInformation = useInformation;

        equipmentList.addEquipment(Equipment);
    }

    public UseInformation getUseInformation(){
        return useInformation;
    }

    public void setUseInformation(UseInformation useInformation){
    }

    public String use(GameObject target, GameState gameState){

    }

    @Override
    public String toString() {
        return super.toString() + ", useInformation=" + useInformation;
    }

}
