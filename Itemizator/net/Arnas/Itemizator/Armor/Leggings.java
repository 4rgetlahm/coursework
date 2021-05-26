package net.Arnas.Itemizator.Armor;

class Leggings extends EnchantableArmorItem{
    public Leggings(String name, int defence, int weight, int maxDurability) {
        super(name, defence, weight, maxDurability);
    }

    @Override
    public int repair() {
        int repaired = Math.min(this.maxDurability - this.durability, 20);
        this.durability += repaired;
        return repaired;
    }
}
