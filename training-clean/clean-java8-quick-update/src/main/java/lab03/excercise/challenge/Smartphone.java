package lab03.excercise.challenge;

public class Smartphone {
	
	private Connection connection;

	// could cause NPEs
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
}
