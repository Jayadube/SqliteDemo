
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;




public class InsertData {
	
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

	    public void insert(String name,String actor,String actress,String director,int yearOfRelease ) {
	        String sql = "INSERT INTO Movies1(name,actor,actress,director,yearOfRelease) VALUES(?,?,?,?,?)";

	        try (Connection conn = this.connect();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, name);
	            pstmt.setString(2, actor);
	            pstmt.setString(3, actress);
	            pstmt.setString(4, director);
	            pstmt.setInt(5, yearOfRelease);
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }

	public static void main(String[] args) {
		InsertData ind = new InsertData();
        // insert three new rows
        ind.insert("Tanhaji","Ajay Devgn","Kajol Devgn","Ram Raut",2020);
        ind.insert("Baghi","Tiger Shroff","Shraddha Kapoor","Sabbir Khan",2020);
        ind.insert("Kabir Singh","Shahid Kappor","Kiara Advani","Sandeep Reddy",2019);
	}

}
