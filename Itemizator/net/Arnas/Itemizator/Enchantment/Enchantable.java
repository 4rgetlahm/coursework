/**
 * @author Arnas Verpecinskas
 * @description Enchantable interface that lets interact with Enchantable objects (Armor, Weapon)
 */

package net.Arnas.Itemizator.Enchantment;

import java.util.ArrayList;

public interface Enchantable {
    /**
     *
     * @param enchantment enchantment to enchant with
     */
    void enchant(Enchantment enchantment);

    /**
     *
     * @return list of current enchantments
     */
    ArrayList<Enchantment> getEnchantments();
}
