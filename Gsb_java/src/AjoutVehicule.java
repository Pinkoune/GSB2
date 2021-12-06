/**
 * Ajout des Vehicules
 * @author Jeremy
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AjoutVehicule extends JPanel implements ActionListener {

    //Attributs privés

    //Frame
    private JFrame framePrincipale;

    //Panel
    private JPanel panelAjoutVehicule;
    private JPanel panelMessage;
    private JPanel panelChamps;
    private JPanel monPanelGlobal = new JPanel();

    //Label
    private JLabel lblMessage;
    private JLabel lblImmatriculation;
    private JLabel lblModele;
    private JLabel lblMarque;
    private JLabel lblNbPLaces;
    private JLabel lblInsertion;

    //JTextField
    private JTextField jtfImmatriculation;
    private JTextField jtfModele;
    private JTextField jtfMarque;
    private JTextField jtfNbPLaces;

    //Bouton
    private JButton btnValider;

    //Constructeur
    public AjoutVehicule() {

        //Instanciation de la frame
        this.framePrincipale = new JFrame();

        //Instanciation des panels
        this.panelAjoutVehicule = new JPanel();
        this.panelMessage = new JPanel();
        this.panelChamps = new JPanel();
        this.monPanelGlobal.setLayout(new BorderLayout());

        //Background des panels
        this.panelAjoutVehicule.setBackground(Color.white);
        this.panelMessage.setBackground(Color.blue);
        this.panelChamps.setBackground(Color.white);

        //Disposition des panels
        this.panelAjoutVehicule.setLayout(new BorderLayout());
        this.panelMessage.setLayout(new FlowLayout());
        this.panelChamps.setLayout(new FlowLayout());

        //Instanciation des messages
        this.lblMessage = new JLabel("Vehicule - ajout");
        this.lblImmatriculation = new JLabel("Immatriculation du Vehicule :");
        this.lblModele = new JLabel("Modele du Vehicule :");
        this.lblMarque = new JLabel("Marque du Vehicule :");
        this.lblNbPLaces = new JLabel("Nombre de places du Vehicule :");
        this.lblInsertion = new JLabel();
        this.lblInsertion.setText("");

        //Instanciation des entrées
        this.jtfImmatriculation = new JTextField();
        this.jtfImmatriculation.setPreferredSize(new Dimension(150, 30));
        this.jtfModele = new JTextField();
        this.jtfModele.setPreferredSize(new Dimension(150, 30));
        this.jtfMarque = new JTextField();
        this.jtfMarque.setPreferredSize(new Dimension(150, 30));
        this.jtfNbPLaces = new JTextField();
        this.jtfNbPLaces.setPreferredSize(new Dimension(150, 30));

        //Couleur de la police
        this.lblMessage.setForeground(Color.white);
        this.lblImmatriculation.setForeground(Color.black);
        this.lblModele.setForeground(Color.black);
        this.lblMarque.setForeground(Color.black);
        this.lblNbPLaces.setForeground(Color.black);

        //Instanciation des boutons
        this.btnValider = new JButton("Valider");
        this.btnValider.addActionListener(this);

        //Ajout des attributs aux panels
        this.panelAjoutVehicule.add(panelMessage, BorderLayout.PAGE_START);
        this.panelAjoutVehicule.add(panelChamps, BorderLayout.CENTER);

        this.panelMessage.add(lblMessage);

        this.panelChamps.add(lblImmatriculation);
        this.panelChamps.add(jtfImmatriculation);
        
        this.panelChamps.add(lblModele);
        this.panelChamps.add(jtfModele);
        
        this.panelChamps.add(lblMarque);
        this.panelChamps.add(jtfMarque);
        
        this.panelChamps.add(lblNbPLaces);
        this.panelChamps.add(jtfNbPLaces);
        
        this.panelChamps.add(btnValider);
        this.panelChamps.add(lblInsertion);

        //Toujours à la fin
        this.framePrincipale.getRootPane().setDefaultButton(btnValider);
        this.framePrincipale.setAlwaysOnTop(true);
        this.framePrincipale.getContentPane().add(panelAjoutVehicule);
        this.monPanelGlobal.add(panelAjoutVehicule, BorderLayout.CENTER);
        this.framePrincipale.getContentPane().add(monPanelGlobal);
    }

    //les getter et setter
    public JPanel getMonPanelGlobal() {
        return monPanelGlobal;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnValider) {
            String immatV = jtfImmatriculation.getText();
            String modeleV = jtfModele.getText();
            String marqueV = jtfMarque.getText();
            int nbPlacesV = Integer.parseInt(jtfNbPLaces.getText());
            boolean rep = Modele.ajoutVehicule(immatV, modeleV, marqueV, nbPlacesV);
            if (rep) {
                lblInsertion.setText("Un nouveau Vehicule a été ajouté");
            } else {
                lblInsertion.setText("ERREUR, le Vehicule n'a pas pu être ajouté");
            }
        }
    }
}