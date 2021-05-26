package net.Arnas.Itemizator.Armor;

class Boots extends EnchantableArmorItem{
    public Boots(String name, int defence, int weight, int maxDurability) {
        super(name, defence, weight, maxDurability);
    }

    @Override
    public int repair() {
        int repaired = Math.min(this.maxDurability - this.durability, 5);
        this.durability += repaired;
        return repaired;
    }
}
