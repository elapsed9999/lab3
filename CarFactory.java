public class CarFactory {


    public static void createVolvo240(){
        if (CarModule.getCars().size() <= 9) {
            CarModule.cars.add(new Volvo240());
        }
    }

    public static void createSaab95(){
        if (CarModule.getCars().size() <= 9) {
        CarModule.cars.add(new Saab95());
        }
    }

    public static void createScania(){
        if (CarModule.getCars().size() <= 9) {
            Scania scania = new Scania();
            CarModule.cars.add(scania);
            CarModule.scania.add(scania);
        }
    }

    public static void removeCar(){
        if(CarModule.cars.size() > 1)
        {
            CarModule.cars.remove(CarModule.getCars().size()-1);  
        }
            
    }
}