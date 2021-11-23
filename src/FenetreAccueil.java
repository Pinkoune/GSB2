import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class FenetreAccueil extends JFrame implements ActionListener {
	

	
	public FenetreAccueil() {
			
			this.setTitle("RaSio");
	    	this.setLocationRelativeTo(null);
	    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	this.setSize(800, 600);
	    	this.setResizable(false);
	    	
	    	
	        
	        // Permet de définir le menu utilisé dans la JFrame
	        this.setAlwaysOnTop(true);
	        this.setVisible(true);

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