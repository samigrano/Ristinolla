package Pelilauta;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Nappula.Nappula;

public class TicTacToeFrame extends JFrame implements ActionListener {
	
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
		
		// Tekee nappulat laudalle näkyviin.
		p.setLayout(new GridLayout(3,3));
		for(int i=0; i<9; i++){
			nappula[i] = new Nappula();
			p.add(nappula[i]);
		}
		// Lisää laudan kehykseen.
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
		
	}
	
	public static int getVuoro(){
		return vuoro;
	}
	
	public static void kasvataVuoro(){
		vuoro++;
	}
}
