import java.awt.*;
import java.util.ArrayList;

public class CarTransporter extends Truck{

    protected final ArrayList <Car> carin = new ArrayList<>();
    
    private double closeness; 

    public CarTransporter(){
        super(2,80,"CarTransporter",Color.GREEN,0,0,0);

    }

    public void rampdownToggle() {
        if(getCurrentSpeed() == 0)
            rampdown = !(rampdown);
    }

    public void move(){
        moveForward();
        checkWall();
        moveCarin();
    }  

    public void moveCarin(){
        for (Car car:carin){
            car.xpos=xpos;
            car.ypos=ypos;
        }
    }


    public void pickup(Car carpick) {
        if (rampdown()){
            closeness = Math.sqrt(Math.pow((getCurrentXpos()+carpick.getCurrentXpos()), 2))+Math.pow((getCurrentYpos()+carpick.getCurrentYpos()), 2);
            if(closeness <= 15)
                if(!carpick.isDocked && !(carpick instanceof CarTransporter)){
                    carin.add(carpick);
                    carpick.isDocked = true;
                }
        }
    }

    public void unload(Car carpick) {
        if(rampdown()) 
            if(carin.get(carin.size()-1)==carpick){
                carin.remove(carin.size()-1);
                carpick.isDocked=false;
                }
    }

}

