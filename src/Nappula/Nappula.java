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
	
	public Nappula(){
		X = new ImageIcon(getClass().getResource("X.png"));
		O = new ImageIcon(getClass().getResource("O.png"));
		this.addActionListener(this);
	}
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

