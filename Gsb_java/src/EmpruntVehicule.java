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

public class EmpruntVehicule extends JPanel implements ActionListener {

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
    private JLabel lblNomVehicule;
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
    private JComboBox jcbNomVehicule;

    //Bouton
    private JButton btnValider;
    
    //Calendrier pour les dates
    private JDatePickerImpl dateDebut;
    private JDatePickerImpl dateFin;

    //Constructeur
    public EmpruntVehicule(String unPseudo) {
    	
    	//Definition du pseudo
    	this.jtfPseudo = new JTextField();
    	this.jtfPseudo.setText(unPseudo);

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
        this.panelChamps.setLayout(new FlowLayout());

        //Instanciation des messages
        this.lblMessage = new JLabel("Véhicule - Emprunt");
        this.lblNomVehicule = new JLabel("Nom du Véhicule :");
        this.lblDateDebut = new JLabel("Date du début de l'emprunt :");
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
        this.lblNomVehicule.setForeground(Color.white);
        this.lblDateDebut.setForeground(Color.white);
        this.lblDateFin.setForeground(Color.white);
        this.lblDuree.setForeground(Color.white);

        //Instanciation des boutons
        this.btnValider = new JButton("Valider");
        this.btnValider.setBorder(null);
		this.btnValider.setBackground(new Color(144, 12, 63));
		this.btnValider.setForeground(Color.white);
		this.btnValider.setPreferredSize(new Dimension(170,30));
        this.btnValider.addActionListener(this);
        
        //Ajout de la liste dans le jcbNomVehicule
        ArrayList<String> listeVehicule = Modele.recupListeVehiculeM();
		String nomVehicule[] = new String[Modele.nbListeAjoutVehicule()];
		int i = 0; 
        for (String unVehicule : listeVehicule) {
            nomVehicule[i] = unVehicule;
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
        this.jcbNomVehicule = new JComboBox<String>();
        this.jcbNomVehicule = new JComboBox<String>(nomVehicule);
        this.jcbNomVehicule.addActionListener(this);
        

        //Ajout des attributs aux panels
        this.panelAjoutVehicule.add(panelMessage, BorderLayout.PAGE_START);
        this.panelAjoutVehicule.add(panelChamps, BorderLayout.CENTER);

        this.panelMessage.add(lblMessage);

        this.panelChamps.add(lblNomVehicule);
        this.panelChamps.add(jcbNomVehicule);
        
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
            String nomVehicule = (String)jcbNomVehicule.getSelectedItem();
            int idVehicule = Modele.recupIdVehicule(nomVehicule);
            
            String nomVisiteur = this.jtfPseudo.getText();
            String idVisiteur = Modele.recupIdVisiteur(nomVisiteur);
            
            //Recuperation des dates
            java.sql.Date ptiteDateDebut = (java.sql.Date) EmpruntVehicule.this.dateDebut.getModel().getValue();
            java.sql.Date ptiteDateFin = (java.sql.Date) EmpruntVehicule.this.dateFin.getModel().getValue();
            
            float duree = Integer.parseInt(jtfDuree.getText());
            
            boolean rep = Modele.ajoutEmpruntVehicule(idVehicule, ptiteDateDebut, ptiteDateFin, duree, idVisiteur);
            if (rep) {
            	boolean statut = Modele.majStatutVehicule(idVehicule);
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