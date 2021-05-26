/**
 * @author Arnas Verpečinskas
 */

package net.Arnas.task;

public class Sun extends CelestialBody{

    private double luminosity;

    public Sun(String name, double radius, double luminosity){
        this.setName(name);
        this.setRadius(radius);
        this.luminosity = luminosity;
    }

    /**
     *  prints data of this object
     */
    @Override
    public void printData() {
        System.out.println("  " + this.getName() + " (radius: " + this.getRadius() + " luminosity: " + this.luminosity + ")");
    }


    /**
     * explodes the sun by printing
     */
    @Override
    public void explode() {
        System.out.println("You can't explode a sun!");
    }
}
