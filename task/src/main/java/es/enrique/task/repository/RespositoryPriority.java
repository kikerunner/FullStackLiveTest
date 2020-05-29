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

@Repository("repositoryPriority")
public class RespositoryPriority {

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
	
	public List<Priority> selectAllPriorityList() {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		List<Priority> priorityList = new ArrayList<Priority>();
		
		try {
			preparedStatement = conn
					.prepareStatement("SELECT idPriority, PriorityName FROM Task.Priorities;");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Priority priorityFromDataBase = new Priority();
				priorityFromDataBase.setIdPriority(resultSet.getInt(1));
				priorityFromDataBase.setPriorityName(resultSet.getString(2));
				priorityList.add(priorityFromDataBase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}
		return priorityList;
	}
}
