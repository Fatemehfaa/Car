package carser;

import carser.CarSer;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static int id;

    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(System.in);
        CarSer carSer = new CarSer();
        Carr car = new Carr();
    /*    car.setId(sc.nextInt());
        car.setModel(sc.next());
        car.setColor(sc.next());*/
        carSer.registerCar(car);
        carSer.reCAr(car);
        carSer.delCar(id);


       ArrayList<Carr> carList =new ArrayList<>();
               //carSer.getCar();
      /*  for (Carr carItrat : carList) {
            System.out.println(carItrat.getId());
            System.out.println(carItrat.getModel());
            System.out.println(carItrat.getColor());
        }*/
    }

}