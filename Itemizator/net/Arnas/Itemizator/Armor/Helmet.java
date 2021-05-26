package net.Arnas.Itemizator.Armor;

class Helmet extends ArmoredItem{

    public Helmet(String name, int defence, int weight, int maxDurability) {
        super(name, defence, weight, maxDurability);
    }

    @Override
    public int repair() {
        int repaired = Math.min(this.maxDurability - this.durability, 10);
        this.durability += repaired;
        return repaired;
    }
}
