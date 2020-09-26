import java.sql.*;

public class Main {
    public static void main(String[] args) {
        DBConnect connection = new DBConnect();
        connection.getData();
    }
}

class DBConnect{
    private Connection conn;
    private Statement st;
    private ResultSet rs;

    //3306|MySQL開放此端口, CST為中原標準時間
    private String url = "jdbc:mysql://localhost:3306/demo?serverTimezone=CST";
    private String user = "root";
    private String password = "123456789";

    public DBConnect() {        
        try {
            //Class 的靜態 forName() 方法實現動態加載類別
            Class.forName("com.mysql.cj.jdbc.Driver");            
            conn = DriverManager.getConnection(url, user, password);
            st = conn.createStatement();             
        }
        catch(Exception ex){
            System.out.println("Error: " + ex);
        }
    }
     
    public void getData() {        
        try {
            String query = "select * from user";
            rs = st.executeQuery(query);
            System.out.println("Records for Database");
            while(rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");     
                String email = rs.getString("email");
                String create_at = rs.getString("create_at");                
                System.out.printf("%d\t %s\t %s\t %s\t %s", id, username, password, email, create_at);
                System.out.println("");
            }
            conn.close();
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }     
}