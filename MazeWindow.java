import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class MazeWindow {
	JFrame mainFrame;
	
	
	public MazeWindow()
	{
		mainFrame = new JFrame();
		
		int rowDim = 10;
		int colDim = 20;
		int windowWidth = 800;
		int windowHeight = 400;
		int row, col;
		
		int board[][] = new int[rowDim][colDim];
		JButton boardButton[][] = new JButton[rowDim][colDim];
		
		for (row = 0; row < rowDim; row++)
		{
			for (col = 0; col < colDim; col++)
			{
				board[row][col] = 0;
			}
		}
		
		for (row = 0; row < rowDim; row++)
		{
			for (col = 0; col < colDim; col++)
			{
				JButton button;

				button = new JButton();
				button.setText("");
				button.setVisible(true);
				button.setBackground(Color.white);
				button.setBounds(col * (windowWidth/colDim), row * (windowHeight/rowDim), (windowWidth/colDim), (windowHeight/rowDim));
				button.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if((e.getModifiers() & e.CTRL_MASK) > 0)
						{
							int r, c;
							
							c = button.getX() / (windowWidth / colDim);
							r = button.getY() / (windowHeight / rowDim);
							
							board[r][c]++;
							board[r][c] %= 4;
							switch (board[r][c])
							{
							case 0:
								button.setBackground(Color.white); // Free cell
								break;
							case 1:
								button.setBackground(Color.black); // Wall cell
								break;
							case 2:
								button.setBackground(Color.red);  // Mouse cell
								break;
							case 3:
								button.setBackground(Color.green); // Cheese cell
								break;
							}
						}
					}
				});
				
				button.addKeyListener(new KeyListener() {
					
					@Override
					public void keyTyped(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void keyReleased(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void keyPressed(KeyEvent e) {
						int r, c;
						
						c = button.getX() / (windowWidth / colDim);
						r = button.getY() / (windowHeight / rowDim);
						
						if(board[r][c] == 2)
						{
							switch (e.getKeyCode())
							{
							case KeyEvent.VK_UP:
								if(r > 0)
								{
									/*if (board[r-1][c] == 3)
									{
										button.setBackground(Color.white);	
									}*/
									if (board[r-1][c] == 0 || board[r-1][c] == 3)
									{
										board[r-1][c] = 2;
										board[r][c] = 0;
										
										boardButton[r][c].setBackground(Color.white);
										boardButton[r-1][c].setBackground(Color.red);
										
										boardButton[r-1][c].grabFocus();
									}
								}
								break;
							case KeyEvent.VK_DOWN:
								if (r < (rowDim - 1))
								{
									/*if (board[r+1][c] == 3)
									{
										button.setBackground(Color.white);
									}*/
									if (board[r+1][c] == 0 || board[r+1][c] == 3)
									{
										board[r+1][c] = 2;
										board[r][c] = 0;
										
										boardButton[r][c].setBackground(Color.white);
										boardButton[r+1][c].setBackground(Color.red);
										
										boardButton[r+1][c].grabFocus();
									}
								}
								 break;
							case KeyEvent.VK_LEFT:
								if (c > 0)
								{
									/*if (board[r][c-1] == 3)
									{
										button.setBackground(Color.white);
									}*/
									if (board[r][c-1] == 0 || board[r][c-1] == 3)
									{
										board[r][c-1] = 2;
										board[r][c] = 0;
										
										boardButton[r][c].setBackground(Color.white);
										boardButton[r][c-1].setBackground(Color.red);
										
										boardButton[r][c-1].grabFocus();
									}
								}
								break;
							case KeyEvent.VK_RIGHT:
								if (c < (colDim - 1))
								{
									/*if (board[r][c+1] == 3)
									{
										button.setBackground(Color.white);
									}*/
									if (board[r][c+1] == 0 || board[r][c+1] == 3)
									{
										board[r][c+1] = 2;
										board[r][c] = 0;
										
										boardButton[r][c].setBackground(Color.white);
										boardButton[r][c+1].setBackground(Color.red);
										
										boardButton[r][c+1].grabFocus();
									}
								}
								break;
							}
						}
					}
				});
				
				
				boardButton[row][col] = button;
				mainFrame.add(button);
			}
		}
		
		mainFrame.setSize(windowWidth + 17, windowHeight + 40);
		mainFrame.setLayout(null);
		mainFrame.setVisible(true);
	}
}
