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

@Repository("repositoryTask")
public class RespositoryTask {

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
	
	public List<Task> selectAllTodoTaskList() {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		List<Task> tasksList = new ArrayList<Task>();
		
		try {
			preparedStatement = conn
					.prepareStatement("SELECT T.idTask, T.Name, T.Description, T.DeadLine, P.PriorityName, S.statusName FROM Task.Tasks AS T, Task.Priorities AS P, Task.Status AS S WHERE (T.IdPriority = P.IdPriority) AND (T.idStatus = S.idStatus) AND S.statusName = 'toDo'");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Task taskFromDataBase = new Task();
				taskFromDataBase.setIdTask(resultSet.getInt(1));
				taskFromDataBase.setName(resultSet.getString(2));
				taskFromDataBase.setDescription(resultSet.getString(3));
				taskFromDataBase.setDeadLine(resultSet.getDate(4));
				Priority priorityInDatabase = new Priority();
				priorityInDatabase.setPriorityName(resultSet.getString(5));
				taskFromDataBase.setPriority(priorityInDatabase);
				Status statusInDatabase = new Status();
				statusInDatabase.setStatusName(resultSet.getString(6));
				taskFromDataBase.setStatus(statusInDatabase);
				tasksList.add(taskFromDataBase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}
		return tasksList;
	}
	
	public List<Task> selectAllInProgressList() {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		List<Task> tasksList = new ArrayList<Task>();
		
		try {
			preparedStatement = conn
					.prepareStatement("SELECT T.idTask, T.Name, T.Description, T.DeadLine, P.PriorityName, S.statusName FROM Task.Tasks AS T, Task.Priorities AS P, Task.Status AS S WHERE (T.IdPriority = P.IdPriority) AND (T.idStatus = S.idStatus) AND S.statusName = 'inProgress'");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Task taskFromDataBase = new Task();
				taskFromDataBase.setIdTask(resultSet.getInt(1));
				taskFromDataBase.setName(resultSet.getString(2));
				taskFromDataBase.setDescription(resultSet.getString(3));
				taskFromDataBase.setDeadLine(resultSet.getDate(4));
				Priority priorityInDatabase = new Priority();
				priorityInDatabase.setPriorityName(resultSet.getString(5));
				taskFromDataBase.setPriority(priorityInDatabase);
				Status statusInDatabase = new Status();
				statusInDatabase.setStatusName(resultSet.getString(6));
				taskFromDataBase.setStatus(statusInDatabase);
				tasksList.add(taskFromDataBase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}
		return tasksList;
	}
	
	public List<Task> selectAllDoneList() {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		List<Task> tasksList = new ArrayList<Task>();
		
		try {
			preparedStatement = conn
					.prepareStatement("SELECT T.idTask, T.Name, T.Description, T.DeadLine, P.PriorityName, S.statusName FROM Task.Tasks AS T, Task.Priorities AS P, Task.Status AS S WHERE (T.IdPriority = P.IdPriority) AND (T.idStatus = S.idStatus) AND S.statusName = 'Done'");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Task taskFromDataBase = new Task();
				taskFromDataBase.setIdTask(resultSet.getInt(1));
				taskFromDataBase.setName(resultSet.getString(2));
				taskFromDataBase.setDescription(resultSet.getString(3));
				taskFromDataBase.setDeadLine(resultSet.getDate(4));
				Priority priorityInDatabase = new Priority();
				priorityInDatabase.setPriorityName(resultSet.getString(5));
				taskFromDataBase.setPriority(priorityInDatabase);
				Status statusInDatabase = new Status();
				statusInDatabase.setStatusName(resultSet.getString(6));
				taskFromDataBase.setStatus(statusInDatabase);
				tasksList.add(taskFromDataBase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}
		return tasksList;
	}
}