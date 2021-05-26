package net.Arnas.planes;

public class MilitaryPlane extends Plane{

    private int gunCount;
    private String ammoType;
    private int ammoAmount = 0;

    public MilitaryPlane(String model, int engineCount, int seatCount){
        super(model, engineCount, seatCount);
    }

    public MilitaryPlane(String model, int engineCount, int seatCount, int gunCount, String ammoType){
        super(model, engineCount, seatCount);
        this.gunCount = gunCount;
        this.ammoType = ammoType;
    }

    @Override
    public String toString(){
        return "Model: " + this.model + " Engine count: " + this.engineCount + " Seat count: " + this.seatCount + " Gun Count: " + gunCount + " Ammo type: " + ammoType + " Ammo amount: " + this
                .ammoAmount;
    }
}
