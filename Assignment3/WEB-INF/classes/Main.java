import java.sql.Connection;

import beans.TextLog;
import dao.ApplicationDao;
import dao.DBConnection;
import inmemory.ApplicationInMemory;

public class Main {

	public static void main(String[] args) {

		TextLog test1 = new TextLog("Title1", "Content1");

		ApplicationDao appDao = new ApplicationDao();

		if (appDao.insertNewLog(test1.getId().toString(), test1.getTitle(), test1.getContent(),
				test1.getCreateTimestamp().toString()) != 0) {
			System.out.println("Log added to database!");
		} else {
			System.out.println("Not added to database :(");
		}

		if (appDao.deleteLog(test1.getId().toString()) != 0) {
			System.out.println("Successfully deleted!");
		} else {
			System.out.println("Was not deleted");
		}

	}

}
