package net.Arnas.Itemizator.Weapons;

public class WeaponFactory{

    private WeaponFactory(){
    }

    /**
     * @param name weapon name
     * @param damage weapon base damage
     * @param speed weapon attack speed rate (attacks/second)
     * @param maxDurability maximum durability of weapon
     * @return Weapon (Sword)
     */
    public static Weapon createSword(String name, int damage, double speed, int maxDurability){
        return new Sword(name, damage, speed, maxDurability);
    }

    /**
     * @param name weapon name
     * @param damage weapon base damage
     * @param speed weapon attack speed rate (attacks/second)
     * @param maxDurability maximum durability of weapon
     * @return Weapon (Dagger)
     */
    public static Weapon createDagger(String name, int damage, double speed, int maxDurability){
        return new Dagger(name, damage, speed, maxDurability);
    }
}
