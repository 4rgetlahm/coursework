package net.Arnas.planes;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;

public class Plane implements Serializable, Flyable{
    protected String model;
    protected int engineCount;
    protected int seatCount;

    private double x, y;

    public Plane(String model, int engineCount, int seatCount){
        this.model = model;
        this.engineCount = engineCount;
        this.seatCount = seatCount;

    }

    @Override
    public void fly(double x, double y) throws NoEngineException {
        if(this.engineCount == 0){
            throw new NoEngineException();
        }
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return "Model: " + this.model + " Engine count: " + this.engineCount + " Seat count: " + this.seatCount;
    }
}
