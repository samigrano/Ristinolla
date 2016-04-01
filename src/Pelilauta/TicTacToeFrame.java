package Pelilauta;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Nappula.Pelaaja;


public class TicTacToeFrame extends JFrame implements ActionListener {
	
	static int vuoro = 0;
	private static final long serialVersionUID = 1L;
	JPanel p = new JPanel();
	
	public static JButton ruutu1 = new Pelaaja();
	public static JButton ruutu2 = new Pelaaja();
	public static JButton ruutu3 = new Pelaaja();
	public static JButton ruutu4 = new Pelaaja();
	public static JButton ruutu5 = new Pelaaja();
	public static JButton ruutu6 = new Pelaaja();
	public static JButton ruutu7 = new Pelaaja();
	public static JButton ruutu8 = new Pelaaja();
	public static JButton ruutu9 = new Pelaaja();
	
	
	public TicTacToeFrame(){
		
		//Luo uuden kehyksen ja lis‰‰ napit.
		
		super("TicTacToe - Sami&Joonas");
		setSize(300, 300);
		setResizable(false);
		setLocationRelativeTo(null);
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
		
		lisaaNappula();
	}
		//Luo napit.
	
	public void lisaaNappula(){

		ruutu1 = new Pelaaja();
		ruutu2 = new Pelaaja();
		ruutu3 = new Pelaaja();
		ruutu4 = new Pelaaja();
		ruutu5 = new Pelaaja();
		ruutu6 = new Pelaaja();
		ruutu7 = new Pelaaja();
		ruutu8 = new Pelaaja();
		ruutu9 = new Pelaaja();
		
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		
		String name = e.getActionCommand();
		
		
		if(name.equals("New")){
			
			dispose();
			vuoro = 0;
			new TicTacToeFrame().setVisible(true);
			Pelilauta.tyhjennaLauta();
						
		}
			
		else if(name.equals("Save")){
			Pelilauta.save();
			System.out.println("Painoit Save nappia");
		}
		else if(name.equals("Load")){
			Pelilauta.load();
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
