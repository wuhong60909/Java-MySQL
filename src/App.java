import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        String driver = "com.mysql.cj.jdbc.Driver";
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        // serverTimezone=CST, CST為中原標準時間
        String url = "jdbc:mysql://localhost:3306/demo?serverTimezone=CST";
        String user = "root";
        String password = "123456789";
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("成功連接demo資料庫!");

            st = conn.createStatement();
            rs = st.executeQuery("select * from user");
            while(rs.next()) {
                System.out.printf("%s\t", rs.getString("id"));
                System.out.printf("%s\t\t", rs.getString("username"));
                System.out.printf("%s\t\t", rs.getString("password"));
                System.out.printf("%s\t\t", rs.getString("email"));
                System.out.printf("%s\t", rs.getString("create_at"));
                System.out.printf("\n");
            }
            conn.close();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
