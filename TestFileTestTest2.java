import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestFileTestTest2 {

    @Test
    void testScaniaRamp() {

        /* i rörelse kan inte rampen åka ner */
        Scania scania1 = new Scania();
        scania1.gas(1);
        scania1.incrementDegree(20);
        assertEquals(0,scania1.getCurrentDegree());

        scania1.currentSpeed=0;
        scania1.incrementDegree(20);
        assertEquals(20,scania1.getCurrentDegree());

        /* kan inte vara mindre än 0 */
        scania1.decrementDegree(71);
        assertEquals(0,scania1.getCurrentDegree());

        /* kan inte vara mer än 70 */
        scania1.incrementDegree(71);
        assertEquals(70,scania1.getCurrentDegree());

        /*kan inte köra om rampen är nere*/
        scania1.gas(1);
        assertEquals(0,scania1.getCurrentSpeed());



    }

    @Test
    void testCarTransporter() {
        CarTransporter carT1 = new CarTransporter();
        CarTransporter carT3 = new CarTransporter();
        Volvo240 car1 = new Volvo240();
        Volvo240 car2 = new Volvo240();

        /*rampen kan inte åka ner om den är i rörelse*/
        carT1.gas(1);
        carT1.rampdown();

        /*plocka upp bilar*/
        carT1.currentSpeed = 0;
        carT1.rampdown();
        carT1.pickup(car1);
        assertEquals(0, carT1.carin.indexOf(car1));
        carT1.pickup(car2);
        assertEquals(1, carT1.carin.indexOf(car2));

        /*unload försök misslyckas då car2 är ivägen*/
        carT1.unload(car1);
        assertEquals(0, carT1.carin.indexOf(car1));

        carT1.gas(1);
        carT1.gas(1);
        carT1.gas(1);
        carT1.gas(1);
        carT1.turnLeft();
        carT1.gas(1);
        carT1.gas(1);
        carT1.gas(1);
        carT1.gas(1);
        car1.gas(1);

        assertEquals(carT1.carin.get(0).xpos, carT1.getCurrentXpos());
        assertEquals(car1.getCurrentYpos(), carT1.getCurrentYpos());


        carT1.currentSpeed = 0;
        carT1.rampdown();
        carT1.rampdownToggle();
        carT1.unload(car2);
        assertEquals(false, car2.isDocked);
        assertEquals(-1, carT1.carin.indexOf(car2));
    }

    @Test
    void testCarTransporterPickCarT() {

        /*kan inte plocka up andra cartransporters*/
        CarTransporter carT2 = new CarTransporter();
        CarTransporter carT1 = new CarTransporter();
        carT1.pickup(carT2);

        carT1.currentSpeed=0;
        carT1.rampdownToggle();

        assertEquals(true,carT1.rampdown());
        assertEquals(-1, carT1.carin.indexOf(carT2));
    }
    @Test
    void testCarTransporterPickCarTa() {
        CarTransporter carT1 = new CarTransporter();
        CarTransporter carT2 = new CarTransporter();
        Volvo240 car1 = new Volvo240();
        Volvo240 car2 = new Volvo240();

        /* Om bilen är långt borta kan inte carT1 plocka upp den.*/
        car2.gas(1);
        car2.gas(1);
        car2.gas(1);
        car2.gas(1);
        car2.turnLeft();
        car2.gas(1);
        car2.gas(1);
        car2.gas(1);
        car2.gas(1);

        carT1.rampdownToggle();
        assertEquals(true,carT1.rampdown());

        carT1.pickup(car1);
        carT1.pickup(car2);
        assertEquals(-1,carT1.carin.indexOf(car2));

        /*Om bilen redan är på en carT så kan en annan carT inte plocka upp den*/
        carT2.currentSpeed=0;
        carT2.rampdownToggle();
        carT2.pickup(car1);
        assertEquals(0,carT1.carin.indexOf(car1));
        assertEquals(-1,carT2.carin.indexOf(car1));



    }

    @Test
    void testWorkshop() {
        Garage<Volvo240> work1 = new Garage();
        CarTransporter carT1 = new CarTransporter();
        Volvo240 car1 = new Volvo240();
        Volvo240 car2 = new Volvo240();

        /*bil kan inte åka ifrån om upplockad*/
        work1.leaveCar(car1);
        double x=car1.getCurrentXpos();
        double y=car1.getCurrentYpos();
        car1.gas(1);
        car1.turnLeft();
        car1.gas(1);
        assertTrue(car1.isDocked);
        assertEquals(x,car1.getCurrentXpos());
        assertEquals(y,car1.getCurrentYpos());

        /*kan inte plocka up workshop*/
        /*carT1.pickup(work1);*/
       



    }

    }
