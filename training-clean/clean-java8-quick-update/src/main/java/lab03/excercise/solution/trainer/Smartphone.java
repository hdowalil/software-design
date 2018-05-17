package lab03.excercise.solution.trainer;

import java.util.Optional;

public class Smartphone {
	
	private Connection connection;

	public Optional<Connection> getConnection() {
		return Optional.ofNullable(connection);
	}

	public Optional<Connection> getWorkingConnection() {
		return getConnection().filter(Connection::isConnected);
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public String speak(String input) {
		
		Connection con = getWorkingConnection().orElseThrow(NoConnectionPossibleException::new);
		return con.speak(input);
	}
	
}
