/**
 * @author Arnas Verpecinskas
 * @description Enchantment object that can be used with Enchantable objects
 */

package net.Arnas.Itemizator.Enchantment;

import java.awt.*;

public class Enchantment {
    private String name;
    private Color color;
    private int statBoost;
    private EnchantmentType enchantmentType;


    /**
     *
     * @param enchantmentType type of enchantment
     * @param name name of the enchantment
     * @param color color of the enchantment
     * @param statBoost how much will increase stats
     */
    public Enchantment(EnchantmentType enchantmentType, String name, Color color, int statBoost){
        this.name = name;
        this.color = color;
        this.statBoost = statBoost;
        this.enchantmentType = enchantmentType;
    }

    /**
     *
     * @return stat boost
     */
    public int getStatBoost(){
        return this.statBoost;
    }

    /**
     *
     * @return enchantment type
     */
    public EnchantmentType getEnchantmentType(){
        return this.enchantmentType;
    }

    /**
     *
     * @return enchantment name
     */
    public String getName(){
        return this.name;
    }

    /**
     *
     * @return enchantment color
     */
    public Color getColor(){
        return this.color;
    }
}
