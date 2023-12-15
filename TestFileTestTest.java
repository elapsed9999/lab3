import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class TestFileTestTest {

    @Test
    void testGas() {

        /*
        Test för Saab95 med 1, 1.2 och -0.1.
        Ger 0 i hastighet när amount i gas <= 0 eller >= 1.
        Ger rätt hastighet när amount i gas är 1.0 enl. test.

        Saab95 är namnet på klassen, car1 är det skapade objektet. 
        new Saab95(); gör en ny instans av klassen Saab95. 
        
         */

        Saab95 car1 = new Saab95();

        car1.gas(1.0);
        assertEquals(1.25, car1.getCurrentSpeed());

        car1.currentSpeed = 0;
        car1.gas(1.2);
        assertEquals(0, car1.getCurrentSpeed());

        car1.currentSpeed = 0;
        car1.gas(-0.1);
        assertEquals(0, car1.getCurrentSpeed());

        car1.currentSpeed = 100;
        double a = car1.getCurrentSpeed();
        car1.gas(1.0);
        assertTrue(a <= car1.getCurrentSpeed());


    }

    @Test
    void testBrake() {

        /*
        Test med för höga positiva, negativa och tillåtna tal.
        Negativa tal blir 0 och hastigheten är oförändrad.
        */

        Saab95 car1 = new Saab95();

        car1.currentSpeed = 1.25;
        car1.brake(-0.1);
        assertEquals(1.25, car1.getCurrentSpeed());

        car1.currentSpeed = 1.25;
        car1.brake(0.1);
        assertEquals(1.125, car1.getCurrentSpeed());

        car1.currentSpeed = 1.25;
        car1.brake(1.6);
        assertEquals(1.25, car1.getCurrentSpeed());

        car1.currentSpeed = 100;
        double b = car1.getCurrentSpeed();
        car1.brake(1.0);
        assertTrue(b >= car1.getCurrentSpeed());

    }

    @Test
    void testSpeed() {

        /*
        Test med hastighet, tillåts ej överträda 125. 
        Och ej understiga 0. 
        */

            Saab95 car1 = new Saab95();

            car1.currentSpeed = 126;
            car1.gas(1);
            assertEquals(125, car1.getCurrentSpeed());

            car1.currentSpeed = 0;
            car1.brake(1);
            assertEquals(0, car1.getCurrentSpeed());

        }

    }
