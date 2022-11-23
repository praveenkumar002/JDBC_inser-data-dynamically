import java.sql.*;

public class Main {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/jdbctest";
        String uName = "virtusa";
        String pass = "root";
        Connection con = DriverManager.getConnection(url, uName, pass);


        int id = 4;
        String name = "Amirtha";
        String query1 = "INSERT INTO student VALUES (?, ?)";
        String query2 = "UPDATE student SET userName = ? WHERE userid = ?";
        String query3 = "DELETE FROM student WHERE userid = ?";

        PreparedStatement st1 = con.prepareStatement(query1); //query is fixed values are changed
        st1.setInt(1, id);
        st1.setString(2, name);
        int count1 = st1.executeUpdate();

        PreparedStatement st2 = con.prepareStatement(query2); //query is fixed values are changed
        st2.setString(1, name);
        st2.setInt(2, id);
        int count2 = st2.executeUpdate();

        PreparedStatement st3 = con.prepareStatement(query3); //query is fixed values are changed
        st3.setInt(1, id);
        int count3 = st3.executeUpdate();

        //Process the result
        System.out.println(count1 + " rows affected");
        System.out.println(count2 + " rows affected");
        System.out.println(count3 + " rows affected");

        //close the connection
        st1.close();
        st2.close();
        st3.close();
        con.close();
    }
}