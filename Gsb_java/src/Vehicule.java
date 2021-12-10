/**
 * Classe des Vehicules
 * @author Jeremy
 *
 */

public class Vehicule {
	
	//attributs prives
	private String immat;
	private String modele;
	private String marque;
	private int nbPlaces;
	private String dateDebut;
	private String dateFin;
	private float duree;
	private String nomVisiteur;
	private String prenomVisiteur;

	
	//Constructeur
	public Vehicule(String unImmat, String unModele, String uneMarque, int unNbPlaces) {
		this.immat = unImmat;
		this.modele = unModele;
		this.marque = uneMarque;
		this.nbPlaces = unNbPlaces;
	}
	
	public Vehicule(String unImmat, String unModele, String uneMarque, int unNbPlaces, String uneDateDebut, String uneDateFin, float uneDuree) {
		this.immat = unImmat;
		this.modele = unModele;
		this.marque = uneMarque;
		this.nbPlaces = unNbPlaces;
		this.dateDebut = uneDateDebut;
		this.dateFin = uneDateFin;
		this.duree = uneDuree;
	}
	
	public Vehicule(String unImmat, String unModele, String uneMarque, String uneDateDebut, String uneDateFin, float uneDuree, String unNomVisiteur, String unPrenomVisiteur) {
		this.immat = unImmat;
		this.modele = unModele;
		this.marque = uneMarque;
		this.dateDebut = uneDateDebut;
		this.dateFin = uneDateFin;
		this.duree = uneDuree;
		this.nomVisiteur = unNomVisiteur;
		this.prenomVisiteur = unPrenomVisiteur;
	}

	//Accesseurs des vehicules
	
	public String getImmat() {
		return immat;
	}

	public void setImmat(String immat) {
		this.immat = immat;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public int getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}
	
	//Accesseurs lies aux emprunts
	
	public String getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	public float getDuree() {
		return duree;
	}

	public void setDuree(float duree) {
		this.duree = duree;
	}
	
	//Accesseurs lies aux informations des visiteurs
	
	public String getNomVisiteur() {
		return nomVisiteur;
	}

	public void setNomVisiteur(String nomVisiteur) {
		this.nomVisiteur = nomVisiteur;
	}

	public String getPrenomVisiteur() {
		return prenomVisiteur;
	}

	public void setPrenomVisiteur(String prenomVisiteur) {
		this.prenomVisiteur = prenomVisiteur;
	}

	//toString
	public String toString() {
		return this.getImmat() + " - " + this.getModele()+ " - "  + this.getMarque() + " - " + this.getNbPlaces() + " places.";
	}
	
}
