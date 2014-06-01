/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seats.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Genny Andrea Centeno Metri 
 * @author Karimy Anaí Chablé Cruz
 * @author Brent Heftye Sánchez
 * @author Maya Itzel Villanueva Borja
 * 
 */
public abstract class DAOBase {

    protected Connection connection;
    
    private final String HOST = "localhost";
    private final String DATABASE = "online_reserv";
    private final String USER = "postgres";
    private final String PASSWORD = "genny";
    private final String PORT = "5432";
    private final String DRIVER = "org.postgresql.Driver";
    private final String CONNECTION_STRING = "jdbc:postgresql://" + HOST + ":" + PORT + "/" + DATABASE;
//jdbc:mysql://localhost:3306/online_reserv
    protected DAOBase() {
        establishConnection();
    }

    protected void closeConnection() {
        if (connection != null) {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DAOBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    protected int getGeneratedID(PreparedStatement statement) {
        int id = 0;
        try {
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    private void establishConnection() {
        connection = null;
        loadDriver();
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING, USER, PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(DAOBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void loadDriver() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
