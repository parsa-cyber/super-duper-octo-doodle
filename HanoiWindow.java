import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class HanoiWindow {
	JFrame mainFrame;
	int DiskCount = 6;
	int windowWidth = 1000;
	int windowHeight = 600;

	
	public JButton[] ButtonList = new JButton[DiskCount];
	public int[] TowerDiskCount = new int[3];
  
	public int MoveIndex = 0;
	public int[][] Moves = new int[2][(int)(Math.pow(2, DiskCount) - 1)];
	public int CurrentMove = 0;
	
	public void HanoiTowers(int n, int A, int B, int C)
	{
		if (n<=0)
			return;
		
		HanoiTowers(n-1, A, C, B);
		
		Moves[0][MoveIndex] = A;
		Moves[1][MoveIndex] = C;
		MoveIndex++;
		
		HanoiTowers(n-1, B, A, C);
	}
	
	public HanoiWindow()
	{
		mainFrame = new JFrame();
		int i;

		HanoiTowers(DiskCount, 0, 1, 2);
		
		TowerDiskCount[0] = DiskCount;
		TowerDiskCount[1] = 0;
		TowerDiskCount[2] = 0;
		
		JButton stage = new JButton();
		stage.setText("Move Disk");
		stage.setForeground(Color.white);
		stage.setBackground(Color.black);
		stage.setBounds(10, windowHeight - 50, windowWidth - 20, 50);
		stage.setVisible(true);
		stage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(CurrentMove < (int)(Math.pow(2, DiskCount) - 1))
					{
					int from = Moves[0][CurrentMove]; // From Tower
					int to = Moves[1][CurrentMove]; // To Tower
					CurrentMove++;
					int diskHeight = (windowHeight - 150) / DiskCount;
					
					int topFrom = windowHeight - 50 - diskHeight*TowerDiskCount[from];
					int topTo = windowHeight - 50 - diskHeight*(TowerDiskCount[to] + 1);
					
					int index;
					for (index = 0; index < DiskCount; index++)
					{
						if(ButtonList[index].getBounds().y == topFrom && ButtonList[index].getBounds().x == ((from+1)*(windowWidth /4)-ButtonList[index].getBounds().width/2))
						{
							ButtonList[index].setBounds((to+1)*(windowWidth /4)-ButtonList[index].getBounds().width/2, topTo, ButtonList[index].getBounds().width, ButtonList[index].getBounds().height);
							
							TowerDiskCount[from]--;
							TowerDiskCount[to]++;
						}
					}
				}
			}
		});
		
		mainFrame.add(stage);
		
		
		for (i = 0; i < DiskCount; i++)
		{
			Random rand = new Random();

			int diskWidth = windowWidth / (i + 5);
			int diskHeight = (windowHeight - 150) / DiskCount;
			
			JButton disk = new JButton();
			disk.setText("");
			//disk.setBackground(Color.getHSBColor((float)(i*20.0/256), (float)(i*15.5/256), (float)(i*10.5/256)));
			disk.setBackground(new Color((Math.abs(rand.nextInt()))%255 , (Math.abs(rand.nextInt()))%255, (Math.abs(rand.nextInt()))%255));
			disk.setBounds((windowWidth/4) - (diskWidth/2), windowHeight - 50 - (i + 1)*diskHeight, diskWidth, diskHeight);
			disk.setVisible(true);
			
			ButtonList[i] = disk;
			mainFrame.add(disk);
		}
		
		for (i = 0; i < 3; i++)
		{
			JButton tower = new JButton();
			tower.setText("");
			tower.setBackground(Color.black);
			tower.setBounds((i+1)*(windowWidth/4) - 5, 50, 10, windowHeight - 100);
			tower.setVisible(true);
			tower.setEnabled(false);
			mainFrame.add(tower);
		}
		
		mainFrame.setSize(windowWidth + 17, windowHeight + 40);
		mainFrame.setLayout(null);
		mainFrame.setVisible(true);
	}
}
