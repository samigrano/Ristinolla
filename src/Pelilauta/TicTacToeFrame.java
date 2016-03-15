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

import Nappula.Nappula;

public class TicTacToeFrame extends JFrame implements ActionListener {
	
	
	public static JButton ruutu1 = new Nappula();
	public static JButton ruutu2 = new Nappula();
	public static JButton ruutu3 = new Nappula();
	public static JButton ruutu4 = new Nappula();
	public static JButton ruutu5 = new Nappula();
	public static JButton ruutu6 = new Nappula();
	public static JButton ruutu7 = new Nappula();
	public static JButton ruutu8 = new Nappula();
	public static JButton ruutu9 = new Nappula();
	
	
	static int vuoro = 0;
	private static final long serialVersionUID = 1L;
	JPanel p = new JPanel();
	Nappula [] nappula = new Nappula[9];
	
	public TicTacToeFrame(){
		
		//Luo uuden kehyksen ja 
		super("TicTacToe - Sami&Joonas");
		setSize(600, 600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
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
		
		//Tekee menu valikon ja nappeja.
		JMenuBar bar  = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenuItem newFile = new JMenuItem("New");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem load = new JMenuItem("Load");
		JMenuItem close = new JMenuItem("Exit");
		
		//Lisää kuuntelijat valikon nappeihin.
		newFile.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
		close.addActionListener(this);
		
		//Lisää napit valikkoon
		setJMenuBar(bar);
		bar.add(file);
		file.add(newFile);
		file.add(save);
		file.add(load);
		file.addSeparator();
		file.add(close);
		
		}
		/*Nappien vaikutukset valikossa. Tonne pitää lisätä
		 * tonne pitää lisätä vielä toiminnalisuudet newGamelle, savelle ja loadille.
		 * Exit toimii jo.
		 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object yolo = e.getSource();
		String name = e.getActionCommand();
		
		
		if(name.equals("New")){
			new TicTacToeFrame();
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
		
		
		//asettaa napille enabled -> false kun painettu. ruma ku mikä.
		else if(yolo == ruutu1){
			ruutu1.setEnabled(false);
		}
		else if(yolo == ruutu2){
			ruutu2.setEnabled(false);
		}
		else if(yolo == ruutu3){
			ruutu3.setEnabled(false);
		}
		else if(yolo == ruutu4){
			ruutu4.setEnabled(false);
		}
		else if(yolo == ruutu5){
			ruutu5.setEnabled(false);
		}
		else if(yolo == ruutu6){
			ruutu6.setEnabled(false);
		}
		else if(yolo == ruutu7){
			ruutu7.setEnabled(false);
		}
		else if(yolo == ruutu8){
			ruutu8.setEnabled(false);
		}
		else if(yolo == ruutu9){
			ruutu9.setEnabled(false);
		}
		
		
	}
	
	public static int getVuoro(){
		return vuoro;
	}
	
	public static void kasvataVuoro(){
		vuoro++;
	}
}
