/**
 * Ajout des Materiels
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

public class AjoutMateriel extends JPanel implements ActionListener {

    //Attributs privés

    //Frame
    private JFrame framePrincipale;

    //Panel
    private JPanel panelAjoutMateriel;
    private JPanel panelMessage;
    private JPanel panelChamps;
    private JPanel monPanelGlobal = new JPanel();

    //Label
    private JLabel lblMessage;
    private JLabel lblNomMateriel;
    private JLabel lblTypeMateriel;
    private JLabel lblLargeurMateriel;
    private JLabel lblLongueurMateriel;
    private JLabel lblInsertion;

    //JTextField
    private JTextField jtfNomMateriel;
    private JTextField jtfTypeMateriel;
    private JTextField jtfLargeurMateriel;
    private JTextField jtfLongueurMateriel;

    //Bouton
    private JButton btnValider;

    //Constructeur
    public AjoutMateriel() {

        //Instanciation de la frame
        this.framePrincipale = new JFrame();

        //Instanciation des panels
        this.panelAjoutMateriel = new JPanel();
        this.panelMessage = new JPanel();
        this.panelChamps = new JPanel();
        this.monPanelGlobal.setLayout(new BorderLayout());

        //Background des panels
        this.panelAjoutMateriel.setBackground(Color.white);
        this.panelMessage.setBackground(Color.blue);
        this.panelChamps.setBackground(Color.white);

        //Disposition des panels
        this.panelAjoutMateriel.setLayout(new BorderLayout());
        this.panelMessage.setLayout(new FlowLayout());
        this.panelChamps.setLayout(new FlowLayout());

        //Instanciation des messages
        this.lblMessage = new JLabel("Matériel - ajout");
        this.lblNomMateriel = new JLabel("Nom du matériel :");
        this.lblTypeMateriel = new JLabel("Type du matériel :");
        this.lblLargeurMateriel = new JLabel("Largeur du matériel :");
        this.lblLongueurMateriel = new JLabel("Longueur du matériel :");
        this.lblInsertion = new JLabel();
        this.lblInsertion.setText("");

        //Instanciation des entrées
        this.jtfNomMateriel = new JTextField();
        this.jtfNomMateriel.setPreferredSize(new Dimension(150, 30));
        this.jtfTypeMateriel = new JTextField();
        this.jtfTypeMateriel.setPreferredSize(new Dimension(150, 30));
        this.jtfLargeurMateriel = new JTextField();
        this.jtfLargeurMateriel.setPreferredSize(new Dimension(150, 30));
        this.jtfLongueurMateriel = new JTextField();
        this.jtfLongueurMateriel.setPreferredSize(new Dimension(150, 30));

        //Couleur de la police
        this.lblMessage.setForeground(Color.white);
        this.lblNomMateriel.setForeground(Color.black);
        this.lblTypeMateriel.setForeground(Color.black);
        this.lblLargeurMateriel.setForeground(Color.black);
        this.lblLongueurMateriel.setForeground(Color.black);

        //Instanciation des boutons
        this.btnValider = new JButton("Valider");
        this.btnValider.addActionListener(this);

        //Ajout des attributs aux panels
        this.panelAjoutMateriel.add(panelMessage, BorderLayout.PAGE_START);
        this.panelAjoutMateriel.add(panelChamps, BorderLayout.CENTER);

        this.panelMessage.add(lblMessage);

        this.panelChamps.add(lblNomMateriel);
        this.panelChamps.add(jtfNomMateriel);
        
        this.panelChamps.add(lblTypeMateriel);
        this.panelChamps.add(jtfTypeMateriel);
        
        this.panelChamps.add(lblLargeurMateriel);
        this.panelChamps.add(jtfLargeurMateriel);
        
        this.panelChamps.add(lblLongueurMateriel);
        this.panelChamps.add(jtfLongueurMateriel);
        
        this.panelChamps.add(btnValider);
        this.panelChamps.add(lblInsertion);

        //Toujours à la fin
        this.framePrincipale.getRootPane().setDefaultButton(btnValider);
        this.framePrincipale.setAlwaysOnTop(true);
        this.framePrincipale.getContentPane().add(panelAjoutMateriel);
        this.monPanelGlobal.add(panelAjoutMateriel, BorderLayout.CENTER);
        this.framePrincipale.getContentPane().add(monPanelGlobal);
    }

    //les getter et setter
    public JPanel getMonPanelGlobal() {
        return monPanelGlobal;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnValider) {
            String nomMateriel = jtfNomMateriel.getText();
            String typeMateriel = jtfTypeMateriel.getText();
            float largeurMateriel = Integer.parseInt(jtfLargeurMateriel.getText());
            float longueurMateriel = Integer.parseInt(jtfLongueurMateriel.getText());
            boolean rep = Modele.ajoutMateriel(nomMateriel, typeMateriel, largeurMateriel, longueurMateriel);
            if (rep) {
                lblInsertion.setText("Un nouveau matériel a été ajouté");
            } else {
                lblInsertion.setText("ERREUR, le maté0riel n'a pas pu être ajouté");
            }
        }
    }
}