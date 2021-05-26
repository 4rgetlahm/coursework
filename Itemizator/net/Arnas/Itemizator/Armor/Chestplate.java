package net.Arnas.Itemizator.Armor;

class Chestplate extends EnchantableArmorItem{

    public Chestplate(String name, int defence, int weight, int maxDurability) {
        super(name, defence, weight, maxDurability);
    }

    @Override
    public int repair() {
        int repaired = Math.min(this.maxDurability - this.durability, 30);
        this.durability += repaired;
        return repaired;
    }
}
