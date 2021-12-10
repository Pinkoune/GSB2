/**
 * Classe des Materiels
 * @author Jeremy
 *
 */

public class Materiel {
	//attributs prives
	private String nomMateriel;
	private String typeMateriel;
	private float largeur;
	private float longueur;
	private String dateDebut;
	private String dateFin;
	private float duree;
	private String nomVisiteur;
	private String prenomVisiteur;
	
	//Constructeur
	public Materiel(String unNomMateriel, String unTypeMateriel, float uneLargeur, float uneLongueur) {
		this.nomMateriel = unNomMateriel;
		this.typeMateriel = unTypeMateriel;
		this.largeur = uneLargeur;
		this.longueur = uneLongueur;
	}
	
	public Materiel(String unNomMateriel, String unTypeMateriel, float uneLargeur, float uneLongueur, String uneDateDebut, String uneDateFin, float uneDuree) {
		this.nomMateriel = unNomMateriel;
		this.typeMateriel = unTypeMateriel;
		this.largeur = uneLargeur;
		this.longueur = uneLongueur;
		this.dateDebut = uneDateDebut;
		this.dateFin = uneDateFin;
		this.duree = uneDuree;
	}
	
	public Materiel(String unNomMateriel, String unTypeMateriel, String uneDateDebut, String uneDateFin, float uneDuree, String unNomVisiteur, String unPrenomVisiteur) {
		this.nomMateriel = unNomMateriel;
		this.typeMateriel = unTypeMateriel;
		this.dateDebut = uneDateDebut;
		this.dateFin = uneDateFin;
		this.duree = uneDuree;
		this.nomVisiteur = unNomVisiteur;
		this.prenomVisiteur = unPrenomVisiteur;
	}

	//Accesseurs des materiels
	
	public String getNomMateriel() {
		return this.nomMateriel;
	}

	public void setNomMateriel(String unNomMateriel) {
		this.nomMateriel = unNomMateriel;
	}

	public String getTypeMateriel() {
		return typeMateriel;
	}

	public void setTypeMateriel(String unTypeMateriel) {
		this.typeMateriel = unTypeMateriel;
	}	
	
	public float getLargeur() {
		return largeur;
	}

	public void setLargeur(float largeur) {
		this.largeur = largeur;
	}

	public float getLongueur() {
		return longueur;
	}

	public void setLongueur(float longueur) {
		this.longueur = longueur;
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
		return this.getNomMateriel() + " - " + this.getTypeMateriel()+ " - "  + this.getLargeur() + " cm de largeur - " + this.getLongueur() + " cm de longueur.";
	}
	
}
