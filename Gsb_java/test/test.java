import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class test {

	/*@Test
	public void testCoVisiteur() {
		String nom = "visit";
		String mdp = "123";
		Assert.assertEquals("Problème de connexion du visiteur", true , Modele.coVisiteur(nom, mdp));
	}
	
	@Test
	public void testCoResponsable() {
		String nom = "resp";
		String mdp = "123";
		Assert.assertEquals("Problème de connexion du visiteur", true , Modele.coVisiteur(nom, mdp));
	}
	
	@Test
	public void testCoDirecteur() {
		String nom = "direc";
		String mdp = "123";
		Assert.assertEquals("Problème de connexion du visiteur", true , Modele.coVisiteur(nom, mdp));
	}
	
	@Test
	public void testRecupIdMateriel() {
		String nom = "Galaxy S7";
		Assert.assertEquals("Problème de recup de l'id via le nom du materiel", 3, Modele.recupIdMateriel(nom));
	}*/
	
	@Test
	public void testRecupIdVisiteur() {
		String nomMateriel = "dandre";
		Assert.assertEquals("problème", "a17", Modele.recupIdVisiteur(nomMateriel));
	}
	
	@Test
	public void	testSuppressionEmpruntMat() {
		int idMat = 6;
		String idV = "t";
		Assert.assertEquals("Probleme", true, Modele.suppressionEmpruntMateriel(idMat, idV));
	}
	
	/*@Test
	public void testAjoutEmpruntVraiVisiteur() {
		int idMat = 2;
		Date dateD = "E";
		Date dateF = "F";
		float duree = 34;
		String idVisiteur = "a17";
		Assert.assertEquals("Prob insert emprunt vrai visiteur", true, Modele.ajoutEmpruntMateriel(idMat, dateD, dateF, duree, idVisiteur));
	}*/

}
