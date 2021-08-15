import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;




public class CreateTable {
	 public static void createNewTable() {
	        // SQLite connection string
	        String url = "jdbc:sqlite:C:/sqlite/MoviesDemo.db";
	        
	        // SQL statement for creating a new table
	        String sql = "CREATE TABLE IF NOT EXISTS Movies1 (\n"
	        		 + " id integer PRIMARY KEY,\n"
	        		+ "	 name text NOT NULL,\n"
	                + "	 actor text,\n"
	                + "	 actress text,\n"
	                + "	 director text,\n"
	                + "	 yearOfRelease integer\n"
	                + ");";
	        
	        try (Connection conn = DriverManager.getConnection(url);
	                Statement stmt = conn.createStatement()) {
	            // create a new table
	            stmt.execute(sql);
	            System.out.println("Table is created successfully");
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createNewTable();

	}

}
