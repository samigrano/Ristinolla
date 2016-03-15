package Pelilauta;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TicTacToeFrame extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	public TicTacToeFrame(){
		super("TicTacToe - Sami&Joonas");
		setSize(300, 300);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		
		//Pelin aloitus, tallennus lautausta varten olevat napit.
		JButton newGame = new JButton("New");
		JButton saveGame = new JButton("Save");
		JButton loadGame = new JButton("Load");
		newGame.addActionListener(this);
		saveGame.addActionListener(this);
		loadGame.addActionListener(this);
		add(newGame);
		add(saveGame);
		add(loadGame);
		
		//Vaihtoehto napeille, tehd‰ menubar.
		JMenuBar bar  = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenuItem newFile = new JMenuItem("New");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem load = new JMenuItem("Load");
		JMenuItem close = new JMenuItem("Exit");
		
		newFile.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
		close.addActionListener(this);
		
		setJMenuBar(bar);
		bar.add(file);
		file.add(newFile);
		file.add(save);
		file.add(load);
		file.addSeparator();
		file.add(close);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = e.getActionCommand();
		
		Pelilauta lauta = new Pelilauta();
		
		if(name.equals("New")){
			lauta.piirraLauta(); // Piirt‰‰ uuden laudan
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
}
