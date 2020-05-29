package es.enrique.task.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import es.enrique.task.connection.ConnectionManager;
import es.enrique.task.connection.ConnectionSQL;
import es.enrique.task.model.Priority;
import es.enrique.task.model.Status;
import es.enrique.task.model.Task;

@Repository("repositoryStatus")
public class RespositoryStatus {

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
	
	public List<Status> selectAllStatusList() {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		List<Status> statusList = new ArrayList<Status>();
		
		try {
			preparedStatement = conn
					.prepareStatement("SELECT idStatus, StatusName FROM Task.Status;");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Status statusFromDataBase = new Status();
				statusFromDataBase.setIdStatus(resultSet.getInt(1));
				statusFromDataBase.setStatusName(resultSet.getString(2));
				statusList.add(statusFromDataBase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}
		return statusList;
	}
}
