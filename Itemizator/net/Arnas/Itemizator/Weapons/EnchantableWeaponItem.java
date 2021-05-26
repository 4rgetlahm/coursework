package net.Arnas.Itemizator.Weapons;

import net.Arnas.Itemizator.Enchantment.Enchantable;
import net.Arnas.Itemizator.Enchantment.Enchantment;
import net.Arnas.Itemizator.Enchantment.EnchantmentType;

import java.util.ArrayList;

class EnchantableWeaponItem extends WeaponItem implements Enchantable {

    protected ArrayList<Enchantment> enchantments = new ArrayList<>();

    public EnchantableWeaponItem(String name, int damage, double speed, int maxDurability) {
        super(name, damage, speed, maxDurability);
    }

    @Override
    public void enchant(Enchantment enchantment) {
        enchantments.add(enchantment);
        this.damage += enchantment.getStatBoost();
    }

    @Override
    public ArrayList<Enchantment> getEnchantments() {
        return enchantments;
    }

    @Override
    public int damage() {
        this.durability = Math.max(this.durability-2, 0);
        if(this.durability <= 0) return 0;

        int strengthEnchants = 1;
        for(Enchantment enchantment : enchantments){
            if(enchantment.getEnchantmentType().equals(EnchantmentType.STRENGTH)){
                strengthEnchants++;
            }
        }
        return this.damage * strengthEnchants;
    }
}
