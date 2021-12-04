import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class test {

	@Test
	void testCoVisiteur() {
		String nom = "visit";
		String mdp = "123";
		Assert.assertEquals("Problème de connexion du visiteur", true , Modele.coVisiteur(nom, mdp));
	}
	
	@Test
	void testCoResponsable() {
		String nom = "resp";
		String mdp = "123";
		Assert.assertEquals("Problème de connexion du visiteur", true , Modele.coVisiteur(nom, mdp));
	}
	
	@Test
	void testCoDirecteur() {
		String nom = "direc";
		String mdp = "123";
		Assert.assertEquals("Problème de connexion du visiteur", true , Modele.coVisiteur(nom, mdp));
	}

}
