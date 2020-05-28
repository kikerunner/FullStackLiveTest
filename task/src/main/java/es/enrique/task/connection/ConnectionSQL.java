package es.enrique.task.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.TimeZone;

public class ConnectionSQL implements ConnectionManager {

	public Connection open(String sqlUrl) {
		Connection conn = null;
		try {
			TimeZone.getDefault();
			conn = DriverManager.getConnection(sqlUrl, "root", "IVSZ2h12");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return conn;
	}

	public Connection executeSql(Connection conn, String sql) {
		PreparedStatement prepareStatement;
		try {
			prepareStatement = conn.prepareStatement(sql);
		prepareStatement.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return conn;
	}

	public void close(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

}
