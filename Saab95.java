import java.awt.*;

public class Saab95 extends Car{    

    private static boolean turboOn;

    public Saab95(){
        super(2, 125, "Saab95", Color.red, 0, 200, 0);

    }
    
    public static void setTurboOn(){
	    turboOn = true;
    }

    public static void setTurboOff(){
	    turboOn = false;
    }

    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
}
