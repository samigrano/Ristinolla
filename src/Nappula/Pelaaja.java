package Nappula;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import Pelilauta.Pelilauta;
import Pelilauta.TicTacToeFrame;

public class Pelaaja extends JButton implements ActionListener{

	private static final long serialVersionUID = 1L;
	private ImageIcon X,O;
	private int onkoPainettu = 0;
	private char id; // X == 1, O == 0;
	public static boolean totuus = false;
	
	public Pelaaja(){
		X = new ImageIcon(getClass().getResource("X.png"));
		O = new ImageIcon(getClass().getResource("O.png"));
		this.addActionListener(this);
	}
	public void setId(char id){
		this.id = id;
	}
	
	public void setOnkoPainettu(int onkoPainettu){
		this.onkoPainettu = onkoPainettu;
	}
	
	public char getId(){
		return id;
	}
	
	public void tyhj‰‰(){
		 setId(' ');
		 setOnkoPainettu(0);
		
	}
	
	public static void enableNappula(){
		TicTacToeFrame.ruutu1.setEnabled(false);
		TicTacToeFrame.ruutu2.setEnabled(false);
		TicTacToeFrame.ruutu3.setEnabled(false);
		TicTacToeFrame.ruutu4.setEnabled(false);
		TicTacToeFrame.ruutu5.setEnabled(false);
		TicTacToeFrame.ruutu6.setEnabled(false);
		TicTacToeFrame.ruutu7.setEnabled(false);
		TicTacToeFrame.ruutu8.setEnabled(false);
		TicTacToeFrame.ruutu9.setEnabled(false);
	}
	public void onkoVoitto(){
		if(Pelilauta.tarkastaLauta() == true && !totuus){
			totuus = true;
			enableNappula();
			Pelilauta.voittajanPisteet();
			JOptionPane.showMessageDialog(null, "Voittaja: "+ Pelilauta.annaVoittaja(), "Voittaja", JOptionPane.PLAIN_MESSAGE);
			JOptionPane.showMessageDialog(null, "X: "+ Pelilauta.getVoittajaX()+ " ja " + "O: "+ Pelilauta.getVoittajaO(), "Pistetilanne", JOptionPane.PLAIN_MESSAGE);
			System.out.println(Pelilauta.getVoittajaX());
			System.out.println(Pelilauta.getVoittajaO());
		}
	}
	public void onkoTasa(){		
		
		if (Pelilauta.onkoTasapeli() == true && Pelilauta.tarkastaLauta() == false){
			JOptionPane.showMessageDialog(null, "Tasapeli!", "Tasapeli!", JOptionPane.PLAIN_MESSAGE);
			JOptionPane.showMessageDialog(null, "X: "+ Pelilauta.getVoittajaX()+ " ja " + "O: "+ Pelilauta.getVoittajaO(), "Pistetilanne", JOptionPane.PLAIN_MESSAGE);
			enableNappula();
			
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println(onkoPainettu);
		onkoPainettu++;
		
		if (onkoPainettu == 1){
			

			Object nappi = e.getSource();
			
			//kasvatetaan vuoromuuttuja lukua
			TicTacToeFrame.kasvataVuoro();

			//vuorotellaan X ja O
			if(TicTacToeFrame.getVuoro()%2 == 1){
				this.setId('X');
				setIcon(X);
				
			}
			if(TicTacToeFrame.getVuoro()%2 == 0){
				this.setId('O');
				setIcon(O);
				
			}
			

			//jokaiselle mahdollislle eri sourcelle oma tapaus
			//ruutu 1 vastaa koordinaattia (1,3)
			//ruutu 9 vastaa koordinaattia (3,1)
			//Nappulaluokka tekee aina uuden olion kun nappia painettu ja 
			//tallentaa sen tiedot pelilautaluokkaan
			
			
			if(nappi == TicTacToeFrame.ruutu1){
				
				char u = this.getId();
				System.out.println(u);

				Nappula apu13 = new Nappula(1,3,u);
				apu13.setSijainti(1);
				Pelilauta.lisaaLautaan(apu13);
				onkoVoitto();
				onkoTasa();
			}
			if(nappi == TicTacToeFrame.ruutu2){
				char u = this.getId();
				System.out.println(u);

				Nappula apu23 = new Nappula(2,3,u);
				apu23.setSijainti(2);
				Pelilauta.lisaaLautaan(apu23);
				onkoVoitto();
				onkoTasa();
			}
			if(nappi == TicTacToeFrame.ruutu3){
				char u = this.getId();
				System.out.println(u);

				Nappula apu33 = new Nappula(3,3,u);
				apu33.setSijainti(3);
				Pelilauta.lisaaLautaan(apu33);
				onkoVoitto();
				onkoTasa();
			}
			if(nappi == TicTacToeFrame.ruutu4){
				char u = this.getId();
				System.out.println(u);

				Nappula apu12 = new Nappula(1,2,u);
				apu12.setSijainti(4);
				Pelilauta.lisaaLautaan(apu12);
				onkoVoitto();
				onkoTasa();
			}
			if(nappi == TicTacToeFrame.ruutu5){
				char u = this.getId();
				System.out.println(u);

				Nappula apu22 = new Nappula(2,2,u);
				apu22.setSijainti(5);
				Pelilauta.lisaaLautaan(apu22);
				onkoVoitto();
				onkoTasa();
			}
			if(nappi == TicTacToeFrame.ruutu6){
				char u = this.getId();
				System.out.println(u);

				Nappula apu32 = new Nappula(3,2,u);
				apu32.setSijainti(6);
				Pelilauta.lisaaLautaan(apu32);
				onkoVoitto();
				onkoTasa();
			}
			if(nappi == TicTacToeFrame.ruutu7){
				char u = this.getId();
				System.out.println(u);

				Nappula apu11 = new Nappula(1,1,u);
				apu11.setSijainti(7);
				Pelilauta.lisaaLautaan(apu11);
				onkoVoitto();
				onkoTasa();
			}
			if(nappi == TicTacToeFrame.ruutu8){
				char u = this.getId();
				System.out.println(u);

				Nappula apu21 = new Nappula(2,1,u);
				apu21.setSijainti(8);
				Pelilauta.lisaaLautaan(apu21);
				onkoVoitto();
				onkoTasa();
			}
			if(nappi == TicTacToeFrame.ruutu9){
				char u = this.getId();
				System.out.println(u);

				Nappula apu31 = new Nappula(3,1,u);
				apu31.setSijainti(9);
				Pelilauta.lisaaLautaan(apu31);
				onkoVoitto();
				onkoTasa();
			}
		}
	}
		
}




