import java.awt.*;

public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;

    public Volvo240() {
        super(4, 100, "Volvo240", Color.black, 0, 0, 0);
    };

    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }
}

    
