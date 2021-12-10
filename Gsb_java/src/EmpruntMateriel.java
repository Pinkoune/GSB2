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
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

public class EmpruntMateriel extends JPanel implements ActionListener {

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
    private JLabel lblDateDebut;
    private JLabel lblDateFin;
    private JLabel lblDuree;
    private JLabel lblInsertion;

    //JTextField
    private JTextField jtfDateDebut;
    private JTextField jtfDateFin;
    private JTextField jtfDuree;
    private JTextField jtfPseudo;
    
    //JComboBox
    private JComboBox jcbNomMateriel;

    //Bouton
    private JButton btnValider;
    
    //Calendrier pour les dates
    private JDatePickerImpl dateDebut;
    private JDatePickerImpl dateFin;

    //Constructeur
    public EmpruntMateriel(String unPseudo) {
    	
    	//Definition du pseudo
    	this.jtfPseudo = new JTextField();
    	this.jtfPseudo.setText(unPseudo);

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
        this.lblMessage = new JLabel("Matériel - Emprunt");
        this.lblNomMateriel = new JLabel("Nom du matériel :");
        this.lblDateDebut = new JLabel("Date du debut de l'emprunt :");
        this.lblDateFin = new JLabel("Date de fin de l'emprunt :");
        this.lblDuree = new JLabel("Durée de l'emprunt :");
        this.lblInsertion = new JLabel();
        this.lblInsertion.setText("");
        
        //Instanciation des entr�es
        this.jtfDateDebut = new JTextField();
        this.jtfDateDebut.setPreferredSize(new Dimension(150, 30));
        this.jtfDateFin = new JTextField();
        this.jtfDateFin.setPreferredSize(new Dimension(150, 30));
        this.jtfDuree = new JTextField();
        this.jtfDuree.setPreferredSize(new Dimension(150, 30));

        //Couleur de la police
        this.lblMessage.setForeground(Color.white);
        this.lblNomMateriel.setForeground(Color.black);
        this.lblDateDebut.setForeground(Color.black);
        this.lblDateFin.setForeground(Color.black);
        this.lblDuree.setForeground(Color.black);

        //Instanciation des boutons
        this.btnValider = new JButton("Valider");
        this.btnValider.addActionListener(this);
        
        //Ajout de la liste dans le jcbNomMateriel
        ArrayList<String> listeMateriel = Modele.recupListeNomMateriel();
		String nomMateriel[] = new String[Modele.nbListeMateriel()];
		int i = 0; 
        for (String unMateriel : listeMateriel) {
            nomMateriel[i] = unMateriel;
            i++;
        }
        
        //DatePickerDebut
        SqlDateModel model = new SqlDateModel();
        Properties p = new Properties();
        p.put("text.day", "Day");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl panel = new JDatePanelImpl(model,p);
        this.dateDebut = new JDatePickerImpl(panel, new DateLabelFormatter());
        
        //DatePickerFin
        SqlDateModel model2 = new SqlDateModel();
        Properties p2 = new Properties();
        p2.put("text.day", "Day");
        p2.put("text.month", "Month");
        p2.put("text.year", "Year");
        JDatePanelImpl panel2 = new JDatePanelImpl(model2,p2);
        this.dateFin = new JDatePickerImpl(panel2, new DateLabelFormatter());
        
        //Instanciation de la liste de noms
        this.jcbNomMateriel = new JComboBox<String>();
        this.jcbNomMateriel = new JComboBox<String>(nomMateriel);
        this.jcbNomMateriel.addActionListener(this);
        

        //Ajout des attributs aux panels
        this.panelAjoutMateriel.add(panelMessage, BorderLayout.PAGE_START);
        this.panelAjoutMateriel.add(panelChamps, BorderLayout.CENTER);

        this.panelMessage.add(lblMessage);

        this.panelChamps.add(lblNomMateriel);
        this.panelChamps.add(jcbNomMateriel);
        
        this.panelChamps.add(lblDateDebut);
        this.panelChamps.add(dateDebut);

        this.panelChamps.add(lblDateFin);
        this.panelChamps.add(dateFin);
        
        this.panelChamps.add(lblDuree);
        this.panelChamps.add(jtfDuree);
        
        this.panelChamps.add(btnValider);
        this.panelChamps.add(lblInsertion);

        //Toujours a la fin
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
        	//Changement du nom Materiel en idMateriel
            String nomMateriel = (String)jcbNomMateriel.getSelectedItem();
            int idMat = Modele.recupIdMateriel(nomMateriel);
            
            //Changement du nom Visiteur en idVisiteur
            String nomVisiteur = this.jtfPseudo.getText();
            String idVisiteur = Modele.recupIdVisiteur(nomVisiteur);
            
            //Recuperation des dates
            java.sql.Date ptiteDateDebut = (java.sql.Date) EmpruntMateriel.this.dateDebut.getModel().getValue();
            java.sql.Date ptiteDateFin = (java.sql.Date) EmpruntMateriel.this.dateFin.getModel().getValue();
            
            float duree = Integer.parseInt(jtfDuree.getText());
            
            boolean rep = Modele.ajoutEmpruntMateriel(idMat, ptiteDateDebut, ptiteDateFin, duree, idVisiteur);
            if (rep) {
            	boolean statut = Modele.majStatutMateriel(idMat);
            	if(statut) {
            		lblInsertion.setText("Emprunt réussi");
            	}
            	else {
            		lblInsertion.setText("ERREUR, emprunt avec statut echoué");
            	}
            } else {
                lblInsertion.setText("ERREUR, emprunt echoué");
            }
        }
    }
}