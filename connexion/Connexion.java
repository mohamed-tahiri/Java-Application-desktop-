package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
	private static Connection connection;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tracker?serverTimezone=UTC", "root","");
		} catch (ClassNotFoundException e) {
			System.out.println("Impossible de charger le driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Imoossible d'�tabir la connexion");
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connection;
	}

	
}
