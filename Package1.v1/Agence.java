package Package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




public class Agence  {

    private String adresse;
    private String numtel;
    private int nbVoiture; 
    private ArrayList<VoitureDeLuxe> listedeVoiture;
    private String url = "jdbc:mysql://localhost/luxedrive";
    private String user = "root";
    private String passwd = "root";
		public Agence(String  tel,String add,int nbVoiture){
			this.adresse=add;
			this.numtel=tel;
			listedeVoiture=new ArrayList<>();
			  this.nbVoiture = nbVoiture;}
		//le tel est String car int est pas access grand a finir avec un patern 
		
		public boolean exists(VoitureDeLuxe v) {
			return listedeVoiture.contains(v);
		}
		public void ajouterVoiture(VoitureDeLuxe nouV) {
		    try (Connection connection = DriverManager.getConnection(url, user, passwd)) {
		        // Utilisez la connexion pour préparer et exécuter une requête SQL d'insertion
		        String sql = "INSERT INTO voituredeluxe (Couleur, immatriculation,marque, prixLocation,lien_img) VALUES (?,?,?,?,?)";
		        try (PreparedStatement statement = connection.prepareStatement(sql)) {
		            // Remplacez les valeurs par celles de la nouvelle voiture
		            statement.setString(1, nouV.getMarque());
		            statement.setString(2, nouV.getCouleur());
		            statement.setFloat(3, nouV.getPrixLocation());
		            statement.setString(4, nouV.getLien_img());
		            statement.setString(5,nouV.getImmatriculation());
		            
		            // Exécutez la requête d'insertion
		            int rowsInserted = statement.executeUpdate();
		            if (rowsInserted > 0) {
		                System.out.println("La nouvelle voiture a été ajoutée avec succès !");
		                listedeVoiture.add(nouV); // Ajoutez également la voiture à la liste de l'agence
		            } else {
		                System.out.println("Échec de l'ajout de la nouvelle voiture.");
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}

		 public void SupprimerVoiture(int id) { 
			 try (Connection connection = DriverManager.getConnection(url, user, passwd)) {
		            String sql = "DELETE FROM nom_table_voitures WHERE id = ?";
		            try (PreparedStatement statement = connection.prepareStatement(sql)) {
		                statement.setInt(1, id);
		                int rowsDeleted = statement.executeUpdate();
		                if (rowsDeleted > 0) {
		                    System.out.println("La voiture a été supprimée avec succès !");
		                } else {
		                    System.out.println("La voiture avec cet ID n'a pas été trouvée.");
		                }
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		 
		    public void MettreAjourVoiture(VoitureDeLuxe v) {
		        try (Connection connection = DriverManager.getConnection(url, user, passwd)) {
		            String sql = "UPDATE `voituredeluxe` SET `idVoiture`=?,`Couleur`=?,"
		            		+ "`immatriculation`=?,`marque`=?,`prixLocation`=?,"
		            		+ "`lien_img`=? WHERE idVoiture= v.getIdVoiture()";
		            try (PreparedStatement statement = connection.prepareStatement(sql)) {
		               
		            	 statement.setInt(1, v.getIdVoiture()); 
		            	 statement.setString(2, v.getCouleur());
		            	 statement.setString(3, v.getImmatriculation());
		            	 statement.setString(4, v.getMarque());
		            	 statement.setFloat(5,  v.getPrixLocation());
		            	 statement.setString(4, v.getLien_img());
		                
		                
		               
		                int rowsUpdated = statement.executeUpdate();
		                if (rowsUpdated > 0) {
		                    System.out.println("La voiture a été mise à jour avec succès !");
		                } else {
		                    System.out.println("La voiture avec cet ID n'a pas été trouvée.");
		                }
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        }}
		    
		    public void RechercheVoiture() {
		    	 String sql = "SELECT * FROM  voituredeluxe";
		         Connection connection = null;
				try (PreparedStatement statement = connection.prepareStatement(sql)) {
		             ResultSet resultSet = statement.executeQuery();
		             while (resultSet.next()) {
		                 // Traitez les résultats de la recherche ici
		                 int idVoiture = resultSet.getInt("id");
		                 String marque = resultSet.getString("marque");
		                 String Couleur=  resultSet.getString("Couleur");
		                 float prixLocation= resultSet.getFloat("prixLocation");
		        
		                 System.out.println("ID: " + idVoiture + ", Marque: " + marque+ ", Couleur: " + Couleur +", prixLocation: " +prixLocation );
		             }
		         }
		     catch (SQLException e) {
		         e.printStackTrace();}
		     }
		       

}
