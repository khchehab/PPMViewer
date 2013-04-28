package ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

import ascii.PPM;

public class PPMViewer {
	private JFrame frame;
	private File f;
	private PPMPanel ppmp;
	private BufferedImage img;
	
	public PPMViewer () {
		frame = new JFrame ();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenu menu = new JMenu("File");
		
		//////////////////////////////////////////////////////////
		// 	     	    Load - Menu Item			//
		//////////////////////////////////////////////////////////
		JMenuItem loadItem = new JMenuItem("Load");
		loadItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				f = new LoadViewer().f;
				
				if (f != null) {
					img = new PPM(f).toBufferedImage();
					
					if (ppmp != null) // ppmp already exist in frame
						frame.remove(ppmp);
					
					ppmp = new PPMPanel(img);
					frame.add(ppmp);
					frame.setSize(img.getWidth() + 100, img.getHeight() + 100);
					frame.setLocation(0, 0);
					String title = f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1, f.getName().indexOf('.'));
					frame.setTitle(title);
				}
			}
		});
		loadItem.setMnemonic('L');
		loadItem.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.Event.CTRL_MASK));
		menu.add(loadItem);
		
		//////////////////////////////////////////////////////////
		// 	     	    Save - Menu Item			//
		//////////////////////////////////////////////////////////
		JMenuItem saveItem = new JMenuItem("Save");
		saveItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f = new SaveViewer().f;
				
				while (f != null) {
					if (f.getName().substring(f.getName().indexOf('.') + 1).equals("gif") ||
						f.getName().substring(f.getName().indexOf('.') + 1).equals("jpg") ||
						f.getName().substring(f.getName().indexOf('.') + 1).equals("png"))
						break;
					
					f = new SaveViewer().f;
				}
				
				if (f != null) {
					String ext = f.getName().substring(f.getName().indexOf('.') + 1);
					try {
						ImageIO.write(img, ext, f);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(frame, "File could not be saved for some reason.\nMessage: " + e1.getMessage(), "Error Occured", JOptionPane.ERROR_MESSAGE);
					}
				}	
			}
		});
		saveItem.setMnemonic('S');
		saveItem.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.Event.CTRL_MASK));
		menu.add(saveItem);
		
		//////////////////////////////////////////////////////////
		menu.add(new JSeparator());
		//////////////////////////////////////////////////////////
		
		//////////////////////////////////////////////////////////
		// 	     	    Exit - Menu Item			//
		//////////////////////////////////////////////////////////
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		exitItem.setMnemonic('Q');
		exitItem.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.Event.CTRL_MASK));
		menu.add(exitItem);
		
		//////////////////////////////////////////////////////////
		// 	     	    Add Menu to Menu Bar		//
		//////////////////////////////////////////////////////////
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(menu);
		
		frame.setJMenuBar(menuBar);
		
		frame.setSize(200, 200);
		
		frame.setVisible(true);
	}
	
	class PPMPanel extends JPanel {
		// Generated Serial Version ID
		private static final long serialVersionUID = 2847259566304998389L;
		
		private BufferedImage img;
		private Dimension size = new Dimension();
		
		PPMPanel (BufferedImage img) {
			this.img = img;
			size.setSize(img.getWidth(), img.getHeight());
		}
		
		protected void paintComponent (Graphics g) {
			int x = (getWidth() - size.width) / 2;
			int y = (getHeight() - size.height) / 2;
			g.drawImage(img, x, y, this);
		}
		
		public Dimension getPreferredSize () { return size; }
	}
}
