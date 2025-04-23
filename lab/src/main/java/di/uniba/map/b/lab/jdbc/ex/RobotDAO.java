/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package di.uniba.map.b.lab.jdbc.ex;

import di.uniba.map.b.lab.collection.esercizi.HolderQuantity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author pierpaolo
 */
public class RobotDAO {

    private final Connection connection;

    public RobotDAO(Connection connection) {
        this.connection = connection;
    }

    public void aggiungiRobot(String nome, int potenza, int difesa) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("INSERT INTO robot(nome, potenza, difesa) VALUES (?, ?, ?)");
        stm.setString(1, nome);
        stm.setInt(2, potenza);
        stm.setInt(3, difesa);
        stm.executeLargeUpdate();
        stm.close();
    }

    public List<Robot> getTuttiIRobot() throws SQLException {
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM robot");
        List<Robot> list = new ArrayList<>();
        while (rs.next()) {
            list.add(Robot.creatFromResultSet(rs));
        }
        rs.close();
        stm.close();
        return list;
    }

    public Robot getRobotPiuForte() throws SQLException {
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery("SELECT id, nome, potenza, difesa FROM robot ORDER BY (difesa+potenza) DESC");
        Robot robot = null;
        if (rs.next()) {
            robot = Robot.creatFromResultSet(rs);
        }
        rs.close();
        stm.close();
        return robot;
    }

    public void inserisciBattaglia(int robot1, int robot2, int winner) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("INSERT INTO battle(robot1, robot2, winner) VALUES (?, ?, ?)");
        stm.setInt(1, robot1);
        stm.setInt(2, robot2);
        stm.setInt(3, winner);
        stm.executeLargeUpdate();
        stm.close();
    }

    public int classifica(boolean best) throws SQLException {
        Statement stm = connection.createStatement();
        Map<Integer, Integer> map = new HashMap<>();
        ResultSet rs = stm.executeQuery("SELECT winner FROM battle");
        while (rs.next()) {
            int winner = rs.getInt("winner");
            Integer v = map.get(winner);
            if (v == null) {
                map.put(winner, 1);
            } else {
                map.put(winner, v + 1);
            }
        }
        rs.close();
        stm.close();
        List<HolderQuantity<Integer>> l = new ArrayList<>();
        for (Integer k : map.keySet()) {
            l.add(new HolderQuantity<>(k, map.get(k)));
        }
        Collections.sort(l, Collections.reverseOrder());
        if (best) {
            return l.get(0).getItem();
        } else {
            return l.get(l.size() - 1).getItem();
        }
    }

    public Connection getConnection() {
        return connection;
    }

}
