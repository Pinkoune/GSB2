/**
 * Affichage des Materiels
 * @author Jeremy
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.text.MessageFormat;
import java.util.ArrayList;

public class AffEmpruntMaterielDirecteur extends JPanel implements ActionListener {

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
    
    //Bouton
    private JButton btnPDF;

    //Scrollbar
    private JScrollPane scrollPane;

    //Constructeur
    public AffEmpruntMaterielDirecteur(ArrayList < Materiel > listeMateriel) {

        //Instanciation de la frame
        this.framePrincipale = new JFrame();

        //Instanciation des panels
        this.panelMateriel = new JPanel();
        this.panelMessage = new JPanel();
        this.panelTableau = new JPanel();
        this.monPanelGlobal.setLayout(new BorderLayout());

        //Background des panels
        this.panelMateriel.setBackground(Color.white);
        this.panelMessage.setBackground(new Color(67, 87, 186));
        this.panelTableau.setBackground(Color.white);

        //Disposition des panels
        this.panelMateriel.setLayout(new BorderLayout());
        this.panelMessage.setLayout(new FlowLayout());
        this.panelTableau.setLayout(new FlowLayout());

        //Instanciation des messages
        this.lblMessage = new JLabel("Les emprunts de matériels");

        //Couleur de la police
        this.lblMessage.setForeground(Color.white);
        
        //Instanciation du bouton de pdf
        this.btnPDF = new JButton("PDF");
        this.btnPDF.setBorder(null);
		this.btnPDF.setBackground(new Color(22, 38, 119));
		this.btnPDF.setForeground(Color.white);
		this.btnPDF.setPreferredSize(new Dimension(170,30));
		this.btnPDF.setBounds(240, 285, 200, 35);
        this.btnPDF.addActionListener(this);
        
        //Tableau
        Object data[][] = new Object[15][7];
        int i = 0;
        for (Materiel monMateriel: listeMateriel) {
            data[i][0] = monMateriel.getNomMateriel();
            data[i][1] = monMateriel.getTypeMateriel();
            data[i][2] = monMateriel.getDateDebut();
            data[i][3] = monMateriel.getDateFin();
            data[i][4] = monMateriel.getDuree();
            data[i][5] = monMateriel.getNomVisiteur();
            data[i][6] = monMateriel.getPrenomVisiteur();
            i++;
        }
        String[] title = {
            "Nom du matériel",
            "Type du matériel",
            "Date de l'emprunt",
            "Expiration de l'emprunt",
            "Durée de l'emprunt",
            "Nom de l'emprunteur",
            "Prenom de l'emprunteur",
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
        this.panelMateriel.add(panelMessage, BorderLayout.PAGE_START);

        this.panelMessage.add(lblMessage);
        this.panelMessage.add(btnPDF);

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

    public void actionPerformed(ActionEvent e) {
    	if(e.getSource() == btnPDF) {
    		MessageFormat header = new MessageFormat("Statistiques des emprunts.");
    		MessageFormat footer = new MessageFormat("Page{0,number,integer}");
    		
    		try {
    			this.tableau.print(JTable.PrintMode.NORMAL, header, footer);
    		}
    		catch(java.awt.print.PrinterException ev){
    			System.err.format("Erreur d'exportation PDF", ev.getMessage());
    		}
    		catch(java.lang.NullPointerException ea) {
    			this.lblMessage.setText("Information non inscrites.");
    		}
    	}
    }
}