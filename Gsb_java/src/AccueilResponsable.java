/**
 * Page principale du programme
 * @author Jeremy
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class AccueilResponsable extends JFrame implements ActionListener {
	
	//les panel classiques
  private JPanel monPanel = new JPanel();
  private JPanel monPanelGlobal = new JPanel();

  //La barre menu
  private JMenuBar jMenu;
  
  //Les menus
  private JMenu courses;
  private JMenu ecuries;
  private JMenu circuits;
  
  //Les boutons course
  private JMenuItem btnAjouterCourse;
  private JMenuItem btnSupprimerCourse;
  private JMenuItem btnRechercherCourse;
  private JMenuItem btnAffichageCourse;
  
  //Les boutons ecurie
  private JMenuItem btnAjouterEcurie;
  private JMenuItem btnSupprimerEcurie;
  private JMenuItem btnRechercherEcurie;
  private JMenuItem btnAffichageEcurie;
  
  //Les boutons circuit
  private JMenuItem btnAjouterCircuit;
  private JMenuItem btnSupprimerCircuit;
  private JMenuItem btnRechercherCircuit;
  private JMenuItem btnAffichageCircuit;

  
  private JLabel lblMessage;


  //CONSTRUCTEURS
  public AccueilResponsable() {
	  this.setTitle("RaSio");  
	  this.setLocationRelativeTo(null);
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  this.setSize(700, 500);
    
    
    //INSTANCIATION DU PANEL GLOBAL

    this.monPanel.setLayout(new FlowLayout(1, 4, 2));
    this.monPanel.setBackground(Color.pink);

    this.monPanelGlobal = new JPanel();
    this.monPanelGlobal.setLayout(new BorderLayout());
    
    // Creation des menus
    this.courses = new JMenu("Menu des courses");
    this.ecuries = new JMenu("Menu des ecuries");
    this.circuits = new JMenu("Menu des circuits");
    
    // Creation de la barre de menu
    JMenuBar jMenu = new JMenuBar();

    //Creation des elements du menu course
    this.btnAffichageCourse = new JMenuItem("Afficher les courses");
    this.btnAjouterCourse = new JMenuItem("Ajouter une course");
    this.btnSupprimerCourse = new JMenuItem("Supprimer une course");
    this.btnRechercherCourse = new JMenuItem("Rechercher une course");
    this.courses.add(btnAffichageCourse);
    this.courses.add(btnAjouterCourse);
    this.courses.add(btnSupprimerCourse);
    this.courses.add(btnRechercherCourse);
    
    //Creation des elements du menu ecurie
    this.btnAffichageEcurie = new JMenuItem("Afficher les ecuries");
    this.btnAjouterEcurie = new JMenuItem("Ajouter une ecurie");
    this.btnSupprimerEcurie = new JMenuItem("Supprimer une ecurie");
    this.btnRechercherEcurie = new JMenuItem("Rechercher une ecurie");
    this.ecuries.add(btnAffichageEcurie);
    this.ecuries.add(this.btnAjouterEcurie);
    this.ecuries.add(this.btnSupprimerEcurie);
    this.ecuries.add(this.btnRechercherEcurie);
    
    //Creation des elements du menu circuit
    this.btnAffichageCircuit = new JMenuItem("Afficher les circuits");
    this.btnAjouterCircuit = new JMenuItem("Ajouter une circuit");
    this.btnSupprimerCircuit = new JMenuItem("Supprimer une circuit");
    this.btnRechercherCircuit = new JMenuItem("Rechercher une circuit");
    this.circuits.add(btnAffichageCircuit);
    this.circuits.add(this.btnAjouterCircuit);
    this.circuits.add(this.btnSupprimerCircuit);
    this.circuits.add(this.btnRechercherCircuit);

    
    
    //Ecoute des items du menu course
    this.btnAjouterCourse.addActionListener(this);
    this.btnSupprimerCourse.addActionListener(this);
    this.btnRechercherCourse.addActionListener(this);
    this.btnAffichageCourse.addActionListener(this);
    
    //Ecoute des items du menu ecurie
    this.btnAjouterEcurie.addActionListener(this);
    this.btnSupprimerEcurie.addActionListener(this);
    this.btnRechercherEcurie.addActionListener(this);
    this.btnAffichageEcurie.addActionListener(this);
    
    //Ecoute des items du menu circuit
    this.btnAjouterCircuit.addActionListener(this);
    this.btnSupprimerCircuit.addActionListener(this);
    this.btnRechercherCircuit.addActionListener(this);
    this.btnAffichageCircuit.addActionListener(this);

    // Ajout de l'element au menu 
    jMenu.add(courses);
    jMenu.add(ecuries);
    jMenu.add(circuits);
    
    // Permet de definir le menu utilise dans la JFrame
    this.setJMenuBar(jMenu);

    //LABEL PERMETTANT D'AFFICHER UN TEXTE
    this.lblMessage = new JLabel();
    this.lblMessage.setText("La RaSIO");

    this.monPanel.add(lblMessage);

    this.monPanelGlobal.add(monPanel, BorderLayout.CENTER);

    this.getContentPane().add(this.monPanelGlobal);
    this.setVisible(true);

  }

  //les getter et setter
  public JPanel getMonPanelGlobal() {
    return monPanelGlobal;
  }

  //Lance le changement de panel
  public void actionPerformed(ActionEvent e) {

	//Boutons des Courses
    if (e.getSource().equals(btnAjouterCourse)) {
    	this.getContentPane().removeAll();
    	//this.getContentPane().add(new AjoutCourse().getMonPanelGlobal());
    	this.getContentPane().revalidate();
    	this.getContentPane().repaint();
    	
    } else if (e.getSource().equals(btnSupprimerCourse)) {
      
    	this.getContentPane().removeAll();
		//this.getContentPane().add(new SuppCourse().getMonPanelGlobal());
		this.getContentPane().revalidate();
		this.getContentPane().repaint();
		
    } else if (e.getSource().equals(btnRechercherCourse)) {
        
    	this.getContentPane().removeAll();
		//this.getContentPane().add(new RechCourse().getMonPanelGlobal());
		this.getContentPane().revalidate();
		this.getContentPane().repaint();
		
    } else if (e.getSource().equals(btnAffichageCourse)) {
        //ArrayList<ContenuCourse> listeCourse;
        //listeCourse = new ArrayList<ContenuCourse>();
        //listeCourse = Modele.affichageCourse();
    	this.getContentPane().removeAll();
		//this.getContentPane().add(new AffCourse(listeCourse).getMonPanelGlobal());
		this.getContentPane().revalidate();
		this.getContentPane().repaint();
		
	//Boutons des Ecuries
    } else if (e.getSource().equals(btnAjouterEcurie)) {
    	
      this.getContentPane().removeAll();
      //this.getContentPane().add(new AjoutEcurie().getMonPanelGlobal());
      this.getContentPane().revalidate();
      this.getContentPane().repaint();
    
  	} else if (e.getSource().equals(btnSupprimerEcurie)) {
  	
      this.getContentPane().removeAll();
      //this.getContentPane().add(new SuppEcurie().getMonPanelGlobal());
      this.getContentPane().revalidate();
      this.getContentPane().repaint();
      
  	} else if (e.getSource().equals(btnRechercherEcurie)) {
    	
        this.getContentPane().removeAll();
        //this.getContentPane().add(new RechEcurie().getMonPanelGlobal());
        this.getContentPane().revalidate();
        this.getContentPane().repaint();
        
  	} else if (e.getSource().equals(btnAffichageEcurie)) {
        //ArrayList<ContenuEcurie> listeEcurie;
        //listeEcurie = new ArrayList<ContenuEcurie>();
        //listeEcurie = Modele.affichageEcurie();
    	this.getContentPane().removeAll();
		//this.getContentPane().add(new AffEcurie(listeEcurie).getMonPanelGlobal());
		this.getContentPane().revalidate();
		this.getContentPane().repaint();
        
    // Boutons des Circuits
  	} else if (e.getSource().equals(btnAjouterCircuit)) {
    	
        this.getContentPane().removeAll();
        //this.getContentPane().add(new AjoutCircuit().getMonPanelGlobal());
        this.getContentPane().revalidate();
        this.getContentPane().repaint();
    
  	} else if (e.getSource().equals(btnSupprimerCircuit)) {
  	
      this.getContentPane().removeAll();
      //this.getContentPane().add(new SuppCircuit().getMonPanelGlobal());
      this.getContentPane().revalidate();
      this.getContentPane().repaint();
    
  	} else if (e.getSource().equals(btnRechercherCircuit)) {
  	  	
        this.getContentPane().removeAll();
        //this.getContentPane().add(new RechCircuit().getMonPanelGlobal());
        this.getContentPane().revalidate();
        this.getContentPane().repaint();
        
  	} else if (e.getSource().equals(btnAffichageCircuit)) {
        //ArrayList<ContenuCircuit> listeCircuit;
        //listeCircuit = new ArrayList<ContenuCircuit>();
        //listeCircuit = Modele.affichageCircuit();
    	this.getContentPane().removeAll();
		//this.getContentPane().add(new AffCircuit(listeCircuit).getMonPanelGlobal());
		this.getContentPane().revalidate();
		this.getContentPane().repaint();
      
  	}

  }
  
} 