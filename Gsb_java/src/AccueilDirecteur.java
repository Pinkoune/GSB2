import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccueilDirecteur extends JPanel implements ActionListener {

    //JFrame
    private JFrame framePrincipale;

    //JPanel
    private JPanel monPanel;
    private JPanel monPanelGlobal;

    //JLabel
    private JLabel lblTest;

    public AccueilDirecteur() {
        //Instanciation de la frame
        this.framePrincipale = new JFrame();

        //Instanciation des panels
        this.monPanel = new JPanel();
        this.monPanelGlobal = new JPanel();

        //Disposition des panels
        this.monPanel.setLayout(new GridBagLayout());
        this.monPanelGlobal.setLayout(new BorderLayout());

        //Definition des parametre de la frame principale
        this.framePrincipale.setTitle("GSB");
        this.framePrincipale.setLocationRelativeTo(null);
        this.framePrincipale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.framePrincipale.setSize(800, 600);
        this.framePrincipale.setResizable(false);

        //Insianciation des labels
        this.lblTest = new JLabel("Directeur");

        //Ajout du contenu dans les panels
        this.monPanel.add(lblTest);

        //Defini le menu dans la JFrame

        //this.framePrincipale.getRootPane().setDefaultButton(jbValider);

        this.framePrincipale.setAlwaysOnTop(true);
        this.monPanelGlobal.add(this.monPanel);
        this.framePrincipale.getContentPane().add(monPanelGlobal);
        this.framePrincipale.setVisible(true);

    }

    //Get du panel global
    public JPanel getMonPanelGlobal() {
        return monPanelGlobal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
		/*
		if(e.getSource().equals(afficherCourse)) {
			this.getContentPane().removeAll();
			this.getContentPane().add(new PanelAfficherCourse().getMonPanel());
			this.getContentPane().revalidate();
			this.getContentPane().repaint();
		}*/

    }
}
