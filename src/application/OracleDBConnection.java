package application;

import java.sql.SQLException;
import java.util.Properties;
import oracle.jdbc.pool.OracleDataSource;
import oracle.jdbc.OracleConnection;

public class OracleDBConnection implements AutoCloseable {

    private final OracleDataSource ods;
    private OracleConnection connection;

    public OracleDBConnection() throws SQLException {
        try {
            final String DB_USER = "admin";
            final String DB_PASSWORD = "tu#63_CSE365";
            final String DB_URL = "jdbc:oracle:thin:@(description= (retry_count=20)(retry_delay=3)(address=(protocol=tcps)(port=1522)(host=adb.us-phoenix-1.oraclecloud.com))(connect_data=(service_name=gd44933cc717050_cyhxfar9lch0mgfg_high.adb.oraclecloud.com))(security=(ssl_server_dn_match=yes)))";

            Properties info = new Properties();
            info.put(OracleConnection.CONNECTION_PROPERTY_USER_NAME, DB_USER);
            info.put(OracleConnection.CONNECTION_PROPERTY_PASSWORD, DB_PASSWORD);
            info.put(OracleConnection.CONNECTION_PROPERTY_DEFAULT_ROW_PREFETCH, "20");

            ods = new OracleDataSource();
            ods.setURL(DB_URL);
            ods.setConnectionProperties(info);

            // Initialize connection here
            connection = (OracleConnection) ods.getConnection();
        } catch (SQLException e) {
            // Handle the exception or rethrow it
            e.printStackTrace();
            throw e;
        }
    }

    public OracleConnection makeConnection() {
        return connection;
    }

    @Override
    public void close() throws Exception {
        // Close the connection when this object is closed
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
