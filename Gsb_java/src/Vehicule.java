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

	
	//Constructeur
	public Vehicule(String unImmat, String unModele, String uneMarque, int unNbPlaces) {
		this.immat = unImmat;
		this.modele = unModele;
		this.marque = uneMarque;
		this.nbPlaces = unNbPlaces;
	}
	
	//Accesseurs
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

	public String toString() {
		return this.getImmat() + " - " + this.getModele()+ " - "  + this.getMarque() + " - " + this.getNbPlaces() + " places.";
	}
	
}
