/**
 * Fenetre de recherche des Vehicules
 * @author Jeremy
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
public class RechercheVehicule extends JPanel implements ActionListener {

    //Attributs privés

    //Frame
    private JFrame framePrincipale;

    //Panel
    private JPanel monPanel;
    private JPanel monPanelGlobal = new JPanel();
    private JPanel panelHaut;
    private JPanel panelMil;
    private JLabel lblInsertion;

    //Lebel
    private JLabel lblSupp1;
    private JLabel lblMessage;

    //TextField
    private JTextField jtfSupp1;

    //Bouton
    private JButton btnValider1;

    public RechercheVehicule() {

        //Instanciation de la frame
        this.framePrincipale = new JFrame();

        //Instanciation des panels
        this.monPanel = new JPanel();
        this.panelHaut = new JPanel();
        this.panelMil = new JPanel();

      //Background et disposition des panels
        this.panelHaut.setBackground(new Color(144, 12, 63));
        this.panelMil.setBackground(new Color(88, 24, 69));

        this.monPanel.setLayout(new BorderLayout());
        this.panelMil.setLayout(new FlowLayout());
        this.panelHaut.setLayout(new FlowLayout());
        this.monPanelGlobal.setLayout(new BorderLayout());

        //Instanciation des messages
        this.lblMessage = new JLabel("Véhicule - recherche");
        this.lblSupp1 = new JLabel("Entrez l'immatriculation du Véhicule : ");
        this.jtfSupp1 = new JTextField("");
        this.jtfSupp1.setPreferredSize(new Dimension(150, 30));
        this.lblInsertion = new JLabel();
        this.lblInsertion.setText("");

        //Instanciation du bouton
        this.btnValider1 = new JButton("Valider");
        this.btnValider1.setBorder(null);
		this.btnValider1.setBackground(new Color(144, 12, 63));
		this.btnValider1.setForeground(Color.white);
		this.btnValider1.setPreferredSize(new Dimension(170,30));
        this.btnValider1.addActionListener(new ActionListener() {
            //Recherche d'un Vehicule
            public void actionPerformed(ActionEvent e) {
                String immatVehicule = jtfSupp1.getText();
                String result = Modele.rechercheVehicule(immatVehicule);
                lblInsertion.setText(result);
            }
        });

        //Couleur de la police
        this.lblMessage.setForeground(Color.white);
        this.lblSupp1.setForeground(Color.white);
        this.lblInsertion.setForeground(Color.white);

        //Ajout des attributs aux panels
        this.monPanel.add(panelHaut, BorderLayout.PAGE_START);
        this.monPanel.add(panelMil, BorderLayout.CENTER);

        this.panelHaut.add(lblMessage);
        this.panelMil.add(lblSupp1);
        this.panelMil.add(jtfSupp1);
        this.panelMil.add(btnValider1);
        this.panelMil.add(lblInsertion);

        //Toujours à la fin
        this.framePrincipale.getRootPane().setDefaultButton(btnValider1);
        this.framePrincipale.setAlwaysOnTop(true);
        this.framePrincipale.getContentPane().add(monPanel);
        this.monPanelGlobal.add(monPanel, BorderLayout.CENTER);
        this.framePrincipale.getContentPane().add(this.monPanelGlobal);
    }

    //les getter et setter
    public JPanel getMonPanelGlobal() {
        return monPanelGlobal;
    }

    public void actionPerformed(ActionEvent e) {

    }
}