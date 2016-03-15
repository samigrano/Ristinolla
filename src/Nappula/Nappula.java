package Nappula;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Nappula extends JButton implements ActionListener{
	ImageIcon X,O;
	int value=0;
	
	
	/*private char id; // X tai 0
	private int x;
	private int y;*/
	
	/* Hakee nappulalle kuvakkeet. 
	 * Noi vois olla kauniimmatkin. kuhan v‰s‰sin jotain.
	 * Kuvia voi muokata ja ladata paremmat.
	 */
	public Nappula(){
		X = new ImageIcon(getClass().getResource("X2.png"));
		O = new ImageIcon(getClass().getResource("O2.jpg"));
		this.addActionListener(this);
	}
	// Lis‰‰ toiminnat kun nappeja painaa. value m‰‰r‰‰ kuin monta kertaa on painettu.
	@Override
	public void actionPerformed(ActionEvent e) {
			value++;
			value%=3;
			if(value==0){
				setIcon(null);
			}
			if(value==1){
				setIcon(X);
			}
			if(value==2){
				setIcon(O);
			}
	}
	// Kommentoin ulos kun en tie miten voidaan hyˆdynt‰‰ n‰is grafiikois.
	/*
	public Nappula (char id, int x, int y){
		this.id = id;
		this.x =  x;
		this.y = y;
	}
	
	public Nappula (char id){
		this.id = id;
	}
	
	public char getId() {
		return id;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setId(char id) {
		this.id = id;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}*/


}

