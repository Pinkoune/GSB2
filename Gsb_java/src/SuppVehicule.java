/**
 * Suppression des Vehicules
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

public class SuppVehicule extends JPanel implements ActionListener {

    //Attributs privés

    //Frame
    private JFrame framePrincipale;

    //Panel
    private JPanel panelSuppVehicule;
    private JPanel panelMessage;
    private JPanel panelChamps;
    private JPanel panelBtnQuitter;
    private JPanel monPanelGlobal = new JPanel();

    //Label
    private JLabel lblMessage;
    private JLabel lblNomVehicule;
    private JLabel lblInsertion;

    //JTextField
    private JTextField jtfSuppression;

    //Bouton
    private JButton btnValider;

    public SuppVehicule() {

        //Instanciation de la frame
        this.framePrincipale = new JFrame();

        //Instanciation des panels
        this.panelSuppVehicule = new JPanel();
        this.panelMessage = new JPanel();
        this.panelChamps = new JPanel();
        this.panelBtnQuitter = new JPanel();
        this.monPanelGlobal.setLayout(new BorderLayout());

        //Background des panels
        this.panelSuppVehicule.setBackground(Color.white);
        this.panelMessage.setBackground(Color.blue);
        this.panelChamps.setBackground(Color.white);
        this.panelBtnQuitter.setBackground(Color.white);

        //Disposition des panels
        this.panelSuppVehicule.setLayout(new BorderLayout());
        this.panelMessage.setLayout(new FlowLayout());
        this.panelChamps.setLayout(new FlowLayout());
        this.panelBtnQuitter.setLayout(new FlowLayout());

        //Instanciation des messages
        this.lblMessage = new JLabel("Vehicule - suppression");
        this.lblNomVehicule = new JLabel("Entrez l'immatriculation :");
        this.lblInsertion = new JLabel("");

        //Instanciation des entrées
        this.jtfSuppression = new JTextField();
        this.jtfSuppression.setPreferredSize(new Dimension(150, 30));

        //Couleur de la police
        this.lblMessage.setForeground(Color.white);

        //Instanciation des boutons
        this.btnValider = new JButton("Valider");
        this.btnValider.addActionListener(this);

        //Ajout des attributs aux panels
        this.panelSuppVehicule.add(panelMessage, BorderLayout.PAGE_START);
        this.panelSuppVehicule.add(panelChamps, BorderLayout.CENTER);
        this.panelSuppVehicule.add(panelBtnQuitter, BorderLayout.PAGE_END);

        this.panelMessage.add(lblMessage);

        this.panelChamps.add(lblNomVehicule);
        this.panelChamps.add(jtfSuppression);
        this.panelChamps.add(btnValider);
        this.panelChamps.add(lblInsertion);

        //Toujours à la fin
        this.framePrincipale.getRootPane().setDefaultButton(btnValider);
        this.framePrincipale.setAlwaysOnTop(true);
        this.framePrincipale.getContentPane().add(panelSuppVehicule);
        this.monPanelGlobal.add(panelSuppVehicule, BorderLayout.CENTER);
        this.framePrincipale.getContentPane().add(this.monPanelGlobal);
    }

    //les getter et setter
    public JPanel getMonPanelGlobal() {
        return monPanelGlobal;
    }

    public void actionPerformed(ActionEvent e) {
        //Si la source de l'évènement est le JButton appelé 
        if (e.getSource() == btnValider) {
            String immatVehicule = jtfSuppression.getText();
            if (Modele.suppressionVehicule(immatVehicule)) {
                lblInsertion.setText("Suppression effectuée.");
            } else {
                lblInsertion.setText("Suppression non effectuée.");
            }
        }
    }

}