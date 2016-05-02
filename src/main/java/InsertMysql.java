import java.sql.*;

/**
 * Created by Administrator on 2016/5/2 0002.
 */
public class InsertMysql {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded");

        String user = "root";
        String password = "199011081108";
        String url = "jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=true";
        try {
            Connection connection = DriverManager.getConnection(url,user,password);
            System.out.println("Database Connected");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeUpdate("INSERT course(Course_Id,Dept_Name,Tot_Cred,Course_Name,Student_Name)values ("9531","ll","kkk","kkk"","lll"));
            System.out.println();
            System.out.printf("%-15s%-15s%-15s%-20s%-15s\n","Course_Id","Dept_Name","Tot_Cred","Course_Name","Student_Name");
            while(resultSet.next()){

                System.out.printf("%-15s%-15s%-15s%-20s%-15s\n",resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5));
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
