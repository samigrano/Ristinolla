package Pelilauta;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Pelilauta.Pelilauta;
import Nappula.Nappula;
import Nappula.Apu;

public class TicTacToeFrame extends JFrame implements ActionListener {
	
	static int vuoro = 0;
	private static final long serialVersionUID = 1L;
	JPanel p = new JPanel();
	JButton [] nappula = new Nappula[9];
	
	public static JButton ruutu1 = new Nappula();
	public static JButton ruutu2 = new Nappula();
	public static JButton ruutu3 = new Nappula();
	public static JButton ruutu4 = new Nappula();
	public static JButton ruutu5 = new Nappula();
	public static JButton ruutu6 = new Nappula();
	public static JButton ruutu7 = new Nappula();
	public static JButton ruutu8 = new Nappula();
	public static JButton ruutu9 = new Nappula();
	
	public TicTacToeFrame(){
		
		//Luo uuden kehyksen ja lis‰‰ napit.
		
		super("TicTacToe - Sami&Joonas");
		setSize(300, 300);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		//Tekee menu valikon ja nappeja.
		JMenuBar bar  = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenuItem newFile = new JMenuItem("New");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem load = new JMenuItem("Load");
		JMenuItem close = new JMenuItem("Exit");
		
		//Lis‰‰ kuuntelijat valikon nappeihin.
		newFile.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
		close.addActionListener(this);
		
		//Lis‰‰ napit valikkoon
		setJMenuBar(bar);
		bar.add(file);
		file.add(newFile);
		file.add(save);
		file.add(load);
		file.addSeparator();
		file.add(close);
		
		addButton();
	}
		//Luo napit.
	
	public void addButton(){
		
		p.add(ruutu1);
		p.add(ruutu2);
		p.add(ruutu3);
		p.add(ruutu4);
		p.add(ruutu5);
		p.add(ruutu6);
		p.add(ruutu7);
		p.add(ruutu8);
		p.add(ruutu9);
		
		ruutu1.addActionListener(this);
		ruutu2.addActionListener(this);
		ruutu3.addActionListener(this);
		ruutu4.addActionListener(this);
		ruutu5.addActionListener(this);
		ruutu6.addActionListener(this);
		ruutu7.addActionListener(this);
		ruutu8.addActionListener(this);
		ruutu9.addActionListener(this);
		
		p.setLayout(new GridLayout(3,3));
		
		add(p);
		
	}
	
		/*Nappien vaikutukset valikossa. Tonne pit‰‰ lis‰t‰
		 * tonne pit‰‰ lis‰t‰ viel‰ toiminnalisuudet newGamelle, savelle ja loadille.
		 * Exit toimii jo.
		 */
	@Override
	public void actionPerformed(ActionEvent e) {
	
		
		String name = e.getActionCommand();
		
		
		if(name.equals("New")){
			Pelilauta.tyhjennaLauta();
			dispose();
			ruutu1.setIcon(null);
			ruutu2.setIcon(null);
			ruutu3.setIcon(null);
			ruutu4.setIcon(null);
			ruutu5.setIcon(null);
			ruutu6.setIcon(null);
			ruutu7.setIcon(null);
			ruutu8.setIcon(null);
			ruutu9.setIcon(null);
			
			new TicTacToeFrame().setVisible(true);
			ruutu1 = new Nappula();
			ruutu2 = new Nappula();
			ruutu3 = new Nappula();
			ruutu4 = new Nappula();
			ruutu5 = new Nappula();
			ruutu6 = new Nappula();
			ruutu7 = new Nappula();
			ruutu8 = new Nappula();
			ruutu9 = new Nappula();
						
		}
			
		else if(name.equals("Save")){
			System.out.println("Painoit Save nappia");
		}
		else if(name.equals("Load")){
			System.out.println("Painoit Load nappia");
		}
		else if(name.equals("Exit")){
			System.out.println("Ohjelma lopetettu");
			System.exit(0);
		}
		
	
		
	}
	
	public static int getVuoro(){
		return vuoro;
	}
	
	public static void kasvataVuoro(){
		vuoro++;
	}
}
