import java.awt.*;

/*
Abstract class är en "basklass" som byggs på. Den innehåller bl.a. gemensam, duplicerad kod från Saab95 och Volvo240.
Implements implementerar Movable och dess metoder.
*/

public abstract class Car implements Movable{

    /*
Deklarering av variabler och sätts till private där tillåtet. Ökar säkerheten.
*/

    private int nrDoors;
    protected double enginePower;
    private Color color;
    private String modelName;
    protected double currentSpeed = 0;
    protected double xpos;
    protected double ypos;
    protected double direction;
    public boolean isDocked = false;


    /*
Start på konstruktorn, med kodens parametrar...
*/
    public Car(int nrDoors, double enginePower, String modelName, Color color, double xpos, double ypos, double direction) {

        /*
Initialiserar de 7 parametrar som getts i konstruktorn, "this" sätter värden till instansvariablerna (attributen).
*/

        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.color = color;
        this.xpos = xpos;
        this.ypos = ypos;
        this.direction = direction;
        
    }

    
    /* ändrar x-/y-värde beroende på currentspeed och direction (direction = r=0 mod 2pi ger riktning åt öst)*/
    public void move(){
        moveForward();
        checkWall();
    }

    public void checkWall(){
        if (ypos < 0){
            rotateMe();
            ypos = 0;
            currentSpeed=0;
            gas(1);
        }
        if (ypos > 500) {
            rotateMe();
            ypos = 500;
            currentSpeed=0;
            gas(1);
        }
        if (xpos < 0){
            rotateMe();
            xpos = 0;
            currentSpeed=0;
            gas(1);
        }
        if (xpos > 700) {
            rotateMe();
            xpos = 700;
            currentSpeed=0;
            gas(1);
        }
    }

    public void moveForward() {
        xpos += Math.round(Math.cos(direction) * currentSpeed);
        ypos += Math.round(Math.sin(direction) * currentSpeed);
    }
    
    /* Ändrar direction med 90 grader (det vill säga rotation med pi/2 där höger subtraherar och vänster adderar) */
    public void turnRight(){
        direction += Math.PI/2;
    }

    public void turnLeft(){
        direction -= Math.PI/2;
    }

    abstract double speedFactor();

    public void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    public void  rotateMe(){
        direction+= Math.PI;
    }


    public void gas(double amount){
        if(amount >= 0 && amount <= 1) {
            if (!isDocked) {
                incrementSpeed(amount);
                move();
            }
        }
    }

    /*
 	EXEMPEL:

	Metod "brake" och parameter "double amount". Lokal variabel "amount".
	Om if-satsen stämmer kallas metoden "decrementSpeed()" med "amount" som argument.
	Därefter kallas metoden "move()"

  	vvvvvvvvvvv
	*/
    public void brake(double amount){
        if(amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
            move();
        }
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {

        return enginePower;
    }
    public String getModelName() {

        return modelName;
    }
    public Color getColor() {

        return color;
    }

    public void setColor(Color clr){
	    color = clr;
    }

    public void startEngine(){
	    currentSpeed = 0.1;
    }

    public void stopEngine(){
	    currentSpeed = 0;
    }
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public double getCurrentXpos(){
        return xpos;
    }

    public double getCurrentYpos(){
        return ypos;
    }

    public boolean getCurrentIsDocked(){
        return isDocked;
    }

}

