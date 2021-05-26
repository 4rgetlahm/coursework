/**
 * @author Arnas Verpečinskas
 */

package net.Arnas.task;

public class Moon extends CelestialBody{
    /**
     * Constructor
     * @param name - moon name
     * @param isHabitable - moon's habitability
     * @param radius - radius of a moon (kilometers)
     */
    public Moon(String name, boolean isHabitable, double radius){
        this.setName(name);
        this.setRadius(radius);
        this.setHabitable(isHabitable);
    }

    /**
     * Crashes a meteor on the moon
     */
    public void crashMeteor(){
        System.out.println("Meteor crashed into: " + this.getName());
    }

    @Override
    public void printData() {
        System.out.print("•");
        super.printData();
    }

    /**
     * if moon is eligible, will be exploded by printing that
     */
    @Override
    public void explode(){
        if(getRadius() >= 200.0){
            System.out.println("Moon " + this.getName() + " is too big to explode!");
            return;
        }
        System.out.println("Successfully exploded moon: " + this.getName());
    }
}
