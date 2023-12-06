package Package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Entreprise extends Client {
	   private int numEntreprise;
	    private String nomEntreprise;
	    static String url = "jdbc:mysql://localhost/luxedrive";
		   static   String user = "root";
		    static  String passwd = "root";
		
		public Entreprise (int id,String n, String t,String email, String mdp, String nE,int numE ) {
			super(id,n,t,email,mdp);
		this.nomEntreprise=nE;
		this.numEntreprise=numE;
		}
		public void insererEntreprise() {
		    

		    try (Connection connection = DriverManager.getConnection(url, user, passwd)) {
		        String SQL = "INSERT INTO `entreprise`(`numEntreprise`, `NomEntreprise`, `idClient`) "
		        		+"VALUES(?, ?, ?)";

		        // Création de la requête préparée
		        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
		            // Définition des valeurs à insérer
		            statement.setInt(1, this.numEntreprise); 
		            statement.setString(2, this.nomEntreprise); 
		            statement.setInt(5, this.getIdClient()); 
		     

		            // Exécution de la requête
		            int rowsAffected = statement.executeUpdate();
		            if (rowsAffected > 0) {
		                System.out.println("Données insérées avec succès !");
		            } else {
		                System.out.println("Aucune donnée n'a été insérée.");
		            }
		        }
		    } catch (Exception exception) {
		        throw new RuntimeException(exception);
		    }
		}

	}

