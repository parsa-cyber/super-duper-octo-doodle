import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JLabel;

public class ImagePuzzleWindow {
	public JFrame mainFrame;
	public JMenuBar mainMenuBar;
	public JMenu gameMenu;
	public JMenu windowMenu;
	
	public ImagePuzzleWindow()
	{
		InitializeMenuBar();
		//InitializeImage();
		JLabel label = new JLabel();

		ImageIcon img = new ImageIcon("resources\\F2018.jpg"); //Image File Path

		label.setIcon(img);
		label.setVisible(true);
		label.setSize(400,400);
		mainFrame  = new JFrame("Games Window");
		mainFrame.add(label);
		
		mainFrame.setJMenuBar(mainMenuBar);
		
		mainFrame.setSize(300, 200);
		mainFrame.setLayout(null);
		mainFrame.setVisible(true);
		//mainFrame.pack();
		mainFrame.setLocationRelativeTo(null);
	}

	private void InitializeMenuBar()
	{
		mainMenuBar = new JMenuBar();
		
		gameMenu = new JMenu("Game");
		//gameMenu.setText("Game");
		mainMenuBar.add(gameMenu);
		JMenuItem newMenuItem = new JMenuItem("New");
		gameMenu.add(newMenuItem);
		JMenuItem closeMenuItem = new JMenuItem("Close");
		gameMenu.add(closeMenuItem);
		
		windowMenu = new JMenu("Window");
		mainMenuBar.add(windowMenu);
		JMenuItem size4x4MenuItem = new JMenuItem("4x4");
		windowMenu.add(size4x4MenuItem);
	    JMenuItem size5x5MenuItem = new JMenuItem("5x5");
	    windowMenu.add(size5x5MenuItem);
	    
	    newMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(newMenuItem.getBackground()==Color.red)
					newMenuItem.setBackground(Color.green);
				else
					newMenuItem.setBackground(Color.red);
			}
		});
	
	    closeMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(closeMenuItem.getBackground()==Color.red)
					closeMenuItem.setBackground(Color.green);
				else
					closeMenuItem.setBackground(Color.red);
				
			}
		});
	}

	private void InitializeImage()
	{

	}
}
