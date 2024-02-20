package cardataacses;

import carser.Carr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CarDA {
        private Connection connection;
        private PreparedStatement preparedStatement;

        public CarDA() throws Exception{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice" , "root" ,"123456" );
        }

        public ArrayList<Carr> select() throws Exception{
            preparedStatement = connection.prepareStatement("select * from car");
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Carr> carrs = new ArrayList<>();

            while (resultSet.next()){
                Carr car = new Carr();
                car.setId(resultSet.getInt("id"));
                car.setModel(resultSet.getString("model"));
                car.setColor(resultSet.getString("color"));
                carrs.add(car);
            }
            return carrs;
        }

        public void insert(Carr car) throws Exception{
            preparedStatement = connection.prepareStatement("insert into car (id , model ,color) values (? ,? ,?)");
            preparedStatement.setInt(1 , car.getId());
            preparedStatement.setString(2,car.getModel());
            preparedStatement.setString(3,car.getColor());
            preparedStatement.executeUpdate();
            connection.close();
            preparedStatement.close();

        }


        public void update (Carr car)throws Exception{
            preparedStatement = connection.prepareStatement("update car set model=? , color = ?  where id = ? ");
            preparedStatement.setString(1 , car.getModel());
            preparedStatement.setString(2 , car.getColor());
            preparedStatement.setInt(3 , car.getId());
            preparedStatement.executeUpdate();
            connection.close();
            preparedStatement.close();

        }

        public void delete (int id) throws Exception{
            preparedStatement = connection.prepareStatement("delete from car where id = ?");
            preparedStatement.setInt(1 , id);
            preparedStatement.executeUpdate();
            connection.close();
            preparedStatement.close();
        }


    }


