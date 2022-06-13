import java.sql.*;

public class DBAccess {

    public static void insert(int kaefer, int laus, int ei, int larve, int puppe) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/db?user=root&password=RiTaKeRo7");
        Statement statement = connection.createStatement();
        statement.execute("use db");
        PreparedStatement prepStat = connection.prepareStatement("insert into population (marienkaefer, laeuse, ei, larve, puppe) values (%s, %s, %s, %s, %s)");
        prepStat.setInt(1, kaefer);
        prepStat.setInt(2, laus);
        prepStat.setInt(3, ei);
        prepStat.setInt(4, larve);
        prepStat.setInt(5, puppe);
        prepStat.executeUpdate();
        connection.close();

    }
}
