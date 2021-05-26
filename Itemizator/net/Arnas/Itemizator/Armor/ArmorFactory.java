package net.Arnas.Itemizator.Armor;

import java.util.Random;

public class ArmorFactory {

    private ArmorFactory(){

    }

    /**
     * @param name name of the armor
     * @param defence base defence amount
     * @param weight weight of the armor
     * @param maxDurability maximum durability that armor can get
     * @return Armor (Helmet)
     */
    public static Armor createHelmet(String name, int defence, int weight, int maxDurability){
        return new Helmet(name, defence, weight, maxDurability);
    }

    /**
     * @param name name of the armor
     * @param defence base defence amount
     * @param weight weight of the armor
     * @param maxDurability maximum durability that armor can get
     * @return Armor (Chestplate)
     */
    public static Armor createChestplate(String name, int defence, int weight, int maxDurability){
        return new Chestplate(name, defence, weight, maxDurability);
    }

    /**
     * @param name name of the armor
     * @param defence base defence amount
     * @param weight weight of the armor
     * @param maxDurability maximum durability that armor can get
     * @return Armor (Leggings)
     */
    public static Armor createLeggings(String name, int defence, int weight, int maxDurability){
        return new Leggings(name, defence, weight, maxDurability);
    }

    /**
     * @param name name of the armor
     * @param defence base defence amount
     * @param weight weight of the armor
     * @param maxDurability maximum durability that armor can get
     * @return Armor (Boots)
     */
    public static Armor createBoots(String name, int defence, int weight, int maxDurability){
        return new Boots(name, defence, weight, maxDurability);
    }





    /**
     *
     * @return random Armor (Leggings/Chestplate/Boots/Helmet) with random parameters
     */
    public static Armor createRandomArmor(){
        Random random = new Random();
        int randomGenerated = random.nextInt(3);
        switch (randomGenerated){
            case 1:
                return new Leggings("Random Leggings", random.nextInt(200), random.nextInt(200), random.nextInt(200));
            case 2:
                return new Chestplate("Random Chestplate", random.nextInt(300), random.nextInt(300), random.nextInt(300));
            case 3:
                return new Boots("Random Boots", random.nextInt(300), random.nextInt(300), random.nextInt(300));
            default:
                return new Helmet("Random Helmet", random.nextInt(100), random.nextInt(100), random.nextInt(200));
        }
    }


}
