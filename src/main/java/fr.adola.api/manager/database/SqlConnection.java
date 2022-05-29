package fr.adola.api.manager.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class SqlConnection {

    private Connection connection;
    private final SqlCredentials sqlCredentials;
    private SqlConnection sqlConnection;

    public SqlCredentials getSqlCredentials() {
        return sqlCredentials;
    }
    public SqlConnection(SqlCredentials dbCredentials) throws SQLException {
        this.sqlCredentials = dbCredentials;
        this.connect();
    }

    public void connect() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(this.sqlCredentials.toUrl(), this.sqlCredentials.getUser(), this.sqlCredentials.getPass());

            Logger.getLogger("Minecraft").info("Success connected to DB.");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

        public void close() throws SQLException {
            if(this.connection != null) {
                if(!this.connection.isClosed()) {
                    this.connection.close();
                }
            }
        }



        public Connection getConnection () throws SQLException {
            if(this.connection != null) {
                if(!this.connection.isClosed()) {
                    return this.connection;
                }
            }
            connect();
            return this.connection;
        }
    }
