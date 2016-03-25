package TicTacToe;
import Nappula.Tietokone;
import Pelilauta.TicTacToeFrame;
public class Driver extends TicTacToeFrame{

	private static final long serialVersionUID = 1L;

	public static void main(String [] args){
		
		new TicTacToeFrame().setVisible(true);
		// Testausta varten
		Tietokone.moi();
	}
}

