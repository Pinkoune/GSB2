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
	}*/
	
	@Test
	public void testRecupIdMateriel() {
		String nom = "Galaxy S7";
		Assert.assertEquals("Problème de recup de l'id via le nom du materiel", 3, Modele.recupIdMateriel(nom));
	}
	
	@Test
	public void testRecupIdVisiteur() {
		String nomMateriel = "resp";
		Assert.assertEquals("problème", "444", Modele.recupIdVisiteur(nomMateriel));
	}
	
	@Test
	public void	testSuppressionEmpruntMat() {
		int idMat = 6;
		Assert.assertEquals("Probleme", true, Modele.suppressionEmpruntMateriel(idMat));
	}

}
