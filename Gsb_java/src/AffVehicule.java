/**
 * Affichage des Vehicules
 * @author Jeremy
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AffVehicule extends JPanel implements ActionListener {

    //Attributs privés

    //Frame
    private JFrame framePrincipale;

    //Panel
    private JPanel panelVehicule;
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
    public AffVehicule(ArrayList < Vehicule > listeVehicule) {

        //Instanciation de la frame
        this.framePrincipale = new JFrame();

        //Instanciation des panels
        this.panelVehicule = new JPanel();
        this.panelMessage = new JPanel();
        this.panelTableau = new JPanel();
        this.monPanelGlobal.setLayout(new BorderLayout());

        //Background des panels
        this.panelVehicule.setBackground(Color.white);
        this.panelMessage.setBackground(new Color(144, 12, 63));
        this.panelTableau.setBackground(Color.white);

        //Disposition des panels
        this.panelVehicule.setLayout(new BorderLayout());
        this.panelMessage.setLayout(new FlowLayout());
        this.panelTableau.setLayout(new FlowLayout());

        //Instanciation des messages
        this.lblMessage = new JLabel("Les Véhicules");

        //Couleur de la police
        this.lblMessage.setForeground(Color.white);

        //Tableau
        Object data[][] = new Object[15][5];
        int i = 0;
        for (Vehicule monVehicule: listeVehicule) {
            data[i][0] = monVehicule.getImmat();
            data[i][1] = monVehicule.getModele();
            data[i][2] = monVehicule.getMarque();
            data[i][3] = monVehicule.getNbPlaces();
            i++;
        }
        String[] title = {
            "Immatriculation du Véhicule",
            "Modèle du Véhicule",
            "Marque du Véhicule",
            "Nombre de places du Véhicule",
        };
        this.tableau = new JTable(data, title);
        this.tableau.setBackground(new Color(47,53,66));
        this.tableau.setForeground(Color.white);
        this.tableau.setPreferredScrollableViewportSize(new Dimension(350, 300));

        //Taille
        this.tableau.setRowHeight(30);

        //Barre de scroll
        this.scrollPane = new JScrollPane(this.tableau);
        this.panelTableau.add(this.scrollPane);

        //Ajout des attributs aux panels
        this.panelVehicule.add(panelMessage, BorderLayout.PAGE_START);

        this.panelMessage.add(lblMessage);

        //Toujours à la fin
        /**
         * Rendu visible de l'app etc.. toujours à la fin de la classe
         */
        this.framePrincipale.setAlwaysOnTop(true);
        this.panelVehicule.add(this.scrollPane);
        this.framePrincipale.getContentPane().add(panelVehicule);
        this.monPanelGlobal.add(panelVehicule, BorderLayout.CENTER);
        this.framePrincipale.getContentPane().add(this.monPanelGlobal);
    }

    //les getter et setter
    public JPanel getMonPanelGlobal() {
        return monPanelGlobal;
    }

    public void actionPerformed(ActionEvent e) {}
}