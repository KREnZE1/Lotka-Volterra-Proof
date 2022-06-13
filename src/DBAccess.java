import java.sql.*;

public class DBAccess {
    public static void insert(int gen, int kaefer, int laus, int ei, int larve, int puppe) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/db?user=root&password=RiTaKeRo7");
        Statement statement = connection.createStatement();
        statement.execute("use biologie");
        PreparedStatement prepStat = connection.prepareStatement("insert into population values (?, ?, ?, ?, ?, ?)");
        prepStat.setInt(1, gen);
        prepStat.setInt(2, kaefer);
        prepStat.setInt(3, laus);
        prepStat.setInt(4, ei);
        prepStat.setInt(5, larve);
        prepStat.setInt(6, puppe);
        prepStat.executeUpdate();
        connection.close();
    }

    public static void insert() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/db?user=root&password=RiTaKeRo7");
        Statement statement = connection.createStatement();
        statement.execute("use biologie");
        PreparedStatement prepStat = connection.prepareStatement("insert into population values (?, ?, ?, ?, ?, ?)");
        prepStat.setObject(1, null);
        prepStat.setObject(2, null);
        prepStat.setObject(3, null);
        prepStat.setObject(4, null);
        prepStat.setObject(5, null);
        prepStat.setObject(6, null);
        prepStat.executeUpdate();
        connection.close();
    }
}
