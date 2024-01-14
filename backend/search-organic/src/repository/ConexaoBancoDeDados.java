//package repository;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class ConexaoBancoDeDados {
//    private static final String SERVER = "vemser-dbc.dbccompany.com.br";
//    private static final String PORT = "25000";
//    private static final String DATABASE = "xe";
//    private static final String USER = "VS_13_EQUIPE_1";
//    private static final String PASS = "oracle";
//    private static final String SCHEMA = "VS_13_EQUIPE_1";
//
//    public static Connection getConnection() throws SQLException {
//        String url = "jdbc:oracle:thin:@" + SERVER + ":" + PORT + ":" + DATABASE;
//
//        Connection con = DriverManager.getConnection(url, USER, PASS);
//
//        con.createStatement().execute("alter session set current_schema=" + SCHEMA);
//
//        return con;
//    }
//
//    public static void closeConnection(Connection connection) {
//        try {
//            if (connection != null)
//                connection.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}

package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBancoDeDados {
    private static final String SERVER = "localhost";
    private static final String PORT = "1521";
    private static final String DATABASE = "xe";
    private static final String USER = "system";
    private static final String PASS = "oracle";
    private static final String SCHEMA = "VEM_SER";

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:oracle:thin:@" + SERVER + ":" + PORT + ":" + DATABASE;

        Connection con = DriverManager.getConnection(url, USER, PASS);

        con.createStatement().execute("alter session set current_schema=" + SCHEMA);

        return con;
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null)
                connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}