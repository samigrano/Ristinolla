package Nappula;

public class Nappula {

	private int x;
	private int y;
	private char id;
	private int arvo;
	private int sijainti; //1,2,3,4,5,6,7,8,9
	
	
	public Nappula(int x, int y, char id){
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public char getId() {
		return id;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setId(char id) {
		this.id = id;
	}


	public int getArvo() {
		return arvo;
	}
	public void setArvo(int arvo){
		this.arvo = arvo;
	}
	
	public int getSijainti(){
		return sijainti;
	}
	public void setSijainti(int sijainti){
		this.sijainti = sijainti;
	}
	
	
}
