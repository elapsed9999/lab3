import java.awt.Color;

public abstract class Truck extends Car {

    public boolean rampdown;

    public Truck(int nrDoors, double enginePower, String modelName, Color color, double xpos, double ypos, double direction) {
        super(nrDoors, enginePower, modelName, color, xpos, ypos, direction);
    }

    public boolean rampdown() {
        return rampdown;
    }

    protected double speedFactor() {
        if (rampdown())
            return 0;
        return getEnginePower() * 0.01;
    }
}