package Package1;

public class VoitureDeLuxe {

    private int idVoiture;
    private String couleur;
    private String immatriculation;
    private  String marque;
    private String lien_img;
    public String getLien_img() {
		return lien_img;
	}



	public void setLien_img(String lien_img) {
		this.lien_img = lien_img;
	}



	public int getIdVoiture() {
		return idVoiture;
	}



	public void setIdVoiture(int idVoiture) {
		this.idVoiture = idVoiture;
	}



	public String getCouleur() {
		return couleur;
	}



	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}



	public String getImmatriculation() {
		return immatriculation;
	}



	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}



	public String getMarque() {
		return marque;
	}



	public void setMarque(String marque) {
		this.marque = marque;
	}



	public float getPrixLocation() {
		return prixLocation;
	}



	public void setPrixLocation(float prixLocation) {
		this.prixLocation = prixLocation;
	}



	public String getStatutDeDisponibilite() {
		return statutDeDisponibilite;
	}



	public void setStatutDeDisponibilite(String statutDeDisponibilite) {
		this.statutDeDisponibilite = statutDeDisponibilite;
	}

	private float prixLocation;
    private String statutDeDisponibilite;

    public void Voiture(int id, String couleur, String immatriculation, String marque, float prix, String statut) {
        this.idVoiture = id;
        this.couleur = couleur;
        this.immatriculation = immatriculation;
        this.marque = marque;
        this.prixLocation = prix;
        this.statutDeDisponibilite = statut;
        // Faut relier ca a la base de donnee
    }
   


    public void VerifierDisponibilitee() {
    }

    public void Operation1() {
    }

}
