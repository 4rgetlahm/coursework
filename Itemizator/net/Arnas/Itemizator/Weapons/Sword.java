package net.Arnas.Itemizator.Weapons;

import java.util.Random;

class Sword extends WeaponItem{


    public Sword(String name, int damage, double speed, int maxDurability) {
        super(name, damage, speed, maxDurability);
    }

    @Override
    public int repair() {
        Random random = new Random();
        int generatedDurability = Math.min(random.nextInt(this.maxDurability) + this.durability, this.maxDurability);
        int returnDurability = generatedDurability - this.durability;
        this.durability = generatedDurability;
        return returnDurability;
    }

    @Override
    public int damage() {
        this.durability = Math.max(this.durability-5, 0);
        if(this.durability <= 0) return 0;

        Random random = new Random();
        return random.nextInt(2 * this.damage);
    }
}
