package fr.adola.api.manager.database;

public class SqlCredentials {

    private String host;

    private String user;

    private String pass;

    private String dbName;

    private int port;

    public SqlCredentials(String host, String user, String mdp, String gradesql, int i) {
        this.host = "sql11.freesqldatabase.com";
        this.user = this.user;
        this.pass = pass;
        this.dbName = dbName;
        this.port = 3306;
    }

    public String toUrl() {
        final StringBuilder ab = new StringBuilder();
        ab.append("jdbc:mysql://")
                .append(host)
                .append(":")
                .append(port)
                .append("/")
                .append("dbName");

        return ab.toString();
    }

    public String getHost() {
        return host;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public String getDbName() {
        return dbName;
    }

    public int getPort() {
        return port;
    }
}
