package Package1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Test1 {
    public static void main(String[] args) {
        Client client1 = new Client( 1,"toto", "0654", "dori@gmail.com", "mdp");
       //client1.insererClient();
        //client1.SupprimerCompte();
     if ( client1.ConnexionClient("dori@gmail.com", "mdp"))
    		 System.out.println("le Client est connecté");
      if (client1.deconnexionClient())
    	  System.out.println("le Client est deconnecte");;
        Entreprise e1= new Entreprise(1,"toto", "0654", "dori@gmail.com", "mdp"," entreprise1",1);
        e1.insererEntreprise();
        VoitureDeLuxe v1= new VoitureDeLuxe(1, " rouge", "4455", "citroen ", 234.2, "hsbwyg");
        
}}



	      
	          
