package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    private static final String DBURL = "jdbc:mysql://localhost:3306/Training?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false";
    private static final String USERNAME ="root";
    private static final String USERPSW = "";
    private static final String DRIVERNAME ="com.mysql.cj.jdbc.Driver";


    public static Connection getCon(){
        Connection con =null;
        try {
            Class.forName(DRIVERNAME);
            con=DriverManager.getConnection(DBURL,USERNAME,USERPSW);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return con;

    }

    public static void closeCon(Connection con){
        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
