package com.example.demo.Service;

import org.springframework.stereotype.Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

@Service
public class DatabaseHandler {
    private final String url = "jdbc:mysql://localhost:3306/company";
    private final String user = "root";
    private final String password = "12345678";
    Connection connection = null;
    Statement statement = null;
    ResultSet result = null;

    public void ExecuteCreateQuery(String query)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
        e.printStackTrace();
        }
    }

    public ResultSet ExecuteSelectQuery(String query)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            result = statement.executeQuery(query);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void printResultTable()
    {
        try{
            Vector<Vector<Object>> resultVector = new Vector<>();
            int columnCount = result.getMetaData().getColumnCount();
            while (result.next()) {
                Vector<Object> rowVector = new Vector<>();
                for (int i = 1; i <= columnCount; i++)
                    rowVector.add(result.getObject(i));
                resultVector.add(rowVector);
            }
            for (Vector<Object> row : resultVector)
                System.out.println(row);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void closeSession()
    {
        try {
            if (result != null) result.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
