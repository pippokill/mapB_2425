/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package di.uniba.map.b.lab.jdbc.ex;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

/**
 *
 * @author pierpaolo
 */
public class ArenaSimulator {

    private final RobotDAO dao;

    private final Random rnd = new Random();

    public ArenaSimulator(RobotDAO dao) {
        this.dao = dao;
    }

    public void simulate(int n) throws SQLException {
        List<Robot> robots = dao.getTuttiIRobot();
        for (int i = 0; i < n; i++) {
            int r1 = rnd.nextInt(robots.size());
            int r2 = rnd.nextInt(robots.size());
            while (r2 == r1) {
                r2 = rnd.nextInt(robots.size());
            }
            int score1 = robots.get(r1).getPotenza() + robots.get(r1).getDifesa() + rnd.nextInt(10);
            int score2 = robots.get(r2).getPotenza() + robots.get(r2).getDifesa() + rnd.nextInt(10);
            if (score1 > score2) {
                dao.inserisciBattaglia(r1, r2, r1);
            } else if (score2 > score1) {

                dao.inserisciBattaglia(r1, r2, r2);
            }
            // in caso di parità la battaglia non è considerata valida e non viene salvata
        }
    }

    public RobotDAO getDao() {
        return dao;
    }

}
