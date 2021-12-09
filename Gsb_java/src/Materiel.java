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

	//Accesseurs
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

	public String toString() {
		return this.getNomMateriel() + " - " + this.getTypeMateriel()+ " - "  + this.getLargeur() + " cm de largeur - " + this.getLongueur() + " cm de longueur.";
	}
	
}
