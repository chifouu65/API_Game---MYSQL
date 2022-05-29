package fr.adola.api.manager.database;

import java.sql.SQLException;

public class SqlManager {

    private final SqlConnection gradeConnection;

    public SqlManager() throws SQLException {
        this.gradeConnection = new SqlConnection(new SqlCredentials("localhost","rankdatabase","rankdatabase","rankdatabase",3306));
    }

    public SqlConnection getGradeConnection() {
        return gradeConnection;
    }

    public void close()  {
        try{
            this.gradeConnection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
