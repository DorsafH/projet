package Package1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;
public class Particulier extends Client {
private int idParticulier;//pas besoin on a id client 
private String Prénom;
private Date dateDeNaissance;
private String Métier;
static String url = "jdbc:mysql://localhost/luxedrive";
static   String user = "root";
 static  String passwd = "root";
public Particulier(int id,String n, String t,String email, String mdp, String p,Date d,String m ) {
	super(id,n,t,email,mdp);
	this.Prénom=p;
	this.dateDeNaissance=d;
	this.Métier=m;
}
public int getIdParticulier() {
	return idParticulier;
}
public void setIdParticulier(int idParticulier) {
	this.idParticulier = idParticulier;
}
public String getPrénom() {
	return Prénom;
}
public void setPrénom(String prénom) {
	Prénom = prénom;
}
public Date getDateDeNaissance() {
	return dateDeNaissance;
}
public void setDateDeNaissance(Date dateDeNaissance) {
	this.dateDeNaissance = dateDeNaissance;
}
public String getMétier() {
	return Métier;
}
public void setMétier(String métier) {
	Métier = métier;
}
public void insererParticulier() {
    

    try (Connection connection = DriverManager.getConnection(url, user, passwd)) {
        String SQL = "INSERT INTO `particuliers`(`idParticulier`, `Prénom`, `dateDeNaissance`, `Métier`, `idClient`)"
        		+"VALUES(?, ?, ?, ?, ?)";

        // Création de la requête préparée
        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            // Définition des valeurs à insérer
            statement.setInt(1, this.idParticulier); 
            statement.setString(2, this.Prénom); 
            statement.setDate(3,(java.sql.Date) this.dateDeNaissance); 
            statement.setString(4, this.Métier);
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
