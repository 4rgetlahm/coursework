/**
 * @author Arnas Verpečinskas
 */

package net.Arnas.task;

import java.util.ArrayList;
import java.util.List;

public class Planet extends CelestialBody{
    private ArrayList<Moon> moonList = new ArrayList<>();

    /**
     *
     * @param name - Planet name
     * @param isHabitable - Planet's habitability
     * @param radius - Planet's radius (kilometers)
     */
    public Planet(String name, boolean isHabitable, double radius){
        this.setName(name);
        this.setHabitable(isHabitable);
        this.setRadius(radius);
    }

    /**
     *
     * @param moon - Moon that is going to be added to a list
     */
    public void addMoon(Moon moon){
        moonList.add(moon);
    }

    /**
     *
     * @return Moonlist
     */
    public List<Moon> getMoonList(){
        return moonList;
    }

    @Override
    public void printData(){
        super.printData();
        for(Moon moon : moonList){
            moon.printData();
        }
    }

    @Override
    public void explode(){
        if(getRadius() >= 4000.0){
            System.out.println("Planet " + this.getName() + " is too big to explode!");
            return;
        }
        System.out.println("Successfully exploded planet: " + this.getName());
    }

}
