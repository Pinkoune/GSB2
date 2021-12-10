/**
 * Suppression des Materiels
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

public class SuppMateriel extends JPanel implements ActionListener {

    //Attributs priv�s

    //Frame
    private JFrame framePrincipale;

    //Panel
    private JPanel panelSuppMateriel;
    private JPanel panelMessage;
    private JPanel panelChamps;
    private JPanel panelBtnQuitter;
    private JPanel monPanelGlobal = new JPanel();

    //Label
    private JLabel lblMessage;
    private JLabel lblNomMateriel;
    private JLabel lblInsertion;

    //JTextField
    private JTextField jtfSuppression;
    private JTextField jtfPseudo;

    //Bouton
    private JButton btnValider;

    public SuppMateriel(String unPseudo) {
    	
    	//Definition du pseudo
    	this.jtfPseudo = new JTextField();
    	this.jtfPseudo.setText(unPseudo);

        //Instanciation de la frame
        this.framePrincipale = new JFrame();

        //Instanciation des panels
        this.panelSuppMateriel = new JPanel();
        this.panelMessage = new JPanel();
        this.panelChamps = new JPanel();
        this.panelBtnQuitter = new JPanel();
        this.monPanelGlobal.setLayout(new BorderLayout());

        //Background des panels
        this.panelSuppMateriel.setBackground(Color.white);
        this.panelMessage.setBackground(Color.blue);
        this.panelChamps.setBackground(Color.white);
        this.panelBtnQuitter.setBackground(Color.white);

        //Disposition des panels
        this.panelSuppMateriel.setLayout(new BorderLayout());
        this.panelMessage.setLayout(new FlowLayout());
        this.panelChamps.setLayout(new FlowLayout());
        this.panelBtnQuitter.setLayout(new FlowLayout());

        //Instanciation des messages
        this.lblMessage = new JLabel("Materiel - suppression");
        this.lblNomMateriel = new JLabel("Entrez le nom :");
        this.lblInsertion = new JLabel("");

        //Instanciation des entr�es
        this.jtfSuppression = new JTextField();
        this.jtfSuppression.setPreferredSize(new Dimension(150, 30));

        //Couleur de la police
        this.lblMessage.setForeground(Color.white);

        //Instanciation des boutons
        this.btnValider = new JButton("Valider");
        this.btnValider.addActionListener(this);

        //Ajout des attributs aux panels
        this.panelSuppMateriel.add(panelMessage, BorderLayout.PAGE_START);
        this.panelSuppMateriel.add(panelChamps, BorderLayout.CENTER);
        this.panelSuppMateriel.add(panelBtnQuitter, BorderLayout.PAGE_END);

        this.panelMessage.add(lblMessage);

        this.panelChamps.add(lblNomMateriel);
        this.panelChamps.add(jtfSuppression);
        this.panelChamps.add(btnValider);
        this.panelChamps.add(lblInsertion);

        //Toujours � la fin
        this.framePrincipale.getRootPane().setDefaultButton(btnValider);
        this.framePrincipale.setAlwaysOnTop(true);
        this.framePrincipale.getContentPane().add(panelSuppMateriel);
        this.monPanelGlobal.add(panelSuppMateriel, BorderLayout.CENTER);
        this.framePrincipale.getContentPane().add(this.monPanelGlobal);
    }

    //les getter et setter
    public JPanel getMonPanelGlobal() {
        return monPanelGlobal;
    }

    public void actionPerformed(ActionEvent e) {
        //Si la source de l'�v�nement est le JButton appel� 
        if (e.getSource() == btnValider) {
        	
            String nomMateriel = jtfSuppression.getText();
            int idMat = Modele.recupIdMateriel(nomMateriel);
            
            //Changement du nom Visiteur en idVisiteur
            String nomVisiteur = this.jtfPseudo.getText();
            String idVisiteur = Modele.recupIdVisiteur(nomVisiteur);
            
            if (Modele.suppressionMateriel(nomMateriel)) {
            	if(Modele.suppressionEmpruntMateriel(idMat, idVisiteur)) {
            		lblInsertion.setText("Suppression effectuee.");
            	}
            	else {
            		lblInsertion.setText("Probleme dans la suppression de l'emprunt.");
            	}
            } else {
                lblInsertion.setText("Suppression non effectuee.");
            }
        }
    }

}