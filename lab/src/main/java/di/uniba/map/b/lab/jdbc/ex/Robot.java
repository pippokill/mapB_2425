/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package di.uniba.map.b.lab.jdbc.ex;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pierpaolo
 */
public class Robot {

    private int id;

    private String nome;

    private int potenza;

    private int difesa;

    public Robot(int id) {
        this.id = id;
    }

    public Robot(int id, String nome, int potenza, int difesa) {
        this.id = id;
        this.nome = nome;
        this.potenza = potenza;
        this.difesa = difesa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPotenza() {
        return potenza;
    }

    public void setPotenza(int potenza) {
        this.potenza = potenza;
    }

    public int getDifesa() {
        return difesa;
    }

    public void setDifesa(int difesa) {
        this.difesa = difesa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Robot other = (Robot) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Robot{" + "id=" + id + ", nome=" + nome + ", potenza=" + potenza + ", difesa=" + difesa + '}';
    }

    static Robot creatFromResultSet(ResultSet rs) throws SQLException {
        return new Robot(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
    }

}
