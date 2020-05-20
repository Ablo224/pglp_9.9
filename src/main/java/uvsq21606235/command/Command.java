package uvsq21606235.command;

import java.sql.SQLException;

public interface Command {
	
	String execute() throws SQLException;
}
