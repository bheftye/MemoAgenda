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
import seats.model.Reservation;

/**
 *
 * @author Genny Andrea Centeno Metri
 * @author Karimy Anaí Chablé Cruz
 * @author Brent Heftye Sánchez
 * @author Maya Itzel Villanueva Borja
 *
 */
public class DAOReservation extends DAOBase {

    private final String RESERVATION_TABLE_NAME = "public.reservaciones";
    private int id_user, id_reservation;

    public List<Reservation> getAllReservations() {
        List<Reservation> reservationSet = null;
        try {
            String query = "SELECT * FROM " + RESERVATION_TABLE_NAME + " ORDER BY id_usuario ASC";
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(query);
            reservationSet = new ArrayList<>();
            Reservation resultReservation;
            while (results.next()) {
                resultReservation = new Reservation(results.getInt("id_usuario"), results.getInt("id_reservacion"), results.getString("id_asiento"));
                reservationSet.add(resultReservation);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return reservationSet;
    }

    public int getMaxIdUser() {
        List<Reservation> reservationSet = null;
        reservationSet = getAllReservations();
        if (reservationSet.isEmpty()) {
            id_user = 0;
        } else {
            try {
                String query = "SELECT MAX(id_usuario) FROM " + RESERVATION_TABLE_NAME;
                Statement statement = connection.createStatement();
                statement.execute(query);
                ResultSet results = statement.getResultSet();
                while (results.next()) {
                    id_user = results.getInt(1);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return id_user;
    }

    public int getMaxIdReservation() {
        List<Reservation> reservationSet = null;
        reservationSet = getAllReservations();
        if (reservationSet.isEmpty()) {
            id_reservation = 0;
        } else {
            try {
                String query = "SELECT MAX(id_reservacion) FROM " + RESERVATION_TABLE_NAME;
                Statement statement = connection.createStatement();
                statement.execute(query);
                ResultSet results = statement.getResultSet();
                while (results.next()) {
                    id_reservation = results.getInt(1);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return id_reservation;
    }

    public Reservation getReservation(int id) {
        Reservation resultReservation = null;
        try {
            String query = "SELECT * FROM " + RESERVATION_TABLE_NAME + " WHERE id_usuario = " + id;
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                resultReservation = new Reservation(results.getInt("id_usuario"), results.getInt("id_reservacion"), results.getString("id_asiento"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultReservation;
    }

    public void addReservation(Reservation reservation) {
        Statement statement;
        try {
            String insertStatement = "INSERT INTO " + RESERVATION_TABLE_NAME + " (id_usuario,id_reservacion ,id_asiento) VALUES (" + reservation.getId_user() + "," + reservation.getId_reservation() + ",'" + reservation.getId_seat() + "')";
            statement = connection.createStatement();
            statement.executeUpdate(insertStatement);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addNewUser(int idUser) {
        Statement statement;
        try {
            String insertStatement = "INSERT INTO " + RESERVATION_TABLE_NAME + " (id_usuario) VALUES (" + idUser + ")";
            statement = connection.createStatement();
            statement.executeUpdate(insertStatement);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean deleteCompleteReservation(int id_usuario) {
        boolean deleted = false;
        try {
            String query = "DELETE FROM " + RESERVATION_TABLE_NAME + " WHERE id_usuario = " + id_usuario;
            Statement statement = connection.createStatement();
            int affectedRows = statement.executeUpdate(query);
            if (affectedRows == 1) {
                deleted = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return deleted;
    }

    public boolean deleteSeatReservation(Reservation reservation) {
        boolean deleted = false;
        try {
            String query = "DELETE FROM " + RESERVATION_TABLE_NAME + " WHERE id_usuario = " + reservation.getId_user() + " AND id_asiento = '" + reservation.getId_seat() + "' AND id_reservacion = " + reservation.getId_reservation();
            Statement statement = connection.createStatement();
            int affectedRows = statement.executeUpdate(query);
            if (affectedRows == 1) {
                deleted = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return deleted;
    }

    public boolean updateReservation(Reservation reservation) {
        boolean successful = false;
        try {
            String query = "UPDATE " + RESERVATION_TABLE_NAME + " SET id_asientos = '"
                    + reservation.getId_seat() + "', id_reservacion = "
                    + reservation.getId_reservation() + " WHERE id_usuario = " + reservation.getId_user();
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

    public int getReservationId(int id) {
        int user_id = 0;
        try {
            String query = "SELECT id_reservacion FROM " + RESERVATION_TABLE_NAME + " WHERE id_usuario = " + id;
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                user_id = results.getInt("id_reservacion");
                System.out.println("Estoy en el dao   " + user_id);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user_id;
    }

    public static void main(String[] args) {
        DAOReservation dao = new DAOReservation();
//        int id_user, id_reser;
//        id_user = dao.getMaxIdUser() + 1;
//        id_reser = dao.getMaxIdReservation() + 1;
//        Reservation res1 = new Reservation(1, id_reser, "A7");
//        Reservation res2 = new Reservation(1, id_reser, "A8");
//        Reservation res3 = new Reservation(1, id_reser, "A9");
//        Reservation res4 = new Reservation(1, id_reser, "A10");
//        dao.addReservation(res1);
//        dao.addReservation(res2);
//        dao.addReservation(res3);
//        dao.addReservation(res4);
//        dao.deleteSeatReservation(new Reservation(1, 1, "A3"));
//        dao.deleteCompleteReservation(1);
//
//        List result = (ArrayList) dao.getAllReservations();
//        for (int i = 0; i < result.size(); i++) {
//            Reservation res6 = (Reservation) result.get(i);
//            System.out.println("ID usuario:" + res6.getId_user() + "ID Reservacion: " + res6.getId_reservation() + " ID asientos: " + res6.getId_seat());
//        }
//
        Reservation res1 = dao.getReservation(1);
        System.out.println(res1.toString());
    }
}
