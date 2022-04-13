package dev.rwamasirabo.utilities;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;


public class jdbcConnection {
    //public static Connection createConnection() {
       // try {

         //   //  "jdbc:postgresql://rwamasirabo-db.cv1tp2j6wufq.us-east-2.rds.amazonaws.com/librarydb?user=postgres&password=Widetechchf01!"
        //    Connection conn = DriverManager.getConnection("jdbc:postgresql://rwamasirabo-db.cv1tp2j6wufq.us-east-2.rds.amazonaws.com/bankdb?user=postgres&password=Widetechchf01!");
      //      return conn;
      //  } catch (SQLException e) {
      //      e.printStackTrace();
       //     return null;
       // }

    //}

   // public static void main(String[] args) {
   //     Connection connection = jdbcConnection.createConnection();
   // }
//}
    //public static final String URL = "jdbc:mysql://localhost:3306/bankdb";
    //public static final String USER = "postgres";
    //public static final String PASS = "Widetechchf01!";

    /**
     * Get a connection to database
     * @return Connection object
     */
   public static Connection getConnection()
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://rwamasirabo-db.cv1tp2j6wufq.us-east-2.rds.amazonaws.com/postgres?user=postgres&password=Widetechchf01!");
           return conn;
        } catch (SQLException ex) {
           throw new RuntimeException("Error connecting to the database", ex);
        }
    }

    /**
     * Test Connection
     */
    public static void main(String[] args) {
       Connection connection = jdbcConnection.getConnection();
    }

}

