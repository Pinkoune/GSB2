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

import javax.swing.BorderFactory;
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
        this.panelMessage.setBackground(new Color(144, 12, 63));
        this.panelChamps.setBackground(new Color(88, 24, 69));

        //Disposition des panels
        this.panelAjoutVehicule.setLayout(new BorderLayout());
        this.panelMessage.setLayout(new FlowLayout());
        this.panelChamps.setLayout(null);

        //Instanciation des messages
        this.lblMessage = new JLabel("Véhicule - ajout");
        
        this.lblImmatriculation = new JLabel("Immatriculation du Véhicule");
        this.lblImmatriculation.setBounds(262, 35, 200, 25);
        
        this.lblModele = new JLabel("Modèle du Véhicule");
        this.lblModele.setBounds(285, 95, 150, 25);
        
        this.lblMarque = new JLabel("Marque du Véhicule");
        this.lblMarque.setBounds(285, 155, 150, 25);
        
        this.lblNbPLaces = new JLabel("Nombre de places du Véhicule");
        this.lblNbPLaces.setBounds(255, 215, 200, 25);
        
        this.lblInsertion = new JLabel();
        this.lblInsertion.setBounds(265, 330, 150, 25);
        this.lblInsertion.setText("");

        //Instanciation des entrées
        this.jtfImmatriculation = new JTextField();
        this.jtfImmatriculation.setBackground(new Color(47,53,66));
		this.jtfImmatriculation.setBorder(BorderFactory.createLineBorder(new Color(144, 12, 63)));
        this.jtfImmatriculation.setPreferredSize(new Dimension(150, 30));
        this.jtfImmatriculation.setCaretColor(Color.white);
        this.jtfImmatriculation.setBounds(265, 60, 150, 25);
        
        this.jtfModele = new JTextField();
        this.jtfModele.setBackground(new Color(47,53,66));
		this.jtfModele.setBorder(BorderFactory.createLineBorder(new Color(144, 12, 63)));
        this.jtfModele.setPreferredSize(new Dimension(150, 30));
        this.jtfModele.setCaretColor(Color.white);
        this.jtfModele.setBounds(265, 120, 150, 25);
        
        this.jtfMarque = new JTextField();
        this.jtfMarque.setBackground(new Color(47,53,66));
		this.jtfMarque.setBorder(BorderFactory.createLineBorder(new Color(144, 12, 63)));
        this.jtfMarque.setPreferredSize(new Dimension(150, 30));
        this.jtfMarque.setCaretColor(Color.white);
        this.jtfMarque.setBounds(265, 180, 150, 25);
        
        this.jtfNbPLaces = new JTextField();
        this.jtfNbPLaces.setBackground(new Color(47,53,66));
		this.jtfNbPLaces.setBorder(BorderFactory.createLineBorder(new Color(144, 12, 63)));
        this.jtfNbPLaces.setPreferredSize(new Dimension(150, 30));
        this.jtfNbPLaces.setCaretColor(Color.white);
        this.jtfNbPLaces.setBounds(265, 240, 150, 25);

        //Couleur de la police
        this.lblMessage.setForeground(Color.white);
        this.lblImmatriculation.setForeground(Color.white);
        this.lblModele.setForeground(Color.white);
        this.lblMarque.setForeground(Color.white);
        this.lblNbPLaces.setForeground(Color.white);
        this.lblInsertion.setForeground(Color.white);
        
        this.jtfImmatriculation.setForeground(Color.white);
        this.jtfModele.setForeground(Color.white);
        this.jtfMarque.setForeground(Color.white);
        this.jtfNbPLaces.setForeground(Color.white);

        //Instanciation des boutons
        this.btnValider = new JButton("Valider");
        this.btnValider.setBorder(null);
		this.btnValider.setBackground(new Color(144, 12, 63));
		this.btnValider.setForeground(Color.white);
		this.btnValider.setPreferredSize(new Dimension(170,30));
		this.btnValider.setBounds(240, 285, 200, 35);
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
                lblInsertion.setText("Un nouveau Véhicule a été ajouté");
            } else {
                lblInsertion.setText("ERREUR, le Véhicule n'a pas pu être ajouté");
            }
        }
    }
}