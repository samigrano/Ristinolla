package Nappula;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import Nappula.Apu;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Pelilauta.*;
import Pelilauta.TicTacToeFrame;

public class Nappula extends JButton implements ActionListener{
	
	ImageIcon X,O;
	int value=0;
	
	char id; // X == 1, O == 0;

	public Nappula(){
		X = new ImageIcon(getClass().getResource("X.png"));
		O = new ImageIcon(getClass().getResource("O.png"));
		this.addActionListener(this);
	}
	
	public void setId(char id){
		this.id = id;
	}
	
	public char getId(){
		return id;
	}
	
	
	
	
	
	// Lis�� toiminnat kun nappeja painaa. value m��r�� kuin monta kertaa on painettu.
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		Object yolo = e.getSource();
	
		//kasvatetaan vuoromuuttuja lukua
		TicTacToeFrame.kasvataVuoro();
	
		
		//vuorotellaan X ja O
		if(TicTacToeFrame.getVuoro()%2 == 0){
			this.setId('O');
			setIcon(O);
		}
		if(TicTacToeFrame.getVuoro()%2 == 1){
			this.setId('X');
			setIcon(X);
		}
		
		
		
		
		//jokaiselle mahdollislle eri sourcelle oma tapaus
		//ruutu 1 vastaa koordinaattia (1,3)
		//ruutu 9 vastaa koordinaattia (3,1)
		//apuluokka tekee aina uuden olion kun nappia painettu ja tallentaa sen tiedot pelilautaluokkaan
		if(yolo == TicTacToeFrame.ruutu1){
			char u = this.getId();
			System.out.println(u);
			
			Apu apu13 = new Apu(1,3,u);
			Pelilauta.lisaaLautaan(apu13);
		}
		if(yolo == TicTacToeFrame.ruutu2){
			char u = this.getId();
			System.out.println(u);
			
			Apu apu23 = new Apu(2,3,u);
			Pelilauta.lisaaLautaan(apu23);
		}
		if(yolo == TicTacToeFrame.ruutu3){
			char u = this.getId();
			System.out.println(u);
			
			Apu apu33 = new Apu(3,3,u);
			Pelilauta.lisaaLautaan(apu33);
		}
		if(yolo == TicTacToeFrame.ruutu4){
			char u = this.getId();
			System.out.println(u);
			
			Apu apu12 = new Apu(1,2,u);
			Pelilauta.lisaaLautaan(apu12);
		}
		if(yolo == TicTacToeFrame.ruutu5){
			char u = this.getId();
			System.out.println(u);
			
			Apu apu22 = new Apu(2,2,u);
			Pelilauta.lisaaLautaan(apu22);
		}
		if(yolo == TicTacToeFrame.ruutu6){
			char u = this.getId();
			System.out.println(u);
			
			Apu apu32 = new Apu(3,2,u);
			Pelilauta.lisaaLautaan(apu32);
		}
		if(yolo == TicTacToeFrame.ruutu7){
			char u = this.getId();
			System.out.println(u);
			
			Apu apu11 = new Apu(1,1,u);
			Pelilauta.lisaaLautaan(apu11);
		}
		if(yolo == TicTacToeFrame.ruutu8){
			char u = this.getId();
			System.out.println(u);
			
			Apu apu21 = new Apu(2,1,u);
			Pelilauta.lisaaLautaan(apu21);
		}
		if(yolo == TicTacToeFrame.ruutu9){
			char u = this.getId();
			System.out.println(u);
			
			Apu apu31 = new Apu(3,1,u);
			Pelilauta.lisaaLautaan(apu31);
		}
	}



}

