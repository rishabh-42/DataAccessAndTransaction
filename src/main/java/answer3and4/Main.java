package answer3and4;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class Main {


    @Autowired
    DataSource dataSource;
    @Autowired
    SingleConnectionDataSource singleConnectionDataSource;
    @Autowired
    BasicDataSource basicDataSource;

    void printDatasource() throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from user");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name") + " " + resultSet.getString("age") + " " + resultSet.getString(4));
        }
    }

    void printSingleConnectionDataSource() throws SQLException {
        Connection connection = singleConnectionDataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name") + " " + resultSet.getString("age") + " " + resultSet.getString(4));
        }
    }

    void basicDataSource() throws SQLException {
        Connection connection = basicDataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name") + " " + resultSet.getString("age") + " " + resultSet.getString(4));
        }
    }


    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        Main obj = context.getBean("main", Main.class);

        try {
            obj.printDatasource();
            obj.printSingleConnectionDataSource();
            obj.basicDataSource();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
