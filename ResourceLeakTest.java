import java.io.*;
import java.sql.*;

public class ResourceLeakTest {
	
	   static final String DB_URL = "jdbc:mysql://localhost/Test";
	   static final String USER = "guest";
	   static final String PASS = "guest123";
	   static final String QUERY = "SELECT id, first, last, age FROM Employees";


	public static void main(String[] args) {
		
		
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("")));
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		// Open a connection
		Connection conn = null;
	      try{
	    	  conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    	  Statement stmt = conn.createStatement();
		      ResultSet rs = stmt.executeQuery(QUERY);

		         
	      }catch (SQLException e) {
	         e.printStackTrace();
//	         try {
//				conn.close();
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
	      } 
	      
	      
	      InputStream input = null;
	      OutputStream output = null;
	      try {
	          input = new FileInputStream("");
	          output = new FileOutputStream ("");  // BUG MARKED HERE
	          byte[] buffer = new byte[1024 * 8];

	          output.flush();
//	          output.close();
//	          input.close();

	      } catch(Exception e){
	    	  
	      }finally {
	          if(output!=null) {
	              
	              try {
	            	  output.flush();
//					output.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	          }
	          if(input!=null) {
//	              try {
//					input.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
	          }
	      }
	      
	   }

}
