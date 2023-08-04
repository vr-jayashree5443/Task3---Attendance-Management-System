import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        try{
            String url="jdbc:mysql://localhost:3306/attendance";

            String databaseName="mysql";
            String userName="root";
            String password="QWE098*123asd";
            Connection connection= DriverManager.getConnection(url, userName, password);
            System.out.println("Connected");

            /*Statement statement = connection.createStatement();

            // Alter the table to drop the column
            String sql = "ALTER TABLE attendance.names DROP 2023.08.03";
            statement.executeUpdate(sql);
            System.out.println("Done");*/

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the date (yyyy-MM-dd): ");
            String date = scanner.next();
            scanner.nextLine();

            String alterTableSQL = "ALTER TABLE names ADD COLUMN " + date + " VARCHAR(1) DEFAULT NULL";
            Statement stmt = connection.createStatement();
            stmt.execute(alterTableSQL);

            String selectNamesSQL = "SELECT id, name FROM attendance.names";
            Statement stmt1= connection.createStatement();
            stmt1.execute(selectNamesSQL);

            java.sql.ResultSet rs = stmt1.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");

                System.out.print("Attendance for " + name + " (Enter 'a' for absent, 'p' for present): ");
                String attendance = scanner.next();
                String updateAttendanceSQL = "UPDATE names SET " + date + " = ? WHERE id = ?";
                PreparedStatement pstmt = connection.prepareStatement(updateAttendanceSQL);
                pstmt.setString(1, attendance);
                pstmt.setInt(2, id);
                pstmt.executeUpdate();
            }

       
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
