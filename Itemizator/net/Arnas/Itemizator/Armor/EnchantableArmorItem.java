package net.Arnas.Itemizator.Armor;

import net.Arnas.Itemizator.Enchantment.Enchantable;
import net.Arnas.Itemizator.Enchantment.Enchantment;
import net.Arnas.Itemizator.Enchantment.EnchantmentType;

import java.util.ArrayList;
import java.util.Random;

class EnchantableArmorItem extends ArmoredItem implements Enchantable {

    private ArrayList<Enchantment> enchantments = new ArrayList<>();

    public EnchantableArmorItem(String name, int defence, int weight, int maxDurability) {
        super(name, defence, weight, maxDurability);
    }

    @Override
    public void enchant(Enchantment enchantment) {
        enchantments.add(enchantment);
        this.defence += enchantment.getStatBoost();
    }

    @Override
    public ArrayList<Enchantment> getEnchantments() {
        return enchantments;
    }

    @Override
    public int protect() {
        this.durability = Math.max(this.durability-2, 0);
        if(this.durability <= 0) return 0;


        int defenseEnchantments = 0;
        for(Enchantment enchantment : enchantments){
            if(enchantment.getEnchantmentType().equals(EnchantmentType.DEFENSE)){
                defenseEnchantments++;
            }
        }
        return super.protect() * defenseEnchantments;
    }

    @Override
    public boolean parry(){
        this.durability = Math.max(this.durability-4, 0);
        if(this.durability <= 0) return false;


        int parryEnchants = 1;
        for(Enchantment enchantment : enchantments){
            if(enchantment.getEnchantmentType() == EnchantmentType.PARRY){
                parryEnchants++;
            }
        }
        Random random = new Random();
        if(random.nextInt(this.defence) >= this.defence/(2 * parryEnchants)){
            return true;
        }
        return false;
    }
}
