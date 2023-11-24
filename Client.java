package Package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Client extends Utilisateurs {
	   private int idClient;
	    private String nomClient;
	    private String tel;
	    private String email;
	    private String motDePasse;
	    public Location location;
	    private Connection connection;
	   
	    public boolean ConnexionClient(String email, String motDePasse) {
	    	    try {
	    	        String query = "SELECT * FROM client WHERE email = ? AND motDePasse = ?";
	    	        PreparedStatement statement = connection.prepareStatement(query);
	    	        statement.setString(1, email);
	    	        statement.setString(2, motDePasse);
	    	        ResultSet resultSet = statement.executeQuery();
	    	        return resultSet.next(); // Si le client existe avec ces identifiants
	    	    } catch (Exception e) {
	    	        e.printStackTrace();
	    	    }
	    	    return false;
	    }
	    public void miseJourInfoClient() {
	    }
	    public void DeconnexionClient() {
	    	disconnect();
	     }
	    

	    public String getNomClient() {
			return nomClient;
		}
		public void setNomClient(String nomClient) {
			this.nomClient = nomClient;
		}
		public String getTel() {
			return tel;
		}
		public void setTel(String tel) {
			this.tel = tel;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public int getIdClient() {
			return idClient;
		}
		public void setIdClient(int idClient) {
			this.idClient = idClient;
		}
		public String getMotDePasse() {
			return motDePasse;
		}
		public void setMotDePasse(String motDePasse) {
			this.motDePasse = motDePasse;
		}
		public Location getLocation() {
			return location;
		}
		public void setLocation(Location location) {
			this.location = location;
		}
		
		public void SupprimerCompte(Client client) {
	        try {
	            String query = "DELETE FROM clients WHERE id = ?";
	            PreparedStatement statement = connection.prepareStatement(query);
	            statement.setInt(1, client.getIdClient()); // Supposons que getId() retourne l'identifiant du client
	            statement.executeUpdate();
	            System.out.println("Compte client supprimé !");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}


