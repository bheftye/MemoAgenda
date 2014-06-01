/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seats.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import seats.model.Seat;

/**
 *
 * @author Genny Andrea Centeno Metri 
 * @author Karimy Anaí Chablé Cruz
 * @author Brent Heftye Sánchez
 * @author Maya Itzel Villanueva Borja
 * 
 */
public class DAOSeat extends DAOBase {

    private final String SEATS_TABLE_NAME = "public.asientos";

    public List<Seat> getAllSeats() {
        List<Seat> seatSet = null;
        try {
            String query = "SELECT * FROM " + SEATS_TABLE_NAME + " ORDER BY id_asientos ASC";
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(query);
            seatSet = new ArrayList<>();
            Seat resultSeat;
            while (results.next()) {
                resultSeat = new Seat(results.getString("id_asientos"), results.getInt("ocupado"));
                seatSet.add(resultSeat);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return seatSet;
    }

    public Seat getSeat(String id) {
        Seat resultSeat = null;
        try {
            String query = "SELECT * FROM " + SEATS_TABLE_NAME + " WHERE id_asientos = '" + id + "'";
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                resultSeat = new Seat(results.getString("id_asientos"), results.getInt("ocupado"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultSeat;
    }

    public boolean updateSeat(Seat seat) {
        boolean successful = false;
        try {
            String query = "UPDATE " + SEATS_TABLE_NAME + " SET ocupado = '"
                    + seat.getIsTaken() + "' WHERE id_asientos = '" + seat.getId_seat() + "\'";
            Statement statement = connection.createStatement();
            int affectedRows = statement.executeUpdate(query);
            if (affectedRows == 1) {
                successful = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return successful;
    }

    public void addSeat(Seat seat) {
        Statement statement;
        try {
            String insertStatement = "INSERT INTO " + SEATS_TABLE_NAME + " (id_asientos,ocupado) VALUES ('" + seat.getId_seat() + "'," + seat.getIsTaken() + ")";
            statement = connection.createStatement();
            statement.executeUpdate(insertStatement);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
