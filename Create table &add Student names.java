import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Runbefore {
    public static void main(String[] args) {
        try{
            String url="jdbc:mysql://localhost:3306/";

            String databaseName="mysql";
            String userName="root";
            String password="QWE098*123asd";
            Connection connection= DriverManager.getConnection(url, userName, password);
            System.out.println("Connected");
            
            String createDBSQL = "CREATE DATABASE IF NOT EXISTS attendance";
            PreparedStatement pstmt = connection.prepareStatement(createDBSQL);
            pstmt.execute();

            String createTableSQL = "CREATE TABLE IF NOT EXISTS attendance.names (" +"id INT PRIMARY KEY AUTO_INCREMENT," +"name VARCHAR(100) NOT NULL" +")";
            PreparedStatement pstmt1 = connection.prepareStatement(createTableSQL);
            pstmt1.execute();

            String insertSQL = "INSERT INTO attendance.names (name) VALUES (?)";
            PreparedStatement pstmt2 = connection.prepareStatement(insertSQL);
            String[] names = {"Alice", "Bob", "Charlie", "David", "Eva"};
            for (String name : names) {
                pstmt2.setString(1, name);
                pstmt2.executeUpdate();
        }
    }
}
