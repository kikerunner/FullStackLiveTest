package es.enrique.task.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import es.enrique.task.connection.ConnectionManager;
import es.enrique.task.connection.ConnectionSQL;
import es.enrique.task.model.User;


@Repository("repositoryUser")
public class RepositoryUser {
	
	private static final String jdbcUrl = "jdbc:mysql://localhost:3306/Task?useSSL=false";
	ConnectionManager manager = new ConnectionSQL();

	private void close(PreparedStatement prepareStatement) {
		try {
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	private void close(ResultSet resultSet) {
		try {
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public User selectWorkerByID(String userName) {
		User userRescuedInDatabase = new User();
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT idUser, userName, surname, password "
					+ "FROM Users WHERE userName = (?)");
			prepareStatement.setString(1, userName);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				userRescuedInDatabase.setIdUser(resultSet.getInt(1));
				userRescuedInDatabase.setUserName(resultSet.getString(2));
				userRescuedInDatabase.setSurname(resultSet.getString(3));
				userRescuedInDatabase.setPassword(resultSet.getString(4));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			close(prepareStatement);
		}
		manager.close(conn);
		return userRescuedInDatabase;
	}
}
