import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Modele {
	
	//Attributs
	public static Connection connexion;
	public static Statement st;
	public static ResultSet rs;
	private static PreparedStatement ps;
	
	/**
	 * Connexion a la base de donnees
	 * @return
	 */
	
	// Methode de connexion a la bdd
	public static void connexionBdd() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connexion = DriverManager.getConnection("jdbc:mysql://localhost/gsb2?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", "root", "");
			st = connexion.createStatement();
		} catch (ClassNotFoundException e) {
			System.out.println("Le driver n'as pu etre charge");
			//	erreur.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Erreur de la connexion a la bdd");
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
			ps = connexion.prepareStatement("SELECT COUNT(*) AS nb FROM visiteur WHERE login = ? AND mdp = sha1(?) AND statut IS NULL;");
			ps.setString(1, unLogin);
			ps.setString(2, unMdp);
			rs = ps.executeQuery();
			while( rs.next()) { // .next il rentre dans le tableau a la premiere ligne et le parcours l par l
				j = rs.getInt("nb");
			}
			if (j == 1) {
				rep = true;
			}
		}catch (SQLException e) {
			System.out.println("Erreur connexion");
		}
		return rep;
	}

	//Connexion du responsable
	public static boolean coResponsable(String unLogin, String unMdp) {
		Modele.connexionBdd();
		boolean rep = false;
		int j = 0 ;
		try {
			ps = connexion.prepareStatement("SELECT COUNT(*) AS nb2 FROM visiteur WHERE login = ? AND mdp = sha1(?) AND statut = ?;");
			ps.setString(1, unLogin);
			ps.setString(2, unMdp);
			ps.setString(3, "r");
			rs = ps.executeQuery();
			while( rs.next()) { // .next il rentre dans le tableau a la premiere ligne et le parcours l par l
				j = rs.getInt("nb2");
			}
			if (j == 1) {
				rep = true;
			}
		}catch (SQLException e) {
			System.out.println("Erreur connexion");
		}
		return rep;
	}

	//Connexion du directeur
	public static boolean coDirecteur(String unLogin, String unMdp) {
		Modele.connexionBdd();
		boolean rep = false;
		int j = 0 ;
		try {
			ps = connexion.prepareStatement("SELECT COUNT(*) AS nb3 FROM visiteur WHERE login = ? AND mdp = sha1(?) AND statut = ?;");
			ps.setString(1, unLogin);
			ps.setString(2, unMdp);
			ps.setString(3, "d");
			rs = ps.executeQuery();
			while( rs.next()) { // .next il rentre dans le tableau a la premiere ligne et le parcours l par l
				j = rs.getInt("nb3");
			}
			if (j == 1) {
				rep = true;
			}
		}catch (SQLException e) {
			System.out.println("Erreur connexion");
		}
		return rep;
	}
	
	//Recuperation de l'id des materiels
		public static String recupIdVisiteur(String unPseudoVisiteur) {
			Modele.connexionBdd();
			String idVisit = "";
			try {
				ps = connexion.prepareStatement("SELECT id FROM visiteur WHERE login = ? ;") ;
				ps.setString(1, unPseudoVisiteur);
				rs = ps.executeQuery();
				while (rs.next()) {
					idVisit = rs.getString("id");
				}
	            rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Erreur dans la recuperation de l'id d'un visiteur via le login");
				e.printStackTrace();
			}
			return idVisit;
		}
	
	
	/**
	 * Requetes des materiels
	 * @param unNomMateriel
	 * @param unTypeMateriel
	 * @param uneLargeur
	 * @param uneLongueur
	 * @return
	 */
	
	//Ajout du materiel
	public static boolean ajoutMateriel(String unNomMateriel, String unTypeMateriel, float uneLargeur, float uneLongueur) {
        //Insertion d'un materiel
        boolean rep = false;
        int result = 0;
        try {
            ps = connexion.prepareStatement("INSERT INTO materiel (nomMateriel, typeMateriel, largeur, longueur) VALUES (?,?,?,?);");
            ps.setString(1, unNomMateriel);
            ps.setString(2, unTypeMateriel);
            ps.setFloat(3, uneLargeur);
            ps.setFloat(4, uneLongueur);
            result = ps.executeUpdate();
            if (result == 1) {
                rep = true;
            }
        } catch (SQLException e) {
            System.out.println("Erreur d'insertion d'un materiel.");
            e.printStackTrace();
        }
        return rep;

    }
	
	//Suppression du materiel
	public static boolean suppressionMateriel(String unNomMateriel) {
        //Suppression d'une course
        boolean rep = false;
        int result = 0;
        try {
            ps = connexion.prepareStatement("DELETE FROM materiel WHERE nomMateriel = ?;");
            ps.setString(1, unNomMateriel);
            result = ps.executeUpdate();
            if (result == 1) {
                rep = true;
            }
        } catch (SQLException e) {
            System.out.println("Erreur de suppression d'un materiel.");
            e.printStackTrace();
        }
        return rep;
    }
	
	//Recherche du materiel
	public static String rechercheMateriel(String unNomMateriel) {
        //Attributs
        ArrayList < Materiel > listeMateriel = new ArrayList < Materiel > ();
        String result = "\nCet materiel n'existe pas.";
        int index = 0;
        String req;
        //Selection
        try {
            st = connexion.createStatement();
            req = "SELECT * FROM materiel;";
            rs = st.executeQuery(req);
            // Pour acc�der � chacune des lignes du r�sultat de la requ�te :
            while (rs.next()) {
            	String nomMateriel = rs.getString("nomMateriel");
                String typeMateriel = rs.getString("typeMateriel");
                float largeur = rs.getFloat("largeur");
                float longueur = rs.getFloat("longueur");
                
                listeMateriel.add(new Materiel(nomMateriel, typeMateriel, largeur, longueur));
            }

            while (index < listeMateriel.size() && !listeMateriel.get(index).getNomMateriel().equals(unNomMateriel)) {
                index = index + 1;
            }
            if (index < listeMateriel.size()) {
                result = "\nVoici le materiel : " + listeMateriel.get(index).toString();
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
	
	//Affichage des materiels
	public static ArrayList < Materiel > affichageMateriel() {
        ArrayList < Materiel > listeMateriel;
        listeMateriel = new ArrayList < Materiel > ();
        try {
            st = connexion.createStatement();
            rs = st.executeQuery("SELECT * FROM materiel;");
            while (rs.next()) {
                String nomMateriel = rs.getString("nomMateriel");
                String typeMateriel = rs.getString("typeMateriel");
                float largeur = rs.getFloat("largeur");
                float longueur = rs.getFloat("longueur");
                
                listeMateriel.add(new Materiel(nomMateriel, typeMateriel, largeur, longueur));
            }
        } catch (Exception e) {
            System.out.println("Erreur dans l'affichage des materiels.");
            e.printStackTrace();
        }
        return listeMateriel;
    }
	
	/**
	 * Requetes requises pour les emprunts materiel
	 * @return
	 */
	
	//Selection du nom des materiels
	public static ArrayList<String> recupListeNomMateriel() {
		Modele.connexionBdd();
		ArrayList<String> listeMateriel = new ArrayList<String>();
		try {		
			rs = st.executeQuery("SELECT nomMateriel FROM materiel WHERE statut IS NULL;");
			String nom;
            while(rs.next()) {
                nom = rs.getString("nomMateriel");
                listeMateriel.add(nom);
            }
            rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur de l'ajout du nom dans la liste.");
			e.printStackTrace();
		}
		return listeMateriel;
	}
	
	//Recuperation du nombre de materiels
	public static int nbListeMateriel() {
		Modele.connexionBdd();
		int count = 0;
		try {		
			rs = st.executeQuery("SELECT COUNT(*) AS nb FROM materiel WHERE statut IS NULL;") ;
            while(rs.next()) {
            	count = rs.getInt("nb");
            }
            rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur de l'affichage du nombre de materiels");
			e.printStackTrace();
		}
		return count;
	}
	
	//Recuperation de l'id des materiels
	public static int recupIdMateriel(String unNomMateriel) {
		Modele.connexionBdd();
		int idMat = 0;
		try {
			ps = connexion.prepareStatement("SELECT idMateriel FROM materiel WHERE nomMateriel = ? ;") ;
			ps.setString(1, unNomMateriel);
			rs = ps.executeQuery();
			while (rs.next()) {
				idMat = rs.getInt("idMateriel");
			}
            rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur dans la recuperation de l'id materiel via le nom");
			e.printStackTrace();
		}
		return idMat;
	}
	
	//Affichage des emprunts de materiel
		public static ArrayList < Materiel > affichageEmpruntMateriel(String unIdVisiteur) {
	        ArrayList < Materiel > listeMateriel;
	        listeMateriel = new ArrayList < Materiel > ();
	        try {
	            st = connexion.createStatement();
	            rs = st.executeQuery("SELECT * FROM empruntm, materiel WHERE empruntm.idMateriel = materiel.idMateriel AND idVisiteur = '"+ unIdVisiteur +"';");
	            while (rs.next()) {
	                String nomMateriel = rs.getString("nomMateriel");
	                String typeMateriel = rs.getString("typeMateriel");
	                float largeur = rs.getFloat("largeur");
	                float longueur = rs.getFloat("longueur");
	                String dateDebut = rs.getString("dateDebut");
	                String dateFin = rs.getString("dateFin");
	                float duree = rs.getFloat("duree");
	                
	                listeMateriel.add(new Materiel(nomMateriel, typeMateriel, largeur, longueur, dateDebut, dateFin, duree));
	            }
	        } catch (Exception e) {
	            System.out.println("Erreur dans l'affichage des emprunts materiels.");
	            e.printStackTrace();
	        }
	        return listeMateriel;
	    }
	
	//Ajout d'un materiel dans un emprunt
	public static boolean ajoutEmpruntMateriel(int unIdMateriel, String uneDateDebut, String uneDateFin, float uneDuree, String unIdVisiteur) {
        //Insertion d'un materiel
        boolean rep = false;
        int result = 0;
        try {
            ps = connexion.prepareStatement("INSERT INTO empruntm (idMateriel, dateDebut, dateFin, duree, idVisiteur) VALUES (?,?,?,?,?);");
            ps.setInt(1, unIdMateriel);
            ps.setString(2, uneDateDebut);
            ps.setString(3, uneDateFin);
            ps.setFloat(4, uneDuree);
            ps.setString(5, unIdVisiteur);
            result = ps.executeUpdate();
            if (result == 1) {
                rep = true;
            }
        } catch (SQLException e) {
            System.out.println("Erreur d'insertion d'un materiel.");
            e.printStackTrace();
        }
        return rep;

    }
	
	//Mise a jour du statut du materiel a occupe
	public static boolean majStatutMateriel(int unIdMateriel) {
		boolean rep = false;
        int result = 0;
        try {
            ps = connexion.prepareStatement("UPDATE materiel SET statut = 1 WHERE idMateriel = ?");
            ps.setInt(1, unIdMateriel);
            result = ps.executeUpdate();
            if (result == 1) {
                rep = true;
            }
        } catch (SQLException e) {
            System.out.println("Erreur de la mise a jour du statut.");
            e.printStackTrace();
        }
        return rep;
	}
	
	//Mise a jour du statut du materiel non occupe
		public static boolean majStatutMaterielLibre(int unIdMateriel) {
			boolean rep = false;
	        int result = 0;
	        try {
	            ps = connexion.prepareStatement("UPDATE materiel SET statut = null WHERE idMateriel = ?");
	            ps.setInt(1, unIdMateriel);
	            result = ps.executeUpdate();
	            if (result == 1) {
	                rep = true;
	            }
	        } catch (SQLException e) {
	            System.out.println("Erreur de la mise a jour du statut.");
	            e.printStackTrace();
	        }
	        return rep;
		}
	
		//Suppression de l'emprunt du materiel
		public static boolean suppressionEmpruntMateriel(int unIdMat) {
	        boolean rep = false;
	        int result = 0;
	        try {
	            ps = connexion.prepareStatement("DELETE FROM empruntm WHERE idMateriel = ?;");
	            ps.setInt(1, unIdMat);
	            result = ps.executeUpdate();
	            if (result == 1) {
	                rep = true;
	            }
	        } catch (SQLException e) {
	            System.out.println("Erreur de suppression d'un emprunt de materiel.");
	            e.printStackTrace();
	        }
	        return rep;
	    }
	
	/**
	 * Requetes des vehicules
	 * @param unImmat
	 * @param unModele
	 * @param uneMarque
	 * @param unNbPlaces
	 * @return
	 */
	
	
	//Ajout du vehicule
	public static boolean ajoutVehicule(String unImmat, String unModele, String uneMarque, int unNbPlaces) {
        //Insertion d'un materiel
        boolean rep = false;
        int result = 0;
        try {
            ps = connexion.prepareStatement("INSERT INTO vehicule (immat, modele, marque, nbPlace) VALUES (?,?,?,?);");
            ps.setString(1, unImmat);
            ps.setString(2, unModele);
            ps.setString(3, uneMarque);
            ps.setInt(4, unNbPlaces);
            result = ps.executeUpdate();
            if (result == 1) {
                rep = true;
            }
        } catch (SQLException e) {
            System.out.println("Erreur d'insertion d'un vehicule.");
            e.printStackTrace();
        }
        return rep;

    }
		
	//Suppression du vehicule
	public static boolean suppressionVehicule(String unModele) {
        //Suppression d'une course
        boolean rep = false;
        int result = 0;
        try {
            ps = connexion.prepareStatement("DELETE FROM vehicule WHERE modele = ?;");
            ps.setString(1, unModele);
            result = ps.executeUpdate();
            if (result == 1) {
                rep = true;
            }
        } catch (SQLException e) {
            System.out.println("Erreur de suppression d'un vehicule.");
            e.printStackTrace();
        }
        return rep;
    }
	
	//Recherche d'un vehicule
	public static String rechercheVehicule(String unImmat) {
        //Attributs
        ArrayList < Vehicule > listeVehicule = new ArrayList < Vehicule > ();
        String result = "\nCe materiel n'existe pas.";
        int index = 0;
        String req;
        //Selection
        try {
            st = connexion.createStatement();
            req = "SELECT * FROM vehicule;";
            rs = st.executeQuery(req);
            // Pour acc�der � chacune des lignes du r�sultat de la requ�te :
            while (rs.next()) {
            	String immat = rs.getString("immat");
                String modele = rs.getString("modele");
                String marque = rs.getString("marque");
                int nbPlaces = rs.getInt("nbPlace");
                
                listeVehicule.add(new Vehicule(immat, modele, marque, nbPlaces));
            }

            while (index < listeVehicule.size() && !listeVehicule.get(index).getImmat().equals(unImmat)) {
                index = index + 1;
            }
            if (index < listeVehicule.size()) {
                result = "\nVoici le vehicule : " + listeVehicule.get(index).toString();
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
	
	//Affichage des vehicules
	public static ArrayList < Vehicule > affichageVehicule() {
        ArrayList < Vehicule > listeVehicule;
        listeVehicule = new ArrayList < Vehicule > ();
        try {
            st = connexion.createStatement();
            rs = st.executeQuery("SELECT * FROM vehicule;");
            while (rs.next()) {
            	String immat = rs.getString("immat");
                String modele = rs.getString("modele");
                String marque = rs.getString("marque");
                int nbPlaces = rs.getInt("nbPlace");
                
                listeVehicule.add(new Vehicule(immat, modele, marque, nbPlaces));
            }
        } catch (Exception e) {
            System.out.println("Erreur dans l'affichage des vehicules.");
            e.printStackTrace();
        }
        return listeVehicule;
    }
	
	/**
	 * Requetes requises pour les emprunts de vehicules
	 * @return
	 */
	
	//Selection du nom des materiels
	public static ArrayList<String> recupListeNomVehicule() {
		Modele.connexionBdd();
		ArrayList<String> listeVehicule = new ArrayList<String>();
		try {		
			rs = st.executeQuery("SELECT modele FROM vehicule WHERE statut IS NULL;");
			String nom;
            while(rs.next()) {
                nom = rs.getString("modele");
                listeVehicule.add(nom);
            }
            rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur de l'ajout du nom dans la liste.");
			e.printStackTrace();
		}
		return listeVehicule;
	}
	
	//Recuperation du nombre de materiels
	public static int nbListeVehicule() {
		Modele.connexionBdd();
		int count = 0;
		try {		
			rs = st.executeQuery("SELECT COUNT(*) AS nb FROM vehicule WHERE statut IS NULL;") ;
            while(rs.next()) {
            	count = rs.getInt("nb");
            }
            rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur de l'affichage du nombre de vehicules");
			e.printStackTrace();
		}
		return count;
	}
	
	//Recuperation de l'id des materiels
	public static int recupIdVehicule(String unModeleVehicule) {
		Modele.connexionBdd();
		int idMat = 0;
		try {
			ps = connexion.prepareStatement("SELECT idVehicule FROM vehicule WHERE modele = ? ;") ;
			ps.setString(1, unModeleVehicule);
			rs = ps.executeQuery();
			while (rs.next()) {
				idMat = rs.getInt("idVehicule");
			}
            rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur dans la recuperation de l'id vehicule via l'immatriculation");
			e.printStackTrace();
		}
		return idMat;
	}
	
	//Affichage des emprunts de materiel
		public static ArrayList < Vehicule > affichageEmpruntVehicule(String unIdVisiteur) {
	        ArrayList < Vehicule > listeVehicule;
	        listeVehicule = new ArrayList < Vehicule > ();
	        try {
	            st = connexion.createStatement();
	            rs = st.executeQuery("SELECT * FROM empruntv, vehicule WHERE empruntv.idVehicule = vehicule.idVehicule AND idVisiteur = '"+ unIdVisiteur +"';");
	            while (rs.next()) {
	                String immat = rs.getString("immat");
	                String modele = rs.getString("modele");
	                String marque = rs.getString("marque");
	                int nbPlace = rs.getInt("nbPlace");
	                String dateDebut = rs.getString("dateDebut");
	                String dateFin = rs.getString("dateFin");
	                float duree = rs.getFloat("duree");
	                
	                listeVehicule.add(new Vehicule(immat, modele, marque, nbPlace, dateDebut, dateFin, duree));
	            }
	        } catch (Exception e) {
	            System.out.println("Erreur dans l'affichage des materiels.");
	            e.printStackTrace();
	        }
	        return listeVehicule;
	    }
	
	//Ajout d'un materiel dans un emprunt
	public static boolean ajoutEmpruntVehicule(int unIdVehicule, String uneDateDebut, String uneDateFin, float uneDuree, String unIdVisiteur) {
        //Insertion d'un materiel
        boolean rep = false;
        int result = 0;
        try {
            ps = connexion.prepareStatement("INSERT INTO empruntv (idVehicule, dateDebut, dateFin, duree, idVisiteur) VALUES (?,?,?,?,?);");
            ps.setInt(1, unIdVehicule);
            ps.setString(2, uneDateDebut);
            ps.setString(3, uneDateFin);
            ps.setFloat(4, uneDuree);
            ps.setString(5, unIdVisiteur);
            result = ps.executeUpdate();
            if (result == 1) {
                rep = true;
            }
        } catch (SQLException e) {
            System.out.println("Erreur d'insertion d'un vehicule.");
            e.printStackTrace();
        }
        return rep;

    }
	
	//Mise a jour du statut du materiel
	public static boolean majStatutVehicule(int unIdVehicule) {
		boolean rep = false;
        int result = 0;
        try {
            ps = connexion.prepareStatement("UPDATE vehicule SET statut = 1 WHERE idVehicule = ?;");
            ps.setInt(1, unIdVehicule);
            result = ps.executeUpdate();
            if (result == 1) {
                rep = true;
            }
        } catch (SQLException e) {
            System.out.println("Erreur de la mise a jour du statut.");
            e.printStackTrace();
        }
        return rep;
	}
	
	//Suppression de l'emprunt du materiel
	public static boolean suppressionEmpruntVehicule(int unIdVehicule) {
        //Suppression d'une course
        boolean rep = false;
        int result = 0;
        try {
            ps = connexion.prepareStatement("DELETE FROM empruntv WHERE idVehicule = ?;");
            ps.setInt(1, unIdVehicule);
            result = ps.executeUpdate();
            if (result == 1) {
                rep = true;
            }
        } catch (SQLException e) {
            System.out.println("Erreur de suppression d'un emprunt de vehicule.");
            e.printStackTrace();
        }
        return rep;
    }
	
	//Mise a jour du statut du materiel non occupe
	public static boolean majStatutVehiculeLibre(int unIdVehicule) {
		boolean rep = false;
        int result = 0;
        try {
            ps = connexion.prepareStatement("UPDATE vehicule SET statut = null WHERE idVehicule = ?");
            ps.setInt(1, unIdVehicule);
            result = ps.executeUpdate();
            if (result == 1) {
                rep = true;
            }
        } catch (SQLException e) {
            System.out.println("Erreur de la mise a jour du statut.");
            e.printStackTrace();
        }
        return rep;
	}

	//Suppression de l'emprunt du materiel
	public static boolean suppressionVehiculeMateriel(int unIdVehicule) {
        boolean rep = false;
        int result = 0;
        try {
            ps = connexion.prepareStatement("DELETE FROM empruntv WHERE idVehicule = ?;");
            ps.setInt(1, unIdVehicule);
            result = ps.executeUpdate();
            if (result == 1) {
                rep = true;
            }
        } catch (SQLException e) {
            System.out.println("Erreur de suppression d'un emprunt d'un vehicule.");
            e.printStackTrace();
        }
        return rep;
    }
	
}