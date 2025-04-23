/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package di.uniba.map.b.lab.jdbc.ex;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pierpaolo
 */
public class TestArena {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            DatabaseManager dm = new DatabaseManager();
            Connection connection = dm.getConnection();
            RobotDAO dao = new RobotDAO(connection);
            for (int i = 0; i < 10; i++) {
                dao.aggiungiRobot("robot " + i, Math.round((float) Math.random() * 10f), Math.round((float) Math.random() * 10f));
            }
            System.out.println("=== ROBOT PIù FORTE ===");
            Robot r = dao.getRobotPiuForte();
            System.out.println(r);
            System.out.println("=== LISTA ROBOT ===");
            List<Robot> list = dao.getTuttiIRobot();
            for (Robot e : list) {
                System.out.println(e);
            }
            ArenaSimulator sim = new ArenaSimulator(dao);
            sim.simulate(20);
            System.out.println("Best robot: "+dao.classifica(true));
            System.out.println("Worst robot: "+dao.classifica(false));
            dm.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(TestArena.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
