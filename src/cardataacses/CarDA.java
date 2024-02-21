package cardataacses;

import carser.Carr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class CarDA {
        private Connection connection;
        private PreparedStatement preparedStatement;
        Scanner scanner = new Scanner(System.in);

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

        public void insert() throws Exception{
            System.out.println("enter id: ");
            int input = scanner.nextInt();
            System.out.println("enter car model: ");
            String input1 = scanner.next();
            System.out.println("enter car color: ");
            String input2 = scanner.next();
            preparedStatement = connection.prepareStatement("insert into car (id , model ,color) values (? ,? ,?)");
            preparedStatement.setInt(1 ,input );
            preparedStatement.setString(2,input1);
            preparedStatement.setString(3,input2);
            preparedStatement.executeUpdate();
            connection.close();
            preparedStatement.close();

        }


        public void update ()throws Exception{
            preparedStatement = connection.prepareStatement("update car set model=? , color = ?  where id = ? ");
            System.out.println("model: ");
            preparedStatement.setString(1 , scanner.next());
            System.out.println("color: ");
            preparedStatement.setString(2 , scanner.next());
            System.out.println("id: ");
            preparedStatement.setInt(3 , scanner.nextInt());
            preparedStatement.executeUpdate();
            connection.close();
            preparedStatement.close();

        }

        public void delete (int id) throws Exception{
            preparedStatement = connection.prepareStatement("delete from car where id = ?");
            System.out.println("id delete: ");
            preparedStatement.setInt(1 ,scanner.nextInt());
            preparedStatement.executeUpdate();
            connection.close();
            preparedStatement.close();
        }


    }


