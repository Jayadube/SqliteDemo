import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class SelectData {
	
	 private Connection connect() {
	        // SQLite connection string
	        String url = "jdbc:sqlite:C:/sqlite/MoviesDemo.db";
	        Connection conn = null;
	        try {
	            conn = DriverManager.getConnection(url);
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        return conn;
	    }

	    
	    /**
	     * select all rows in the warehouses table
	     */
	    public void selectAll(){
	        String sql = "SELECT id, name,actor,actress,director,yearOfRelease FROM Movies1";
	        
	        try (Connection conn = this.connect();
	             Statement stmt  = conn.createStatement();
	             ResultSet rs    = stmt.executeQuery(sql)){
	            
	            // loop through the result set
	            while (rs.next()) {
	                System.out.println(rs.getInt("id") +  "\t" + 
	                                   rs.getString("name") + "\t" +
	                                   rs.getString("actor") + "\t" +
	                                   rs.getString("actress") + "\t" +
	                                   rs.getString("director") + "\t" +
	                                   rs.getInt("yearOfRelease"));
	            }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 SelectData app = new SelectData();
	        app.selectAll();
	}

}
