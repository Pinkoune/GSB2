/**
 * Affichage des Materiels
 * @author Jeremy
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AffEmpruntVehiculeDirecteur extends JPanel implements ActionListener {

    //Attributs privés

    //Frame
    private JFrame framePrincipale;

    //Panel
    private JPanel panelMateriel;
    private JPanel panelMessage;
    private JPanel panelTableau;
    private JPanel monPanelGlobal = new JPanel();

    //Label
    private JLabel lblMessage;

    //Tableau
    private JTable tableau;

    //Scrollbar
    private JScrollPane scrollPane;

    //Constructeur
    public AffEmpruntVehiculeDirecteur(ArrayList < Vehicule > listeVehicule) {

        //Instanciation de la frame
        this.framePrincipale = new JFrame();

        //Instanciation des panels
        this.panelMateriel = new JPanel();
        this.panelMessage = new JPanel();
        this.panelTableau = new JPanel();
        this.monPanelGlobal.setLayout(new BorderLayout());

        //Background des panels
        this.panelMateriel.setBackground(Color.white);
        this.panelMessage.setBackground(new Color(144, 12, 63));
        this.panelTableau.setBackground(Color.white);

        //Disposition des panels
        this.panelMateriel.setLayout(new BorderLayout());
        this.panelMessage.setLayout(new FlowLayout());
        this.panelTableau.setLayout(new FlowLayout());

        //Instanciation des messages
        this.lblMessage = new JLabel("Les emprunts de véhicules");

        //Couleur de la police
        this.lblMessage.setForeground(Color.white);

        //Tableau
        Object data[][] = new Object[8][8];
        int i = 0;
        for (Vehicule monVehicule: listeVehicule) {
            data[i][0] = monVehicule.getImmat();
            data[i][1] = monVehicule.getModele();
            data[i][2] = monVehicule.getMarque();
            data[i][3] = monVehicule.getDateDebut();
            data[i][4] = monVehicule.getDateFin();
            data[i][5] = monVehicule.getDuree();
            data[i][6] = monVehicule.getNomVisiteur();
            data[i][7] = monVehicule.getPrenomVisiteur();
            i++;
        }
        String[] title = {
        	"Immatriculation du Véhicule",
            "Modèle du Véhicule",
            "Marque du Véhicule",
            "Date de l'emprunt",
            "Expiration de l'emprunt",
            "Durée de l'emprunt",
            "Nom de l'emprunteur",
            "Prenom de l'emprunteur",
        };
        this.tableau = new JTable(data, title);
        this.tableau.setPreferredScrollableViewportSize(new Dimension(350, 300));

        //Taille
        this.tableau.setRowHeight(30);

        //Barre de scroll
        this.scrollPane = new JScrollPane(this.tableau);
        this.panelTableau.add(this.scrollPane);

        //Ajout des attributs aux panels
        this.panelMateriel.add(panelMessage, BorderLayout.PAGE_START);

        this.panelMessage.add(lblMessage);

        //Toujours à la fin
        /**
         * Rendu visible de l'app etc.. toujours à la fin de la classe
         */
        this.framePrincipale.setAlwaysOnTop(true);
        this.panelMateriel.add(this.scrollPane);
        this.framePrincipale.getContentPane().add(panelMateriel);
        this.monPanelGlobal.add(panelMateriel, BorderLayout.CENTER);
        this.framePrincipale.getContentPane().add(this.monPanelGlobal);
    }

    //les getter et setter
    public JPanel getMonPanelGlobal() {
        return monPanelGlobal;
    }

    public void actionPerformed(ActionEvent e) {}
}