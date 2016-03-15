package TicTacToe;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.plaf.synth.SynthSeparatorUI;

import Nappula.*;
import Pelilauta.*;
public class Driver {

	public static void main(String [] args){
		
		new TicTacToeFrame().setVisible(true);
		
		Pelilauta lauta = new Pelilauta();
		Nappula[] X = new Nappula[9];
		Nappula[] Y = new Nappula[9];
		
		X[0] = new Nappula('X',1,3);
		X[1] = new Nappula('X',3,1);
		X[2] = new Nappula('X',2,2);
		
		Y[0] = new Nappula('Y',1,1);
		Y[1] = new Nappula('Y',3,3);
		
		//Testaus voiko lis‰t‰ jo valmiin nappulan p‰‰lle
		Y[2] = new Nappula('Y',2,2);
		
		for(int i=0; i<3; i++){
			lauta.lisaaLautaan(X[i]);
		}
		for(int i=0; i<3; i++){
			lauta.lisaaLautaan(Y[i]);
		}
		
		lauta.piirraLauta();
		
		System.out.println(lauta.tarkastaLauta());
		
	}
}

