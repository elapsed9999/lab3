import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;



public class CarModule {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());
    ScaniaObserver scanO;

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    static ArrayList<Car> cars = new ArrayList<>();
    static ArrayList<Scania> scania = new ArrayList<>();
    
    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarModule cm = new CarModule();
        CarController cc = new CarController();

        CarModule.cars.add(new Volvo240());
        CarModule.cars.add(new Saab95());
        Scania scania = new Scania();
        CarModule.cars.add(scania);
        CarModule.scania.add(scania);

        


        cm.scanO = scania;

        // Start a new view and send a reference of self
        cm.frame = new CarView("CarSim 1.0", cc, cm, CarModule.cars);

        // Start the timer
        cm.timer.start();

    }

    public static ArrayList<Car> getCars() {
        return cars;
    }

    public static ArrayList<Scania> getScania() {
        return scania;
    }
    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            DecimalFormat decimalRound = new DecimalFormat("0.00");

            double scaniaSpeed = scanO.returnScaniaSpeed();
            String scaniaSpeedString = decimalRound.format(scaniaSpeed);
            frame.scaniaField.setText(scaniaSpeedString);
            


            int i = 0;
            for (Car car : cars) {
                    DrawPanel.addPoints();
                    car.move();
                    int x = (int) Math.round(car.getCurrentXpos());  //Kan kanske ta bort round
                     int y = (int) Math.round(car.getCurrentYpos());
                     frame.drawPanel.moveit(x, y, i);
                    i++;
                     // repaint() calls the paintComponent method of the panel
                    frame.drawPanel.repaint();
            }
        }
    }
}