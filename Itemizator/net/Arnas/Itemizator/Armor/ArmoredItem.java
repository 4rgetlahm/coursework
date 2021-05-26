package net.Arnas.Itemizator.Armor;

import net.Arnas.Itemizator.Enchantment.Enchantable;

import java.util.Random;

class ArmoredItem implements Armor {
    protected String name;
    protected int defence;
    protected int weight;
    protected int durability, maxDurability;

    public ArmoredItem(String name, int defence, int weight, int maxDurability){
        this.name = name;
        this.defence = defence;
        this.weight = weight;
        this.maxDurability = maxDurability;
        this.durability = this.maxDurability;
    }

    @Override
    public int protect() {
        this.durability = Math.max(this.durability-1, 0);
        if(this.durability <= 0) return 0;

        return defence;
    }

    public boolean parry(){
        this.durability = Math.max(this.durability-1, 0);
        if(this.durability <= 0) return false;

        Random random = new Random();
        if(random.nextInt(this.defence) >= this.defence/2){
            return true;
        }
        return false;
    }

    @Override
    public boolean isEnchantable() {
        if(this instanceof Enchantable){
            return true;
        }
        return false;
    }


    @Override
    public Enchantable getEnchantable() {
        if(this instanceof Enchantable){
            return (Enchantable) this;
        }
        return null;
    }

    @Override
    public int repair() {
        return 0;
    }

    @Override
    public int getDurability() {
        return this.durability;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

}
