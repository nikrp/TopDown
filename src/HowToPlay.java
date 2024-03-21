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
public class HowToPlay extends JPanel {
	private Image bg; // Background Image
	private String[] instructions = {
			"Use WASD or Arrow Keys to Move",
			"Use Mouse to Look",
			"Left Click on Mouse to Shoot Zombies",
			"Only Shoot Zombies with Numbers Assigned to You",
			"Make Sure to Not Shoot your Teammate or Crash into Them"
	};
	
	// Fonts
	private final Font titleFont = new Font(Font.SANS_SERIF, Font.BOLD, 80);
	private final Font instructionsFont = new Font(Font.SANS_SERIF, Font.BOLD, 40);
	
	public HowToPlay() {
		// Collect the Background Image
		ImageIcon bgIcon = new ImageIcon("cemetary.jpg");
		bg = bgIcon.getImage();
		
		// Set the Layout of the JPanel to Null so we Can Position all the Elements
		this.setLayout(null);
		
		// Add Text and Buttons to the Screen		
		JLabel title = new JLabel("How to Play"); // First Title Word
		title.setFont(titleFont);
		Dimension size = title.getPreferredSize();
		title.setBounds((getWidth() / 2) - ((size.width / 2)), 0, size.width, size.height);
		this.add(title);
		
		for (int i = 0; i < instructions.length; i++) {
			JLabel instructionsLabel = TDUtilties.createText((i + 1) + ". " + instructions[i], instructionsFont);
			Dimension instructionsSize = instructionsLabel.getPreferredSize();
			instructionsLabel.setBounds(50, (i * 60) + 125, instructionsSize.width, instructionsSize.height);
			this.add(instructionsLabel);
		}
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
}