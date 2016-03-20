package Nappula;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import Pelilauta.Pelilauta;
import Pelilauta.TicTacToeFrame;

public class Nappula extends JButton implements ActionListener{

	private static final long serialVersionUID = 1L;
	ImageIcon X,O;
	int onkoPainettu = 0;
	char id; // X == 1, O == 0;

	public Nappula(){
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		onkoPainettu++;

		if (onkoPainettu == 1){

			Object yolo = e.getSource();
			
			String name = e.getActionCommand();
			
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
				

				if(Pelilauta.tarkastaLauta() == true){
					JOptionPane.showMessageDialog(null, "Voittaja: "+ Pelilauta.annaVoittaja(), getText(), JOptionPane.PLAIN_MESSAGE);
					enableNappula();
				}
				
				if (Pelilauta.onkoTasapeli() == true && Pelilauta.tarkastaLauta() == false){
					JOptionPane.showMessageDialog(null, "Tasapeli!", "Tasapeli!", JOptionPane.PLAIN_MESSAGE);
					enableNappula();
				}
				
			}
			if(yolo == TicTacToeFrame.ruutu2){
				char u = this.getId();
				System.out.println(u);

				Apu apu23 = new Apu(2,3,u);
				Pelilauta.lisaaLautaan(apu23);

				if(Pelilauta.tarkastaLauta() == true){
					JOptionPane.showMessageDialog(null, "Voittaja: "+ Pelilauta.annaVoittaja(), getText(), JOptionPane.PLAIN_MESSAGE);
					enableNappula();
					
				}
				
				if (Pelilauta.onkoTasapeli() == true && Pelilauta.tarkastaLauta() == false){
					JOptionPane.showMessageDialog(null, "Tasapeli!", "Tasapeli!", JOptionPane.PLAIN_MESSAGE);
					enableNappula();

				}
				
			}
			if(yolo == TicTacToeFrame.ruutu3){
				char u = this.getId();
				System.out.println(u);

				Apu apu33 = new Apu(3,3,u);
				Pelilauta.lisaaLautaan(apu33);
				
				if(Pelilauta.tarkastaLauta() == true){
					JOptionPane.showMessageDialog(null, "Voittaja: "+ Pelilauta.annaVoittaja(), getText(), JOptionPane.PLAIN_MESSAGE);
					enableNappula();
					
				}
				if (Pelilauta.onkoTasapeli() == true && Pelilauta.tarkastaLauta() == false){
					JOptionPane.showMessageDialog(null, "Tasapeli!", "Tasapeli!", JOptionPane.PLAIN_MESSAGE);
					enableNappula();

				}
			
			}
			if(yolo == TicTacToeFrame.ruutu4){
				char u = this.getId();
				System.out.println(u);

				Apu apu12 = new Apu(1,2,u);
				Pelilauta.lisaaLautaan(apu12);

				if(Pelilauta.tarkastaLauta() == true){
					JOptionPane.showMessageDialog(null, "Voittaja: "+ Pelilauta.annaVoittaja(), getText(), JOptionPane.PLAIN_MESSAGE);
					enableNappula();
					
				}
				if (Pelilauta.onkoTasapeli() == true && Pelilauta.tarkastaLauta() == false){
					JOptionPane.showMessageDialog(null, "Tasapeli!", "Tasapeli!", JOptionPane.PLAIN_MESSAGE);
					enableNappula();

				}
				
			}
			if(yolo == TicTacToeFrame.ruutu5){
				char u = this.getId();
				System.out.println(u);

				Apu apu22 = new Apu(2,2,u);
				Pelilauta.lisaaLautaan(apu22);
				Pelilauta.tarkastaLauta();

				if(Pelilauta.tarkastaLauta() == true){
					JOptionPane.showMessageDialog(null, "Voittaja: "+ Pelilauta.annaVoittaja(), getText(), JOptionPane.PLAIN_MESSAGE);
					enableNappula();
				}
				if (Pelilauta.onkoTasapeli() == true && Pelilauta.tarkastaLauta() == false){
					JOptionPane.showMessageDialog(null, "Tasapeli!", "Tasapeli!", JOptionPane.PLAIN_MESSAGE);
					enableNappula();

				}
				
			}
			if(yolo == TicTacToeFrame.ruutu6){
				char u = this.getId();
				System.out.println(u);

				Apu apu32 = new Apu(3,2,u);
				Pelilauta.lisaaLautaan(apu32);

				if(Pelilauta.tarkastaLauta() == true){
					JOptionPane.showMessageDialog(null, "Voittaja: "+ Pelilauta.annaVoittaja(), getText(), JOptionPane.PLAIN_MESSAGE);
					enableNappula();
					
				}
				if (Pelilauta.onkoTasapeli() == true && Pelilauta.tarkastaLauta() == false){
					JOptionPane.showMessageDialog(null, "Tasapeli!", "Tasapeli!", JOptionPane.PLAIN_MESSAGE);
					enableNappula();

				}
				
			}
			if(yolo == TicTacToeFrame.ruutu7){
				char u = this.getId();
				System.out.println(u);

				Apu apu11 = new Apu(1,1,u);
				Pelilauta.lisaaLautaan(apu11);

				if(Pelilauta.tarkastaLauta() == true){
					JOptionPane.showMessageDialog(null, "Voittaja: "+ Pelilauta.annaVoittaja(), getText(), JOptionPane.PLAIN_MESSAGE);
					enableNappula();
					
				}
				if (Pelilauta.onkoTasapeli() == true && Pelilauta.tarkastaLauta() == false){
					JOptionPane.showMessageDialog(null, "Tasapeli!", "Tasapeli!", JOptionPane.PLAIN_MESSAGE);
					enableNappula();

				}
				
			}
			if(yolo == TicTacToeFrame.ruutu8){
				char u = this.getId();
				System.out.println(u);

				Apu apu21 = new Apu(2,1,u);
				Pelilauta.lisaaLautaan(apu21);

				if(Pelilauta.tarkastaLauta() == true){
					JOptionPane.showMessageDialog(null, "Voittaja: "+ Pelilauta.annaVoittaja(), getText(), JOptionPane.PLAIN_MESSAGE);
					enableNappula();
					
				}
				if (Pelilauta.onkoTasapeli() == true && Pelilauta.tarkastaLauta() == false){
					JOptionPane.showMessageDialog(null, "Tasapeli!", "Tasapeli!", JOptionPane.PLAIN_MESSAGE);
					enableNappula();

				}
				
			}
			if(yolo == TicTacToeFrame.ruutu9){
				char u = this.getId();
				System.out.println(u);

				Apu apu31 = new Apu(3,1,u);
				Pelilauta.lisaaLautaan(apu31);

				if(Pelilauta.tarkastaLauta() == true){
					JOptionPane.showMessageDialog(null, "Voittaja: "+ Pelilauta.annaVoittaja(), getText(), JOptionPane.PLAIN_MESSAGE);
					enableNappula();
					
				}
				if (Pelilauta.onkoTasapeli() == true && Pelilauta.tarkastaLauta() == false){
					JOptionPane.showMessageDialog(null, "Tasapeli!", "Tasapeli!", JOptionPane.PLAIN_MESSAGE);
					enableNappula();

				}
				
			}
		}
	}


}

