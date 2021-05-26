/**
 * @author Arnas Verpečinskas
 */

package net.Arnas.task;

import java.util.ArrayList;

public class SolarSystem {
    private ArrayList<Planet> planetList = new ArrayList<>();
    private Sun sun;
    private double diameter;
    private String name;


    /**
     *
     * @param name Solar System's name
     * @param sun Sun of the solar system
     * @param diameter Diameter of solar system
     */
    public SolarSystem(String name, Sun sun, double diameter){
        this.name = name;
        this.diameter = diameter;
        this.sun = sun;
    }

    /**
     *
     * @return Solar System's diameter (in Astronomical Unit)
     */
    public double getDiameter() {
        return diameter;
    }

    /**
     *
     * @param diameter sets Solar System's diameter (in Astronomical Units)
     */
    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    /**
     *
     * @param planet adds Planet to the list
     */
    public void addPlanet(Planet planet){
        planetList.add(planet);
    }

    /**
     *
     * @param sun sets Solar System's sun
     */
    public void setSun(Sun sun){
        this.sun = sun;
    }

    /**
     *
     * @return List of planets in Solar System
     */
    public ArrayList<Planet> getPlanetList(){
        return planetList;
    }

    /**
     *
     * @return Sun object
     */
    public Sun getSun(){
        return sun;
    }

    public void printData(){
        System.out.println("  " + this.name + " (sun: " + this.sun.getName() + ", diameter:" + this.diameter + ")");
        for(Planet planet : this.getPlanetList()){
            planet.printData();
        }
    }

}
