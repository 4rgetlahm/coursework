/**
 * @author Arnas Verpecinskas
 * @description Armor interface that lets interact with Armor objects
 */

package net.Arnas.Itemizator.Armor;

import net.Arnas.Itemizator.Enchantment.Enchantable;

public interface Armor {
    /**
     *
     * @return generated protection amount, always 0 if Armor durability is 0
     */
    int protect();


    /**
     *
     * @return generated value if attack is parried or not, always false if Armor durability is 0
     */
    boolean parry();

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
