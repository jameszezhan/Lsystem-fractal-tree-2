package fractalTree_LSystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import oopforFractalTree.Tree;

public class Main {
	
	public static void createAndShowGUI() {
		JFrame mainFrame = new JFrame("L-System") {
			@Override
			public Dimension getPreferredSize() {
				return new Dimension(2000,2000);
			}
		};
		JPanel mainPanel = new JPanel() {
			@Override
			public Dimension getPreferredSize() {
				return new Dimension(2000, 2000);
			}
			// Need to redefine the paintComponent function from the JPanel class
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.red);
				LSystemPlant obj = new LSystemPlant();
				String string = obj.generate("F", g);
				//obj.draw(g, string);
				}
		};
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		mainPanel.setBackground(Color.black);

		mainFrame.add(mainPanel);
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
	
	
	
	
	
}
