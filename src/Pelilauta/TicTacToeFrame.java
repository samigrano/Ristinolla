package Pelilauta;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

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
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = e.getActionCommand();
		
		if(name.equals("New")){
			System.out.println("Painoit New nappia");
		}
		else if(name.equals("Save")){
			System.out.println("Painoit Save nappia");
		}
		else if(name.equals("Load")){
			System.out.println("Painoit Load nappia");
		}
		
	}
}
