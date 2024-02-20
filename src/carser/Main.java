package carser;

import carser.CarSer;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception{

        CarSer carSer = new CarSer();
        ArrayList<Carr> carList = carSer.gerCar();
        for (Carr car : carList) {
            System.out.println(car.getId());
            System.out.println(car.getModel());
            System.out.println(car.getColor());
        }
    }

}