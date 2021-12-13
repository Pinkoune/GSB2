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

import javax.swing.BorderFactory;
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
        this.panelMessage.setBackground(new Color(67, 87, 186));
        this.panelChamps.setBackground(new Color(22, 38, 119));

        //Disposition des panels
        this.panelAjoutMateriel.setLayout(new BorderLayout());
        this.panelMessage.setLayout(new FlowLayout());
        this.panelChamps.setLayout(null);

        //Instanciation des messages
        this.lblMessage = new JLabel("Matériel - Emprunt");
        
        this.lblNomMateriel = new JLabel("Nom du matériel");
        this.lblNomMateriel.setBounds(290, 35, 150, 25);
        
        this.lblDateDebut = new JLabel("Date du debut de l'emprunt");
        this.lblDateDebut.setBounds(265, 95, 180, 25);
        
        this.lblDateFin = new JLabel("Date de fin de l'emprunt");
        this.lblDateFin.setBounds(270, 155, 150, 25);
        
        this.lblDuree = new JLabel("Durée de l'emprunt");
        this.lblDuree.setBounds(285, 215, 150, 25);
        
        this.lblInsertion = new JLabel();
        this.lblInsertion.setBounds(265, 330, 150, 25);
        
        this.lblInsertion.setText("");
        
        //Instanciation des entrées
        this.jtfDuree = new JTextField();
        this.jtfDuree.setBackground(new Color(47,53,66));
		this.jtfDuree.setBorder(BorderFactory.createLineBorder(new Color(67, 87, 186)));
        this.jtfDuree.setPreferredSize(new Dimension(150, 30));
        this.jtfDuree.setCaretColor(Color.white);
        this.jtfDuree.setBounds(265, 240, 150, 25);

        //Instanciation des boutons
        this.btnValider = new JButton("Valider");
        this.btnValider.setBorder(null);
		this.btnValider.setBackground(new Color(67, 87, 186));
		this.btnValider.setForeground(Color.white);
		this.btnValider.setPreferredSize(new Dimension(170,30));
		this.btnValider.setBounds(240, 285, 200, 35);
        this.btnValider.addActionListener(this);
        
        //Ajout de la liste dans le jcbNomMateriel
        ArrayList<String> listeMateriel = Modele.recupListeEmpruntM();
		String nomMateriel[] = new String[Modele.nbListeAjoutMateriel()];
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
        this.dateDebut.setBackground(new Color(47,53,66));
		this.dateDebut.setBorder(BorderFactory.createLineBorder(new Color(67, 87, 186)));
        this.dateDebut.setBounds(265, 120, 150, 25);
        
        //DatePickerFin
        SqlDateModel model2 = new SqlDateModel();
        Properties p2 = new Properties();
        p2.put("text.day", "Day");
        p2.put("text.month", "Month");
        p2.put("text.year", "Year");
        JDatePanelImpl panel2 = new JDatePanelImpl(model2,p2);
        this.dateFin = new JDatePickerImpl(panel2, new DateLabelFormatter());
        this.dateFin.setBackground(new Color(47,53,66));
		this.dateFin.setBorder(BorderFactory.createLineBorder(new Color(67, 87, 186)));
        this.dateFin.setBounds(265, 180, 150, 25);        
        
        //Instanciation de la liste de noms
        this.jcbNomMateriel = new JComboBox<String>();
        this.jcbNomMateriel = new JComboBox<String>(nomMateriel);
        this.jcbNomMateriel.setBackground(new Color(47,53,66));
		this.jcbNomMateriel.setBorder(BorderFactory.createLineBorder(new Color(67, 87, 186)));
        this.jcbNomMateriel.setBounds(265, 60, 150, 25);
        this.jcbNomMateriel.addActionListener(this);
        
        //Couleur de la police
        this.lblMessage.setForeground(Color.white);
        this.lblNomMateriel.setForeground(Color.white);
        this.lblDateDebut.setForeground(Color.white);
        this.lblDateFin.setForeground(Color.white);
        this.lblDuree.setForeground(Color.white);
        this.lblInsertion.setForeground(Color.white);
        this.jtfDuree.setForeground(Color.white);
        this.jcbNomMateriel.setForeground(Color.white);

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