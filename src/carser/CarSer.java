package carser;

import cardataacses.CarDA;
import carser.Carr;

import java.util.ArrayList;

public class CarSer {

    public void registerCar(Carr car) throws Exception{
        CarDA carDA = new CarDA();
        carDA.insert(car);
        carDA.insert(car);
        carDA.select();
        carDA.update(car);
    }

    public ArrayList<Carr> gerCar()throws Exception{
        CarDA carDA = new CarDA();
        ArrayList<Carr> list = carDA.select();
        return list;


    }

}
