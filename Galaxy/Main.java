import net.Arnas.task.*;


public class Main {
    public static void main(String args[]){
        Galaxy galaxy = new Galaxy("Milky Way");
        Galaxy galaxy2 = new Galaxy();

        Sun sun = new Sun("Sun", 696340.0, 1.0);

        SolarSystem solarSystem1 = new SolarSystem("Solar System", sun, 100000.0);
        SolarSystem solarSystem2 = new SolarSystem("Kepler-90", new Sun("Kepler-90", 834840.0, 1.77), 999999.0);

        Planet planet1 = new Planet("Earth", true, 6371.0);
        Planet planet2 = new Planet("Mars", false, 3389.5);

        Planet keplerPlanet = new Planet("Kepler-90b", false, 8355.5);

        planet1.addMaterial(new Material("Air", 1.0));
        planet1.addMaterial(new Material("Stone", 1100.0));

        planet2.addMaterial(new Material("Sand", 800.0));

        keplerPlanet.addMaterial(new Material("Gravel", 980.0));

        Moon moon = new Moon("Moon", false, 1737.1);
        moon.addMaterial(new Material("Stone", 1231.0));
        planet1.addMoon(moon);

        Moon imaginativeMoon = new Moon("Luna", false, 2134.0);
        keplerPlanet.addMoon(imaginativeMoon);

        solarSystem1.addPlanet(planet1);
        solarSystem1.addPlanet(planet2);

        solarSystem2.addPlanet(keplerPlanet);

        galaxy.addSolarSystem(solarSystem1);
        galaxy.addSolarSystem(solarSystem2);

        galaxy.printAllBodies();

        moon.explode();
        planet1.explode();
        planet2.explode();
        sun.explode();
        moon.crashMeteor();

    }
}