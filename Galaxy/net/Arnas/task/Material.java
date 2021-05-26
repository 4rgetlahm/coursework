/**
 * @author Arnas Verpečinskas
 */

package net.Arnas.task;

public class Material {
    private String name;
    private double density;

    /**
     *
     * @param name Material name
     * @param density Density of the material in kg/m^3
     */
    public Material(String name, double density){
        this.name = name;
        this.density = density;
    }

    /**
     *
     * @return density of the material in kg/m^3
     */
    public double getDensity() {
        return density;
    }

    /**
     *
     * @return name of material
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name name of the material
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param density density of the object in kg/m^3
     */
    public void setDensity(double density) {
        this.density = density;
    }
}
