package carser;

import cardataacses.CarDA;
import carser.Carr;

import java.util.ArrayList;

public class CarSer {

    private int id ;


    public void registerCar(Carr car ) throws Exception{
        CarDA carDA = new CarDA();
        carDA.insert();
    }

    public void reCAr (Carr car) throws Exception{
        CarDA carDA = new CarDA();
        carDA.update();
    }

    public void delCar(int id) throws Exception{
        CarDA carDA = new CarDA();
        carDA.delete(id);
    }

    public ArrayList<Carr> getCar() throws Exception{
        CarDA carDA = new CarDA();
        carDA.insert();
        carDA.update();
        carDA.delete(id);
        ArrayList<Carr> list = carDA.select();
        return list;


    }


}
