package net.Arnas.Itemizator.Weapons;


class Dagger extends EnchantableWeaponItem{

    public Dagger(String name, int damage, double speed, int maxDurability) {
        super(name, damage, speed, maxDurability);
    }

    @Override
    public int repair() {
        this.durability = Math.max(this.durability-2, 0);
        if(this.durability <= 0) return 0;

        int repaired = this.maxDurability - this.durability;
        this.durability += this.maxDurability;
        return repaired;
    }
}
