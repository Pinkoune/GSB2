import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Modele {
	
	//Attributs
	public static Connection connexion;
	public static Statement st;
	public static ResultSet rs;
	private static PreparedStatement pst;
	
	/**
	 * Connexion a la base de donnees
	 * @return
	 */
	
	// Methode de connexion a la bdd
	public static void connexionBdd() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connexion = DriverManager.getConnection("jdbc:mysql://localhost/gsb2?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", "root", "root");
			st = connexion.createStatement();
		} catch (ClassNotFoundException e) {
			System.out.println("Le driver n'as pu �tre charg�");
			//	erreur.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Erreur de la connexion � la bdd");
			//	e.printStackTrace();
		}
	}
	
	//Methode de la deconnexion de la bdd
	public  static void deconnexion() {
		try {
			connexion.close(); // Fermeture de la connexion
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur de la deconnexion");
			e.printStackTrace();
		} 	
	}
	
	/**
	 * Methodes de connexion des differents utilisateur
	 * @param unLogin
	 * @param unMdp
	 * @return
	 */
	
	//Connexion du visiteur
	public static boolean coVisiteur(String unLogin, String unMdp) {
		Modele.connexionBdd();
		boolean rep = false;
		int j = 0 ;
		try {
			pst = connexion.prepareStatement("SELECT COUNT(*) AS nb FROM Visiteur WHERE login = ? AND mdp = sha1(?) AND statut IS NULL;");
			pst.setString(1, unLogin);
			pst.setString(2, unMdp);
			rs = pst.executeQuery();
			while( rs.next()) { // .next il rentre dans le tableau a la premiere ligne et le parcours l par l
				j = rs.getInt("nb");
			}
			if (j == 1) {
				rep = true;
			}
		}catch (SQLException e) {
			System.out.println("Erreur connexion");
		}
		Modele.deconnexion();
		return rep;
	}

	//Connexion du responsable
	public static boolean coResponsable(String unLogin, String unMdp) {
		Modele.connexionBdd();
		boolean rep = false;
		int j = 0 ;
		String statut = "r";
		try {
			pst = connexion.prepareStatement("SELECT COUNT(*) AS nb2 FROM Visiteur WHERE login = ? AND mdp = sha1(?) AND statut = ?;");
			pst.setString(1, unLogin);
			pst.setString(2, unMdp);
			pst.setString(3, statut);
			rs = pst.executeQuery();
			while( rs.next()) { // .next il rentre dans le tableau a la premiere ligne et le parcours l par l
				j = rs.getInt("nb2");
			}
			if (j == 1) {
				rep = true;
			}
		}catch (SQLException e) {
			System.out.println("Erreur connexion");
		}
		Modele.deconnexion();
		return rep;
	}

	//Connexion du directeur
	public static boolean coDirecteur(String unLogin, String unMdp) {
		Modele.connexionBdd();
		boolean rep = false;
		int j = 0 ;
		String statut = "d";
		try {
			pst = connexion.prepareStatement("SELECT COUNT(*) AS nb3 FROM Visiteur WHERE login = ? AND mdp = sha1(?) AND statut = ?;");
			pst.setString(1, unLogin);
			pst.setString(2, unMdp);
			pst.setString(3, statut);
			rs = pst.executeQuery();
			while( rs.next()) { // .next il rentre dans le tableau a la premiere ligne et le parcours l par l
				j = rs.getInt("nb3");
			}
			if (j == 1) {
				rep = true;
			}
		}catch (SQLException e) {
			System.out.println("Erreur connexion");
		}
		Modele.deconnexion();
		return rep;
	}
}