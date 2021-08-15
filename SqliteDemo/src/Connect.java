import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connect 
{
	 public static void connect1() {
	        Connection conn = null;
	        try {
	         
	            String url = "jdbc:sqlite:C:/sqlite/MoviesDemo.db";
	            // create a connection to the database
	            conn = DriverManager.getConnection(url);
	            
	            System.out.println("Connection to SQLite has been established.");
	            
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        } finally {
	            try {
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (SQLException ex) {
	                System.out.println(ex.getMessage());
	            }
	        }
	    }
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 connect1();
	}

}