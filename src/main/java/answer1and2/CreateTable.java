package answer1and2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CreateTable {
    public static void main(String[] args) throws Exception {


        String driverName = "com.mysql.jdbc.Driver";
        Class.forName(driverName).newInstance();
        String connectionString = "jdbc:mysql://localhost:3306/test";
        String username = "rishabh";
        String password = "Rish@bh42";
        Connection connection = (Connection) DriverManager.getConnection(connectionString,
                username, password);
        PreparedStatement preparedStatement = connection.prepareStatement("create table USER\n" +
                "(username VARCHAR(100), \n" +
                "password VARCHAR(100), \n" +
                "name VARCHAR(100), \n" +
                "age INT, \n" +
                "dob DATE)");
        preparedStatement.execute();
        PreparedStatement insertData = connection.prepareStatement("insert into USER values('spring','spring','spring',23,'1990-01-16'),('rishabh','rishabh','rishabh',21,'1997-09-23')");
        insertData.executeUpdate();
    }
}
