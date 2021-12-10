/**
 * Affichage des Materiels
 * @author Jeremy
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AffMateriel extends JPanel implements ActionListener {

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
    public AffMateriel(ArrayList < Materiel > listeMateriel) {

        //Instanciation de la frame
        this.framePrincipale = new JFrame();

        //Instanciation des panels
        this.panelMateriel = new JPanel();
        this.panelMessage = new JPanel();
        this.panelTableau = new JPanel();
        this.monPanelGlobal.setLayout(new BorderLayout());

        //Background des panels
        this.panelMateriel.setBackground(Color.white);
        this.panelMessage.setBackground(Color.blue);
        this.panelTableau.setBackground(Color.white);

        //Disposition des panels
        this.panelMateriel.setLayout(new BorderLayout());
        this.panelMessage.setLayout(new FlowLayout());
        this.panelTableau.setLayout(new FlowLayout());

        //Instanciation des messages
        this.lblMessage = new JLabel("Les Matériels");

        //Couleur de la police
        this.lblMessage.setForeground(Color.white);

        //Tableau
        Object data[][] = new Object[5][5];
        int i = 0;
        for (Materiel monMateriel: listeMateriel) {
            data[i][0] = monMateriel.getNomMateriel();
            data[i][1] = monMateriel.getTypeMateriel();
            data[i][2] = monMateriel.getLargeur();
            data[i][3] = monMateriel.getLongueur();
            i++;
        }
        String[] title = {
            "Nom du matériel",
            "Type du matériel",
            "Largeur du matériel",
            "Longueur du matériel",
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