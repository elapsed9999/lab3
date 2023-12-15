import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{


    // Just a single image, TODO: Generalize

    static ArrayList <Point> points = new ArrayList<>();

    BufferedImage volvoImage;
    BufferedImage scaniaImage;
    BufferedImage saabImage;
    
    public static void addPoints(){
        points.add(new Point());
    }
    

    // TODO: Make this genereal for all cars
    void moveit(int x, int y, int i){
       points.get(i).x=x;
       points.get(i).y=y;
    }
    // Create a HashMap object called capitalCities
    HashMap<String, Image> carImages = new HashMap<String, Image>();

    public void carMaps() {

    
        // Add keys and values (Country, City)
        carImages.put("Volvo240", volvoImage);
        carImages.put("Scania", scaniaImage);
        carImages.put("Saab95", saabImage);

      }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            carMaps();
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        addPoints();
        addPoints();
        super.paintComponent(g);
        int i = 0;
        for(Car car : CarModule.cars){
            g.drawImage(carImages.get(car.getModelName()), points.get(i).x, points.get(i).y, null); // see javadoc for more info on the parameters
            i++;
        }
    }
}
