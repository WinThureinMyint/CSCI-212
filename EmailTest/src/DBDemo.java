import java.sql.*;
import java.util.Properties;

public class DBDemo
{
	 private static final String url = "jdbc:mysql://167.99.148.193:3306/Email";
	 
	    private static final String user = "root";
	 
	    private static final String password = "WinThureinMyint@21";
	 
	    public static void main(String args[]) {
	        try {
	            Connection con = DriverManager.getConnection(url, user, password);
	            System.out.println("Success");
	 
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
