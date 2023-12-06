package Package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class TestConn {
	public static void main(String[] args) {
		Connection cnx=connexionDB();
	}
	
	
	static Connection connexionDB() {
		String url="jdbc:mysql://localhost/luxedrive";
		String user="root";
		String passwd="root";
		Connection conn =null;
		Statement myst=null;
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
     conn =DriverManager.getConnection(url, user, passwd);
     if(conn!=null)
	System.out.println("Connecter");
    
	
	}catch(Exception e) {
		System.out.println("ERREUR DE CHARGEMENT DE DRIVER");
		e.printStackTrace();
		System.exit(0);
	}
	return conn;
	

}}
