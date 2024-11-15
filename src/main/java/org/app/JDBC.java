package org.app;
import java.sql.*;
import java.util.*;

public class JDBC {
    private static final String CREATE_TABLE_Clients = "CREATE TABLE IF NOT EXISTS Clients(ClientID INT PRIMARY KEY, Name VARCHAR(50), Surname VARCHAR(50), Address VARCHAR(100), Payment FLOAT)";
    private static final String DELETE_Clients = "DELETE FORM CLIENTS WHERE ClientID = ?";
    private static final String INSERT_Clients = "INSERT INTO CLIENTS (ClientID, Name, Surname, Address, Payment) VALUES(?, ?, ?, ?, ?)";
    private final Connection connection;
    private Statement stm;
    private final String usernameDB = "filippo";
    private final String passwordDB = "D3v1l.98";
    private final String urlDB = "jdbc:mysql://localhost:3306/Deliveries";
    private static JDBC instanceJdbc = null;

    public JDBC() throws SQLException { // crea la connessione con il DB
        Properties dbprops = new Properties();
        dbprops.setProperty("user", usernameDB);
        dbprops.setProperty("password", passwordDB);
        connection = DriverManager.getConnection(urlDB, dbprops);
        stm = connection.createStatement();
        createTableClients(); // crea la tabella Clients se non esiste una
    }

    private void createTableClients() throws SQLException { // cattura l'eccezione se non esiste la tabella Clients
        stm.executeUpdate(CREATE_TABLE_Clients);
    }

    /*
     @ritorna l'istanza univoca del database
    */
    public static JDBC getDbInstance() {
        if(instanceJdbc == null) {
            try {
                instanceJdbc = new JDBC();
            }
            catch(Exception e) {
                return null;
            }
        }
        return instanceJdbc;
    }

    public List<String> getFromDb(String query, int ClientID) throws SQLException {
        List<String> listId = new ArrayList<>();
        PreparedStatement pstm = connection.prepareStatement(query);
        pstm.setInt(1, ClientID);
        ResultSet rs = pstm.executeQuery();
        while(rs.next()) {
            listId.add(rs.getString(1));
        }
        return listId;
    }

    public List<String> getClientSaved(int ClientID) throws SQLException {
        return getFromDb("SELECT Name, Surname, Address FROM Clients WHERE ClientID =?", ClientID);
    }

    public List<String> getClientAddress(int ClientID) throws SQLException {
        return getFromDb("SELECT Address FROM Clients WHERE Name=? AND Surname=?", ClientID);
    }

}
