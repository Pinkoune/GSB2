import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FenetreAccueil extends JFrame implements ActionListener {

	//JPanel
	private JPanel monPanel;
	private JPanel monPanelGlobal;

	
	public FenetreAccueil() {
			
			this.setTitle("GSB");
	    	this.setLocationRelativeTo(null);
	    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	this.setSize(800, 600);
	    	this.setResizable(false);
	    	
	    	
	        
	        // Permet de d�finir le menu utilis� dans la JFrame
	        this.setAlwaysOnTop(true);
	        this.setVisible(true);

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