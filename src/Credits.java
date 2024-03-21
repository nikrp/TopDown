/*
 * Author: Nikhil Pellakuru & Dev Andra
 * Project: Game Project
 * Project Name: Top Down
 * Project Description: Two player zombie shooting game.
 * File Description: How to Play Page of the Game. Shows instructions of the game.
*/

// Module Imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Credits extends JPanel {
	private Image bg; // Background Image
	private String[] credits = {
			"Game Writers: Dev Andra and Nikhil Pellakuru"
	};
	
	// Fonts
	private final Font titleFont = new Font(Font.SANS_SERIF, Font.BOLD, 80);
	private final Font creditsFont = new Font(Font.SANS_SERIF, Font.BOLD, 40);
	
	public Credits() {
		// Collect the Background Image
		ImageIcon bgIcon = new ImageIcon("cemetary.jpg");
		bg = bgIcon.getImage();
		Timer movingCredits = new Timer(1, new ActionListener() {
		    private int yOffset = 0; // Initial Y offset
		    
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        yOffset -= 2; // Decrease Y offset to move text up
		        
		        // Loop through all components in the panel and adjust their positions
		        Component[] components = getComponents();
		        for (Component component : components) {
		            if (component instanceof JLabel) {
		                JLabel label = (JLabel) component;
		                label.setLocation(label.getX(), label.getY() - 1); // Move label up
		            }
		        }
		        
		        // If the topmost label reaches the top of the panel, reset positions
		        if (components.length > 0 && components[components.length - 1].getY() + yOffset <= (getHeight() + 1250) * -1) {
		            yOffset = getHeight(); // Reset Y offset to the height of the panel
		            for (Component component : components) {
		                if (component instanceof JLabel) {
		                	component.setVisible(false);
		                }
		            }
		            makeText(); // Remake the Credits
		        }
		        
		        repaint();
		    }
		});
		
		// Set the Layout of the JPanel to Null so we Can Position all the Elements
		this.setLayout(null);
		
		makeText();
		
		movingCredits.start();
	}
	
	public int getWidth() {
		return bg.getWidth(null);
	}
	
	public int getHeight() {
		return bg.getHeight(null);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(bg, 0, 0, getWidth(), getHeight(), null);
	}
	
	public void makeText() {
		// Add Text and Buttons to the Screen		
		JLabel title = new JLabel("Credits"); // First Title Word
		title.setFont(titleFont);
		Dimension size = title.getPreferredSize();
		title.setBounds((getWidth() / 2) - ((size.width / 2)), getHeight() + 50, size.width, size.height);
		this.add(title);
		
		for (int i = 0; i < credits.length; i++) {
			JLabel creditsLabel = TDUtilties.createText(credits[i], creditsFont);
			Dimension creditsSize = creditsLabel.getPreferredSize();
			creditsLabel.setBounds((getWidth() / 2) - (creditsSize.width / 2), (i * 80) + ((getHeight() + 50) + 100), creditsSize.width, creditsSize.height);
			this.add(creditsLabel);
		}
	}
}