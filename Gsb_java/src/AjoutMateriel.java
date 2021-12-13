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

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
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
        this.panelMessage.setBackground(new Color(67, 87, 186));
        this.panelChamps.setBackground(new Color(22, 38, 119));

        //Disposition des panels
        this.panelAjoutMateriel.setLayout(new BorderLayout());
        this.panelMessage.setLayout(new FlowLayout());
        this.panelChamps.setLayout(null);

        //Instanciation des messages
        this.lblMessage = new JLabel("Matériel - ajout");
        
        this.lblNomMateriel = new JLabel("Nom du matériel");
        this.lblNomMateriel.setBounds(290, 35, 150, 25);
        
        this.lblTypeMateriel = new JLabel("Type du matériel");
        this.lblTypeMateriel.setBounds(290, 95, 150, 25);
        
        this.lblLargeurMateriel = new JLabel("Largeur du matériel");
        this.lblLargeurMateriel.setBounds(280, 155, 150, 25);
        
        this.lblLongueurMateriel = new JLabel("Longueur du matériel");
        this.lblLongueurMateriel.setBounds(275, 215, 150, 25);
        
        this.lblInsertion = new JLabel();
        this.lblInsertion.setBounds(265, 330, 150, 25);
        this.lblInsertion.setText("");

        //Instanciation des entrées
        this.jtfNomMateriel = new JTextField();
        this.jtfNomMateriel.setBackground(new Color(47,53,66));
		this.jtfNomMateriel.setBorder(BorderFactory.createLineBorder(new Color(67, 87, 186)));
        this.jtfNomMateriel.setMaximumSize(new Dimension(150, 30));
        this.jtfNomMateriel.setCaretColor(Color.white);
        this.jtfNomMateriel.setBounds(265, 60, 150, 25);
        
        this.jtfTypeMateriel = new JTextField();
        this.jtfTypeMateriel.setBackground(new Color(47,53,66));
		this.jtfTypeMateriel.setBorder(BorderFactory.createLineBorder(new Color(67, 87, 186)));
        this.jtfTypeMateriel.setMaximumSize(new Dimension(150, 30));
        this.jtfTypeMateriel.setCaretColor(Color.white);
        this.jtfTypeMateriel.setBounds(265, 120, 150, 25);
        
        this.jtfLargeurMateriel = new JTextField();
        this.jtfLargeurMateriel.setBackground(new Color(47,53,66));
		this.jtfLargeurMateriel.setBorder(BorderFactory.createLineBorder(new Color(67, 87, 186)));
        this.jtfLargeurMateriel.setMaximumSize(new Dimension(150, 30));
        this.jtfLargeurMateriel.setCaretColor(Color.white);
        this.jtfLargeurMateriel.setBounds(265, 180, 150, 25);
        
        this.jtfLongueurMateriel = new JTextField();
        this.jtfLongueurMateriel.setBackground(new Color(47,53,66));
		this.jtfLongueurMateriel.setBorder(BorderFactory.createLineBorder(new Color(67, 87, 186)));
        this.jtfLongueurMateriel.setMaximumSize(new Dimension(150, 30));
        this.jtfLongueurMateriel.setCaretColor(Color.white);
        this.jtfLongueurMateriel.setBounds(265, 240, 150, 25);

        //Couleur de la police
        this.lblMessage.setForeground(Color.white);
        this.lblNomMateriel.setForeground(Color.white);
        this.lblTypeMateriel.setForeground(Color.white);
        this.lblLargeurMateriel.setForeground(Color.white);
        this.lblLongueurMateriel.setForeground(Color.white);
        this.lblInsertion.setForeground(Color.white);
        
        this.jtfNomMateriel.setForeground(Color.white);
        this.jtfTypeMateriel.setForeground(Color.white);
        this.jtfLargeurMateriel.setForeground(Color.white);
        this.jtfLongueurMateriel.setForeground(Color.white);

        //Instanciation des boutons
        this.btnValider = new JButton("Valider");
        this.btnValider.setBorder(null);
		this.btnValider.setBackground(new Color(67, 87, 186));
		this.btnValider.setForeground(Color.white);
		this.btnValider.setMaximumSize(new Dimension(170,30));
		this.btnValider.setBounds(240, 285, 200, 35);
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
                lblInsertion.setText("ERREUR, le matériel n'a pas pu être ajouté");
            }
        }
    }
}