package net.Arnas.Itemizator.Weapons;

import net.Arnas.Itemizator.Enchantment.Enchantable;

class WeaponItem implements Weapon {
    protected String name;
    protected int damage;
    protected double speed;
    protected int durability, maxDurability;

    public WeaponItem(String name, int damage, double speed, int maxDurability){
        this.name = name;
        this.damage = damage;
        this.speed = speed;
        this.maxDurability = maxDurability;
        this.durability = this.maxDurability;
    }

    @Override
    public int damage() {
        this.durability = Math.max(this.durability-1, 0);
        if(this.durability <= 0) return 0;

        return this.damage;
    }

    @Override
    public int repair() {
        this.durability++;
        return 1;
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

}
