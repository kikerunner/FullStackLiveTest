package es.enrique.task.connection;
import java.sql.*;
import java.util.TimeZone;

public class Driver {
	public static void main(String[] args) {
		Connection myConn = null;
		try {
			TimeZone.getDefault();
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Task?useSSL=false", "root", "IVSZ2h12");
			//?useLegacyDatetimeCode=false
			//?verifyServerCertificate=false
			Statement myStmnt = myConn.createStatement();
			ResultSet myRs = myStmnt.executeQuery("select * from Status");
			while (myRs.next()) {
				System.out.println(myRs.getString("idStatus") + ", " + myRs.getString("statusName"));				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
