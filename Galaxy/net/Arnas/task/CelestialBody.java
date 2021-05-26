/**
 * @author Arnas Verpečinskas
 */

package net.Arnas.task;

import java.util.ArrayList;

public abstract class CelestialBody {
    private String name;
    private double radius;
    private boolean habitable;
    private ArrayList<Material> materialList = new ArrayList<>();

    /**
     * prints out CelestialBody data if it is not overridden
     */
    public void printData(){
        System.out.println("    " + this.getName() + " (radius: " + this.getRadius() + ", habitable: " + this.isHabitable() + ")");
        for(Material material : this.getMaterialList()){
            System.out.println("      " + material.getName());
        }
    }

    /**
     *
     * @param name sets object's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return is planet habitable
     */
    public boolean isHabitable() {
        return habitable;
    }

    /**
     *
     * @param habitable sets object's habitability
     */
    public void setHabitable(boolean habitable) {
        this.habitable = habitable;
    }

    /**
     *
     * @return object's name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param material - adds material of the object to a list
     */
    public void addMaterial(Material material){
        materialList.add(material);
    }

    /**
     *
     * @param radius sets radius of an object (in kilometers)
     */
    public void setRadius(double radius){
        this.radius = radius;
    }

    /**
     *
     * @return radius of an object (in kilometers)
     */
    public double getRadius() {
        return radius;
    }

    /**
     *
     * @return list of materials in the object
     */
    public ArrayList<Material> getMaterialList(){
        return materialList;
    }

    /**
     * Explodes the object, sending a message to user on what he has done
     */
    public abstract void explode();

}
