/*
 * Author: Nikhil Pellakuru & Dev Andra
 * Project: Game Project
 * Project Name: Top Down
 * Project Description: Two player zombie shooting game.
 * File Description: Home Page of the game. Will have play button and other information about game.
*/

// Module Imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Home Screen Panel Including Main JFrame
public class Home extends JPanel implements ActionListener {
	private Image bg; // Background Image
	private JPanel screens; // Layout
	
	// Fonts
	private final Font titleFont = new Font(Font.SANS_SERIF, Font.BOLD, 100);
	private final Font bottomFont = new Font(Font.SANS_SERIF, Font.PLAIN, 40);
	
	public Home() {
		// Collect the Background Image
		ImageIcon bgIcon = new ImageIcon("cemetary.jpg");
		bg = bgIcon.getImage();
		
		// Set the Layout of the JPanel to Null so we Can Position all the Elements
		this.setLayout(null);
		
		// Add Text and Buttons to the Screen		
		JLabel title1 = new JLabel("Top Down"); // First Title Word
		title1.setFont(titleFont);
		Dimension size = title1.getPreferredSize();
	    title1.setBounds((getWidth() / 2) - ((size.width / 2)), (getHeight() / 2) - 300, size.width, size.height);
		this.add(title1);
		
//		JLabel title2 = new JLabel("Down"); // Second Title Word
//		title2.setFont(titleFont);
//		Dimension size2 = title2.getPreferredSize();
//	    title2.setBounds((getWidth() / 2) - ((size2.width / 2) - 80), (getHeight() / 2) - 200, size2.width, size2.height);
//		this.add(title2);
		
		JLabel howToPlay = TDUtilties.createLink("How to Play", bottomFont, new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) (screens.getLayout());
				cl.show(screens, "howtoplay");
			}
		}); // How to Play Text
		Dimension howToPlaySize = howToPlay.getPreferredSize();
	    howToPlay.setBounds((getWidth() / 4), getHeight() - 150, howToPlaySize.width, howToPlaySize.height);
		this.add(howToPlay);
		
		JLabel credits = TDUtilties.createLink("Credits", bottomFont, new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) (screens.getLayout());
				cl.show(screens, "credits");
			}
		}); // Credits Text
		Dimension creditsSize = credits.getPreferredSize();
		credits.setBounds((getWidth() / 3) * 2, getHeight() - 150, creditsSize.width, creditsSize.height);
		this.add(credits);
		
		JButton playBtn = TDUtilties.createButton("   Play   ", bottomFont, 45f, 50, 100, 100, new ActionListener() {@Override public void actionPerformed(ActionEvent e) { System.out.println("Hello Testing"); }});
		Dimension playBtnSize = playBtn.getPreferredSize();
		playBtn.setBounds((getWidth() / 2) - (playBtnSize.width / 2), (getHeight() / 2) - 125, playBtnSize.width, playBtnSize.height);
		this.add(playBtn);
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

	public void actionPerformed(ActionEvent e) {}
	
	public void setupWindow(Home homeScreen) {
		JFrame frame = new JFrame("Top Down");
		
		// Initialize the Card Layout Manager and Add all Screens to It
		screens = new JPanel(new CardLayout());
		screens.add(homeScreen, "home");
		screens.add(new HowToPlay(), "howtoplay");
		screens.add(new Credits(), "credits");
		
		frame.setSize(homeScreen.getWidth(), homeScreen.getHeight() - 50);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(screens, BorderLayout.CENTER);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		Home game = new Home();
		game.setupWindow(game);
	}
}