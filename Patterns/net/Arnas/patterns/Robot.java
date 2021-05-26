package net.Arnas.patterns;

public class Robot implements Prototype{
    private String model;
    private String name;
    private int limbCount;
    private String material;

    public Robot(){

    }

    public Robot(Robot baseRobot){
        if(baseRobot == null){
            throw new IllegalArgumentException();
        }
        this.model = baseRobot.model;
        this.name = baseRobot.name;
        this.limbCount = baseRobot.limbCount;
        this.material = baseRobot.material;
    }

    public String getModel() {
        return model;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getLimbCount() {
        return limbCount;
    }

    public void setLimbCount(int limbCount) {
        this.limbCount = limbCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Robot clone(){
        return new Robot(this);
    }
}
