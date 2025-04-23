/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package di.uniba.map.b.lab.jdbc.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author pierpaolo
 */
public class DatabaseManager {

    private static final String TABLE_ROBOT = "CREATE TABLE IF NOT EXISTS robot ("
            + "id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,"
            + "nome TEXT NOT NULL,"
            + "potenza INTEGER,"
            + "difesa INTEGER)";

    private static final String TABLE_BATTLE = "CREATE TABLE IF NOT EXISTS battle ("
            + "id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,"
            + "robot1 INTEGER,"
            + "robot2 INTEGER,"
            + "winner INTEGER)";

    private Connection conn = null;

    public Connection getConnection() throws SQLException {
        if (conn != null) {
            return conn;
        } else {
            Properties dbprops = new Properties();
            dbprops.setProperty("user", "user");
            dbprops.setProperty("password", "1234");
            conn = DriverManager.getConnection("jdbc:h2:./resources/db/arena", dbprops);
            Statement stm = conn.createStatement();
            stm.executeUpdate(TABLE_ROBOT);
            stm.executeLargeUpdate(TABLE_BATTLE);
            stm.close();
            return conn;
        }
    }

    public void closeConnection() throws SQLException {
        if (this.conn != null) {
            conn.close();
            conn = null;
        }
    }

}
