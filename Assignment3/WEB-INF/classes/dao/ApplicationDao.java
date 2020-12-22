package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.UUID;

import beans.DisplayLogs;
import beans.TextLog;

public class ApplicationDao {

	private Connection connection;
	private PreparedStatement deleteLog;
	private PreparedStatement insertNewLog;
	private PreparedStatement editLog;

	public ApplicationDao() {
		try {
			connection = DBConnection.getConnectionToDatabase();
			insertNewLog = connection.prepareStatement(
					"INSERT INTO logs" + "(uuid, title, content, createTimestamp)" + "VALUES (?, ?, ?, ?)");
			deleteLog = connection.prepareStatement("DELETE FROM logs" + " WHERE uuid LIKE ?");
			editLog = connection.prepareStatement("UPDATE logs " + "SET title=?, content=? " + "WHERE uuid=?");
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
	} // end constructor

	public Connection getConnection() {
		return connection;
	}

	public int insertNewLog(String id, String title, String content, String createTimestamp) {
		try {
			insertNewLog.setString(1, id);
			insertNewLog.setString(2, title);
			insertNewLog.setString(3, content);
			insertNewLog.setString(4, createTimestamp);
			return insertNewLog.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int deleteLog(String id) {
		try {
			deleteLog.setString(1, id);
			return deleteLog.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int editLog(String title, String content, String id) {
		try {
			editLog.setString(1, title);
			editLog.setString(2, content);
			editLog.setString(3, id);
			return editLog.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public ArrayList<DisplayLogs> selectAllLogs() throws SQLException {
		ArrayList<DisplayLogs> dbLogs = new ArrayList<>();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM logs ORDER BY createTimestamp");

		while (resultSet.next()) {
			String id = resultSet.getString("uuid");
			String title = resultSet.getString("title");
			String content = resultSet.getString("content");
			String createTimestamp = resultSet.getString("createTimestamp");

			DisplayLogs dl = new DisplayLogs(id, title, content, createTimestamp);
			dbLogs.add(dl);
		}

		return dbLogs;
	}

} // end class ApplicationDao
