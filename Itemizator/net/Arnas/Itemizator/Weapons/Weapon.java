/**
 * @author Arnas Verpecinskas
 * @description Weapon interface that lets interact with Weapon objects
 */

package net.Arnas.Itemizator.Weapons;

import net.Arnas.Itemizator.Enchantment.Enchantable;

public interface Weapon {
    /**
     *
     * @return returns generated weapon damage, always 0 if durability is 0
     */
    int damage();

    /**
     *
     * @return repairs the item, returning repaired amount
     */
    int repair();

    /**
     *
     * @return durability of Armor
     */
    int getDurability();

    /**
     *
     * @return given name
     */
    String getName();

    /**
     *
     * @param name name to set
     */
    void setName(String name);
    /**
     *
     * @return is Armor Enchantable
     */
    boolean isEnchantable();


    /**
     *
     * @return Enchantable if is Enchantable, otherwise null
     */
    Enchantable getEnchantable();

}
