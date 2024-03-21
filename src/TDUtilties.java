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

/*
 * Utility class for our game. Used to simplify the process of creating components in swing.
 * Makes code more readable and is easy to implement.
*/
public class TDUtilties {
	// Create Custom Buttons (font, color, onHover color change, onClick listener)
	public static JButton createButton(String text, Font font, float hue, int sat, int bright, int hoverSat, ActionListener onClick) {
		JButton button = new JButton(text);
		
		button.setFont(font);
		button.setBorderPainted(false);
		button.setFocusPainted(false);
		button.setOpaque(true);
		button.setBackground(Color.getHSBColor(hue, sat, bright));
		
		button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
        		button.setBackground(Color.getHSBColor(hue, hoverSat, bright));
        		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
        		button.setBackground(Color.getHSBColor(hue, sat, bright));
        		button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
		
		if (onClick != null) {
			button.addActionListener(onClick);
		}
		
		return button;
	}
	
	// Create custom links (JLabel with mouseClicked() listeners)
	public static JLabel createLink(String text, Font font, float hue, int sat, int bright, int hoverSat, MouseListener onClick) {
		JLabel link = new JLabel(text);
		
		link.setFont(font);
		link.setForeground(Color.getHSBColor(hue, sat, bright));
		
		link.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				link.setForeground(Color.getHSBColor(hue, hoverSat, bright));
				link.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				link.setForeground(Color.getHSBColor(hue, sat, bright));
				link.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		
		if (onClick != null) {
			link.addMouseListener(onClick);
		}
		
		
		return link;
	}
	public static JLabel createLink(String text, Font font, MouseListener onClick) {
		JLabel link = new JLabel(text);
		
		link.setFont(font);
		link.setForeground(Color.BLACK);
		
		link.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				link.setForeground(Color.DARK_GRAY);
				link.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				link.setForeground(Color.BLACK);
				link.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		
		if (onClick != null) {
			link.addMouseListener(onClick);
		}
		
		return link;
	}
	
	// Create custom text (font, color)
	public static JLabel createText(String text, Font font, float hue, int sat, int bright) {
		JLabel label = new JLabel(text);
		
		label.setFont(font);
		label.setForeground(Color.getHSBColor(hue, sat, bright));
		
		return label;
	}
	public static JLabel createText(String text, Font font) {
		JLabel label = new JLabel(text);
		
		label.setFont(font);
		
		return label;
	}
}