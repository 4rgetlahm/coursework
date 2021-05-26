/**
 * @author Arnas Verpečinskas
 */

package net.Arnas.task;

import java.util.ArrayList;

public class Galaxy {

    private ArrayList<SolarSystem> solarSystems = new ArrayList<>();
    private String name;


    /**
     * Constructor
     * @param name Galaxy name
     */
    public Galaxy(String name){
        this.name = name;
    }

    /**
     *
     * @param solarSystem adds a solar system to galaxy
     */
    public void addSolarSystem(SolarSystem solarSystem){
        solarSystems.add(solarSystem);
    }

    /**
     *
     * @return all solar systems
     */
    public ArrayList<SolarSystem> getSolarSystems(){
        return solarSystems;
    }

    /**
     *
     * @return galaxy name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name galaxy name
     */
    public void setName(String name) {
        this.name = name;
    }

    public void printData(){
        System.out.println(name + ":");
    }

    public void printAllBodies(){
        this.printData();
        for(SolarSystem solarSystem : getSolarSystems()){
            solarSystem.printData();
        }
    }

}
